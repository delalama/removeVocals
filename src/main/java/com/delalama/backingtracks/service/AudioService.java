package com.delalama.backingtracks.service;

import com.delalama.backingtracks.model.dto.AudioDto;
import org.springframework.core.io.ByteArrayResource;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public interface AudioService {

    AudioDto findById(String id);

    ByteArrayResource save(byte[] data) throws IOException, UnsupportedAudioFileException;
}
