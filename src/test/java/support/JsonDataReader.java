package support;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.nio.file.Paths;

public class JsonDataReader {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> T read(String relativePath, Class<T> type) {
        try {
            String abs = Paths.get(System.getProperty("user.dir"), relativePath).toString();
            return MAPPER.readValue(new File(abs), type);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON: " + relativePath, e);
        }
    }

    public static <T> T read(String relativePath, TypeReference<T> typeRef) {
        try {
            String abs = Paths.get(System.getProperty("user.dir"), relativePath).toString();
            return MAPPER.readValue(new File(abs), typeRef);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON: " + relativePath, e);
        }
    }
}


