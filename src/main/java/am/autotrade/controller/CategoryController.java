package am.autotrade.controller;

import am.autotrade.model.Category;
import am.autotrade.model.SubCategory;
import am.autotrade.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> postCategory(@RequestBody Category category) {

        category = categoryService.saveCategory(category);

        return ResponseEntity.status(200).body(category);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {

        return categoryService.getCategoryById(id).map(Category -> ResponseEntity.status(200).body(Category))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(value = "/sub")
    public ResponseEntity<SubCategory> postSubCategory(@RequestBody SubCategory subCategory) {

        subCategory = categoryService.saveSubCategory(subCategory);

        return ResponseEntity.status(200).body(subCategory);
    }

    @GetMapping(value = "/sub/{id}")
    public ResponseEntity<SubCategory> getSubCategory(@PathVariable Long id) {

        return categoryService.getSubCategoryById(id).map(subCategory -> ResponseEntity.status(200).body(subCategory))
                .orElse(ResponseEntity.notFound().build());
    }
}
