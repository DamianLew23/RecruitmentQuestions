package pl.smartdesign.recruitmentquestions.response.model;

import pl.smartdesign.recruitmentquestions.user.User;

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
}
