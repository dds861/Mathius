package com.mathius.dd.mathius;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    android.app.FragmentTransaction fragmentTransaction;
    FragmentStage1 fragmentStage1;
    FragmentStart  fragmentStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        fragmentStage1 = new FragmentStage1();
        fragmentStart = new FragmentStart();

        fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frameLayoutMain,fragmentStart,"FRAGMENT1");
        fragmentTransaction.commit();


    }
    //----------------------------------------------------------------------------
    //----------------------------------------------------------------------------
    //interface
    //----------------------------------------------------------------------------
//    @Override
//    public void sendText(String text){
//        // Get Fragment B
////        FragmentStart frag =  (FragmentStart)getSupportFragmentManager().findFragmentById(R.id.frameLayoutMain);
////        frag.updateText(text);
//    }
    //----------------------------------------------------------------------------
}
