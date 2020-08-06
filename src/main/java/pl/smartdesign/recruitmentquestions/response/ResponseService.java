package pl.smartdesign.recruitmentquestions.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.smartdesign.recruitmentquestions.response.model.Response;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ResponseService {

    private final ResponseRepository responseRepository;

    @Autowired
    public ResponseService(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    public Response getResponseById(Long responseId) {
        return responseRepository.findById(responseId).orElseThrow(
                () -> new EntityNotFoundException(
                        "Odpowiedź o ID: " + responseId + " Nie Istnieje w Bazie Danych."));
    }

    public List<Response> getResponsesByQuestionId(Long questionId) {
        return responseRepository.findAllByQuestion_Id(questionId);
    }

    public Response addResponse(Response newResponseRequest) {
        return null;
    }

    public Response updateResponse(Response updateResponseRequest) {
        return null;
    }

    public void deleteResponseById(Long responseId) {
        responseRepository.deleteById(responseId);
    }
}
