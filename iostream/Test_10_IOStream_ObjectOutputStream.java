package iostream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * <h2>Test_10_IOStream_ObjectOutputStream</h2>
 *
 * <p>
 * This class demonstrates <b>Object Serialization</b> using
 * {@link java.io.ObjectOutputStream}.
 * </p>
 *
 * <p>
 * Serialization is the process of converting an object
 * into a <b>byte stream</b> so that it can be:
 * <ul>
 *   <li>Saved to a file</li>
 *   <li>Transferred over a network</li>
 *   <li>Reconstructed later using deserialization</li>
 * </ul>
 * </p>
 *
 * <p>
 * The {@link BankAccount} class must implement
 * {@link java.io.Serializable} for serialization to work.
 * </p>
 *
 * <p><b>File Generated:</b> <code>bank.ser</code></p>
 *
 * @author Nihir
 * @version 1.0
 */
public class Test_10_IOStream_ObjectOutputStream {

    /**
     * Entry point of the application.
     *
     * @param args command-line arguments (not used)
     * @throws IOException if file write operation fails
     */
    static void main(String[] args) throws IOException {

        // Creating BankAccount object and setting data
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(500000000);
        bankAccount.setAccNum(7856674);
        bankAccount.setEmail("Nihir@gmail.com");
        bankAccount.setMobile(7999382002L);
        bankAccount.setName("Nihir");
        bankAccount.setUsername("Nihir14");
        bankAccount.setPassword("Nihir1224");

        /*
         * Creating ObjectOutputStream by wrapping FileOutputStream.
         * This connects the Java object stream to a physical file.
         */
        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream("bank.ser"));

        /*
         * Writing object into the file.
         * Internally:
         *  - Object → byte stream
         *  - Uses serialVersionUID
         */
        oos.writeObject(bankAccount);

        System.out.println("Data Saved Successfully");

        // Closing stream to release system resources
        oos.close();
    }
}
