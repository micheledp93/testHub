package it.unikey.testhub_server.PL.controller;

import it.unikey.testhub_server.BLL.dto.response.TagResponseDTO;
import it.unikey.testhub_server.BLL.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tag")
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
public class TagController {

    public final TagService tagService;

    @GetMapping
    public ResponseEntity<List<TagResponseDTO>> getAllTags() {
        return new ResponseEntity<>(tagService.findAllTags(), HttpStatus.OK);
    }

    @GetMapping("/{description}")
    public ResponseEntity<TagResponseDTO> getTag(@PathVariable String description) {
        return new ResponseEntity<>(tagService.getTag(description), HttpStatus.OK);
    }


}
