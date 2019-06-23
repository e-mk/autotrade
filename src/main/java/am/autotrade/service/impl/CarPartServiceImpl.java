package am.autotrade.service.impl;

import am.autotrade.entity.CarPartEntity;
import am.autotrade.exception.CarPartNotFoundException;
import am.autotrade.exception.CategoryNotFoundException;
import am.autotrade.model.CarPart;
import am.autotrade.repository.CarPartRepository;
import am.autotrade.service.CarPartService;
import am.autotrade.service.CategoryService;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarPartServiceImpl implements CarPartService {

    @Autowired
    private CarPartRepository carPartRepository;

    @Autowired
    private CategoryService categoryService;

    private ModelMapper mapper;

    @Autowired
    public CarPartServiceImpl(ModelMapper mapper) {
        this.mapper = mapper;

    }

    @Override
    public Optional<CarPart> getCarPartById(Long carPartId) {

        Optional<CarPartEntity> carPartEntityOpt = carPartRepository.findById(carPartId);

        carPartEntityOpt.orElseThrow(() -> new CarPartNotFoundException("No car part with this id"));

        CarPart carPart = mapper.map(carPartEntityOpt.get(), CarPart.class);

        return Optional.of(carPart);
    }

    @Override
    public CarPart saveCarPart(CarPart carPart) {

        if (carPart.getSubCategory() == null || carPart.getSubCategory().getId() == null) {
            throw new CategoryNotFoundException("You need to provide sub category id to save Car Part for that sub category");
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
}
