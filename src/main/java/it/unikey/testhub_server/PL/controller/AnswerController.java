package it.unikey.testhub_server.PL.controller;

import it.unikey.testhub_server.BLL.dto.response.AnswerResponseDTO;
import it.unikey.testhub_server.BLL.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/answer")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class AnswerController {

    private final AnswerService answerService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<List<AnswerResponseDTO>> getAnswersByQuestion_id(@PathVariable("id")Long id){
        return new ResponseEntity<>(answerService.findAnswersByQuestion_id(id), HttpStatus.OK);
    }

    @GetMapping(path = "/byId/{id}")
    public ResponseEntity<AnswerResponseDTO> getAnswerById(@PathVariable("id")Long id){
        return new ResponseEntity<>(answerService.findById(id), HttpStatus.OK);
    }

}
