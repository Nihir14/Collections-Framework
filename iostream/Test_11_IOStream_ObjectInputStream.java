package iostream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * <h2>Test_11_IOStream_ObjectInputStream</h2>
 *
 * <p>
 * This class demonstrates <b>Object Deserialization</b> using
 * {@link java.io.ObjectInputStream}.
 * </p>
 *
 * <p>
 * Deserialization is the reverse process of serialization, where
 * a byte stream is converted back into a Java object.
 * </p>
 *
 * <p>
 * This program reads the serialized {@link BankAccount} object
 * from the file <b>bank.ser</b>, reconstructs it in memory,
 * and displays its contents.
 * </p>
 *
 * <p><b>Prerequisite:</b></p>
 * <ul>
 *   <li>The class must implement {@link java.io.Serializable}</li>
 *   <li>{@code serialVersionUID} must match during serialization and deserialization</li>
 * </ul>
 *
 * @author Nihir
 * @version 1.0
 */
public class Test_11_IOStream_ObjectInputStream {

    /**
     * Entry point of the application.
     *
     * @param args command-line arguments (not used)
     * @throws IOException if file read operation fails
     * @throws ClassNotFoundException if the class definition is not found
     */
    static void main(String[] args)
            throws IOException, ClassNotFoundException {

        /*
         * Creating ObjectInputStream by wrapping FileInputStream.
         * This connects the object input stream to the serialized file.
         */
        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream("bank.ser"));

        /*
         * Reading object from file.
         * readObject() returns Object, so explicit casting is required.
         */
        Object obj = ois.readObject();
        System.out.println(obj);

        /*
         * Downcasting Object reference to BankAccount type
         */
        BankAccount bankAccount = (BankAccount) obj;
        System.out.println(bankAccount);

        // Closing stream to release system resources
        ois.close();
    }
}
