package miprimeraap.andriod.teaching.com.miprimeraapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
    public void onGoku(View view){
        Intent gokuIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.animemovil.com"));
        startActivity(gokuIntent);
    }
}
