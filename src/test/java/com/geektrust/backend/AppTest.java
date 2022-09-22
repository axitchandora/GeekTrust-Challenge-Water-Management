package com.geektrust.backend;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@DisplayName("AppTest")
class AppTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Integration Test #1")
    void runTest1(){
        //Arrange
        List<String> arguments= new ArrayList<>(Collections.singletonList("sample_input/input1.txt"));

        String expectedOutput = "2400 5215";
        //Act
        App.run(arguments);
        //Assert
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Integration Test #2")
    void runTest2(){
        //Arrange
        List<String> arguments= new ArrayList<>(Collections.singletonList("sample_input/input2.txt"));

        String expectedOutput = "3000 5750";
        //Act
        App.run(arguments);
        //Assert
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
    }

    @Test
    @DisplayName("Integration Test #3")
    void runTest3(){
        //Arrange
        List<String> arguments= new ArrayList<>(Collections.singletonList("sample_input/input3.txt"));

        String expectedOutput = "900 1200";
        //Act
        App.run(arguments);
        //Assert
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
