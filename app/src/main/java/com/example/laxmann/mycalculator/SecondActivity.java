package com.example.laxmann.mycalculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends ActionBarActivity implements View.OnClickListener {

    private Button button1, button2, button3, button4;
    private TextView editText2;

    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        init();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu2, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuOne:
                Toast.makeText(SecondActivity.this, "Calculator", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.menuTwo:
                Toast.makeText(SecondActivity.this, "About US", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, ThirdActivity.class));
                return true;
            case R.id.menuThree:
                Toast.makeText(SecondActivity.this, "Comments", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Database.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void init() {
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (TextView) findViewById(R.id.editText2);

        button1.setOnClickListener((View.OnClickListener) this);
        button2.setOnClickListener((View.OnClickListener) this);
        button3.setOnClickListener((View.OnClickListener) this);
        button4.setOnClickListener((View.OnClickListener) this);
    }
    @Override
    public void onClick(View view) {
        String num1 = editText.getText().toString();
        switch (view.getId()) {
            case R.id.button1:
                int square = Integer.parseInt(num1) * Integer.parseInt(num1);
                editText2.setText(String.valueOf(square));
                break;
            case R.id.button2:
                int cube = Integer.parseInt(num1) * Integer.parseInt(num1) * Integer.parseInt(num1);
                editText2.setText(String.valueOf(cube));
                break;
            case R.id.button3:
                int rect = Integer.parseInt(num1) * Integer.parseInt(num1) * Integer.parseInt(num1) * Integer.parseInt(num1);
                editText2.setText(String.valueOf(rect));
                break;
            case R.id.button4:
                int hect = Integer.parseInt(num1) * Integer.parseInt(num1) * Integer.parseInt(num1) * Integer.parseInt(num1) * Integer.parseInt(num1);
                editText2.setText(String.valueOf(hect));
                break;


        }
    }

}
