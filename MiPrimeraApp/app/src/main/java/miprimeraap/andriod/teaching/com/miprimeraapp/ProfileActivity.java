package miprimeraap.andriod.teaching.com.miprimeraapp;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteConstraintException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.File;

public class ProfileActivity  extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private EditText ageEditText;
    private RadioButton radioButtonMale;
    private RadioButton radioButtonFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                if (hasFocus) {
                    new DatePickerDialog(ProfileActivity.this, new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            ageEditText.setText(year + "/" + (month + 1) + "/" + dayOfMonth);

                        }
                    }, 1997, 6, 11).show();
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

        getExternalFilesDir(null).mkdirs();

        File imgFile = new File(getExternalFilesDir(null),"Sfg8m-n6_400x400.jpg");
        if(imgFile.exists()){

            ImageView imageView = findViewById(R.id.profile);
            imageView.setImageURI(Uri.fromFile(imgFile));
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences sharedPreferences = getSharedPreferences("miprimeraap.android.teaching.com.BASIC_PREFERENCE_FILE",Context.MODE_PRIVATE);
        String usernameValue = sharedPreferences.getString("username", "");
        AppDataBase db = Room.databaseBuilder(getApplicationContext(),
                AppDataBase.class, "database-name").allowMainThreadQueries().build();
        User user = db.userDao().findByUsername(usernameValue);
        if (user != null){
            usernameEditText.setText(user.getUsername());
            emailEditText.setText(user.getEmail());
            passwordEditText.setText(user.getPassword());
            ageEditText.setText(user.getAge());
            if (user.getGender().equals("M")){
                radioButtonMale.setChecked(true);
            }else if (user.getGender().equals("F")){
                radioButtonFemale.setChecked(true);
            }
        }


    }

    @Override
    protected void onStop() {
        super.onStop();
        String username = usernameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String age = ageEditText.getText().toString();

        SharedPreferences sharedPreferences =
                getSharedPreferences(getString(R.string.basic_preference_file), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putString("email", email);
        editor.putString("age", age);
        if (radioButtonMale.isChecked()) {
            editor.putString("gender", "M");
        } else if (radioButtonFemale.isChecked()) {
            editor.putString("gender", "F");
        }
        editor.apply();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater myInfater = getMenuInflater();
        myInfater.inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                saveInternal();
                break;
            case R.id.delete:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveInternal() {
        Log.d("ProfileActivity", "Username: " + usernameEditText.getText());
        Log.d("ProfileActivity", "Email: " + emailEditText.getText());
        Log.d("ProfileActivity", "Password: " + passwordEditText.getText());
        Log.d("ProfileActivity", "Age: " + ageEditText.getText());


        if (radioButtonMale.isChecked()) {
            Log.d("ProfileActivity", "Gender: Male ");
        } else if (radioButtonFemale.isChecked()) {
            Log.d("ProfileActivity", "Gender: Female ");
        }

        AppDataBase db = Room.databaseBuilder(getApplicationContext(),AppDataBase.class, "database-name")
                .allowMainThreadQueries()
                .build();
        try {
            User user = new User();
            user.setUsername(usernameEditText.getText().toString());
            user.setEmail(emailEditText.getText().toString());
            user.setPassword(passwordEditText.getText().toString());
            user.setAge(ageEditText.getText().toString());
            if (radioButtonMale.isChecked()){
                user.setGender("M");
            }else if (radioButtonFemale.isChecked()){
                user.setGender("F");
            }
            db.userDao().insert(user);
        }catch (SQLiteConstraintException ex){
            Toast.makeText(this, "Username is already registered", Toast.LENGTH_LONG).show();
        }

    }

    public void guardarDatos(View view) {saveInternal();}

    public void onClickDelete(final View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.dialog_title).setMessage(R.string.dialog_message);

        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(ProfileActivity.this, "SI QUIERO", Toast.LENGTH_LONG).show();

                SharedPreferences sharedPreferences =
                        getSharedPreferences(getString(R.string.basic_preference_file), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("username");
                editor.apply();
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

                Toast.makeText(ProfileActivity.this, "CANCELAR", Toast.LENGTH_LONG).show();


            }

        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
}

