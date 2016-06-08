package com.example.vishnu.taskone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String NAME = "Name";
    public static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch sw = (Switch)findViewById(R.id.switch1);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    buttonView.setText("Mentorship is Needed");
                else
                    buttonView.setText("Mentorship is not Needed");
            }
        });

        Spinner spinner = (Spinner)(findViewById(R.id.spinner));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.department, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    public void submit(View view) {

        EditText name = (EditText) findViewById(R.id.name);
        EditText rollNo = (EditText) findViewById(R.id.rollNo);

        CheckBox checkBoxes[] = new CheckBox[4];

        checkBoxes[0] = (CheckBox) findViewById(R.id.appDev);
        checkBoxes[1] = (CheckBox) findViewById(R.id.webDev);
        checkBoxes[2] = (CheckBox) findViewById(R.id.tronix);
        checkBoxes[3] = (CheckBox) findViewById(R.id.algo);

        boolean flag = false;

                for(CheckBox checkBox: checkBoxes){
                    if(checkBox.isChecked())
                    {
                        flag = true;
                        break;
                    }
                }

        if(name.getText().toString().length()==0)
        {
            name.setError("This field is required");
            Toast.makeText(MainActivity.this, "Please enter name", Toast.LENGTH_SHORT).show();
            name.requestFocus();
        }

        else if(rollNo.getText().toString().length()==0)
        {
            rollNo.setError("This field is required");
            Toast.makeText(MainActivity.this, "Please enter roll no", Toast.LENGTH_SHORT).show();
            rollNo.requestFocus();
        }

        else if(flag == false){
            Toast.makeText(this, "Please choose a field in checkbox", Toast.LENGTH_SHORT).show();
        }
        else{

            Intent intent = new Intent(this, Main2Activity.class);

            intent.putExtra(NAME, name.getText().toString());

            startActivityForResult(intent, REQUEST_CODE);

        }
    }
}
