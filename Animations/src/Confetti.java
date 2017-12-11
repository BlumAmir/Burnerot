public class Confetti extends SceneAnimation {

    public Confetti(ChickenHead headObject, Wing leftWing, Wing rightWing) {
        super(headObject, leftWing, rightWing);

        ContinuousRainbowEffect rainbow = new ContinuousRainbowEffect(new ContinuousWhiteEffect());
        ContinuousConstColorEffect whiteConst = new ContinuousConstColorEffect(HSBColor.WHITE);
        ContinuousConstColorEffect redConst = new ContinuousConstColorEffect(HSBColor.RED);
        ContinuousConstColorEffect yellowConst = new ContinuousConstColorEffect(HSBColor.YELLOW);


        head.addMapper(headObject.head,
                new DiscreteConfettiEffect(headObject.head.length, whiteConst.getAsDiscrete(headObject.head.length)));
        head.addMapper(headObject.beak,
                new DiscreteConfettiEffect(headObject.beak.length, yellowConst.getAsDiscrete(headObject.beak.length)));
        head.addMapper(headObject.topSection,
                new DiscreteConfettiEffect(headObject.topSection.length, rainbow.getAsDiscrete(headObject.topSection.length)));
        head.addMapper(headObject.eyeFront, redConst);
        head.addMapper(headObject.eyeBack, redConst);
        lWing.addMapper(leftWing.allIndexes,
                new DiscreteConfettiEffect(leftWing.allIndexes.length, rainbow.getAsDiscrete(leftWing.allIndexes.length)));
        rWing.addMapper(rightWing.allIndexes,
                new DiscreteConfettiEffect(rightWing.allIndexes.length, rainbow.getAsDiscrete(rightWing.allIndexes.length)));
    }

}
