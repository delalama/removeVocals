package com.delalama.backingtracks.service.converter;

import com.delalama.backingtracks.model.Audio;
import com.delalama.backingtracks.model.dto.AudioDto;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AudioToAudioDtoConverter implements Converter<Audio, AudioDto> {

    @Override
    public AudioDto convert(Audio audio){
        return new ModelMapper().map(audio, AudioDto.class);
    }
}
