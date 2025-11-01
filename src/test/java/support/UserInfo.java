package support;

import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Map;

public class UserInfo {
    private static Map<String, Map<String, String>> cache;
    private static final String JSON_PATH = "src/test/java/resources/info.json";

    public static Map<String, String> get(String userKey) {
        if (cache == null) {
            cache = JsonDataReader.read(JSON_PATH, new TypeReference<Map<String, Map<String, String>>>() {});
        }
        return cache.get(userKey);
    }
}


