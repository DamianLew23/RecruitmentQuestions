package pl.smartdesign.recruitmentquestions.response.model;

import pl.smartdesign.recruitmentquestions.auth.model.User;
import pl.smartdesign.recruitmentquestions.question.model.Question;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "responses")
public class Response {

    @Id
    private Long id;
    private String content;
    private LocalDateTime responseDateTime;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Response() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getResponseDateTime() {
        return responseDateTime;
    }

    public void setResponseDateTime(LocalDateTime responseDateTime) {
        this.responseDateTime = responseDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
