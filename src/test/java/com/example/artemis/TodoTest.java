package com.example.artemis;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    @Test
    public void testToString() throws ArtemisException {
        Todo todo = new Todo("Buy groceries");
        String expected = "[T][ ] Buy groceries";
        String actual = todo.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testToFileString() {
        Todo todo = new Todo("Buy groceries");
        String expected = "T | 0 | Buy groceries";
        String actual = todo.toFileString();
        assertEquals(expected, actual);
    }
}
