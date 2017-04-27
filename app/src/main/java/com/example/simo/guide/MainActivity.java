package com.example.simo.guide;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.NativeExpressAdView;

public class MainActivity extends AppCompatActivity {

    String newlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ads admobe
        NativeExpressAdView adView = (NativeExpressAdView)findViewById(R.id.adView);

        AdRequest request = new AdRequest.Builder()
               // .addTestDevice("YOUR_DEVICE_ID")
                .build();
        adView.loadAd(request);





    }


    public void review1(View view) {


        Bundle b = getIntent().getExtras();
        String newlink = b.getString("newurl");

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(newlink));
        startActivity(intent);

    }
}
