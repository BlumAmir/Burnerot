public class ContinuousTimedColorEffect extends ContinuousEffect {

    public ContinuousTimedColorEffect(TimedColor c) {
        configure(c);
    }

    public void configure(TimedColor c) {
        this.c = c;
    }

    public HSBColor getColor(double timePercent, double location) {
        return c.getColor(timePercent);
    }

    TimedColor c;
}
