package am.autotrade.service.impl;

import am.autotrade.entity.CategoryEntity;
import am.autotrade.entity.SubCategoryEntity;
import am.autotrade.exception.CategoryNotFoundException;
import am.autotrade.model.Category;
import am.autotrade.model.CategoryInfo;
import am.autotrade.model.SubCategory;
import am.autotrade.repository.CategoryRepository;
import am.autotrade.repository.SubCategoryRepository;
import am.autotrade.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Category saveCategory(Category category) {
        CategoryEntity categoryEntity = mapper.map(category, CategoryEntity.class);
        categoryEntity = categoryRepository.save(categoryEntity);

        return mapper.map(categoryEntity, Category.class);
    }

    @Override
    public Optional<Category> getCategoryById(Long id) {

        Optional<CategoryEntity> categoryEntityOpt = categoryRepository.findById(id);
        categoryEntityOpt.orElseThrow(() -> new CategoryNotFoundException(String.format("Category with id :: %d not found", id)));

        Category category = mapper.map(categoryEntityOpt.get(), Category.class);

        return Optional.of(category);
    }

    @Override
    public SubCategory saveSubCategory(SubCategory subCategory) {

        if (subCategory.getCategory() == null || subCategory.getCategory().getId() == null) {
            throw new CategoryNotFoundException("Can't add sub category to non existing category!");
        }

        Optional<CategoryEntity> categoryEntityOpt = categoryRepository.findById(subCategory.getCategory().getId());

        categoryEntityOpt.orElseThrow(() -> new CategoryNotFoundException("Can't add sub category to non existing category!"));

        SubCategoryEntity subCategoryEntity = mapper.map(subCategory, SubCategoryEntity.class);
        subCategoryEntity.setCategory(categoryEntityOpt.get());
        subCategoryEntity = subCategoryRepository.save(subCategoryEntity);

        return mapper.map(subCategoryEntity, SubCategory.class);
    }

    @Override
    public Optional<SubCategory> getSubCategoryById(Long id) {
        Optional<SubCategoryEntity> subCategoryEntityOpt = subCategoryRepository.findById(id);

        Optional<SubCategory> subCategoryOpt = subCategoryEntityOpt.map(SubCategoryEntity -> mapper.map(SubCategoryEntity, SubCategory.class));

        if (!subCategoryOpt.isPresent()) {
            return Optional.empty();
        }

        SubCategory subCategory = subCategoryOpt.get();
        CategoryEntity categoryEntity = subCategoryEntityOpt.get().getCategory();
        subCategory.setCategory(new CategoryInfo(mapper.map(categoryEntity, Category.class)));
        //TODO add mappings..
        return Optional.of(subCategory);
    }

    @Override
    public Optional<SubCategory> getSubCategory(SubCategory subCategory) {
        return Optional.empty();
    }

}
