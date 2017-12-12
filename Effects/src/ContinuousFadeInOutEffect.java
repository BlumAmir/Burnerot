public class ContinuousFadeInOutEffect extends ContinuousEffect {

    public ContinuousFadeInOutEffect(ContinuousEffect sourceEffect) {
        this.sourceEffect = sourceEffect;
    }

    @Override
    public HSBColor getColor(double timePercent, double location) {
        HSBColor c = this.sourceEffect.getColor(timePercent, location);
        if(timePercent <= 0.5) {
            c.brightness = c.brightness * (2.0 * timePercent);
        }
        else {
            c.brightness = c.brightness * (2.0 - 2.0 * timePercent);
        }
        return c;
    }

    private ContinuousEffect sourceEffect;
}
