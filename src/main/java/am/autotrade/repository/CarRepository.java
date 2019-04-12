package am.autotrade.repository;

import am.autotrade.entity.CarEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CarRepository extends PagingAndSortingRepository<CarEntity, Long> {

    Optional<CarEntity> findByYearAndBrandAndModelAndModification(Integer year, String brand, String model, String modification);

    List<CarEntity> findByYear(Integer year);

    List<CarEntity> findByYearAndBrand(Integer year, String brand);

    List<CarEntity> findByYearAndBrandAndModel(Integer year, String brand, String model);

    @Query("select distinct c.year from CarEntity c order by c.year")
    Set<Integer> findAllDistinctYears();

    @Query("select distinct c.brand from CarEntity c where c.year = ?1")
    Set<String> findAllDistinctBrandsByYear(int year);

    @Query("select distinct c.model from CarEntity c where c.year = ?1 and c.brand = ?2")
    Set<String> findAllModelsByBrandsAndYear(int year, String Brand);

    @Query("select distinct c.modification from CarEntity c where c.year = ?1 and c.brand = ?2 and c.model = ?3")
    Set<String> findAllModificationByBrandsAndYearAndModel(int year, String brand, String model);
}
