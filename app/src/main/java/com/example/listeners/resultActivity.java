package com.example.listeners;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class resultActivity extends AppCompatActivity {
    TextView tv;
    int upbutton, downbutton;
    Intent gi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv = findViewById(R.id.tv);

        gi = getIntent();
        upbutton = gi.getIntExtra("upbutton", -19);
        downbutton = gi.getIntExtra("downbutton", -19);

        if (upbutton > downbutton){
            tv.setText("blue won!!" + "\n"+"blue: "+upbutton + "\n"+"red: "+downbutton );
        }
        else if (upbutton < downbutton){
            tv.setText("red won!!"+ "\n"+"blue: "+upbutton + "\n"+"red: "+downbutton );
        }
        else{
            tv.setText("it's a tie!"+"\n"+"blue: "+upbutton + "\n"+"red: "+downbutton);
        }
    }

    public void Back(View view) {
        upbutton = 0;
        downbutton = 0;
        gi.putExtra("upbutton",upbutton);
        gi.putExtra("downbutton",downbutton);
        setResult(RESULT_OK, gi);
        finish();
    }
}