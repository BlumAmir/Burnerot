import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class SweatLodge {

    public static void run() {

        final Network network = new Network();
        network.configure();

//do only once at the begining//
        RGBColor colorsRGB[] = new RGBColor[240];
        HSBColor colors[] = new HSBColor[240];
        for(int i=0; i<240; i++) {
            colorsRGB[i] = new RGBColor();
            colors[i] = new HSBColor();
        }
//END

//for the change between frames
        int loopCounter = 0;

        while(true) {

            // Set colors[i] for Leds -> i is the led number.  ;
            for(int i=0; i<colorsRGB.length; i++) {

                colors[i].hue = ((loopCounter+i) % 256) / 256.0; //0 = red 0.333 =green   0.666 = 7
                colors[i].brightness = 1.0; //black = 0
                colors[i].saturation = 1.0; //white = 0
            }

            for(int i=0; i<colors.length; i++) {
                colorsRGB[i] = colors[i].toRGBColor();
            }


            //Send to leds (beaglebone)
            System.gc();
            network.addSegment("test", colorsRGB, 0, 0);
            network.addSegment("test", colorsRGB, 2, 0);
            network.send();


            try {
            //delay 1,000 = 1sec
                Thread.sleep(10);
            }
            catch (java.lang.InterruptedException interrupt) {
                break;
            }

            loopCounter++;
        }
    }
}


