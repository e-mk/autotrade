package am.autotrade.repository;

import am.autotrade.entity.CategoryEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<CategoryEntity, Long> {

}
