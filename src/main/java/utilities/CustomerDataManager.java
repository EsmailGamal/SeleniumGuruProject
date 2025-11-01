package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import utilities.models.CustomerData;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomerDataManager {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String CUSTOMER_DATA_FILE = "customer_data.json";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Saves the Customer ID to a JSON file
     * @param customerId The Customer ID to save
     */
    public static void saveCustomerId(String customerId) {
        try {
            String filePath = getCustomerDataFilePath();
            Path path = Paths.get(filePath);
            
            // Ensure parent directories exist
            if (path.getParent() != null) {
                Files.createDirectories(path.getParent());
            }

            CustomerData data = new CustomerData(
                customerId,
                LocalDateTime.now().format(DATE_FORMATTER)
            );

            MAPPER.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), data);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save Customer ID to file", e);
        }
    }

    /**
     * Loads the Customer ID from the JSON file
     * @return The Customer ID, or null if not found
     */
    public static String loadCustomerId() {
        try {
            String filePath = getCustomerDataFilePath();
            File file = new File(filePath);
            
            if (!file.exists()) {
                return null;
            }

            CustomerData data = MAPPER.readValue(file, CustomerData.class);
            return data != null ? data.getCustomerId() : null;
        } catch (Exception e) {
            throw new RuntimeException("Failed to load Customer ID from file", e);
        }
    }

    /**
     * Loads the complete CustomerData object from the JSON file
     * @return CustomerData object, or null if not found
     */
    public static CustomerData loadCustomerData() {
        try {
            String filePath = getCustomerDataFilePath();
            File file = new File(filePath);
            
            if (!file.exists()) {
                return null;
            }

            return MAPPER.readValue(file, CustomerData.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load Customer Data from file", e);
        }
    }

    /**
     * Checks if a Customer ID file exists
     * @return true if the file exists, false otherwise
     */
    public static boolean customerIdExists() {
        String filePath = getCustomerDataFilePath();
        return new File(filePath).exists();
    }

    /**
     * Gets the file path for the customer data JSON file
     * Stores it in the project root directory
     * @return Absolute path to the customer_data.json file
     */
    private static String getCustomerDataFilePath() {
        String projectRoot = System.getProperty("user.dir");
        return Paths.get(projectRoot, CUSTOMER_DATA_FILE).toString();
    }
}

