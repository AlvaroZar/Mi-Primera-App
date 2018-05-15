package miprimeraap.andriod.teaching.com.miprimeraapp;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Application;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

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
        ageEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                    new DatePickerDialog(ProfileActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            ageEditText.setText(year+"/" + (month + 1) + "/" + dayOfMonth);

                        }
                    },1997,6,11).show();
                }
            }
        });

        radioButtonMale = findViewById(R.id.male);
        radioButtonMale.getText().toString();
        radioButtonFemale = findViewById(R.id.female);
        radioButtonFemale.getText().toString();

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater myInfater = getMenuInflater();
        myInfater.inflate(R.menu.menu_profile,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.save:
                 saveInternal();
                 break;
            case R.id.delete:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveInternal (){
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
        public void guardarDatos(View view){
        saveInternal();
    }
     public void onClickDelete (View view) {
         AlertDialog.Builder builder = new AlertDialog.Builder(this);
         builder.setTitle(R.string.dialog_title).setMessage(R.string.dialog_message);

         builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {

                 Toast.makeText(ProfileActivity.this, "SI QUIERO", Toast.LENGTH_LONG).show();

             }
         });
         builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 Toast.makeText(ProfileActivity.this, "NO QUIERO", Toast.LENGTH_LONG).show();
             }
         });
         builder.setNeutralButton(R.string.cancel, new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 Toast.makeText(ProfileActivity.this, "CANCELAR" ,Toast.LENGTH_LONG).show();
             }
         });
         AlertDialog dialog = builder.create();
         dialog.show();
     }

    }


