package edu.grinnell.csc207.texteditor;
import java.util.Arrays;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {

    private char[] gapBuffer;
    private int cursor;
    private int bufferStart;
    private int bufferEnd;

    public GapBuffer() {
        gapBuffer = new char[10];
        cursor = 0;
        bufferStart = 0;
        bufferEnd = 10;
    }
    /** 
     * adds a new character at positon of our cursor to the buffer
     * @param ch character to be added to buffer
     */
    public void insert(char ch) {
        // full case
        if (bufferStart == bufferEnd) {
            int size = this.getSize();
            int grow = gapBuffer.length;
            // create new array larger
            gapBuffer = Arrays.copyOf(gapBuffer, gapBuffer.length * 2);
            // move elements over
            for(int i = bufferEnd; i < size; i++) {
                gapBuffer[i + grow] = gapBuffer[i];
            }
            bufferEnd += grow;
        }
        // main case (O(1))
        gapBuffer[bufferStart] = ch;
        bufferStart++;
        cursor++;
    }

    /**
     * deletes character at index one less than our cursor
     */
    public void delete() {
        // edge case
        if (bufferStart <= 0) return;
        // main case
        bufferStart--;
        cursor--;
    }

    /**
     * @return cursor postion
     */
    public int getCursorPosition() {
        // throw new UnsupportedOperationException("Unimplemented method 'getCursorPosition'");
        if (cursor <= bufferStart) {
            return cursor;
        }
        else {
            return cursor - (bufferEnd - bufferStart);
        }
    }

    /**
     * moves cursor to index - 1
     */
    public void moveLeft() {
        // boundary
        if (cursor <= 0) return;
        // main case
        gapBuffer[bufferEnd-1] = gapBuffer[bufferStart-1]; // cursor at bufferstart is an invariant
        bufferStart--;
        bufferEnd--;
        cursor--;
    }

    /**
     * moves cursor to index + 1
     */
    public void moveRight() {
        // boundary
        if (cursor >= this.getSize()) return;
        // main case
        gapBuffer[bufferStart] = gapBuffer[bufferEnd]; // cursor at bufferstart is an invariant
        bufferStart++;
        bufferEnd++;
        cursor++;
    }

    public int getSize() {
        return (gapBuffer.length - (bufferEnd - bufferStart));
    }

    /**
     * @return char at index i
     * @param i an integer within our string buffer
     */
    public char getChar(int i) throws IndexOutOfBoundsException{
        if (i < 0 || i >= this.getSize()) throw new IndexOutOfBoundsException();
        if (i < bufferStart) {
            return gapBuffer[i];
        }
        else {
            return gapBuffer[i + (bufferEnd - bufferStart)];
        }
    }

    /**
     * @return the contents of the buffer as a String
     * 
     */
    public String toString() {
        // obtain front
        char[] front = new char[bufferStart];
        for (int i = 0; i < bufferStart; i++) {
            front[i] = gapBuffer[i];
        }
        // obtain back
        char[] back = new char[gapBuffer.length - bufferEnd];
        int write = 0;
        for (int i = bufferEnd; i < gapBuffer.length; i++) {
            back[write] = gapBuffer[i];
            write++;
        }

        return String.valueOf(front) + String.valueOf(back);
    }
}
