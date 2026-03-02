public class MockDistanceCalculator implements DistanceProvider {
    private double mockKm;

    public MockDistanceCalculator(double mockKm) {
        this.mockKm = mockKm;
    }

    public double km(GeoPoint a, GeoPoint b) {
        return mockKm;
    }
}
