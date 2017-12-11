import java.util.ArrayList;
import java.util.List;

public class LEDObjectAnimation {

    public LEDObjectAnimation(LEDObject ledObj) {
        this.ledObj = ledObj;
    }

    public void apply(double timePercent) {
        ledObj.clear();
        for(EffectToObjectMapper mapper : this.mappers) {
            mapper.apply(timePercent);
        }
    }

    public void addMapper(int[] indices, ContinuousEffect e) {
        this.mappers.add(new EffectToObjectMapper(e.getAsDiscrete(indices.length), this.ledObj.GetAllPixels(), indices));
    }

    public void addMapper(int[] indices, DiscreteEffect e) {
        this.mappers.add(new EffectToObjectMapper(e, this.ledObj.GetAllPixels(), indices));
    }

    protected LEDObject ledObj;
    protected List<EffectToObjectMapper> mappers = new ArrayList<>();

}
