public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

    public void startClass() {
        Projector pj = reg.getFirstOfType("Projector", Projector.class);
        ((PowerControl) pj).powerOn();
        ((InputControl) pj).connectInput("HDMI-1");

        LightsPanel lights = reg.getFirstOfType("LightsPanel", LightsPanel.class);
        ((BrightnessControl) lights).setBrightness(60);

        AirConditioner ac = reg.getFirstOfType("AirConditioner", AirConditioner.class);
        ((TemperatureControl) ac).setTemperatureC(24);

        AttendanceScanner scan = reg.getFirstOfType("AttendanceScanner", AttendanceScanner.class);
        System.out.println("Attendance scanned: present=" + ((AttendanceScanning) scan).scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        ((PowerControl) reg.getFirstOfType("Projector", Projector.class)).powerOff();
        ((PowerControl) reg.getFirstOfType("LightsPanel", LightsPanel.class)).powerOff();
        ((PowerControl) reg.getFirstOfType("AirConditioner", AirConditioner.class)).powerOff();
    }
}
