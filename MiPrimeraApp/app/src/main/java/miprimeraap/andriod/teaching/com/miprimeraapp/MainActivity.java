package miprimeraap.andriod.teaching.com.miprimeraapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("MainActivity", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy");
    }
    public void onClick(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("Paco","Valor de paco");
        intent.putExtra("dinero",200);
        startActivity(intent);

    }
    public void onClick1(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(intent);
    }
    public void onClick2(View view){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1234"));
        startActivity(intent);
    }
    public  void onClick3(View view){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
    public void onClick4(View view){
        Intent intent = new Intent(this, GalleryActivity.class);
        startActivity(intent);
    }
}
