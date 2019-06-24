package am.autotrade.controller;

import am.autotrade.model.CarPart;
import am.autotrade.service.CarPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/car-parts")
public class CarPartController {

    @Autowired
    private CarPartService carPartService;

    @PostMapping
    public ResponseEntity<CarPart> postCarPart(@RequestBody CarPart carPart) {

        carPart = carPartService.saveOrUpdateCarPart(carPart);

        return ResponseEntity.status(200).body(carPart);
    }

    @GetMapping(value = "/{id}")
    public  ResponseEntity<CarPart> getCarPart(@PathVariable Long id) {
        return carPartService.getCarPartById(id).map(carPart -> ResponseEntity.status(HttpStatus.OK).body(carPart))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCarPart(@PathVariable Long id) {
        if (carPartService.removeCarPart(id)) {
            return ResponseEntity.status(HttpStatus.OK).body("deleted car part with id :: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to delete");
        }
    }
}
