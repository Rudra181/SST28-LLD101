public class TransportBookingService {
    private final DistanceProvider distanceProvider;
    private final DriverProvider driverProvider;
    private final PaymentProcessor paymentProcessor;

    public TransportBookingService(DistanceProvider distanceProvider, DriverProvider driverProvider, PaymentProcessor paymentProcessor) {
        this.distanceProvider = distanceProvider;
        this.driverProvider = driverProvider;
        this.paymentProcessor = paymentProcessor;
    }

    public void book(TripRequest req) {
        double km = distanceProvider.km(req.from, req.to);
        System.out.println("DistanceKm=" + km);

        String driver = driverProvider.allocate(req.studentId);
        System.out.println("Driver=" + driver);

        double fare = 50.0 + km * 6.6666666667;
        fare = Math.round(fare * 100.0) / 100.0;

        String txn = paymentProcessor.charge(req.studentId, fare);
        System.out.println("Payment=PAID txn=" + txn);

        BookingReceipt r = new BookingReceipt("R-501", fare);
        System.out.println("RECEIPT: " + r.id + " | fare=" + String.format("%.2f", r.fare));
    }
}
