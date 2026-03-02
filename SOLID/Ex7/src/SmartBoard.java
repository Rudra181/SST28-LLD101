public class SmartBoard implements SmartClassroomDevice, PowerControl, BrightnessControl {
    private boolean on;

    @Override public void powerOn() { on = true; }
    @Override public void powerOff() { on = false; System.out.println("SmartBoard OFF"); }

    @Override public void setBrightness(int pct) { if (on) System.out.println("SmartBoard brightness: " + pct + "%"); }
}
