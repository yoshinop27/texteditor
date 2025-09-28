package edu.grinnell.csc207.texteditor;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.nio.file.*;
import java.io.IO;
import java.io.IOException;
import java.security.Key;

import org.w3c.dom.Text;

import com.googlecode.lanterna.screen.Screen;

/**
 * The driver for the TextEditor Application.
 */
public class TextEditor {

    /**
     * The main entry point for the TextEditor application.
     * @param args command-line arguments.
     */
    public static void main(String[] args) throws IOException{
        // Create a gap buffer
        GapBuffer buffer = new GapBuffer();

        // load in file if given
        Path path = null;
        if (args.length == 1) {
            path = Paths.get(args[0]);
            if(Files.isRegularFile(path)) {
                String content = Files.readString(path);
                for (int i = 0; i < content.length(); i++) {
                    buffer.insert(content.charAt(i));
                }
            }
        }        

        // Create a screen to display the text editor
        Screen screen = new DefaultTerminalFactory().createScreen();
        screen.startScreen();
        drawBuffer(buffer, screen);

        // loop to read inputs and run buffer
        boolean isRunning = true;
        while (isRunning) {
            KeyStroke stroke = screen.readInput();
            // no input case
            if (stroke == null) continue;

            // retrieve key type
            KeyType t = stroke.getKeyType();
            // Handle cases
            switch (t) {
                case Character:
                    char c = stroke.getCharacter();
                    buffer.insert(c);
                    break; 
                case Backspace:
                    buffer.delete();
                    break;
                case ArrowLeft:
                    buffer.moveLeft();
                    break;
                case ArrowRight:
                    buffer.moveRight();
                    break;
                case Escape:
                    isRunning = false;
                    break;
                default:
                    break;
            }

            // draw buffer to screen
            drawBuffer(buffer, screen);
        }
        screen.stopScreen();
        if (args.length == 1) {
            Files.writeString(path, buffer.toString());
        }
    }
    /**
     * Draws the contents of the buffer to the screen.
     * @param buf the buffer to draw
     * @param screen the screen to draw to
     */
    public static void drawBuffer(GapBuffer buf, Screen screen) throws IOException {
        // clear screen
        screen.clear();
        // get contents
        String text = buf.toString();
        // write content to back buffer
        for (int i = 0; i < text.length(); i++) {
            int row = i/20;
            int col = i%20;
            char ch = text.charAt(i);
            TextCharacter tc = TextCharacter.fromCharacter(ch)[0];
            screen.setCharacter(col, row, tc);
        }
        // insert cursor
        int cursorPos = buf.getCursorPosition();
        int cursorRow = cursorPos/20;
        int cursorCol = cursorPos % 20;
        screen.setCursorPosition(new TerminalPosition(cursorCol, cursorRow));

        // back to front buffer
        screen.refresh();
    }
}
