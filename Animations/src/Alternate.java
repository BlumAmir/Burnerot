public class Alternate extends SceneAnimation {

    public Alternate(ChickenHead headObject, Wing leftWing, Wing rightWing, Feathers feathersObject) {
        super(headObject, leftWing, rightWing, feathersObject);

        ContinuousTimedColorEffect c1 = new ContinuousTimedColorEffect(new TimedHueRainbowColor(0.0));
        ContinuousTimedColorEffect c2 = new ContinuousTimedColorEffect(new TimedHueRainbowColor(0.5));

        DiscreteAlternateEffect alternate = new DiscreteAlternateEffect(leftWing.GetPixelsNumber(),
                c1.getAsDiscrete(leftWing.GetPixelsNumber()),
                c2.getAsDiscrete(leftWing.GetPixelsNumber()));

        head.addMapper(headObject.allIndexes, alternate);
        lWing.addMapper(leftWing.allIndexes, alternate);
        rWing.addMapper(rightWing.allIndexes, alternate);
        feathers.addMapper(feathersObject.allIndexes, alternate);
    }

}

