package pl.smartdesign.recruitmentquestions.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.smartdesign.recruitmentquestions.comment.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Long, Comment> {
}
