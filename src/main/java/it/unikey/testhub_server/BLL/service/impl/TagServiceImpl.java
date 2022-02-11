package it.unikey.testhub_server.BLL.service.impl;

import it.unikey.testhub_server.BLL.mapper.TagResponseMapper;
import it.unikey.testhub_server.BLL.dto.response.TagResponseDTO;
import it.unikey.testhub_server.BLL.service.TagService;
import it.unikey.testhub_server.DAL.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final TagResponseMapper tagResponseMapper;

    @Override
    public List<TagResponseDTO> findAllTags() {
        return tagResponseMapper.asDTOList(tagRepository.findAll());
    }

    @Override
    public TagResponseDTO getTag(String inputDescription) {

        List<TagResponseDTO> list = tagResponseMapper.asDTOList(tagRepository.findAll());
        TagResponseDTO tagResponseDTO = new TagResponseDTO();
        for(TagResponseDTO tag : list){
            if(tag.getDescription().equals(inputDescription)){
                tagResponseDTO.setId(tag.getId());
                tagResponseDTO.setDescription(tag.getDescription());
                return tagResponseDTO;
            }
        }
        return null;
    }
}
