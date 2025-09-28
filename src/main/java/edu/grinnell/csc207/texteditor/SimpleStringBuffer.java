package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer {
    
    private String simpleStringBuffer;
    private int cursor;

    /**
     * initializes an empty string buffer
     * 
     */
    public SimpleStringBuffer() {
        simpleStringBuffer = "";
        cursor = 0;
    }

    /** 
     * adds a new character at positon of our cursor to the buffer
     * @param ch character to be added to buffer
     */
    public void insert(char ch) {
        String front = simpleStringBuffer.substring(0, cursor);
        String back = simpleStringBuffer.substring(cursor);
        simpleStringBuffer = front + ch + back;
        cursor++;
    }

    /**
     * deletes character at index one less than our cursor
     */
    public void delete() {
        // base case do nothing
        if (cursor == 0) return;
        String front = simpleStringBuffer.substring(0, cursor-1);
        String back = simpleStringBuffer.substring(cursor);
        simpleStringBuffer = front + back;
        cursor--;
    }

    /**
     * @return cursor postion
     */
    public int getCursorPosition() {
        return cursor;
    }

    /**
     * moves cursor to index - 1
     */
    public void moveLeft() {
        if (cursor == 0) return;
        cursor -= 1;
    }

    /**
     * moves cursor to index + 1
     */
    public void moveRight() {
        if (cursor == this.getSize()) return;
        cursor+=1;
    }

    /**
     * @return size of string buffer
     */
    public int getSize() {
        return simpleStringBuffer.length();
    }

    /**
     * @return char at index i
     * @param i an integer within our string buffer
     */
    public char getChar(int i) throws IndexOutOfBoundsException{
        if (i < 0 || i >= this.getSize()) throw new IndexOutOfBoundsException();
        return simpleStringBuffer.charAt(i);
    }

    /**
     * @return simple string buffer text as a string
     */
    @Override
    public String toString() {
        return simpleStringBuffer;  
    }
}
