package com.example.laxmann.mycalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu3, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuOne:
                Toast.makeText(ThirdActivity.this,"Calculator" , Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.menuTwo:
                Toast.makeText(ThirdActivity.this , "Converter" , Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, SecondActivity.class));
                return true;
            case R.id.menuThree:
                Toast.makeText(ThirdActivity.this , "Comments" , Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Database.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
