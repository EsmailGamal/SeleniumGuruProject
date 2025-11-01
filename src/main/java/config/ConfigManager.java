package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static final Properties properties = new Properties();
    private static boolean initialized = false;

    private static synchronized void initialize() {
        if (initialized) {
            return;
        }

        String env = System.getProperty("env", "default");
        String baseConfigPath = "/config/config.properties";
        String envConfigPath = "/config/config." + env + ".properties";

        try (InputStream baseStream = ConfigManager.class.getResourceAsStream(baseConfigPath)) {
            if (baseStream != null) {
                properties.load(baseStream);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load base config properties", e);
        }

        try (InputStream envStream = ConfigManager.class.getResourceAsStream(envConfigPath)) {
            if (envStream != null) {
                Properties envProps = new Properties();
                envProps.load(envStream);
                properties.putAll(envProps);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load env config properties for env: " + env, e);
        }

        // System properties override files
        for (String name : System.getProperties().stringPropertyNames()) {
            properties.setProperty(name, System.getProperty(name));
        }

        initialized = true;
    }

    private static String get(String key, String defaultValue) {
        if (!initialized) {
            initialize();
        }
        return properties.getProperty(key, defaultValue);
    }

    public static String getBaseUrl() {
        return get("baseUrl", "https://www.amazon.eg/-/en/ref=nav_logo");
    }

    public static String getBrowser() {
        return get("browser", "chrome");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(get("headless", "false"));
    }

    public static int getDefaultTimeoutSeconds() {
        return Integer.parseInt(get("timeout.seconds", "10"));
    }
}


