package com.delalama.backingtracks.controller;

import com.delalama.backingtracks.model.Audio;
import com.delalama.backingtracks.service.AudioService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@AllArgsConstructor
@Slf4j
@RequestMapping("audio")
@RestController
public class audioController {

    private final AudioService audioService;

    @ResponseBody
    @GetMapping(produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getAudio(
            @RequestParam String id){
        Audio audio = new Audio();
        log.info("Audio Controller : getAudio");
        return new ResponseEntity<byte[]>(audioService.findById(id).getData(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> postAudio(
            @RequestBody MultipartFile file) throws IOException {
        log.info("Audio Controller : postAudio");
        byte[] data = file.getBytes();
        return new ResponseEntity<>(audioService.save(data), HttpStatus.OK);
    }
}
