package com.mathius.dd.mathius;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentStart extends Fragment {

    Button btn_start;
    android.app.FragmentTransaction fragmentTransaction;
    FragmentStage1 fragmentStage1 = new FragmentStage1();



    public FragmentStart() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);

        btn_start = (Button) view.findViewById(R.id.btnStart);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentTransaction=getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayoutMain,fragmentStage1);
                fragmentTransaction.commit();


            }
        });

        return view;
    }

}
