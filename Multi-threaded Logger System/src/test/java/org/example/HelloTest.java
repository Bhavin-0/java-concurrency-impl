package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {


    void testHelloMsg(){
        String expected = "HEllO";
        String actual = "HEllO";
        assertEquals(expected,actual);
    }
}
