package pl.smartdesign.recruitmentquestions.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.smartdesign.recruitmentquestions.category.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Long, Category> {
}
