package com.example.calcproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity{

    Button button1;
    Button button2;
    Button button3;
    Button buttonplus;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button buttonminus;
    Button button8;
    Button button9;
    Button buttonmultiply;
    Button buttonclear;
    Button button0;
    Button buttonequal;
    Button buttondivide;
    LinearLayout backround;
    TextView display;
    String input;
    //StringTokenizer stringTokenizer;
    //StringTokenizer a;
    String math;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = "";
        math = "";
        button1 = findViewById(R.id.id_button1);
        button2 = findViewById(R.id.id_button2);
        button3 = findViewById(R.id.id_button3);
        buttonplus = findViewById(R.id.id_buttonplus);
        button4 = findViewById(R.id.id_button4);
        button5 = findViewById(R.id.id_button5);
        button6 = findViewById(R.id.id_button6);
        buttonminus = findViewById(R.id.id_buttonminus);
        button7 = findViewById(R.id.id_button7);
        button8 = findViewById(R.id.id_button8);
        button9 = findViewById(R.id.id_button9);
        buttonmultiply = findViewById(R.id.id_buttonmultiply);
        buttonclear = findViewById(R.id.id_buttonclear);
        button0 = findViewById(R.id.id_button0);
        buttonequal = findViewById(R.id.id_buttonequal);
        buttondivide = findViewById(R.id.id_buttondivide);
        display = findViewById(R.id.id_display);
        backround = findViewById(R.id.id_backround);

        //backround.setBackgroundColor(Color.BLACK);
        //display.setTextColor(Color.WHITE);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="1";
                display.setText(input + " ");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="2";
                display.setText(input + " ");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="3";
                display.setText(input + " ");
            }
        });
        buttonplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="+";
                display.setText(input + " ");
            }
        });button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="4";
                display.setText(input + " ");
            }
        });button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="5";
                display.setText(input + " ");
            }
        });button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="6";
                display.setText(input + " ");
            }
        });buttonminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="-";
                display.setText(input + " ");
            }
        });button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="7";
                display.setText(input + " ");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="8";
                display.setText(input + " ");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="9";
                display.setText(input + " ");
            }
        });
        buttonmultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="*";
                display.setText(input + " ");
            }
        });
        buttonclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input="";
                display.setText("");
            }
        });
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="0";
                display.setText(input + " ");
            }
        });
        buttonequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitEqual();
            }
        });
        buttondivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input+="/";
                display.setText(input + " ");
            }
        });













    }

    public void hitEqual() {


        try {



            StringTokenizer stringTokenizer = new StringTokenizer(input, "/+-*", false);
            ArrayList<Double> list = new ArrayList<Double>();
            ArrayList<Character> indexes = new ArrayList<Character>();
            ArrayList<Integer> mdindex = new ArrayList<Integer>();
            ArrayList<String> equations = new ArrayList<String>();

            while (stringTokenizer.hasMoreTokens()) {
                list.add(Double.parseDouble(stringTokenizer.nextToken()));
            }
            double z = 0;
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == '+' || input.charAt(i) == '*' || input.charAt(i) == '-' || input.charAt(i) == '/') {
                    indexes.add(input.charAt(i));
                }

            }

            for (int i = 0; i < indexes.size(); i++) {
                if (indexes.get(i).equals('*') || indexes.get(i).equals('/')) {
                    mdindex.add(i);
                }
            }

            for (int i = 0; i < indexes.size(); i++) {
                equations.add("" + list.get(i) + indexes.get(i) + list.get(i + 1));
            }






            if(mdindex.size() !=0){
                String[] priorityequations = new String[mdindex.size()];
                int number = equations.size();
                for (int i = 0; i < mdindex.size(); i++) {
                    priorityequations[i] = equations.get(mdindex.get(i));
                }


                Double[] results = new Double[priorityequations.length];
                for (int i = 0; i < priorityequations.length; i++) {
                    if (indexes.get(mdindex.get(i)).equals('*'))
                        results[i] = (double) (list.get(mdindex.get(i)) * list.get(mdindex.get(i) + 1));
                    if (indexes.get(mdindex.get(i)).equals('/'))
                        results[i] = (double) (list.get(mdindex.get(i)) / list.get(mdindex.get(i) + 1));
                }


                //10-2*3-4-5-6*7
                //10-6-4-5-42
                String temp = "";
                int n = 0;
                for (int i = 0; i < equations.size(); i++) {
                    if (equations.size() == 1 && results[i] != null) {
                        equations.set(0, "" + results[0]);
                        n++;
                    } else if ((indexes.get(i).equals('*') || indexes.get(i).equals('/')) && i == equations.size() - 1) {
                        //temp = ""+list.get(i-1) + indexes.get(i-1) + results[i];
                        equations.set((i - 1), ("" + list.get(i - 1) + indexes.get(i - 1) + results[n]));
                        equations.set(i, "" + results[n]);
                        n++;
                    } else if ((indexes.get(i).equals('*') || indexes.get(i).equals('/')) && i == 0) {
                        equations.set((i + 1), ("" + results[n] + indexes.get(i + 1) + list.get(i + 1)));
                        equations.set(i, "" + results[n]);
                        n++;
                    } else if ((indexes.get(i).equals('*') || indexes.get(i).equals('/'))) {
                        //temp = ""+list.get(i-1) + indexes.get(i-1) + results[i];
                        equations.set((i - 1), ("" + list.get(i - 1) + indexes.get(i - 1) + results[n]));
                        equations.set((i + 1), ("" + results[n] + indexes.get(i + 1) + list.get(i + 2)));
                        equations.set(i, "" + results[n]);

                        n++;
                    }


                }



                if (!(equations.size() == 1)) {
                    int m = results.length - 1;
                    for (int i = equations.size() - 1; i >= 0; i--) {
                        if (indexes.get(i).equals('*') || indexes.get(i).equals('/')) {
                            equations.remove(i);
                            indexes.remove(i);
                            list.remove(i);
                            list.set(i, results[m]);
                            m--;
                        }

                    }
                }
            }


            //10-2*3-4-5-6*7
            //10-6-4-5-42

            double u = 0;

            while (equations.size() > 1) {

                if (indexes.get(0).equals('+')) {
                    u = (list.get(0)) + (list.get(1));
                    equations.set(1, "" + (list.get(0)) + (list.get(1)) + indexes.get(0) + list.get(1));
                    list.set(1, (list.get(0)) + (list.get(1)));
                    //equations.set(0,String.valueOf(u));
                }
                if (indexes.get(0).equals('-')) {
                    u = (list.get(0)) - (list.get(1));
                    equations.set(1, "" + (list.get(0)) + (list.get(1)) + indexes.get(0) + list.get(1));
                    list.set(1, (list.get(0)) - (list.get(1)));
                    //equations.set(0,String.valueOf(u));
                }


                //if(indexes.get(0).equals("-"))
                //  list.set(1, (list.get(0))-(list.get(1)));
                //else
                // list.set(1, (list.get(0))+(list.get(1)));
                equations.remove(0);

                indexes.remove(0);
                list.remove(0);
                //list.remove(1);


            }


///*
            if (indexes.get(0).equals('+')) {
                u = (list.get(0)) + (list.get(1));
                equations.set(0, String.valueOf(u));
            }
            if (indexes.get(0).equals('-')) {
                u = (list.get(0)) - (list.get(1));
                equations.set(0, String.valueOf(u));
            }

            double thefinal = Double.parseDouble(equations.get(0));


            if(equations.get(0).equals("Infinity"))
                display.setText("Error");
            else {
                if(thefinal%1==0) {
                    display.setText("" + (int)thefinal + "");
                }
                else
                    display.setText("" + thefinal + "");
            }

            if(thefinal%1==0) {
                input=""+(int)(thefinal);
            }
            else
                input=""+(thefinal);

        } catch (Exception e) {
            display.setText("Error");
        }



    }
}
