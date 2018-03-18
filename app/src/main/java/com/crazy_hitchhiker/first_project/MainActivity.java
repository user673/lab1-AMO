package com.crazy_hitchhiker.first_project;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import java.lang.*;

public class MainActivity extends Activity {

    double a,b,c,d,answer;
    EditText Text1,Text2,Text3, Text4; // Varibles for linear
    TextView Text;

    double f_choose, l_choose, k_choose, d_choose, w_choose, answer_choose; // Variables for choose
    EditText Text_f, Text_l, Text_k, Text_d, Text_w; // For choose
    TextView Text_choose; // For choose

    double b_cycle, answer_cycle; // Thera are parameers for third pard of task
    EditText Text_b_cycle;
    TextView  Text_cycle4,Text_cycle5,Text_cycle6,Text_cycle7,Text_cycle8,Text_cycle9,
            Text_cycle10, Text_cycle11,Text_cycle12,Text_cycle13,Text_cycle14,Text_cycle15,Text_cycle16,
            Text_cycle17,Text_cycle18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Text = (TextView)findViewById(R.id.ansver);
        Text1 = (EditText)findViewById(R.id.a);
        Text2 = (EditText)findViewById(R.id.b);
        Text3 = (EditText)findViewById(R.id.c);
        Text4 = (EditText)findViewById(R.id.d);

        // Here we take parameters from choose variant
        Text_choose = (TextView)findViewById(R.id.ansver_choose);
        Text_f = (EditText) findViewById(R.id.f_choose);
        Text_l = (EditText)findViewById(R.id.l_choose);
        Text_k = (EditText)findViewById(R.id.k_choose);
        Text_d = (EditText)findViewById(R.id.d_choose);
        Text_w = (EditText)findViewById(R.id.w_choose);

        // Here we take meanings from cycle variant
        //Text_cycle = (TextView)findViewById(R.id.answer_cycle);
        Text_cycle4 = (TextView)findViewById(R.id.answer_cycle4);
        Text_cycle5 = (TextView)findViewById(R.id.answer_cycle5);
        Text_cycle6 = (TextView)findViewById(R.id.answer_cycle6);
        Text_cycle7 = (TextView)findViewById(R.id.answer_cycle7);
        Text_cycle8 = (TextView)findViewById(R.id.answer_cycle8);
        Text_cycle9 = (TextView)findViewById(R.id.answer_cycle9);
        Text_cycle10 = (TextView)findViewById(R.id.answer_cycle10);
        Text_cycle11 = (TextView)findViewById(R.id.answer_cycle11);
        Text_cycle12 = (TextView)findViewById(R.id.answer_cycle12);
        Text_cycle13 = (TextView)findViewById(R.id.answer_cycle13);
        Text_cycle14 = (TextView)findViewById(R.id.answer_cycle14);
        Text_cycle15 = (TextView)findViewById(R.id.answer_cycle15);
        Text_cycle16 = (TextView)findViewById(R.id.answer_cycle16);
        Text_cycle17 = (TextView)findViewById(R.id.answer_cycle17);
        Text_cycle18 = (TextView)findViewById(R.id.answer_cycle18);

        Text_b_cycle = (EditText)findViewById(R.id.b_cycle);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("tag1");

        tabSpec.setContent(R.id.linear);
        tabSpec.setIndicator("linear");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag2");
        tabSpec.setContent(R.id.choose);
        tabSpec.setIndicator("choose");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("tag3");
        tabSpec.setContent(R.id.cycle);
        tabSpec.setIndicator("cycle");
        tabHost.addTab(tabSpec);

        tabHost.setCurrentTab(0);

        final Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    a = Double.parseDouble(Text1.getText().toString());
                    b = Double.parseDouble(Text2.getText().toString());
                    c = Double.parseDouble(Text3.getText().toString());
                    d = Double.parseDouble(Text4.getText().toString());
                }catch (NumberFormatException e){

                    a = 0;
                    b = 0;
                    c = 0;
                    d = 1;

                }
                if ( d == 0) {
                    Text.setText("Error \n Enter d =! 0");
                }
                else {
                    answer = Math.pow((a/d),2)+Math.pow((b/d),3)+Math.pow((c/2),4);

                    Text.setText("Answer : " + "\n" + answer);
                }


            }

        });

        // This code for second window
        final Button button_choose = (Button)findViewById(R.id.button_choose);
        button_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    f_choose = Double.parseDouble(Text_f.getText().toString());
                    l_choose = Double.parseDouble(Text_l.getText().toString());
                    k_choose = Double.parseDouble(Text_k.getText().toString());
                    d_choose = Double.parseDouble(Text_d.getText().toString());
                    w_choose = Double.parseDouble(Text_w.getText().toString());

                } catch (NumberFormatException e) { // You need to continue block 'catch'

                    f_choose = 0;

                }

                // Main logic of window
                if ((k_choose * l_choose) == 0 || (k_choose * l_choose) < 0 ) {
                    Text_choose.setText(" Please \n Enter correct data");
                }
                else {
                    if (f_choose == 0) {

                        w_choose = Math.toRadians(w_choose);
                        answer_choose = Math.log(l_choose * k_choose) + d_choose * Math.sin(w_choose * k_choose);
                        Text_choose.setText("Answer: " + "\n" + answer_choose);
                    }
                    else {
                        w_choose = Math.toRadians(w_choose);
                        answer_choose = Math.cos(w_choose * k_choose) + Math.log(l_choose * k_choose);
                        Text_choose.setText("Answer: " + "\n" + answer_choose);
                    }
                }


            }


    });

        final Button button_cycle = (Button)findViewById(R.id.button_cycle);
        button_cycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Logic part of cycle algorithm

                try {
                    b_cycle = Double.parseDouble(Text_b_cycle.getText().toString());

                }
                catch (NumberFormatException e){

                    b_cycle = 0;
                }
                double array[] = new double[15];
                for (int a = 4; a <= 18; a++) {
                    answer_cycle = Math.sqrt(Math.pow(a, 2) + Math.pow(b_cycle, 2)) - Math.pow((a + b_cycle), 2);
                    array[a - 4] = Math.rint(answer_cycle);
                }

               /* for (int i = 0; i <= array.length; i++) {
                    Text_cycle.setText("Answer: " );
                    Text_cycle4.setText(array[i]);
                }*/


                Text_cycle4.setText("1:  " + array[0]);
                Text_cycle5.setText("2:  " + array[1]);
                Text_cycle6.setText("3:  " +  array[2]);
                Text_cycle7.setText("4:  " + array[3]);
                Text_cycle8.setText("5:  " + array[4]);
                Text_cycle9.setText("6:  " + array[5]);
                Text_cycle10.setText("7:  " + array[6]);
                Text_cycle11.setText("8:  " + array[7]);
                Text_cycle12.setText("9:  " + array[8]);
                Text_cycle13.setText("10:  " +  array[9]);
                Text_cycle14.setText("11: " + array[10]);
                Text_cycle15.setText("12: " +  array[11]);
                Text_cycle16.setText("13: " + array[12]);
                Text_cycle17.setText("14: " + array[13]);
                Text_cycle18.setText("15: " + array[14]);






            }
        });

}}