package iostream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * <h2>Test_07_IOStream_BufferedReaderFilterAppend</h2>
 *
 * <p>
 * This class demonstrates how to:
 * <ul>
 *   <li>Read text data line by line using {@link BufferedReader}</li>
 *   <li>Filter lines based on a condition</li>
 *   <li>Append filtered data into an existing file using {@link FileWriter}</li>
 * </ul>
 * </p>
 *
 * <p>
 * Only those lines from the source file (<b>abc.txt</b>) that contain
 * the substring <b>"mm"</b> are appended to the destination file
 * (<b>ebc.txt</b>).
 * </p>
 *
 * <p><b>Important Behavior:</b></p>
 * <ul>
 *   <li>The destination file is opened in <b>append mode</b></li>
 *   <li>Existing data in <b>ebc.txt</b> is NOT overwritten</li>
 *   <li>New matching lines are added at the end of the file</li>
 * </ul>
 *
 * <p>
 * This type of operation is commonly used in:
 * <ul>
 *   <li>Log file accumulation</li>
 *   <li>Incremental report generation</li>
 *   <li>Appending filtered records</li>
 * </ul>
 * </p>
 *
 * @author Nihir
 * @version 1.0
 */
public class Test_07_IOStream_BufferedReaderFilterAppend {

    /**
     * Entry point of the application.
     *
     * @param args command-line arguments (not used)
     * @throws IOException if file read/write operation fails
     */
    static void main(String[] args) throws IOException {

        // Connecting BufferedReader to the source file
        BufferedReader br = new BufferedReader(new FileReader("abc.txt"));

        /*
         * FileWriter with append flag set to true.
         * true  -> append mode
         * false -> overwrite mode (default)
         */
        FileWriter fw = new FileWriter("ebc.txt", true);

        /*
         * Reading the source file line by line.
         * Only lines containing "mm" are appended to the destination file.
         */
        while (br.ready()) {

            String line = br.readLine();

            if (line.contains("mm")) {
                fw.write(line);
                fw.write("\n"); // write each line on a new line
            }
        }

        // Ensures all buffered data is written to the file
        fw.flush();

        System.out.println("Data copied and appended successfully.");

        // Closing resources to prevent memory leaks
        br.close();
        fw.close();
    }
}
