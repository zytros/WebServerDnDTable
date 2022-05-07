package JSON;

public class LEDInfo {
    int LEDNum;
    int r;
    int g;
    int b;
    int ledRange;
    String func;

    public LEDInfo(int LEDNum, int r, int g, int b, int ledRange, String func) {
        this.LEDNum = LEDNum;
        this.r = r;
        this.g = g;
        this.b = b;
        this.ledRange = ledRange;
        this.func = func;
    }

    public int getLEDNum() {
        return LEDNum;
    }

    public void setLEDNum(int LEDNum) {
        this.LEDNum = LEDNum;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getLedRange() {
        return ledRange;
    }

    public void setLedRange(int ledRange) {
        this.ledRange = ledRange;
    }

    public String getFunc() {
        return func;
    }

    public void setFunc(String func) {
        this.func = func;
    }
}
