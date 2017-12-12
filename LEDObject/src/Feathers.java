public class Feathers extends LEDObject{

    public HSBColor pixels[] = CreateHSBArray(300);
    public int[] allIndexes = CreateIndexRange(6, 300-1);
    public int[][] parts = {CreateIndexRange(6, 34), CreateIndexRange(35, 64), CreateIndexRange(65, 94),
            CreateIndexRange(95, 123), CreateIndexRange(124, 152), CreateIndexRange(153, 181),
            CreateIndexRange(182, 210), CreateIndexRange(211, 240), CreateIndexRange(241, 270),
            CreateIndexRange(271, 299)};

    @Override
    public HSBColor[] GetAllPixels() {
        return this.pixels;
    }
}
