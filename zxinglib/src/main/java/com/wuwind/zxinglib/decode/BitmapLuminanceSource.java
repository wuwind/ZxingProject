package com.wuwind.zxinglib.decode;

import android.graphics.Bitmap;

import com.google.zxing.LuminanceSource;

/**
 * Created by Wuhf on 2016/7/22.
 * Description ：
 */
public class BitmapLuminanceSource extends LuminanceSource {

    byte[] bitmapPixels;
    int width;
    int height;

    protected BitmapLuminanceSource(Bitmap bitmap) {
        super(bitmap.getWidth(), bitmap.getHeight());
        width = bitmap.getWidth();
        height = bitmap.getHeight();
        int[] pixels = new int[width * height];
        bitmapPixels = new byte[width * height];
        bitmap.getPixels(pixels, 0, width, 0, 0, width, height);
        for (int i = 0; i < pixels.length; i++) {
            bitmapPixels[i] = (byte) pixels[i];
        }
    }

    @Override
    public byte[] getRow(int i, byte[] bytes) {
        System.arraycopy(bitmapPixels, i * width, bytes, 0, width);
        return bytes;
    }

    @Override
    public byte[] getMatrix() {
        return bitmapPixels;
    }
}
