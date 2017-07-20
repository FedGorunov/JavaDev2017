package jdev.server.services;

import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by pinta on 17.07.2017.
 */

@Service
public class FileService {
    private File file = new File("server-core//src//main//resources//tracks.txt");

    public void writeInFile(String data) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(file, true))) {
            br.write(data + System.getProperty("line.separator"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
