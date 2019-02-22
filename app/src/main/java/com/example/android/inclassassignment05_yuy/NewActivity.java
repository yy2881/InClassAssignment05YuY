package com.example.android.inclassassignment05_yuy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NewActivity extends AppCompatActivity {
    TextView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        view = findViewById(R.id.view);


        Intent intent = getIntent();
        String title = intent.getStringExtra("KEY_VALUE1");

        view.setText(title);

        this.setTitle("InClassAssignment");
    }


}
