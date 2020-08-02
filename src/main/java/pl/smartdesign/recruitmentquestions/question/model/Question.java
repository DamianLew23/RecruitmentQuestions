package pl.smartdesign.recruitmentquestions.question.model;

import pl.smartdesign.recruitmentquestions.category.model.Category;
import pl.smartdesign.recruitmentquestions.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    private Long id;
    private String content;
    private String description;
    private LocalDate creationDate;
    private Integer plusRate;
    private Integer minusRate;
    @Enumerated(value = EnumType.STRING)
    private Level level;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Question() {}

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getPlusRate() {
        return plusRate;
    }

    public void setPlusRate(Integer plusRate) {
        this.plusRate = plusRate;
    }

    public Integer getMinusRate() {
        return minusRate;
    }

    public void setMinusRate(Integer minusRate) {
        this.minusRate = minusRate;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
