package collections;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Test_16_Map_Properties demonstrates the behavior and
 * internal working of {@link java.util.Properties}.
 *
 * <p>
 * Properties is a subclass of {@link java.util.Hashtable}
 * and is mainly used to store configuration data
 * as <b>key-value pairs of Strings</b>.
 * </p>
 *
 * <h2>Key Characteristics</h2>
 * <ul>
 *   <li>Keys and values are of type String</li>
 *   <li>Thread-safe (inherits Hashtable)</li>
 *   <li>Used for configuration files (.properties)</li>
 *   <li>Supports file I/O (load & store)</li>
 * </ul>
 *
 * <p>
 * Properties is commonly used for:
 * <ul>
 *   <li>Database configuration</li>
 *   <li>Application settings</li>
 *   <li>Environment-specific values</li>
 * </ul>
 * </p>
 *
 * @author Nihir
 */
public class Test_16_Map_Properties {

    /**
     * Entry point for Properties demonstration.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) throws IOException {

        /* -------------------------------------------------
         * 1. CREATE PROPERTIES OBJECT
         * ------------------------------------------------- */

        Properties props = new Properties();

        /* -------------------------------------------------
         * 2. SET PROPERTIES
         * -------------------------------------------------
         *
         * setProperty(key, value):
         * - Both key and value must be String
         */

        props.setProperty("db.url", "jdbc:mysql://localhost:3306/testdb");
        props.setProperty("db.user", "root");
        props.setProperty("db.password", "root123");
        props.setProperty("app.name", "CollectionLearning");

        System.out.println("Properties after setting values:");
        System.out.println(props);
        System.out.println();

        /* -------------------------------------------------
         * 3. GET PROPERTIES
         * ------------------------------------------------- */

        System.out.println("db.url      : " + props.getProperty("db.url"));
        System.out.println("db.user     : " + props.getProperty("db.user"));
        System.out.println("missing.key: " + props.getProperty("missing.key"));
        System.out.println(
                "missing.key with default: "
                        + props.getProperty("missing.key", "DEFAULT_VALUE")
        );
        System.out.println();

        /* -------------------------------------------------
         * 4. STORE PROPERTIES TO FILE
         * -------------------------------------------------
         *
         * Properties file format:
         * key=value
         */

        try (FileOutputStream fos =
                     new FileOutputStream("app.properties")) {

            props.store(fos, "Application Configuration");
        }

        System.out.println("Properties saved to app.properties file");
        System.out.println();

        /* -------------------------------------------------
         * 5. LOAD PROPERTIES FROM FILE
         * ------------------------------------------------- */

        Properties loadedProps = new Properties();

        try (FileInputStream fis =
                     new FileInputStream("app.properties")) {

            loadedProps.load(fis);
        }

        System.out.println("Loaded properties from file:");
        System.out.println(loadedProps);
        System.out.println();

        /* -------------------------------------------------
         * 6. IMPORTANT OPERATIONS
         * ------------------------------------------------- */

        System.out.println("Contains key 'app.name' : "
                + loadedProps.containsKey("app.name"));

        System.out.println("Property names:");
        loadedProps.stringPropertyNames()
                .forEach(System.out::println);

        /* -------------------------------------------------
         * 7. REMOVE & CLEAR
         * ------------------------------------------------- */

        loadedProps.remove("db.password");
        System.out.println("\nAfter removing db.password:");
        System.out.println(loadedProps);

        loadedProps.clear();
        System.out.println("\nAfter clear(): " + loadedProps);
    }
}
