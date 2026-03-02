public class Main {
    public static void main(String[] args) {
        System.out.println("=== Transport Booking ===");
        TripRequest req = new TripRequest("23BCS1010", new GeoPoint(12.97, 77.59), new GeoPoint(12.94, 77.59));
        
        DistanceProvider distanceProvider = new DistanceCalculator();
        DriverProvider driverProvider = new DriverAllocator();
        PaymentProcessor paymentProcessor = new PaymentGateway();
        
        TransportBookingService svc = new TransportBookingService(distanceProvider, driverProvider, paymentProcessor);
        svc.book(req);
    }
}
