package iostream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <h2>Test_06_IOStream_BufferedReaderFilter</h2>
 *
 * <p>
 * This class demonstrates how to:
 * <ul>
 *   <li>Read text data line by line using {@link BufferedReader}</li>
 *   <li>Apply filtering logic on each line</li>
 *   <li>Write filtered data into another file using {@link FileWriter}</li>
 * </ul>
 * </p>
 *
 * <p>
 * Only those lines from the source file (<b>abc.txt</b>) that contain
 * the substring <b>"mm"</b> are copied into the destination file
 * (<b>dbc.txt</b>).
 * </p>
 *
 * <p><b>Concepts Covered:</b></p>
 * <ul>
 *   <li>Buffered character streams</li>
 *   <li>Line-by-line file processing</li>
 *   <li>Conditional filtering of file content</li>
 *   <li>Writing filtered output to a new file</li>
 * </ul>
 *
 * <p>
 * This approach is commonly used in:
 * <ul>
 *   <li>Log file filtering</li>
 *   <li>Text data processing</li>
 *   <li>Configuration file parsing</li>
 * </ul>
 * </p>
 *
 * @author Nihir
 * @version 1.0
 */
public class Test_06_IOStream_BufferedReaderFilter {

    /**
     * Entry point of the application.
     *
     * @param args command-line arguments (not used)
     * @throws IOException if file read/write operation fails
     */
    static void main(String[] args) throws IOException {

        // Connecting BufferedReader to the source text file
        BufferedReader br = new BufferedReader(new FileReader("abc.txt"));

        // Connecting FileWriter to the destination file
        FileWriter fw = new FileWriter("dbc.txt");

        /*
         * Reading the source file line by line.
         * Only lines containing "mm" are written to the destination file.
         */
        while (br.ready()) {

            String line = br.readLine();

            if (line.contains("mm")) {
                fw.write(line);
                fw.write("\n"); // new line after each matching line
            }
        }

        // Ensures all buffered data is written to the file
        fw.flush();

        System.out.println("Data copied successfully.");

        // Closing resources to avoid memory/resource leaks
        br.close();
        fw.close();
    }
}
