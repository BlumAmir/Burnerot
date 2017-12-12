public class TimeChangingSections extends SceneAnimation {

    public TimeChangingSections(ChickenHead headObject, Wing leftWing, Wing rightWing, Feathers feathersObject) {
        super(headObject, leftWing, rightWing, feathersObject);

        head.addMapper(headObject.beakTop, new ContinuousTimedColorEffect(new TimedHueRainbowColor(0.5)));
        head.addMapper(headObject.beakBottom, new ContinuousTimedColorEffect(new TimedHueRainbowColor(0.5)));
        head.addMapper(headObject.eyeBack, new ContinuousTimedColorEffect(new TimedHueRainbowColor(0.6)));
        head.addMapper(headObject.eyeFront, new ContinuousTimedColorEffect(new TimedHueRainbowColor(0.6)));
        head.addMapperForTopSections(new ContinuousTimedColorEffect(new TimedHueRainbowColor(0.0)));
        head.addMapper(headObject.head, new ContinuousConstColorEffect(new HSBColor(0.0, 0.0, 0.5)));

        lWing.addMapper(leftWing.allIndexes, new ContinuousTimedColorEffect(new TimedHueRainbowColor(0.5)));
        rWing.addMapper(rightWing.allIndexes, new ContinuousTimedColorEffect(new TimedHueRainbowColor(0.5)));

        for(int i=0; i<feathersObject.parts.length; i++) {
            feathers.addMapper(feathersObject.parts[i], new ContinuousTimedColorEffect(new TimedHueRainbowColor(((double)i % 2) / 2.0)));
        }
    }

}
