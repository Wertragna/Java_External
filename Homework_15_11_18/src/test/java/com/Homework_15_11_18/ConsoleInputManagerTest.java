package com.Homework_15_11_18;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ConsoleInputManagerTest {

    @Test
    public void getKeyFromConsole_correctInput_correctResult() throws IOException {
        BufferedReader br = Mockito.mock(BufferedReader.class);
        when(br.readLine()).thenReturn("5");
        assertEquals(5, ConsoleInputManager.getKeyFromConsole(br));
    }

    @Test(expected = NumberFormatException.class)
    public void getKeyFromConsole_wrongInput_exception() throws IOException {
        BufferedReader br = Mockito.mock(BufferedReader.class);
        when(br.readLine()).thenReturn("asdf");
        ConsoleInputManager.getKeyFromConsole(br);
    }

    @Test
    public void getStringKeyFromConsole() throws IOException {
        BufferedReader br = Mockito.mock(BufferedReader.class);
        when(br.readLine()).thenReturn("5");
        assertEquals("5", ConsoleInputManager.getStringKeyFromConsole(br));
    }
}