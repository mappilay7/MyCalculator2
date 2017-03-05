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

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private Button btnAdd, btnMinus, btnTimes, btnDivide;
    private TextView textBox3;

    private EditText textBox1, textBox2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnTimes = (Button) findViewById(R.id.btnTimes);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        textBox1 = (EditText) findViewById(R.id.textBox1);
        textBox2 = (EditText) findViewById(R.id.textBox2);
        textBox3 = (TextView) findViewById(R.id.textBox3);

        btnAdd.setOnClickListener((View.OnClickListener) this);
        btnMinus.setOnClickListener((View.OnClickListener) this);
        btnTimes.setOnClickListener((View.OnClickListener) this);
        btnDivide.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)


    {
        switch (item.getItemId()) {

            case R.id.menuOne:
                Toast.makeText(MainActivity.this, "Converter", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, SecondActivity.class));
                return true;
            case R.id.menuTwo:
                Toast.makeText(MainActivity.this, "About US", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, ThirdActivity.class));
                return true;
            case R.id.menuThree:
                Toast.makeText(MainActivity.this, "Comments", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Database.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);

            }

        }

    @Override
    public void onClick(View view) {
        String num1 = textBox1.getText().toString();
        String num2 = textBox2.getText().toString();
        switch (view.getId()) {
            case R.id.btnAdd:
                int addition = Integer.parseInt(num1) + Integer.parseInt(num2);
                textBox3.setText(String.valueOf(addition));
                break;
            case R.id.btnMinus:
                int subtraction = Integer.parseInt(num1) - Integer.parseInt(num2);
                textBox3.setText(String.valueOf(subtraction));
                break;
            case R.id.btnDivide:
                try {
                    int division = Integer.parseInt(num1) / Integer.parseInt(num2);
                    textBox3.setText(String.valueOf(division));
                } catch (Exception e) {
                    textBox3.setText("Cannot DIVIDE!");
                }
                break;
            case R.id.btnTimes:
                int multiply = Integer.parseInt(num1) * Integer.parseInt(num2);
                textBox3.setText(String.valueOf(multiply));
                break;
        }
    }

}
