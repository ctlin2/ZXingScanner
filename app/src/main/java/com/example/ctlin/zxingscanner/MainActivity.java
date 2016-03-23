package com.example.ctlin.zxingscanner;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                if(getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY).size() == 0) {
                    //未安裝
                    Uri marketUri = Uri.parse("market://details?id=com.google.zxing.client.android");
                    Intent marketIntent = new Intent(Intent.ACTION_VIEW,marketUri);
                    startActivity(marketIntent);
                }

                // SCAN_MODE, 可判別所有支援的條碼
                // QR_CODE_MODE, 只判別 QRCode
                // PRODUCT_MODE, UPC and EAN 碼
                // ONE_D_MODE, 1 維條碼
                // intent.putExtra("SCAN_MODE", "SCAN_MODE"); //使用所有支援的條碼
                intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
                // 呼叫ZXing Scanner，完成動作後回傳1給 onActivityResult 的 requestCode 參數
                startActivityForResult(intent, 1);
                */

                //*
                Intent intent = new Intent(getApplicationContext(), com.google.zxing.client.android.CaptureActivity.class);
                intent.setAction("com.google.zxing.client.android.SCAN");
                intent.putExtra("SAVE_HISTORY", false);
                startActivityForResult(intent, 0);
                //*/
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0)
        {
            if(resultCode==RESULT_OK)
            {
                // ZXing回傳的內容
                String contents = data.getStringExtra("SCAN_RESULT");
                TextView textView1 = (TextView) findViewById(R.id.textView);
                textView1.setText(contents.toString());
            }
            else
            if(resultCode==RESULT_CANCELED)
            {
                Toast.makeText(this, "取消掃描", Toast.LENGTH_LONG).show();
            }
        }

    }
}
