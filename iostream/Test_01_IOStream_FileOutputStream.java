package iostream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * <h2>Test_01_IOStream_FileOutputStream</h2>
 *
 * <p>
 * This class demonstrates how to write data into a file using
 * {@link java.io.FileOutputStream}.
 * </p>
 *
 * <p>
 * FileOutputStream is a <b>byte-oriented output stream</b> used to write
 * raw binary data (bytes) into a file.
 * </p>
 *
 * <p><b>Key points covered:</b></p>
 * <ul>
 *   <li>Writing single bytes using ASCII values</li>
 *   <li>Writing characters (auto-converted to bytes)</li>
 *   <li>Writing String data using {@code getBytes()}</li>
 *   <li>File creation and overwrite behavior</li>
 * </ul>
 *
 * <p>
 * If the file <b>abc.txt</b> does not exist, it will be created.
 * If it already exists, existing data will be overwritten.
 * </p>
 *
 * @author Nihir
 * @version 1.0
 */
public class Test_01_IOStream_FileOutputStream {

    /**
     * Entry point of the program.
     *
     * @param args command-line arguments (not used)
     * @throws IOException if an I/O error occurs during file operations
     */
    public static void main(String[] args) throws IOException {

        // Connecting Java application to the file abc.txt
        FileOutputStream fos = new FileOutputStream("abc.txt");

        /*
         * Writing data to the file:
         *
         * 97  -> ASCII value of 'a'
         * 'b' -> Character (converted to byte)
         * 'c' -> Character (converted to byte)
         */
        fos.write(97);     // writes 'a'
        fos.write('b');    // writes 'b'
        fos.write('c');    // writes 'c'

        /*
         * Writing String data:
         * String is converted into byte array using UTF-8 encoding
         */
        fos.write("Nihir".getBytes(StandardCharsets.UTF_8));

        // Confirmation message
        System.out.println("Data is saved successfully");

        // Closing the stream (mandatory to release system resources)
        fos.close();
    }
}
