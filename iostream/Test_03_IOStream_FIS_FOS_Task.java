package iostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <h2>Test_03_IOStream_FIS_FOS_Task</h2>
 *
 * <p>
 * This class demonstrates a <b>file copy operation</b> using
 * {@link java.io.FileInputStream} and {@link java.io.FileOutputStream}.
 * </p>
 *
 * <p>
 * The program reads all bytes from a source file (<b>abc.txt</b>)
 * into a byte array and writes those bytes into a destination file
 * (<b>bbc.txt</b>).
 * </p>
 *
 * <p><b>Concepts covered:</b></p>
 * <ul>
 *   <li>Byte-oriented streams</li>
 *   <li>Reading file data into a byte buffer</li>
 *   <li>Writing byte data to another file</li>
 *   <li>Basic file copy mechanism</li>
 * </ul>
 *
 * <p>
 * This approach is suitable for small files.
 * For large files, buffered streams should be preferred.
 * </p>
 *
 * @author Nihir
 * @version 1.0
 */
public class Test_03_IOStream_FIS_FOS_Task {

    /**
     * Entry point of the program.
     *
     * @param args command-line arguments (not used)
     * @throws IOException if file read/write operation fails
     */
    static void main(String[] args) throws IOException {

        // Connecting input stream to source file
        FileInputStream fis = new FileInputStream("abc.txt");

        // Connecting output stream to destination file
        FileOutputStream fos = new FileOutputStream("bbc.txt");

        /*
         * Creating a byte array buffer of exact file size.
         * fis.available() returns number of bytes remaining in the file.
         */
        byte[] buffer = new byte[fis.available()];

        // Reading all bytes from source file into buffer
        fis.read(buffer);

        // Writing all bytes from buffer to destination file
        fos.write(buffer);

        System.out.println("Copy Operation Completed");

        // Closing streams to release system resources
        fis.close();
        fos.close();
    }
}
