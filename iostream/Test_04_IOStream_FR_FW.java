package iostream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <h2>Test_04_IOStream_FR_FW</h2>
 *
 * <p>
 * This class demonstrates a <b>file copy operation</b> using
 * <b>character-oriented streams</b>:
 * {@link java.io.FileReader} and {@link java.io.FileWriter}.
 * </p>
 *
 * <p>
 * The program reads character data from a source text file
 * (<b>abc.txt</b>) and writes it into a destination file
 * (<b>cbc.txt</b>) character by character.
 * </p>
 *
 * <p><b>Concepts Covered:</b></p>
 * <ul>
 *   <li>Character Streams</li>
 *   <li>Unicode / text-based file handling</li>
 *   <li>Sequential reading using read()</li>
 *   <li>End-of-file detection using -1</li>
 * </ul>
 *
 * <p>
 * <b>Note:</b> FileReader and FileWriter are best suited for
 * text files, not binary data.
 * </p>
 *
 * @author Nihir
 * @version 1.0
 */
public class Test_04_IOStream_FR_FW {

    /**
     * Entry point of the application.
     *
     * @param args command-line arguments (not used)
     * @throws IOException if any file read/write operation fails
     */
    static void main(String[] args) throws IOException {

        // Connecting FileReader to source text file
        FileReader fr = new FileReader("abc.txt");

        // Connecting FileWriter to destination text file
        FileWriter fw = new FileWriter("cbc.txt");

        // Variable to hold one character at a time
        int data;

        /*
         * Reading characters one by one until end of file (-1)
         * and writing them to destination file
         */
        while ((data = fr.read()) != -1) {
            fw.write(data);
        }

        System.out.println("Copy Operation Completed");

        // Closing streams to release system resources
        fr.close();
        fw.close();
    }
}
