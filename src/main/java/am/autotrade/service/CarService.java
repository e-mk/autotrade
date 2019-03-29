package am.autotrade.service;

import am.autotrade.model.Car;

import java.util.Set;

public interface CarService {

    Car saveCar(Car car);

    Car getCarById(Long id);

    Set<Integer> getAllDistinctYears();

    Set<String> getAllDistinctBrandsByYear(Integer year);
}
