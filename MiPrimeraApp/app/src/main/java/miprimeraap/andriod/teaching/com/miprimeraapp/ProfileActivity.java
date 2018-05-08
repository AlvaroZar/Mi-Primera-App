package miprimeraap.andriod.teaching.com.miprimeraapp;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class ProfileActivity  extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        EditText usernameEdidtex= findViewById(R.id.username);
        usernameEdidtex.getText().toString();
    }

}
