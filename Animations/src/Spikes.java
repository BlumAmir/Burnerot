import java.util.concurrent.ThreadLocalRandom;

public class Spikes extends SceneAnimation {

    public Spikes(ChickenHead headObject, Wing leftWing, Wing rightWing, Feathers feathersObject) {
        super(headObject, leftWing, rightWing, feathersObject);

        ContinuousRainbowEffect rainbow = new ContinuousRainbowEffect(new ContinuousWhiteEffect());
        this.spikeWingEffect = new ContinuousSpikeEffect(rainbow);
        this.spikeHeadTopEffect = new ContinuousSpikeEffect(rainbow);
        ContinuousFadeInOutEffect fadeInOut = new ContinuousFadeInOutEffect(this.spikeWingEffect);

        head.addMapper(headObject.topSection, this.spikeHeadTopEffect.getAsDiscrete(headObject.topSection.length));
        head.addMapper(headObject.eyeBack, rainbow.getAsDiscrete(headObject.eyeBack.length));
        head.addMapper(headObject.eyeFront, rainbow.getAsDiscrete(headObject.eyeFront.length));
        head.addMapper(headObject.beakTop, this.spikeHeadTopEffect.getAsDiscrete(headObject.beakTop.length));
        head.addMapper(headObject.beakBottom, this.spikeHeadTopEffect.getAsDiscrete(headObject.beakBottom.length));

        lWing.addMapper(leftWing.allIndexes, fadeInOut.getAsDiscrete(leftWing.allIndexes.length));
        rWing.addMapper(rightWing.allIndexes, fadeInOut.getAsDiscrete(rightWing.allIndexes.length));

        feathers.addMapperForEachFeather(this.spikeHeadTopEffect);
    }

    public void newCycle() {

        double headStart = ThreadLocalRandom.current().nextDouble(0.0, 0.5);
        double tailLength = ThreadLocalRandom.current().nextDouble(0.1, 0.2);
        double amountToMove = ThreadLocalRandom.current().nextDouble(tailLength + 0.1, 0.5);
        if(ThreadLocalRandom.current().nextDouble() < 0.5) {
            amountToMove *= -1;
        }
        double headEnd = headStart + amountToMove;
        spikeWingEffect.configure(headStart, headEnd, tailLength);

        if(ThreadLocalRandom.current().nextDouble() < 0.5) {
            this.spikeHeadTopEffect.configure(0.0, 2.0, 1.0);
        }
        else {
            this.spikeHeadTopEffect.configure(1.0, -1.0, 1.0);
        }
    }

    ContinuousSpikeEffect spikeWingEffect;
    ContinuousSpikeEffect spikeHeadTopEffect;

}

