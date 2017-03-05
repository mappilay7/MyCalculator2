package com.example.laxmann.mycalculator;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Database extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName, editComment;
    Button btnAddData;
    Button btnviewAll;

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
                Toast.makeText(Database.this, "Calculator", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
                return true;
            case R.id.menuTwo:
                Toast.makeText(Database.this, "Converter", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, SecondActivity.class));
                return true;
            case R.id.menuThree:
                Toast.makeText(Database.this, "About US", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, ThirdActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        myDb = new DatabaseHelper(this);
        editName = (EditText) findViewById(R.id.editText3);
        editComment = (EditText) findViewById(R.id.editText4);


        btnAddData = (Button) findViewById(R.id.button);
        btnviewAll = (Button) findViewById(R.id.button5);
        AddData();
        viewAll();

        display("constructor called");

    }
    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editName.getText().toString(),
                                editComment.getText().toString());

                        if (isInserted == true)
                            Toast.makeText(Database.this, "Data Inserted ",
                                    Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Database.this, "Data Not Inserted ",
                                    Toast.LENGTH_LONG).show();
                        display("onCreate called");
                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if (res.getCount() == 0) {
                            showMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id : " + res.getString(0) + "\n");
                            buffer.append("Name : " + res.getString(1) + "\n");
                            buffer.append("Comments : " + res.getString(2) + "\n");



                        }
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title, String Mesage) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Mesage);
        builder.show();
    }


    public void display(String msg) {
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
    }
}


