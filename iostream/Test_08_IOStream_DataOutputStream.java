package iostream;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <h2>Test_08_IOStream_DataOutputStream</h2>
 *
 * <p>
 * This class demonstrates how to write <b>primitive data types</b>
 * into a file using {@link java.io.DataOutputStream}.
 * </p>
 *
 * <p>
 * {@code DataOutputStream} is a <b>byte-oriented stream</b> that allows
 * writing Java primitive data types in a <b>machine-independent</b> way.
 * </p>
 *
 * <p><b>Concepts Covered:</b></p>
 * <ul>
 *   <li>Writing primitive data types to a file</li>
 *   <li>Difference between write() and writeInt()/writeByte()</li>
 *   <li>Binary file creation</li>
 * </ul>
 *
 * <p>
 * Data written using {@code DataOutputStream} should always be read
 * using {@link java.io.DataInputStream} in the same order.
 * </p>
 *
 * @author Nihir
 * @version 1.0
 */
public class Test_08_IOStream_DataOutputStream {

    /**
     * Entry point of the application.
     *
     * @param args command-line arguments (not used)
     * @throws IOException if file write operation fails
     */
    public static void main(String[] args) throws IOException {

        // Creating DataOutputStream by wrapping FileOutputStream
        DataOutputStream dos =
                new DataOutputStream(new FileOutputStream("abc.txt"));

        /*
         * Writing primitive data types:
         *
         * writeByte(97)  -> writes 1 byte (ASCII of 'a')
         * writeShort(98) -> writes 2 bytes
         * writeInt(99)   -> writes 4 bytes
         *
         * Total bytes written = 1 + 2 + 4 = 7 bytes
         */
        dos.writeByte(97);
        dos.writeShort(98);
        dos.writeInt(99);

        System.out.println("Data saved successfully");

        // Closing stream to flush data and release resources
        dos.close();
    }
}
