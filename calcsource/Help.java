package edu.ucsd.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        //Launches second activity within the main activity
        ImageButton exitActivityBtn = findViewById(R.id.exitBtn);
        exitActivityBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Create an intent with button that goes to 2nd screen
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }
        });

    }
}
