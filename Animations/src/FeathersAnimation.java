public class FeathersAnimation extends LEDObjectAnimation {

    public FeathersAnimation(Feathers feathersObject) {
        super(feathersObject);
        this.feathersObject = feathersObject;
    }

    public void addMapperForEachFeather(ContinuousEffect effect) {
        for(int[] feather: feathersObject.parts) {
            addMapper(feather, effect);
        }
    }

    public void addMapperForEachFeather(DiscreteEffect effect) {
        for(int[] feather: feathersObject.parts) {
            addMapper(feather, effect);
        }
    }


    private Feathers feathersObject;
}
