package am.autotrade.service;

import am.autotrade.model.Car;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CarService {

    Car saveCar(Car car);

    Optional<Car> getCarById(Long id);

    Optional<Car> getCar(Car car);

    List<Car> getAllCars();

    Set<Integer> getAllDistinctYears();

    Set<String> getAllDistinctBrandsByYear(Integer year);

    Set<String> getAllDistinctModelsByYearAndBrand(Integer year, String brand);

    Set<String> getAllDistinctModificationsByYearAndBrandAndModel(Integer year, String brand, String model);
}
