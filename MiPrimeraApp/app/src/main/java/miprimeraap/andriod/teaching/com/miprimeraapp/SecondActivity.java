package miprimeraap.andriod.teaching.com.miprimeraapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String paco = intent.getStringExtra("paco");
        int dinero = intent.getIntExtra("dinero", 0);
        Log.d("SecondActivity", "El extra de 'paco' vale"+ paco);
        Log.d("SecondActivity", "El extra de 'dinero' vale"+ dinero);

    }
}
