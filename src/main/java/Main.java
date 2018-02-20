import com.sun.corba.se.impl.corba.EnvironmentImpl;
import file.ReadFile;
import file.WriteFile;
import org.omg.CORBA.Environment;
import parser.Parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        ReadFile readFile = new ReadFile();
        Parser parser = new Parser();
        WriteFile writeFile = new WriteFile();
        properties.load(new FileInputStream("src\\main\\resources\\app.properties"));
        String intupFile = properties.getProperty("input.file");
        String outputFile = properties.getProperty("output.file");
        List yamlFile = readFile.readYaml(intupFile);
        List<StringBuilder> propertiesList = parser.yamlToProperties(yamlFile);
        writeFile.writeFile(propertiesList,outputFile);
    }
}
