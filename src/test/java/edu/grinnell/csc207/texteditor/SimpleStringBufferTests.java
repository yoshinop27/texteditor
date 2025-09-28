package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

public class SimpleStringBufferTests {

    @Test
    public void insert(){
        SimpleStringBuffer s = new SimpleStringBuffer();
        s.insert('a');
        assertEquals(1, s.getSize());
        assertEquals(1, s.getCursorPosition());
        assertEquals('a', s.getChar(0));
    }

    @Test
    public void delete(){
        SimpleStringBuffer s = new SimpleStringBuffer();
        s.insert('a');
        s.delete();
        assertEquals(0, s.getSize());
        assertEquals(0, s.getCursorPosition());
    }

    @Test
    public void moveLeft(){
        SimpleStringBuffer s = new SimpleStringBuffer();
        s.insert('a');
        s.moveLeft();
        assertEquals(0, s.getCursorPosition());
    }

    @Test
    public void moveRight(){
        SimpleStringBuffer s = new SimpleStringBuffer();
        s.insert('a');
        s.moveLeft();
        s.moveRight();
        assertEquals(1, s.getCursorPosition());
    }

    @Test
    public void complex(){
        SimpleStringBuffer s = new SimpleStringBuffer();
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
        SimpleStringBuffer s = new SimpleStringBuffer();
        s.moveLeft();
        assertEquals(0, s.getCursorPosition());
        s.insert('a');
        s.moveLeft();
        s.moveLeft();
        assertEquals(0, s.getCursorPosition());
    }

    @Test
    public void moveRightBoundaries(){
        SimpleStringBuffer s = new SimpleStringBuffer();
        s.moveRight();
        assertEquals(0, s.getCursorPosition());
        s.insert('a');
        s.moveRight();
        s.moveRight();
        assertEquals(1, s.getCursorPosition());
    }

    @Test
    public void deleteBoundaries(){
        SimpleStringBuffer s = new SimpleStringBuffer();
        s.delete();
        assertEquals(0, s.getSize());
        s.insert('a');
        s.delete();
        s.delete();
        assertEquals(0, s.getSize());
    }

    @Property
    public void insertProperty(@ForAll char ch){
        SimpleStringBuffer s = new SimpleStringBuffer();
        s.insert(ch);
        assertEquals(1, s.getSize());
        assertEquals(1, s.getCursorPosition());
        assertEquals(ch, s.getChar(0));
    }
}
