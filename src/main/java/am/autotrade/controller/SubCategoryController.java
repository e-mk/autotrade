package am.autotrade.controller;

import am.autotrade.model.SubCategory;
import am.autotrade.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        return ResponseEntity.status(HttpStatus.OK).body(subCategory);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SubCategory> getSubCategory(@PathVariable Long id) {

        return categoryService.getSubCategoryById(id).map(subCategory -> ResponseEntity.status(200).body(subCategory))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteSubCategory(@PathVariable Long id) {
        if (categoryService.deleteSubCategory(id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("probably there is car parts registered for this sub category");
        }

        return ResponseEntity.status(HttpStatus.OK).body("deleted sub category with id :: " + id);
    }
}
