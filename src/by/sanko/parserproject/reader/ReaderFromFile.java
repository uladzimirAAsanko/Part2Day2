package by.sanko.parserproject.reader;

import by.sanko.parserproject.exeption.ReaderException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ReaderFromFile {
    private static final String RESOURCE_NAME = "resources.property.file";
    private static final String FILE_DOESNT_EXIST_MSG = "File does not exist";
    private static final String FILE_NAME = "filename";
    private static final String FILE_PATH = "path";
    private static final String RESOURCES_BUNDLE_DOESNT_EXIST_MSG = "ResourceBundle does not exist";
    private static final String SLASH = "/";
    private static final String SPACE = " ";
    private static final String PARAGRAPH_END = "\n";

    public String read() throws ReaderException{
        String pathOutput = getPath();
        String filePath = pathOutput.substring(0,pathOutput.indexOf(' '));
        String fileName = pathOutput.substring(pathOutput.indexOf(' ') + 1);
        String resultText = "";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath + SLASH + fileName))) {
            resultText = bufferedReader.lines().collect(Collectors.joining(PARAGRAPH_END));

        }catch (IOException e){
            StringBuilder msg = new StringBuilder(e.getMessage() + SPACE);
            for(Throwable t : e.getSuppressed()){
                msg.append(t.getMessage()).append(SPACE);
            }
            throw new ReaderException(msg.toString(),e);
        }
        return resultText;
    }

    private String getPath() throws ReaderException {
        try {
            ResourceBundle res = ResourceBundle.getBundle(RESOURCE_NAME);
            String filePath = res.getString(FILE_PATH);
            String fileName = res.getString(FILE_NAME);
            String path = "";
            if(Files.exists(Paths.get(filePath, fileName))) {
                path = filePath +" " + fileName;
            } else {
                throw new ReaderException(FILE_DOESNT_EXIST_MSG);
            }
            return path;
        } catch (MissingResourceException e) {
            throw new ReaderException(RESOURCES_BUNDLE_DOESNT_EXIST_MSG, e);
        }
    }
}
