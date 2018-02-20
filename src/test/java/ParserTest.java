import file.ReadFile;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import parser.Parser;

import java.io.IOException;
import java.util.*;


public class ParserTest {
    private static final String path = "src\\main\\resources\\fileFoTest\\";
    private List<List<String>> inputFile;
    private List<List<String>> ounputFile;
    private Parser parser;
    private ReadFile readFile;

    @Before
    public void init() throws IOException {
        parser = new Parser();
        readFile = new ReadFile();
        inputFile = new ArrayList<>();
        ounputFile = new ArrayList<>();
        inputFile.add(readFile.readYaml(path + "test1.yaml"));
        ounputFile.add(readFile.readYaml(path + "result-test1.properties"));
    }

    @After
    public void endTest() {

    }

    @Test
    public void Test() {
        List<StringBuilder> list = parser.yamlToProperties(inputFile.get(0));
        Assert.assertTrue(ounputFile.get(0).toString().equals(list.toString()));

    }

}
