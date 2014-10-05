package imageprocessing.bitmap;

import imageprocessing.extensions.BitMapExtensions;
import android.graphics.Bitmap;

public class BitMap {

    private String mName;
    private static short[][] mPixels;
    private short[][] mBinaryPixels;
    private int mHeight;
    private int mWidth;


    public BitMap(String name, Bitmap bitmap)
    {
        this.mName = name;

        this.mHeight = bitmap.getHeight();
        this.mWidth = bitmap.getWidth();
        this.mPixels = new short[mHeight][mWidth];
        this.mBinaryPixels = new short[mHeight][mWidth];

        BitMapExtensions.getPixels(bitmap, mPixels);
    }


    public static short[][] getPixels() {
        return mPixels;
    }

    public int getHeight() {
        return mHeight;
    }

    public int getWidth() {
        return mWidth;
    }

   

    public int getPixel(int y, int x) {
        return mPixels[y][x];
    }

    public void setBinaryPixel(int y, int x, short val) {
        mBinaryPixels[y][x] = val;
    }

    public short[][] getBinaryPixels() {
        return mBinaryPixels;
    }

   
    public String getName() {
        return mName;
    }

    public void exportBinaryPixelsToFile(String outputDirectory, String name) {
        BitMapExtensions.exportToFile(mBinaryPixels, mHeight, mWidth,
                outputDirectory, name);
    }

    public short getBinaryPixel(int y, int x) {
        return mBinaryPixels[y][x];
    }


	public void setPixel(int y, int x, short val) {
		// TODO Auto-generated method stub
		mPixels[y][x]=val;
	}
}

