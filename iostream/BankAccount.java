package iostream;

import java.io.Serial;
import java.io.Serializable;

/**
 * <h2>BankAccount</h2>
 *
 * <p>
 * This class represents a <b>Bank Account entity</b> and demonstrates
 * the concept of <b>Object Serialization</b> in Java.
 * </p>
 *
 * <p>
 * By implementing {@link Serializable}, objects of this class can be:
 * <ul>
 *   <li>Converted into a byte stream</li>
 *   <li>Stored in a file</li>
 *   <li>Transferred over a network</li>
 *   <li>Reconstructed later using Deserialization</li>
 * </ul>
 * </p>
 *
 * <h3>Serialization Notes</h3>
 * <ul>
 *   <li>This class is a <b>marker class</b> for serialization</li>
 *   <li>No methods are required to implement Serializable</li>
 *   <li>{@code serialVersionUID} is used for version control</li>
 * </ul>
 *
 * <p>
 * <b>Important:</b> In real applications, sensitive fields like
 * password should be marked as {@code transient}.
 * </p>
 *
 * @author Nihir
 * @version 1.0
 */
public class BankAccount implements Serializable {

    /**
     * serialVersionUID is used to verify that the sender and receiver
     * of a serialized object have loaded classes for that object
     * that are compatible with respect to serialization.
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /* =========================================================
     * INSTANCE VARIABLES (STATE)
     * ========================================================= */

    private long accNum;
    private double balance;
    private String name;
    private long mobile;
    private String email;
    private String username;

    /**
     * Password field.
     *
     * ⚠️ NOTE:
     * For security reasons, this field should ideally be marked
     * as {@code transient} so it is not serialized.
     */
    private String password;

    private String address;

    /* =========================================================
     * GETTERS AND SETTERS
     * ========================================================= */

    public long getAccNum() {
        return accNum;
    }

    public void setAccNum(long accNum) {
        this.accNum = accNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /* =========================================================
     * toString()
     * ========================================================= */

    /**
     * Returns a string representation of the BankAccount object.
     *
     * <p>
     * ⚠️ In real banking systems, sensitive data like password
     * should never be printed.
     * </p>
     *
     * @return formatted string containing account details
     */
    @Override
    public String toString() {
        return "BankAccount{" +
                "accNum=" + accNum +
                ", balance=" + balance +
                ", name='" + name + '\'' +
                ", mobile=" + mobile +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
