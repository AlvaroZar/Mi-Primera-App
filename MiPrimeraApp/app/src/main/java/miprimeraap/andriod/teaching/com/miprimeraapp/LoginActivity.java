package miprimeraap.andriod.teaching.com.miprimeraapp;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences =
                getSharedPreferences(getString(R.string.basic_preference_file),Context.MODE_PRIVATE);
        String savedUsername = sharedPreferences.getString("username1","");
        usernameEditText.setText(savedUsername);

    }

    public void onLogin(View view){
        String username = usernameEditText.getText().toString();
        String password = usernameEditText.getText().toString();

        if (TextUtils.isEmpty(username)){
            usernameEditText.setError(getString(R.string.username_error));
        }else if (TextUtils.isEmpty(password)){
            passwordEditText.setError(getString(R.string.password_error));
        }else {


            AppDataBase db = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, "database-name")
                    .allowMainThreadQueries()
                    .build();

            User retrievedUser = db.userDao().findByUsername(username);
            if (retrievedUser == null) {
                Toast.makeText(this, "Username does not exist", Toast.LENGTH_LONG).show();
            } else if (password.equals(retrievedUser.getPassword())) {

                Intent profileIntent = new Intent(this, ProfileActivity.class);
                startActivity(profileIntent);
                SharedPreferences sharedPreferences =
                        getSharedPreferences(getString(R.string.basic_preference_file),
                                Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username1", username);
                editor.apply();

            } else {
                passwordEditText.setError("Invalid password");
            }

            }
        }


    public void onCancel(View view){
        usernameEditText.getText();
        passwordEditText.getText();
    }

    public void onRegister(View view){
        Intent registerIntent = new Intent(this, ProfileActivity.class);
        startActivity(registerIntent);
    }
}
