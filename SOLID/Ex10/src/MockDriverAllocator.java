public class MockDriverAllocator implements DriverProvider {
    private String mockDriver;

    public MockDriverAllocator(String mockDriver) {
        this.mockDriver = mockDriver;
    }

    public String allocate(String studentId) {
        return mockDriver;
    }
}
