package com.example.listeners;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    Button btnUp, btnDown;
    int count, count2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUp = (Button) findViewById(R.id.btnUp);
        btnDown = (Button) findViewById(R.id.btnDown);
        count = 0;
        count2 = 0;

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
            }
        });

        btnDown.setOnLongClickListener(this);
    }

    @Override
    public boolean onLongClick(View view) {
        count2 += 2;
        return true;
    }

    public void result(View view) {
        Intent si = new Intent(this, resultActivity.class);
        si.putExtra("upbutton",count);
        si.putExtra("downbutton",count2);
        startActivityForResult(si,1);
    }

    protected void onActivityResult(int resAct, int good, Intent data_back) {
        super.onActivityResult(resAct, good, data_back);
        if (data_back != null) {
            count = data_back.getIntExtra("upbutton", -1);
            count2 = data_back.getIntExtra("downbutton", -1);
        }
    }
}