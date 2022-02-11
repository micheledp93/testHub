package it.unikey.testhub_server.PL.controller;

import it.unikey.testhub_server.BLL.dto.request.AssessmentRequestDTO;
import it.unikey.testhub_server.BLL.dto.response.AssessmentPaginatorResponseDTO;
import it.unikey.testhub_server.BLL.dto.response.AssessmentResponseDTO;
import it.unikey.testhub_server.BLL.service.AssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/assessment")
@CrossOrigin("http://localhost:4200")
public class AssessmentController {

    private final AssessmentService assessmentService;

    @PutMapping(path = "/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        assessmentService.deleteAssessmentById(id);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<AssessmentPaginatorResponseDTO> getAssessmentByTags(Pageable page, @RequestParam(name = "tag", defaultValue = "") List<Long> tagIds) {
        if (tagIds.size() >= 1) {
            return new ResponseEntity<>(assessmentService.findAssessmentsByTags(tagIds, page), HttpStatus.OK);
        }
        return new ResponseEntity<>(assessmentService.findAll(page), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AssessmentResponseDTO> getById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(assessmentService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> saveAssessment(@RequestBody AssessmentRequestDTO assessmentRequestDTO) {
        assessmentService.saveAssessment(assessmentRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
