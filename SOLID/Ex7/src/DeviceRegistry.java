import java.util.*;

public class DeviceRegistry {
    private final java.util.List<SmartClassroomDevice> devices = new ArrayList<>();

    public void add(SmartClassroomDevice d) { devices.add(d); }

    public <T> T getFirstOfType(String simpleName, Class<T> type) {
        for (SmartClassroomDevice d : devices) {
            if (d.getClass().getSimpleName().equals(simpleName)) return type.cast(d);
        }
        throw new IllegalStateException("Missing: " + simpleName);
    }
}
