package pl.smartdesign.recruitmentquestions.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.smartdesign.recruitmentquestions.question.model.NewQuestionRequest;
import pl.smartdesign.recruitmentquestions.question.model.Question;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question getQuestionById(Long questionId) {
        return questionRepository.findById(questionId).orElseThrow(
                () -> new EntityNotFoundException(
                        "Pytanie o ID: " + questionId + " Nie Istnieje w Bazie Danych."));
    }

    public Page<Question> getQuestions(Specification<Question> specification, Pageable pageable) {
        return questionRepository.findAll(specification, pageable);
    }

    public Question addQuestion(NewQuestionRequest addQuestionRequest) {
        Question newQuestion = new Question();
        newQuestion.setTitle(addQuestionRequest.getTitle());
        newQuestion.setDescription(addQuestionRequest.getDescription());
        newQuestion.setCategory(null);
        newQuestion.setCreationDate(LocalDate.now());
        newQuestion.setLevel(null);
        return questionRepository.save(newQuestion);
    }

    public Question updateQuestion(Long questionId, NewQuestionRequest updateQuestionRequest) {
        Question questionToUpdate = getQuestionById(questionId);
        questionToUpdate.setTitle(updateQuestionRequest.getTitle());
        questionToUpdate.setDescription(updateQuestionRequest.getDescription());
        questionToUpdate.setLevel(null);
        questionToUpdate.setCategory(null);
        questionToUpdate.setCreationDate(LocalDate.now());
        return questionRepository.save(questionToUpdate);
    }

    public void deleteQuestionById(Long questionId) {
        questionRepository.deleteById(questionId);
    }
}
