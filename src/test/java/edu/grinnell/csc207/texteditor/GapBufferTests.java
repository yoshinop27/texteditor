package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

public class GapBufferTests {
    /** TODO: fill me in with unit and property tests! */
    @Test
    public void insert(){
        GapBuffer s = new GapBuffer();
        s.insert('a');
        assertEquals(1, s.getSize());
        assertEquals(1, s.getCursorPosition());
        assertEquals('a', s.getChar(0));
    }

    @Test
    public void delete(){
        GapBuffer s = new GapBuffer();
        s.insert('a');
        s.delete();
        assertEquals(0, s.getSize());
        assertEquals(0, s.getCursorPosition());
    }

    @Test
    public void moveLeft(){
        GapBuffer s = new GapBuffer();
        s.insert('a');
        s.moveLeft();
        assertEquals(0, s.getCursorPosition());
    }

    @Test
    public void moveRight(){
        GapBuffer s = new GapBuffer();
        s.insert('a');
        s.moveLeft();
        s.moveRight();
        assertEquals(1, s.getCursorPosition());
    }

    @Test
    public void complex(){
        GapBuffer s = new GapBuffer();
        s.insert('a');
        s.insert('b');
        s.insert('c');
        s.moveLeft();
        s.delete();
        s.insert('d');
        s.moveLeft();
        s.moveLeft();
        s.insert('e');
        assertEquals(4, s.getSize());
        assertEquals(1, s.getCursorPosition());
        assertEquals('e', s.getChar(0));
        assertEquals('a', s.getChar(1));
        assertEquals('d', s.getChar(2));
        assertEquals('c', s.getChar(3));
        assertEquals("eadc", s.toString());
    }

    @Test
    public void moveLeftBoundaries(){
        GapBuffer s = new GapBuffer();
        s.moveLeft();
        assertEquals(0, s.getCursorPosition());
        s.insert('a');
        s.moveLeft();
        s.moveLeft();
        assertEquals(0, s.getCursorPosition());
    }

    @Test
    public void moveRightBoundaries(){
        GapBuffer s = new GapBuffer();
        s.moveRight();
        assertEquals(0, s.getCursorPosition());
        s.insert('a');
        s.moveRight();
        s.moveRight();
        assertEquals(1, s.getCursorPosition());
    }

    @Test
    public void deleteBoundaries(){
        GapBuffer s = new GapBuffer();
        s.delete();
        assertEquals(0, s.getSize());
        s.insert('a');
        s.delete();
        s.delete();
        assertEquals(0, s.getSize());
    }

    @Property
    public void insertProperty(@ForAll char ch){
        GapBuffer s = new GapBuffer();
        s.insert(ch);
        assertEquals(1, s.getSize());
        assertEquals(1, s.getCursorPosition());
        assertEquals(ch, s.getChar(0));
    }
}
