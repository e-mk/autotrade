package am.autotrade.service;

import am.autotrade.model.CarPart;

import java.util.List;
import java.util.Optional;

public interface CarPartService {

    Optional<CarPart> getCarPartById(Long carPartId);

    CarPart saveOrUpdateCarPart(CarPart carPart);

    List<CarPart> getCarPartsForSubCategoryId(Long subCategoryId);

    boolean removeCarPart(Long id);
}
