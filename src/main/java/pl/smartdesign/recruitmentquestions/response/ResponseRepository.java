package pl.smartdesign.recruitmentquestions.response;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.smartdesign.recruitmentquestions.response.model.Response;

import java.util.List;

@Repository
public interface ResponseRepository extends JpaRepository<Response, Long> {
    List<Response> findAllByQuestion_Id(Long questionId);
}
