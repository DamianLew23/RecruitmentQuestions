package pl.smartdesign.recruitmentquestions.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.smartdesign.recruitmentquestions.comment.model.Comment;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(
                () -> new EntityNotFoundException(
                        "Komentarz o ID: " + commentId + " Nie Istnieje w Bazie Danych."));
    }

    public List<Comment> getCommentsByResponseId(Long responseId) {
        return commentRepository.findAllByResponse_Id(responseId);
    }

    public Comment addComment(Comment newCommentRequest) {
        return commentRepository.save(newCommentRequest);
    }

    public Comment updateComment(Long commentId, Comment updateCommentRequest) {
        Comment commentToUpdate = getCommentById(commentId);
        commentToUpdate.setContent(updateCommentRequest.getContent());
        return commentRepository.save(commentToUpdate);
    }

    public void deleteCommentById(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
