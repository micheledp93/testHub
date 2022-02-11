package it.unikey.testhub_server.BLL.service;

import it.unikey.testhub_server.BLL.dto.response.TagResponseDTO;

import java.util.List;

public interface TagService {

    List<TagResponseDTO> findAllTags();
    TagResponseDTO getTag(String description);

}
