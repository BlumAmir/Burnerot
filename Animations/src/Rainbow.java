public class Rainbow extends SceneAnimation {

    public Rainbow(ChickenHead headObject, Wing leftWing, Wing rightWing) {
        super(headObject, leftWing, rightWing);

        ContinuousRainbowEffect rainbow = new ContinuousRainbowEffect(new ContinuousWhiteEffect());
        ContinuousCyclicMoveEffect rainbowMove = new ContinuousCyclicMoveEffect(rainbow);


        head.addMapper(headObject.beakTop, rainbowMove);
        head.addMapper(headObject.beakBottom, rainbowMove);
        head.addMapper(headObject.eyeBack, rainbowMove);
        head.addMapper(headObject.eyeFront, rainbowMove);
        head.addMapperForTopSections(rainbowMove);

        head.addMapper(headObject.head, new ContinuousTimedColorEffect(new TimedHueRainbowColor(0.0)));

        lWing.addMapper(leftWing.allIndexes, rainbowMove);
        rWing.addMapper(rightWing.allIndexes, rainbowMove);
    }

}
