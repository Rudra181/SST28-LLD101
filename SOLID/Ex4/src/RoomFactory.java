import java.util.HashMap;
import java.util.Map;

public class RoomFactory {
    private static final Map<Integer, RoomPriceable> roomsByType = new HashMap<>();

    static {
        roomsByType.put(LegacyRoomTypes.SINGLE, new SingleRoom());
        roomsByType.put(LegacyRoomTypes.DOUBLE, new DoubleRoom());
        roomsByType.put(LegacyRoomTypes.TRIPLE, new TripleRoom());
        roomsByType.put(LegacyRoomTypes.DELUXE, new DeluxeRoom());
    }

    public static RoomPriceable getRoomByType(int roomType) {
        return roomsByType.getOrDefault(roomType, new DeluxeRoom());
    }
}
