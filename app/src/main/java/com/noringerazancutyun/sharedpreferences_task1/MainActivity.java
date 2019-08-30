package com.noringerazancutyun.sharedpreferences_task1;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.SharedLibraryInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String NAME_KEY = "name";
    private static final String EMAIL_KEY = "email";
    private static final String SHARED_PREF = "Preference";

    private EditText nameText;
    private EditText emailText;
    private Button saveButton;
    private Button retrieveButton;
    private Button clearText;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        saveButton.setOnClickListener(this);
        retrieveButton.setOnClickListener(this);
        clearText.setOnClickListener(this);
    }

    private void init() {
        nameText = findViewById(R.id.name_edit);
        emailText = findViewById(R.id.email_edit);
        saveButton = findViewById(R.id.save);
        retrieveButton = findViewById(R.id.retrive);
        clearText = findViewById(R.id.clear);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.save:
                saveValues();
                break;
            case R.id.retrive:
                retrieveValues();
                break;
            case R.id.clear:
                clearValues();
                break;
        }

    }

    private void saveValues(){
        preferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(NAME_KEY, nameText.getText().toString());
        editor.putString(EMAIL_KEY, emailText.getText().toString());
        editor.apply();
    }


    private void retrieveValues(){
        SharedPreferences preferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        nameText.setText(preferences.getString(NAME_KEY, ""));
        emailText.setText(preferences.getString(EMAIL_KEY, ""));
    }

    private void clearValues(){
        nameText.setText("");
        emailText.setText("");
    }
}
