package iostream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * <h2>Test_02_IOStream_FileInputStream</h2>
 *
 * <p>
 * This class demonstrates how to read data from a file using
 * {@link java.io.FileInputStream}.
 * </p>
 *
 * <p>
 * FileInputStream is a <b>byte-oriented input stream</b> used to read
 * raw binary data from a file, one byte at a time or in bulk.
 * </p>
 *
 * <p><b>Concepts covered:</b></p>
 * <ul>
 *   <li>Reading bytes sequentially using {@code read()}</li>
 *   <li>End-of-file detection using {@code -1}</li>
 *   <li>Reading all bytes at once using {@code available()}</li>
 *   <li>Byte array traversal using normal and enhanced for-loops</li>
 * </ul>
 *
 * <p>
 * This program reads data from <b>abc.txt</b>, which was previously
 * written using {@link java.io.FileOutputStream}.
 * </p>
 *
 * @author Nihir
 * @version 1.0
 */
public class Test_02_IOStream_FileInputStream {

    /**
     * Entry point of the program.
     *
     * @param args command-line arguments (not used)
     * @throws IOException if file is not found or read operation fails
     */
    public static void main(String[] args) throws IOException {

        // Connecting Java application to the file abc.txt
        FileInputStream fis = new FileInputStream("abc.txt");

        /*
         * Reading all available bytes at once.
         * available() returns the number of remaining bytes in the file.
         */
        byte[] bytes = new byte[fis.available()];

        // Reading file data into byte array
        fis.read(bytes);

        /*
         * Printing raw byte array
         * (ASCII values stored in the file)
         */
        System.out.println(Arrays.toString(bytes));

        /*
         * Traversing byte array using normal for loop
         */
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }

        /*
         * Traversing byte array using enhanced for-each loop
         */
        for (int value : bytes) {
            System.out.println(value);
        }

        // Closing the stream (mandatory to avoid resource leak)
        fis.close();
    }
}
