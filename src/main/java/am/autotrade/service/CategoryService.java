package am.autotrade.service;

import am.autotrade.model.Category;
import am.autotrade.model.SubCategory;

import java.util.Optional;

public interface CategoryService {

    Category saveCategory(Category category);

    Optional<Category> getCategoryById(Long id);

    SubCategory saveSubCategory(SubCategory subCategory);

    Optional<SubCategory> getSubCategoryById(Long id);

    Optional<SubCategory> getSubCategory(SubCategory subCategory);

}
