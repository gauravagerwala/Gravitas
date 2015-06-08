package com.example.gaurav.gravitas.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gaurav.gravitas.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText reg,dob,phone;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        reg=(EditText)findViewById(R.id.etRegNo);
        dob=(EditText)findViewById(R.id.etDob);
        phone=(EditText)findViewById(R.id.etPhone);
        login=(Button)findViewById(R.id.bLogin);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        /* TODO: Create the thread to verify details from backend here */
        Intent i= new Intent(LoginActivity.this,MainActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
