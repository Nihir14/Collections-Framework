package iostream;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * <h2>Test_09_IOStream_DataInputStream</h2>
 *
 * <p>
 * This class demonstrates how to read <b>primitive data types</b>
 * from a file using {@link java.io.DataInputStream}.
 * </p>
 *
 * <p>
 * {@code DataInputStream} is a <b>byte-oriented input stream</b> that
 * reads Java primitive data types in a <b>machine-independent</b> format.
 * </p>
 *
 * <p><b>Important Rule:</b></p>
 * <ul>
 *   <li>Data must be read in the <b>same order</b> in which it was written
 *       using {@link java.io.DataOutputStream}</li>
 * </ul>
 *
 * <p>
 * This program reads data written by
 * {@code Test_08_IOStream_DataOutputStream}.
 * </p>
 *
 * @author Nihir
 * @version 1.0
 */
public class Test_09_IOStream_DataInputStream {

    /**
     * Entry point of the application.
     *
     * @param args command-line arguments (not used)
     * @throws IOException if file read operation fails
     */
    static void main(String[] args) throws IOException {

        // Creating DataInputStream by wrapping FileInputStream
        DataInputStream dis =
                new DataInputStream(new FileInputStream("abc.txt"));

        /*
         * Reading primitive data types.
         * Order must exactly match the writing order:
         *
         * writeByte()  -> readByte()
         * writeShort() -> readShort()
         * writeInt()   -> readInt()
         */
        System.out.println(dis.readByte());   // reads 1 byte
        System.out.println(dis.readShort());  // reads 2 bytes
        System.out.println(dis.readInt());    // reads 4 bytes

        // Closing stream to release system resources
        dis.close();
    }
}
