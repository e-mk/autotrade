package am.autotrade.controller;

import am.autotrade.model.Car;
import am.autotrade.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(path = "/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Car> getCar(@PathVariable Long id) {

        return carService.getCarById(id).map(car -> ResponseEntity.status(200).body(car))
                        .orElse(ResponseEntity.notFound()
                        .build());
    }

    @GetMapping
    public ResponseEntity<List<Car>> getCars(@RequestParam(required = false) Integer year,
                                             @RequestParam(required = false) String brand,
                                             @RequestParam(required = false) String model,
                                             @RequestParam(required = false) String modification) {

        List<Car> cars = new ArrayList<>();

        if (year != null && brand != null && model != null && modification != null) {
            Optional<Car> carOpt = carService.getCar(new Car(year, brand, model, modification));

            if (carOpt.isPresent()) {
                cars.add(carOpt.get());
                return ResponseEntity.status(HttpStatus.OK).body(cars);
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(cars);
            }
        }

        //TODO: add case with not all params

        cars = carService.getAllCars();

        if (cars.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(cars);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(cars);
        }
    }

    @GetMapping(value = "/years")
    public ResponseEntity<Set<Integer>> getDistinctYears() {

        Set<Integer> distinctYears = carService.getAllDistinctYears();

        if (distinctYears.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(distinctYears);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(distinctYears);
        }
    }

    @GetMapping(value = "/brands")
    public ResponseEntity<Set<String>> getDistinctBrands(@RequestParam Integer year) {

        Set<String> distinctBrands = carService.getAllDistinctBrandsByYear(year);

        if (distinctBrands.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(distinctBrands);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(distinctBrands);
        }
    }

    @GetMapping(value = "/models")
    public ResponseEntity<Set<String>> getDistinctModels(@RequestParam Integer year,
                                                         @RequestParam String brand) {

        Set<String> distinctModels = carService.getAllDistinctModelsByYearAndBrand(year, brand);

        if (distinctModels.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(distinctModels);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(distinctModels);
        }
    }

    @GetMapping(value = "/modifications")
    public ResponseEntity<Set<String>> getDistinctModels(@RequestParam Integer year,
                                                         @RequestParam String brand,
                                                         @RequestParam String model) {

        Set<String> distinctModifications = carService.getAllDistinctModificationsByYearAndBrandAndModel(year, brand, model);

        if (distinctModifications.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(distinctModifications);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(distinctModifications);
        }
    }
}
