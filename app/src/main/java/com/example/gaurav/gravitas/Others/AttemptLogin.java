package com.example.gaurav.gravitas.Others;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.RequiresPermission;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ADMINIBM on 6/8/2015.
 */
public class AttemptLogin extends AsyncTask<String,String,String> {

    boolean failure = false;
    ProgressDialog pDialog;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog = new ProgressDialog(Login.this);
        pDialog.setMessage("Attempting for login...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();
    }



    @Override
    protected String doInBackground(String... param) {
        int success;
        String username = user.getText().toString();
        String password = pass.getText().toString();
        try {

            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("username", username));
            params.add(new BasicNameValuePair("password", password));

            Log.d("request!", "starting");

            JSONObject json = jsonParser.makeHttpRequest(
                    LOGIN_URL, "POST", params);

            // checking  log for json response
            Log.d("Login attempt", json.toString());

            // success tag for json
            success = json.getInt(TAG_SUCCESS);
            if (success == 1) {
                Log.d("Successfully Login!", json.toString());

                Intent ii = new Intent(Login.this,OtherActivty.class);
                finish();
                // this finish() method is used to tell android os that we are done with current //activity now! Moving to other activity
                startActivity(ii);
                return json.getString(TAG_MESSAGE);
            }else{

                return json.getString(TAG_MESSAGE);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    protected void onPostExecute(String message) {

        pDialog.dismiss();
        if (message != null){
            Toast.makeText(Login.this, message, Toast.LENGTH_LONG).show();
        }
    }
}

