package it.unikey.testhub_server.PL.controller;

import it.unikey.testhub_server.BLL.dto.request.QuestionRequestDTO;
import it.unikey.testhub_server.BLL.dto.response.QuestionPaginatorResponseDTO;
import it.unikey.testhub_server.BLL.dto.response.QuestionResponseDTO;
import it.unikey.testhub_server.BLL.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/question")
@CrossOrigin("http://localhost:4200")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<QuestionResponseDTO> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(questionService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<QuestionPaginatorResponseDTO> getQuestionsByTags(Pageable page, @RequestParam(name = "tag", defaultValue = "") List<Long> tagIds) {
        if (tagIds.size() >= 1) {
            return new ResponseEntity<>(questionService.findQuestionsByTags(tagIds, page), HttpStatus.OK);
        }
        return new ResponseEntity<>(questionService.findAll(page), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> saveQuestion(@RequestBody QuestionRequestDTO questionRequestDTO) {
        questionService.saveQuestion(questionRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public void logicDeleteById(@PathVariable("id") Long id) {
        questionService.logicDeleteById(id);
    }

}
