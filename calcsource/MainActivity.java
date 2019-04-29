package edu.ucsd.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Loads activity_main.xml
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create spinner with id
        Spinner staticSpinner = findViewById(R.id.spinner);

        // Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
                .createFromResource(MainActivity.this,R.array.operation_array,
                        android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        staticAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner.setAdapter(staticAdapter);
        staticSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Depending on item selected, changes operation done
                switch(position) {
                    case 0:
                        operation = 0;
                        break;
                    case 1:
                        operation = 1;
                        break;
                    case 2:
                        operation = 2;
                        break;
                    case 3:
                        operation = 3;
                        break;
                    case 4:
                        operation = 4;
                        break;
                    case 5:
                        operation = 5;
                        break;
                    case 6:
                        operation = 6;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //addition by default
                operation = 0;
            }
        });

        //Calculate when button is pressed
        Button addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double num1;
                double num2;
                //Sets text 1 and 2
                //Error handling
                try {
                    EditText firstNumEditText = findViewById(R.id.firstEditNumText);
                    EditText secondNumEditText = findViewById(R.id.secondEditNumText);
                    //Converts to int
                    num1 = Double.parseDouble(firstNumEditText.getText().toString());
                    num2 = Double.parseDouble(secondNumEditText.getText().toString());
                }
                catch(Exception e) {
                    return;
                }

                double result = 0;
                TextView resultTextView = findViewById(R.id.result);
                //Calculates result based on operation and prints it
                switch(operation) {
                    case 0:
                        result = num1 + num2;
                        break;
                    case 1:
                        result = num1 - num2;
                        break;
                    case 2:
                        result = num1 * num2;
                        break;
                    case 3:
                        if(num2 == 0) {
                            resultTextView.setText("Undefined!");
                            return;
                        }
                        result = num1 / num2;
                        break;
                    case 4:
                        result = Math.pow(num1, num2);
                        break;
                    case 5:
                        if(num2 == 0) {
                            resultTextView.setText("Undefined!");
                            return;
                        }
                        result = Math.pow(num1, (1/num2));
                        break;
                    case 6:
                        if(num2 == 0) {
                            resultTextView.setText("Undefined!");
                            return;
                        }
                        result = num1 % num2;
                        break;
                }
                resultTextView.setText(result + "");
            }
        });
    }

}
