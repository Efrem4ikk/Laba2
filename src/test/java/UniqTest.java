import org.example.Main;
import org.example.Uniq;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UniqTest {

    @Test
    void test1() throws Exception {
        String[] strArgs = {"-u", "-o", "Output", "Input_Test1"};
        Main main = new Main();
        Uniq us = main.parseArguments(strArgs);
        List<String> expectedOutput = new ArrayList<>(Arrays.asList("enormous", "EnORMous", "lip", "lipp", "broad"));
        assertEquals(expectedOutput,(us.make_uniq()));
    }

    @Test
    void test2() throws Exception {
        String[] strArgs = {"-i", "-s", "2", "-o", "Output", "Input_Test2"};
        Main main = new Main();
        Uniq us = main.parseArguments(strArgs);
        List<String> expectedOutput = new ArrayList<>(Arrays.asList("Dance", "cold", "spectacular", "improve", "prove", "powerful"));
        assertEquals(expectedOutput,(us.make_uniq()));
    }

    @Test
    void test3() throws Exception {
        String[] strArgs = {"-i", "-u", "-o", "Output", "Input_Test3"};
        Main main = new Main();
        Uniq us = main.parseArguments(strArgs);
        List<String> expectedOutput = new ArrayList<>(Arrays.asList("structure", "hysterical", "sour", "toy"));
        assertEquals(expectedOutput,(us.make_uniq()));
    }
    @Test
    void test4() throws Exception {
        String[] strArgs = {"-i", "-c", "-o", "Output", "Input_Test4"};
        Main main = new Main();
        Uniq us = main.parseArguments(strArgs);
        List<String> expectedOutput = new ArrayList<>(Arrays.asList("3protective", "dear", "deap", "2squash", "squas", "mellow", "2distance"));
        assertEquals(expectedOutput,(us.make_uniq()));
    }

}