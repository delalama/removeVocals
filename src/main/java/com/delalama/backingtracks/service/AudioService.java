package com.delalama.backingtracks.service;

import com.delalama.backingtracks.model.dto.AudioDto;

import java.awt.color.ICC_Profile;

public interface AudioService {

    AudioDto findById(String id);

    String save(byte[] data);

}
