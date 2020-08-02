package pl.smartdesign.recruitmentquestions.question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.smartdesign.recruitmentquestions.question.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Long, Question> {
}
