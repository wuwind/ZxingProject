package com.wuwind.zxinglib.decode;

import android.graphics.Bitmap;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;

/**
 * Created by Wuhf on 2016/7/22.
 * Description ：
 */
public class DecodeUtil {

    public static String decode(Bitmap bitmap) {
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BitmapLuminanceSource(bitmap)));
        MultiFormatReader multiFormatReader = new MultiFormatReader();
        Result result = null;
        try {
            result = multiFormatReader.decode(binaryBitmap);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

        if (result != null) {
            return result.getText();
        } else {

        }
        return null;
    }
}
