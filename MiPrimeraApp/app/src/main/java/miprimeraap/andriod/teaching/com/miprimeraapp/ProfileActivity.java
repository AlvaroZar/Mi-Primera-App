package miprimeraap.andriod.teaching.com.miprimeraapp;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class ProfileActivity  extends AppCompatActivity{

    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText ageEditText;
    private RadioButton radioButtonMale;
    private RadioButton radioButtonFemale;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        usernameEditText = findViewById(R.id.username);
        usernameEditText.getText().toString();
        emailEditText = findViewById(R.id.email);
        emailEditText.getText().toString();
        passwordEditText = findViewById(R.id.password);
        passwordEditText.getText().toString();
        ageEditText = findViewById(R.id.age);
        ageEditText.getText().toString();

        radioButtonMale = findViewById(R.id.male);
        radioButtonMale.getText().toString();
        radioButtonFemale = findViewById(R.id.female);
        radioButtonFemale.getText().toString();
    }
    public void guardarDatos (View view){
        Log.d("ProfileActivity","Username: " + usernameEditText.getText());
        Log.d("ProfileActivity","Email: " + emailEditText.getText());
        Log.d("ProfileActivity","Password: " + passwordEditText.getText());
        Log.d("ProfileActivity","Age: " + ageEditText.getText());


        if (radioButtonMale.isChecked()){
            Log.d("ProfileActivity", "Gender: Male ");
        }
        else if(radioButtonFemale.isChecked()){
            Log.d("ProfileActivity","Gender: Female " );
        }

        }

    }


