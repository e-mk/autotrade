package am.autotrade.service;

import am.autotrade.model.Car;

import java.util.Optional;
import java.util.Set;

public interface CarService {

    Car saveCar(Car car);

    Optional<Car> getCarById(Long id);

    Set<Integer> getAllDistinctYears();

    Set<String> getAllDistinctBrandsByYear(Integer year);

    Set<String> getAllDistinctModelsByBrandAndYear(Integer year, String brand);

    Set<String> getAllModificationByBrandsAndYearAndModel(Integer year, String brand, String model);
}
