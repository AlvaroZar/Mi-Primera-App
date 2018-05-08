package miprimeraap.andriod.teaching.com.miprimeraapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);


    }

    public void onLogin(View view){
        String username = usernameEditText.getText().toString();
        String password = usernameEditText.getText().toString();

        if (TextUtils.isEmpty(username)){
            usernameEditText.setError(getString(R.string.username_error));
        }else if (TextUtils.isEmpty(password)){
            passwordEditText.setError(getString(R.string.password_error));
        }else {
            Intent profileIntent = new Intent(this, ProfileActivity.class);
            startActivity(profileIntent);
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
