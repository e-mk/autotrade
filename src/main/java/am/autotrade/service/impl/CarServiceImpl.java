package am.autotrade.service.impl;

import am.autotrade.entity.CarEntity;
import am.autotrade.model.Car;
import am.autotrade.repository.CarRepository;
import am.autotrade.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Car saveCar(Car car) {

        if (car.getId() == null) {
            Optional<Car> carOpt = getCar(new Car(car.getYear(), car.getBrand(), car.getModel(), car.getModification()));

            if (carOpt.isPresent()) {
                return carOpt.get();
            }
        }

        CarEntity carEntity = mapper.map(car, CarEntity.class);
        carEntity = carRepository.save(carEntity);

        return mapper.map(carEntity, Car.class);
    }

    @Override
    public Optional<Car> getCarById(Long id) {

        Optional<CarEntity> carEntityOpt = carRepository.findById(id);

        return carEntityOpt.map(carEntity -> mapper.map(carEntity, Car.class));
    }

    @Override
    public Optional<Car> getCar(Car car) {

        Optional<CarEntity> carEntityOpt = carRepository.findByYearAndBrandAndModelAndModification(car.getYear(),
                car.getBrand(), car.getModel(), car.getModification());

        return carEntityOpt.map(carEntity -> mapper.map(carEntity, Car.class));
    }

    @Override
    public List<Car> getAllCars() {

        Iterable<CarEntity> carEntityIterable = carRepository.findAll();
        List<Car> cars = new ArrayList<>();
        carEntityIterable.forEach(carEntity -> cars.add(mapper.map(carEntity, Car.class)));

        return cars;
    }

    @Override
    public Set<Integer> getAllDistinctYears() {

        Set<Integer> distinctYears = carRepository.findAllDistinctYears();

        return distinctYears;
    }

    @Override
    public Set<String> getAllDistinctBrandsByYear(Integer year) {

        Set<String> distinctBrands = carRepository.findAllDistinctBrandsByYear(year);

        return distinctBrands;
    }

    @Override
    public Set<String> getAllDistinctModelsByYearAndBrand(Integer year, String brand) {

        Set<String> distinctModels = carRepository.findAllModelsByBrandsAndYear(year, brand);

        return distinctModels;
    }

    @Override
    public Set<String> getAllDistinctModificationsByYearAndBrandAndModel(Integer year, String brand, String model) {

        Set<String> distinctModifications = carRepository.findAllModificationByBrandsAndYearAndModel(year, brand, model);

        return distinctModifications;
    }

}
