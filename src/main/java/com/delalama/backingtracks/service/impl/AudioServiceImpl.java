package com.delalama.backingtracks.service.impl;

import com.delalama.backingtracks.model.Audio;
import com.delalama.backingtracks.model.dto.AudioDto;
import com.delalama.backingtracks.repository.AudioRepository;
import com.delalama.backingtracks.service.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class AudioServiceImpl implements AudioService {

    @Autowired
    AudioRepository audioRepository;

    @Autowired
    ConversionService conversionService;

    @Override
    public AudioDto findById(String id) {
        return conversionService.convert(audioRepository.findById(id).orElseThrow(), AudioDto.class);
    }

    @Override
    public String save(byte[] data) {
        var audio = new Audio(data);

        String id = audioRepository.save(audio).getId();

        return id;
    }
}
