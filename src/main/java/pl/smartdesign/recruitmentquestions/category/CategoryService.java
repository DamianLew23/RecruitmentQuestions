package pl.smartdesign.recruitmentquestions.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.smartdesign.recruitmentquestions.category.model.Category;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(
                () -> new EntityNotFoundException(
                        "Kategoria o ID: " + categoryId + " Nie Istnieje w Bazie Danych."));
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category addCategory(Category newCategory) {
        return categoryRepository.save(newCategory);
    }

    public Category updateCategory(Long categoryId, Category newCategory) {
        Category categoryToUpdate = getCategoryById(categoryId);
        categoryToUpdate.setName(newCategory.getName());
        return categoryToUpdate;
    }

    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
