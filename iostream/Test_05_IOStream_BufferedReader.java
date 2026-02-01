package iostream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * <h2>Test_05_IOStream_BufferedReader</h2>
 *
 * <p>
 * This class demonstrates how to read text data from a file
 * using {@link java.io.BufferedReader}.
 * </p>
 *
 * <p>
 * BufferedReader is a <b>character-oriented buffered stream</b>
 * that reads text efficiently by buffering characters instead
 * of reading one character at a time from disk.
 * </p>
 *
 * <p><b>Concepts Covered:</b></p>
 * <ul>
 *   <li>BufferedReader with FileReader</li>
 *   <li>Reading text line by line</li>
 *   <li>Difference between readLine(), ready()</li>
 *   <li>Efficient file reading</li>
 * </ul>
 *
 * <p>
 * BufferedReader is preferred over FileReader when:
 * <ul>
 *   <li>Reading large text files</li>
 *   <li>Line-by-line processing is required</li>
 * </ul>
 * </p>
 *
 * @author Nihir
 * @version 1.0
 */
public class Test_05_IOStream_BufferedReader {

    /**
     * Entry point of the application.
     *
     * @param args command-line arguments (not used)
     * @throws IOException if file is not found or read operation fails
     */
    public static void main(String args[]) throws IOException {

        // Creating BufferedReader by wrapping FileReader
        BufferedReader br = new BufferedReader(new FileReader("abc.txt"));

        /*
         * Method 1 (Recommended):
         * Reading file line by line until end of file.
         *
         * String line;
         * while ((line = br.readLine()) != null) {
         *     System.out.println(line);
         * }
         */

        /*
         * Method 2:
         * Using ready() method to check if stream is ready to be read.
         *
         * Note:
         * ready() checks availability of data, not end-of-file reliably.
         * It should be used carefully.
         */
        while (br.ready()) {
            System.out.println(br.readLine());
        }

        // Closing BufferedReader to release system resources
        br.close();
    }
}
