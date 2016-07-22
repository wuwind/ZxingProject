package com.wuwind.zxingproject.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.wuwind.zxinglib.activity.CaptureActivity;
import com.wuwind.zxinglib.decode.DecodeUtil;
import com.wuwind.zxinglib.encoding.EncodingUtils;
import com.wuwind.zxingproject.R;

public class MainActivity extends Activity {

    private TextView resultTv;
    private EditText contentEt;
    private ImageView qrcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = (TextView) findViewById(R.id.resultTv);
        contentEt = (EditText) findViewById(R.id.contentEt);
        qrcode = (ImageView) findViewById(R.id.qrcode);
    }

    public void open(View view) {
        Intent intent = new Intent(this, CaptureActivity.class);
        startActivityForResult(intent, 100);
    }

    public void generate(View view) {
        Bitmap qrCode = EncodingUtils.createQRCode(contentEt.getText().toString(), 500,500, null);
        qrcode.setImageBitmap(qrCode);
    }

    public void qrcClick(View view) {
        ImageView view1 = (ImageView) view;
        view1.setDrawingCacheEnabled(true);
        Bitmap drawingCache = view1.getDrawingCache();
        resultTv.setText(DecodeUtil.decode(drawingCache));
        view1.setDrawingCacheEnabled(false);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();

            resultTv.setText(extras.getString("result"));
        }
    }
}
