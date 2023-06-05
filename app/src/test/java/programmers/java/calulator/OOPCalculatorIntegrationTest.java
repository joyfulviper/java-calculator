/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package programmers.java.calulator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import programmers.java.calulator.common.Calculator;
import programmers.java.calulator.console.reader.ConsoleReader;
import programmers.java.calulator.console.runner.ConsoleRunner;
import programmers.java.calulator.console.writer.ConsoleWriter;

import java.io.*;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;


public class OOPCalculatorIntegrationTest {
    private final ByteArrayOutputStream testOut = new ByteArrayOutputStream();
    private final PrintStream systemOut = System.out;
    private final InputStream systemIn = System.in;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(systemOut);
        System.setIn(systemIn);

    }

    @Test
    @DisplayName("객체지향 계산기 통합 테스트")
    public void 통합테스트() {
        String[] inputs = { "2", "1 + 3", "2", "1 + 2 * 3", "2", "3 - 2 * 2", "1", "exit" };
        InputStream in = new ByteArrayInputStream(String.join("\n", inputs).getBytes());
        System.setIn(in);


        assertThrows(IllegalArgumentException.class, () -> {
            new ConsoleRunner(new Calculator(), new ConsoleReader(), new ConsoleWriter(), new HashMap<>()).run();
        });
        String output = testOut.toString();

        assertTrue(output.contains("1. 조회"));
        assertTrue(output.contains("2. 계산"));
        assertTrue(output.contains("1 + 3 = 4"));
        assertTrue(output.contains("1 + 2 * 3 = 7"));
        assertTrue(output.contains("3 - 2 * 2 = -1"));
    }
}

