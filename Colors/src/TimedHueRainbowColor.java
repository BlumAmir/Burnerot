public class TimedHueRainbowColor extends TimedColor {

    public TimedHueRainbowColor(double startHue) {
        this.startHue = startHue;
        c = new HSBColor(startHue, 1.0, 1.0);
    }

    public TimedHueRainbowColor(double startHue, double saturation, double brightness) {
        this.startHue = startHue;
        c = new HSBColor(startHue, saturation, brightness);
    }

        @Override
    public HSBColor getColor(double timePercent) {
        c.hue = this.startHue + timePercent % 1.0;
        return c;
    }

    double startHue = 0.0;
    HSBColor c;
}
