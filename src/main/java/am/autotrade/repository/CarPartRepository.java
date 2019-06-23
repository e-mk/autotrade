package am.autotrade.repository;

import am.autotrade.entity.CarPartEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CarPartRepository extends PagingAndSortingRepository<CarPartEntity, Long>  {

    List<CarPartEntity> findAllBySubCategoryId(Long subCategoryId);
}
