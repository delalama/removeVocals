package com.delalama.backingtracks.service.impl;

import com.delalama.backingtracks.model.dto.AudioDto;
import com.delalama.backingtracks.repository.AudioRepository;
import com.delalama.backingtracks.service.AudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;

@Service
public class AudioServiceImpl implements AudioService {

    @Autowired
    AudioRepository audioRepository;

    @Autowired
    ConversionService conversionService;

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public AudioDto findById(String id) {
        return conversionService.convert(audioRepository.findById(id).orElseThrow(), AudioDto.class);
    }

    String SEPARATE_COMMAND = "python3 -m spleeter separate -i /home/elaltas/devel/java/backingtracks/src/main/resources/test.mp3 -p spleeter:2stems -o /home/elaltas/devel/java/backingtracks/src/main/resources/output";

    @Override
    public ByteArrayResource save(byte[] data) throws IOException, UnsupportedAudioFileException {
        ClassLoader classLoader = getClass().getClassLoader();

        createFile(data);
//        String id = audioRepository.save(audio).getId();

        runtimeCodeExecution();
        Resource resource = resourceLoader.getResource("classpath:test.mp3");

        System.out.println("PROCESO FINALIZADORRRRR");

//        processBuilder(SEPARATE_COMMAND);

        return new ByteArrayResource(createByteArray()) ;
    }


    private void runtimeCodeExecution() {
        try {

            //Run a bat file
            Process process = Runtime.getRuntime().exec(SEPARATE_COMMAND);

            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
                System.out.println(output);
            } else {
                //abnormal...
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    private void processBuilder(String SEPARATE_COMMAND) {
        ProcessBuilder processBuilder = new ProcessBuilder();

        // -- Linux --

        // Run a shell command
        processBuilder.command(SEPARATE_COMMAND);

        // Run a shell script
        //processBuilder.command("path/to/hello.sh");

        // -- Windows --

        // Run a command
        //processBuilder.command("cmd.exe", "/c", "dir C:\\Users\\mkyong");

        // Run a bat file
        //processBuilder.command("C:\\Users\\mkyong\\hello.bat");

        try {

            Process process = processBuilder.start();

            StringBuilder output = new StringBuilder();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
                System.out.println(output);
                System.exit(0);
            } else {
                //abnormal...
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void createFile(byte[] data) {
        writeByte(data);
    }

    private void writeByte(byte[] data) {
        String FILEPATH = "/home/elaltas/devel/java/backingtracks/src/main/resources/test.mp3";
        File file = new File(FILEPATH);
        try {

            OutputStream os = new FileOutputStream(file);

            os.write(data);
            System.out.println("Successfully"
                    + " byte inserted");

            os.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }


    private byte[] createByteArray() {
        String filePath = "/home/elaltas/devel/java/backingtracks/src/main/resources/output/test/accompaniment.wav";
        File file = new File(filePath);

        byte[] bytes = new byte[(int) file.length()];

        try(FileInputStream fis = new FileInputStream(file)){
            fis.read(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    private String getCommand() {

        return null;
    }


}
