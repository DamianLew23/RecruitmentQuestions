package pl.smartdesign.recruitmentquestions.response;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.smartdesign.recruitmentquestions.response.model.Response;

@Repository
public interface ResponseRepository extends JpaRepository<Long, Response> {
}
