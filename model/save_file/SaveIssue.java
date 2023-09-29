package model.save_file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveIssue<E> implements Writable<E>{

    @Override
    public boolean writeToFile(E file, String path) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, false))) {
            bufferedWriter.write(file.toString());
            bufferedWriter.newLine();
        }
        return true;
    }
}
