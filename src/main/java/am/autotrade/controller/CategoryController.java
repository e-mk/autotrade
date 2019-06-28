package am.autotrade.controller;

import am.autotrade.model.Category;
import am.autotrade.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        return categoryService.getCategoryById(id).map(category -> ResponseEntity.status(200).body(category))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id) {
        if (categoryService.deleteCategory(id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("probably there is sub categories registered for this category");
        }

        return ResponseEntity.status(HttpStatus.OK).body("deleted category with id :: " + id);
    }
}
