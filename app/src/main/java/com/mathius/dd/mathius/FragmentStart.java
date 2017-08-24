package com.mathius.dd.mathius;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentStart extends Fragment {

    Button btn_start;
    android.app.FragmentTransaction fragmentTransaction;
    FragmentStage1 fragmentStage1 = new FragmentStage1();
    private InterstitialAd mInterstitialAd;


    //----------------------------------------------------------------------------
    //----------------------------------------------------------------------------
    //interface
    //----------------------------------------------------------------------------
//    public void updateText(String text){
//        // Here you have it
//    }
    //----------------------------------------------------------------------------

    public FragmentStart() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);

        mInterstitialAd = new InterstitialAd(view.getContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-3941279894802307/7390113827");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


        btn_start = (Button) view.findViewById(R.id.btnStart);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }


                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayoutMain, fragmentStage1);
                fragmentTransaction.commit();

            }
        });
        return view;
    }

}
