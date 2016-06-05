package com.filadelfia.lucas.igrejafiladelfia;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Appointmentsbook extends AppCompatActivity {

    Spinner spinner;
    private ProgressDialog pDialog;
    private String dates_url = "http://igrejafiladelfia-conectguitar.rhcloud.com/dates";
    private static final String TAG_APPOINTMENTSBOOK = "appointmentsbook";
    private static final String TAG_APPOINTMENT_DATE = "appointment_date";
    private static final String TAG_COMMITMENT = "commitment";
    private static final String TAG_MINISTRY = "ministry";
    private static final String TAG_START_HOUR = "start_hour";
    private static final String TAG_END_HOUR = "end_hour";
    private static final String TAG_DATE = "date";
    JSONArray appointmentsbooks = null;
    ArrayList<HashMap<String, String>> appointmentsList;
    //private ArrayList datesList;
    HashMap<String, String> teclist;
    private ArrayList<Dates> datesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointmentsbook);

        datesList = new ArrayList<Dates>();

        spinner=(Spinner)findViewById(R.id.spinner);

        new GetDates().execute();

    }

    private class GetDates extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Appointmentsbook.this);
            pDialog.setMessage("Please wait...");
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
                    if (jsonObj != null) {
                        JSONArray dates = jsonObj
                                .getJSONArray(TAG_DATE);

                        for (int i = 0; i < dates.length(); i++) {
                            JSONObject userObj = (JSONObject) dates.get(i);
                            Dates date = new Dates(userObj.getString("months"), userObj.getString("year_month"));

                            datesList.add(date);

                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } else {
                Log.e("JSON Data", "Didn't receive any data from server!");
            }

            return null;
            //return teachersList;
        }

        @Override
        //protected void onPostExecute(ArrayList<HashMap<String, String>> result) {
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */

            populateSpinner();

        }

    }

    private void populateSpinner() {

        String[] lables = new String[datesList.size()];
        //HashMap<String, String> spinnerMap = new HashMap<String, String>();

        teclist = new HashMap<>();
        for (int i = 0; i < datesList.size(); i++) {
            teclist.put(String.valueOf(datesList.get(i).getYear_month()), String.valueOf(datesList.get(i).getMonths()));
            lables[i] = datesList.get(i).getMonths();
        }

        // Creating adapter for spinner
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        spinnerAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(spinnerAdapter);

    }

}
