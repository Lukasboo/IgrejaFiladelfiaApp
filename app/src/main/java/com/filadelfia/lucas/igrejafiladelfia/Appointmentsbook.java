package com.filadelfia.lucas.igrejafiladelfia;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Appointmentsbook extends AppCompatActivity {

    private ProgressDialog pDialog;
    private String dates_url = "http://igrejafiladelfia-conectguitar.rhcloud.com/dates";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointmentsbook);
    }

    private class GetDates extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Appointmentsbook.this);
            pDialog.setMessage("Por favor, espere");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(dates_url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    users = jsonObj.getJSONArray(TAG_USERS);
                    studentsList = new ArrayList<HashMap<String, String>>();
                    // looping through All Contacts
                    for (int i = 0; i < users.length(); i++) {
                        JSONObject c = users.getJSONObject(i);

                        String id = c.getString(TAG_ID);
                        String name = c.getString(TAG_NAME);
                        String original_filename = c.getString(TAG_ORIGINAL_FILENAME);
                        String filename = c.getString(TAG_FILENAME);
                        String student_id = c.getString(TAG_STUDENT_ID);
                        String stage = c.getString(TAG_STAGE);
                        String lesson = c.getString(TAG_LESSON);

                        //studentsList = new ArrayList<HashMap<String, String>>();

                        // tmp hashmap for single contact
                        HashMap<String, String> contact = new HashMap<String, String>();

                        // adding each child node to HashMap key => value
                        contact.put(TAG_ID, id);
                        contact.put(TAG_NAME, name);
                        contact.put(TAG_ORIGINAL_FILENAME, original_filename);
                        contact.put(TAG_FILENAME, filename);
                        contact.put(TAG_STUDENT_ID, student_id);
                        contact.put(TAG_STAGE, stage);
                        contact.put(TAG_LESSON, lesson);

                        // adding contact to contact list
                        studentsList.add(contact);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */

            ListAdapter adapter = new SimpleAdapter(Display.this, studentsList, R.layout.display_entry, new String[]{"id", "name", "original_filename", "filename", "stage", "lesson", "student_id"}, new int[]{R.id.students_Id, R.id.students_name, R.id.students_lesson, R.id.students_filename, R.id.students_nstage, R.id.students_nlesson, R.id.students_ID});
            lv.setAdapter(adapter);

        }

    }

}
