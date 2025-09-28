package edu.grinnell.csc207.texteditor;
import java.util.Arrays;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {

    private char[] GapBuffer;
    private int cursor;
    private int bufferStart;
    private int bufferEnd;

    public GapBuffer() {
        GapBuffer = new char[10];
        cursor = 0;
        bufferStart = 0;
        bufferEnd = 10;
    }

    public void insert(char ch) {
        // throw new UnsupportedOperationException("Unimplemented method 'delete'");
        if (bufferStart == bufferEnd) {
            GapBuffer = Arrays.copyOf(GapBuffer, GapBuffer.length * 2);
            bufferEnd += GapBuffer.length / 2;
        }
        if (cursor <= bufferStart) {
            for (int i = bufferStart; i > cursor; i--) {
                GapBuffer[i] = GapBuffer[i - 1];
            }
            GapBuffer[cursor] = ch;
            bufferStart++;
            moveRight();
        } else {
            for (int i = bufferEnd; i < cursor; i++) {
                GapBuffer[i - 1] = GapBuffer[i];
            }
            GapBuffer[cursor - 1] = ch;
            bufferEnd--;
        }
    }

    public void delete() {
        // throw new UnsupportedOperationException("Unimplemented method 'delete'");
        if (cursor == 0) return;
        if (cursor <= bufferStart) {
            for (int i = cursor; i < bufferStart; i++) {
                GapBuffer[i - 1] = GapBuffer[i];
            }
            bufferStart--;
            moveLeft();
        } else {
            for (int i = cursor - 1; i > bufferEnd; i--) {
                GapBuffer[i] = GapBuffer[i - 1];
            }
            bufferEnd++;
        }
    }

    public int getCursorPosition() {
        // throw new UnsupportedOperationException("Unimplemented method 'getCursorPosition'");
        if (cursor <= bufferStart) {
            return cursor;
        }
        else {
            return cursor - (bufferEnd - bufferStart);
        }
    }

    public void moveLeft() {
        // throw new UnsupportedOperationException("Unimplemented method 'moveLeft'");
        if (cursor == bufferEnd) {
            cursor = bufferStart;
        }
        else if (cursor > 0){
            cursor--;
        }
    }

    public void moveRight() {
        // throw new UnsupportedOperationException("Unimplemented method 'moveRight'");
        if (cursor == bufferStart) {
            cursor = bufferEnd;
        }
        else if (cursor < GapBuffer.length - 1){
            cursor++;
        }
    }

    public int getSize() {
        // throw new UnsupportedOperationException("Unimplemented method 'getSize'");
        return (GapBuffer.length - (bufferEnd - bufferStart));
    }

    public char getChar(int i) {
        // throw new UnsupportedOperationException("Unimplemented method 'getChar'");
        if (i < bufferStart) {
            return GapBuffer[i];
        }
        else {
            return GapBuffer[i + (bufferEnd - bufferStart)];
        }
    }

    public String toString() {
        // throw new UnsupportedOperationException("Unimplemented method 'toString'");
        char[] front = new char[bufferStart];
        for (int i = 0; i < bufferStart; i++) {
            front[i] = GapBuffer[i];
        }
        char[] back = new char[GapBuffer.length - bufferEnd];
        for (int i = bufferEnd; i < GapBuffer.length; i++) {
            back[i] = GapBuffer[i];
        }

        return String.valueOf(front) + String.valueOf(back);
    }
}
