
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Wing extends LEDObject {

    public HSBColor pixels[] = CreateHSBArray(240);
    public int[] allIndexes = CreateIndexRange(0, 240 - 1);

    @Override
    public HSBColor[] GetAllPixels() {
        return this.pixels;
    }
}
