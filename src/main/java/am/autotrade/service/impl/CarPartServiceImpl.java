package am.autotrade.service.impl;

import am.autotrade.entity.CarPartEntity;
import am.autotrade.exception.CarNotFoundException;
import am.autotrade.exception.CarPartNotFoundException;
import am.autotrade.exception.CategoryNotFoundException;
import am.autotrade.model.Car;
import am.autotrade.model.CarInfo;
import am.autotrade.model.CarPart;
import am.autotrade.repository.CarPartRepository;
import am.autotrade.service.CarPartService;
import am.autotrade.service.CarService;
import am.autotrade.service.CategoryService;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CarPartServiceImpl implements CarPartService {

    @Autowired
    private CarPartRepository carPartRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CarService carService;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Optional<CarPart> getCarPartById(Long carPartId) {

        Optional<CarPartEntity> carPartEntityOpt = carPartRepository.findById(carPartId);

        carPartEntityOpt.orElseThrow(() -> new CarPartNotFoundException("No car part with id :: " + carPartId));

        CarPart carPart = mapper.map(carPartEntityOpt.get(), CarPart.class);

        return Optional.of(carPart);
    }

    @Override
    public CarPart saveOrUpdateCarPart(CarPart carPart) {

        if (carPart.getId() != null) {
            CarPart oldCarPart = mapper.map(carPartRepository.findById(carPart.getId())
                    .orElseThrow(() -> new CarPartNotFoundException("No car Part with this id to update")), CarPart.class);

            carPart = updateCarPartModel(oldCarPart, carPart);
        }

        Set<CarInfo> cars = carPart.getCars();

        if(cars == null || cars.isEmpty()) {
            throw new CarNotFoundException("You need to provide at least one car id to save Car Part for that car");
        }

        if (carPart.getSubCategory() == null || carPart.getSubCategory().getId() == null) {
            throw new CategoryNotFoundException("You need to provide sub category id to save Car Part for that sub category");
        }

        Set<CarInfo> invalisCars = cars.stream().filter(car -> car.getId() == null || !carService.getCarById(car.getId()).isPresent()).collect(Collectors.toSet());
        cars.removeAll(invalisCars);

        if(cars.isEmpty()) {
            throw new CarNotFoundException("You need to provide at least one car id to save Car Part for that car");
        }

        categoryService.getSubCategoryById(carPart.getSubCategory().getId())
                .orElseThrow(() -> new CategoryNotFoundException("there is no sub category with this id"));

        CarPartEntity carPartEntity = carPartRepository.save(mapper.map(carPart, CarPartEntity.class));
        return mapper.map(carPartEntity, CarPart.class);
    }

    @Override
    public List<CarPart> getCarPartsForSubCategoryId(Long subCategoryId) {

        categoryService.getSubCategoryById(subCategoryId).orElseThrow(() ->
                new CategoryNotFoundException("There is no sub category with this id"));

        java.lang.reflect.Type targetListType = new TypeToken<List<CarPart>>() {}.getType();

        return mapper.map(carPartRepository.findAllBySubCategoryId(subCategoryId), targetListType);
    }

    @Override
    public boolean removeCarPart(Long id) {
        carPartRepository.deleteById(id);
        return true;
    }

    private CarPart updateCarPartModel(CarPart oldCarPart, CarPart newCarPart) {
        oldCarPart.setCount(newCarPart.getCount() != null ? newCarPart.getCount() : oldCarPart.getCount());
        oldCarPart.setDescription(newCarPart.getCount() != null ? newCarPart.getDescription() : oldCarPart.getDescription());
        oldCarPart.setImage(newCarPart.getImage() != null ? newCarPart.getImage() : oldCarPart.getImage());
        oldCarPart.setNumber(newCarPart.getCount() != null ? newCarPart.getNumber() : oldCarPart.getNumber());
        oldCarPart.setPrice(newCarPart.getPrice() != null ? newCarPart.getPrice() : oldCarPart.getPrice());
        oldCarPart.setSubCategory(newCarPart.getSubCategory() != null ? newCarPart.getSubCategory() : oldCarPart.getSubCategory());
        oldCarPart.setName(newCarPart.getName() != null ? newCarPart.getName() : oldCarPart.getName());
        if (newCarPart.getCars() != null) {
            oldCarPart.getCars().addAll(newCarPart.getCars());
        }

        return oldCarPart;
    }
}
