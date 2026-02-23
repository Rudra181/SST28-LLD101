import java.util.*;

public class InputParser {
    public Map<String, String> parse(String raw) {
        Map<String, String> fields = new LinkedHashMap<>();
        String[] parts = raw.split(";");
        for (String segment : parts) {
            String[] keyValue = segment.split("=", 2);
            if (keyValue.length == 2) {
                fields.put(keyValue[0].trim(), keyValue[1].trim());
            }
        }
        return fields;
    }

    public StudentData extractFields(Map<String, String> fields) {
        String name = fields.getOrDefault("name", "");
        String email = fields.getOrDefault("email", "");
        String phone = fields.getOrDefault("phone", "");
        String program = fields.getOrDefault("program", "");
        return new StudentData(name, email, phone, program);
    }
}
