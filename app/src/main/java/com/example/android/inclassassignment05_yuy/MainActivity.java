package com.example.android.inclassassignment05_yuy;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText titleView;
    EditText messageView;
    Button mailButton;
    Button launchButton;
    Button cameraButton;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleView = findViewById(R.id.title_view);
        messageView = findViewById(R.id.message_view);
        mailButton = findViewById(R.id.mailButton);
        launchButton = findViewById(R.id.launch_button);
        cameraButton = findViewById(R.id.camera);
        checkBox = findViewById(R.id.check_box);




        launchButton.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NewActivity.class);
                String title = titleView.getText().toString();
                boolean isChecked = checkBox.isChecked();
                if(isChecked){
                    startActivity(intent);
                }else {
                    intent.putExtra("KEY_VALUE1",title);
                    startActivity(intent);
                }


            }
        });

        cameraButton.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });




    }

    public void sendMail(View view){
        String title = titleView.getText().toString();
        String message = messageView.getText().toString();
        boolean isChecked = checkBox.isChecked();
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        if(isChecked){
            intent.putExtra(Intent.EXTRA_SUBJECT, title);
        }else {
            intent.putExtra(Intent.EXTRA_SUBJECT, title);
            intent.putExtra(Intent.EXTRA_TEXT, message);
        }

        startActivity(intent);

    }

}






