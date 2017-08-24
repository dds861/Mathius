package com.mathius.dd.mathius;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentStage1 extends Fragment implements View.OnClickListener {


    private TextView mTvEquation;
    private TextView mTvAnswer;
    private TextView mlevelCurrent;
    private Button mBtn7;
    private Button mBtn8;
    private Button mBtn9;
    private Button mBtn4;
    private Button mBtn5;
    private Button mBtn6;
    private Button mBtn1;
    private Button mBtn2;
    private Button mBtn3;
    private Button mBtn0;
    private Button mBtnAnswer;
    private Button mBtnC;
    private Button mBtnDelete;
    private Button mBtnMinus;
    private ImageView mBack;
    String answer = "";
    private int equation1;
    private int equation2;
    private int correct;
    private int incorrect;
    private TextView mTvIncorrect;
    private TextView mTvCorrect;
    private TextView mTvTimer;
    private int defaultTimer = 15;
    private int[] timerTime = {defaultTimer};
    Timer timer;
    String level;
    int equationAmounts = 0;
    FragmentStart fragmentStart;
    FragmentTransaction fragmentTransaction;

    //----------------------------------------------------------------------------
    //----------------------------------------------------------------------------
    //interface
    //----------------------------------------------------------------------------
//    TextClicked mCallback;
//
//    public interface TextClicked{
//        public void sendText(String text);
//    }
//
//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//
//        // This makes sure that the container activity has implemented
//        // the callback interface. If not, it throws an exception
//        try {
//            mCallback = (TextClicked) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement TextClicked");
//        }
//    }
//
//    public void someMethod(){
//        mCallback.sendText("YOUR TEXT");
//    }

    //----------------------------------------------------------------------------
    //----------------------------------------------------------------------------

    //Constructor
    public FragmentStage1() {
    }

    //All Actions starts happening here
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //creating View to return it
        View view = inflater.inflate(R.layout.fragment_stage1, container, false);

        //find all components
        initView(view);


        //start making equations
        equations(equationAmounts);

        timerTime[0] = defaultTimer;

        //Start Timer in Thread
        timer = new Timer();
        timer.execute();

        //return View
        return view;
    }

    class Timer extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            //loop for timer
            //timerTime[0] will decrease every 1 second
            for (; timerTime[0] >= 0; timerTime[0]--) {

                //change UI textview on separate thread
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTvTimer.setText(String.valueOf(timerTime[0]));
                    }
                });

                //sleep every 1 second
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            //if the time is over will open another windows
            fragmentStart = new FragmentStart();
            fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayoutMain, fragmentStart, "FRAGMENT1");
            fragmentTransaction.commit();

            return null;
        }
    }

    private void equations(int localEquationAmounts) {


        if (localEquationAmounts < 5) {
            equation1 = (int) Math.floor((Math.random() * 10 + 1));
            equation2 = (int) Math.floor((Math.random() * 10 + 1));
            level = "1";
        } else if (localEquationAmounts < 10) {
            equation1 = (int) Math.floor((Math.random() * 10 + 1));
            equation2 = (int) Math.floor((Math.random() * 100 + 1));
            level = "2";
        } else if (localEquationAmounts < 15) {
            equation1 = (int) Math.floor((Math.random() * 100 + 1));
            equation2 = (int) Math.floor((Math.random() * 100 + 1));
            level = "3";
        } else if (localEquationAmounts < 20) {
            equation1 = (int) Math.floor((Math.random() * 100 + 1));
            equation2 = (int) Math.floor((Math.random() * 1000 + 1));
            level = "4";
        } else if (localEquationAmounts < 25) {
            equation1 = (int) Math.floor((Math.random() * 1000 + 1));
            equation2 = (int) Math.floor((Math.random() * 1000 + 1));
            level = "5";
        } else if (localEquationAmounts < 30) {
            equation1 = (int) Math.floor((Math.random() * 1000 + 1));
            equation2 = (int) Math.floor((Math.random() * 10000 + 1));
            level = "6";
        } else if (localEquationAmounts < 35) {
            equation1 = (int) Math.floor((Math.random() * 10000 + 1));
            equation2 = (int) Math.floor((Math.random() * 10000 + 1));
            level = "7";
        } else if (localEquationAmounts < 40) {
            equation1 = (int) Math.floor((Math.random() * 10000 + 1));
            equation2 = (int) Math.floor((Math.random() * 100000 + 1));
            level = "8";
        } else if (localEquationAmounts < 45) {
            equation1 = (int) Math.floor((Math.random() * 100000 + 1));
            equation2 = (int) Math.floor((Math.random() * 100000 + 1));
            level = "9";
        } else if (localEquationAmounts < 50) {
            equation1 = (int) Math.floor((Math.random() * 100000 + 1));
            equation2 = (int) Math.floor((Math.random() * 1000000 + 1));
            level = "10";
        }


        mTvEquation.setText(equation1 + " + " + equation2 + " = ?");
        mlevelCurrent.setText("Level " + level);


    }

    //we find all components
    private void initView(View view) {
        mTvEquation = (TextView) view.findViewById(R.id.tv_equation);
        mTvAnswer = (TextView) view.findViewById(R.id.tv_answer);
        mlevelCurrent = (TextView) view.findViewById(R.id.levelCurrent);
        mBtn7 = (Button) view.findViewById(R.id.btn7);
        mBtn7.setOnClickListener(this);
        mBtn8 = (Button) view.findViewById(R.id.btn8);
        mBtn8.setOnClickListener(this);
        mBtn9 = (Button) view.findViewById(R.id.btn9);
        mBtn9.setOnClickListener(this);
        mBtn4 = (Button) view.findViewById(R.id.btn4);
        mBtn4.setOnClickListener(this);
        mBtn5 = (Button) view.findViewById(R.id.btn5);
        mBtn5.setOnClickListener(this);
        mBtn6 = (Button) view.findViewById(R.id.btn6);
        mBtn6.setOnClickListener(this);
        mBtn1 = (Button) view.findViewById(R.id.btn1);
        mBtn1.setOnClickListener(this);
        mBtn2 = (Button) view.findViewById(R.id.btn2);
        mBtn2.setOnClickListener(this);
        mBtn3 = (Button) view.findViewById(R.id.btn3);
        mBtn3.setOnClickListener(this);
        mBtn0 = (Button) view.findViewById(R.id.btn0);
        mBtn0.setOnClickListener(this);
        mBtnAnswer = (Button) view.findViewById(R.id.btnAnswer);
        mBtnAnswer.setOnClickListener(this);
        mBtnC = (Button) view.findViewById(R.id.btnC);
        mBtnC.setOnClickListener(this);
        mBtnDelete = (Button) view.findViewById(R.id.btnDelete);
        mBtnDelete.setOnClickListener(this);
//        mBtnMinus = (Button) view.findViewById(R.id.btnMinus);
//        mBtnMinus.setOnClickListener(this);
        mBack = (ImageView) view.findViewById(R.id.btnBack);
        mBack.setOnClickListener(this);
        mTvIncorrect = (TextView) view.findViewById(R.id.tv_incorrect);
        mTvCorrect = (TextView) view.findViewById(R.id.tv_correct);
        mTvTimer = (TextView) view.findViewById(R.id.tv_timer);
    }

    //make listener on button clicks
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn7:
                answer += "7";
                mTvAnswer.setText(answer);
                break;
            case R.id.btn8:
                answer += "8";
                mTvAnswer.setText(answer);
                break;
            case R.id.btn9:
                answer += "9";
                mTvAnswer.setText(answer);
                break;
            case R.id.btn4:
                answer += "4";
                mTvAnswer.setText(answer);
                break;
            case R.id.btn5:
                answer += "5";
                mTvAnswer.setText(answer);
                break;
            case R.id.btn6:
                answer += "6";
                mTvAnswer.setText(answer);
                break;
            case R.id.btn1:
                answer += "1";
                mTvAnswer.setText(answer);
                break;
            case R.id.btn2:
                answer += "2";
                mTvAnswer.setText(answer);
                break;
            case R.id.btn3:
                answer += "3";
                mTvAnswer.setText(answer);
                break;
            case R.id.btn0:

                answer += "0";
                mTvAnswer.setText(answer);
                break;
            case R.id.btnAnswer:

                //events when the answer is correct
                AnswerBtn();
                equations(equationAmounts);

                break;
            case R.id.btnC:

                //make numbers to 0
                mTvAnswer.setText("0");
                answer = "";
                break;
            case R.id.btnDelete:
                if (answer != null && answer.length() > 0) {
                    answer = answer.substring(0, answer.length() - 1);

                } else {
                    answer = "0";
                }

                //make numbers to 0
                mTvAnswer.setText(answer);


                break;
//            case R.id.btnMinus:
//
//                answer += "-";
//                mTvAnswer.setText(answer);
//                break;
            case R.id.btnBack:
                fragmentStart = new FragmentStart();
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayoutMain, fragmentStart, "FRAGMENT1");
                fragmentTransaction.commit();

                timer.cancel(true);
                break;
        }
    }

    private void AnswerBtn() {
        //Get text from TextView mTvAnswer and parse to String
        String temp = String.valueOf(mTvAnswer.getText());

        //Parse to int
        int tempNumber = Integer.valueOf(temp);

        //Check the answer
        if (tempNumber == equation1 + equation2) {

            //increase the score if answer is correct
            correct++;

            //setting the score value to TextView
            mTvCorrect.setText(String.valueOf(correct));

            //if correct, say "correct"
            Toast.makeText(getActivity(), "CORRECT!!!", Toast.LENGTH_SHORT).show();

            //Make timer to default state
            timerTime[0] += defaultTimer;

            equationAmounts++;


        } else {
            incorrect++;
            mTvIncorrect.setText(String.valueOf(incorrect));
            //if not correct, say "incorrect"
            Toast.makeText(getActivity(), "INCORRECT", Toast.LENGTH_SHORT).show();
        }


        //make numbers to 0
        answer = "";
        mTvAnswer.setText("0");


    }
}
