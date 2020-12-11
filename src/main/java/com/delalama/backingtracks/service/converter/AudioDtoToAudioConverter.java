package com.delalama.backingtracks.service.converter;

import com.delalama.backingtracks.model.Audio;
import com.delalama.backingtracks.model.dto.AudioDto;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AudioDtoToAudioConverter implements Converter<AudioDto, Audio> {
    @Override
    public Audio convert(AudioDto imageDto) {
        return new ModelMapper().map(imageDto, Audio.class);
    }
}
