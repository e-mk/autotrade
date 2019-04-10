package am.autotrade.controller;

import am.autotrade.model.Car;
import am.autotrade.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/car")
public class CarController {

    @Autowired
    public CarService carService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Car> getCar(@PathVariable Long id) {

        return carService.getCarById(id).map(car -> ResponseEntity.status(200).body(car))
                        .orElse(ResponseEntity.notFound()
                        .build());
    }
}
