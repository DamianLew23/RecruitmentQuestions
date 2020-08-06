package pl.smartdesign.recruitmentquestions.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.smartdesign.recruitmentquestions.category.model.Category;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public Category getCategoryById(@PathVariable("categoryId") Long categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Category> getCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category addCategory(@RequestBody Category newCategory) {
        return categoryService.addCategory(newCategory);
    }

    @PutMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.OK)
    public Category updateCategory(
            @PathVariable("categoryId") Long categoryId,
            @RequestBody Category newCategory
    ) {
        return categoryService.updateCategory(categoryId, newCategory);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }

}
