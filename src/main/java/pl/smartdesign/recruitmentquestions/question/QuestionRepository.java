package pl.smartdesign.recruitmentquestions.question;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.smartdesign.recruitmentquestions.question.model.Question;

@Repository
public interface QuestionRepository extends
        PagingAndSortingRepository<Question, Long>,
        JpaSpecificationExecutor<Question> {

}
