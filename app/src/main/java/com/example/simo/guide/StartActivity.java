package com.example.simo.guide;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;

public class StartActivity extends AppCompatActivity {

    public  FirebaseRemoteConfig mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

         // ads
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3940256099942544~3347511713");

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        // remot config


        mFirebaseRemoteConfig.setDefaults(R.xml.remote_config_defaults);
        long cacheExpiration = 0; //1 hour = 3600 in seconds
        if(mFirebaseRemoteConfig.getInfo().getConfigSettings().isDeveloperModeEnabled())
        {
            cacheExpiration = 0;
        }
        mFirebaseRemoteConfig.fetch(cacheExpiration)
                .addOnCompleteListener(new OnCompleteListener<Void>(){
                    @Override
                    public void onComplete(@NonNull Task<Void> task){
                        if(task.isSuccessful()){
                            mFirebaseRemoteConfig.activateFetched();
                        } else {

                        }
                    }
                });



    }

    public void butclikid1(View view) {
        Intent i = new Intent(this, MainActivity.class);
        Bundle b = new Bundle();
        b.putString("newurl", mFirebaseRemoteConfig.getString("linkMyApp"));
        i.putExtras(b);
        startActivity(i);
    }

    public void butclikid2(View view) {
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }

    public void butclikid3(View view) {
        Intent i = new Intent(this, Main3Activity.class);
        startActivity(i);
    }

    public void butclikid4(View view) {

        Intent i = new Intent(this, Main4Activity.class);
        startActivity(i);
    }

    public void butclikid5(View view) {



        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(mFirebaseRemoteConfig.getString("linkMyApp")));
        startActivity(intent);
    }



}
