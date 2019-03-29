package am.autotrade.repository;

import am.autotrade.entity.CarEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Set;

public interface CarRepository extends PagingAndSortingRepository<CarEntity, Long> {

    List<CarEntity> findByYear(Integer year);

    List<CarEntity> findByYearAndBrand(Integer year, String brand);

    List<CarEntity> findByYearAndBrandAndModel(Integer year, String brand, String model);

    @Query("select distinct c.year from CarEntity c order by c.year")
    Set<Integer> findAllDistinctYears();

    @Query("select c.brand from CarEntity c where c.year = ?1")
    Set<String> findAllDistinctBrandsByYear(int year);
}
