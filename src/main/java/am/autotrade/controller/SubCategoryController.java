package am.autotrade.controller;

import am.autotrade.model.SubCategory;
import am.autotrade.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/sub-categories")
public class SubCategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<SubCategory> postSubCategory(@RequestBody SubCategory subCategory) {

        subCategory = categoryService.saveSubCategory(subCategory);

        return ResponseEntity.status(200).body(subCategory);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SubCategory> getSubCategory(@PathVariable Long id) {

        return categoryService.getSubCategoryById(id).map(subCategory -> ResponseEntity.status(200).body(subCategory))
                .orElse(ResponseEntity.notFound().build());
    }
}
