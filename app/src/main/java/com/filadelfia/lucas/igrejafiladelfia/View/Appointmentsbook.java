package com.filadelfia.lucas.igrejafiladelfia.View;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.filadelfia.lucas.igrejafiladelfia.Controller.Dates;
import com.filadelfia.lucas.igrejafiladelfia.Controller.ServiceHandler;
import com.filadelfia.lucas.igrejafiladelfia.Model.DatabaseHelper;
import com.filadelfia.lucas.igrejafiladelfia.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Appointmentsbook extends AppCompatActivity {

    Spinner spinner;
    //LinearLayout LL;
    private ProgressDialog pDialog;
    private String dates_url = "http://igrejafiladelfia-conectguitar.rhcloud.com/dates";
    private String url = "http://igrejafiladelfia-conectguitar.rhcloud.com/appointmentsbooks/retornardata/ret/";
    private static final String TAG_ID = "id";
    private static final String TAG_APPOINTMENTSBOOK = "appointmentsbook";
    private static final String TAG_APPOINTMENT_DATE = "appointment_date";
    private static final String TAG_APPOINTMENT_DAY = "appointment_day";
    private static final String TAG_APPOINTMENT_WEEK_DAY = "week_day";
    private static final String TAG_COMMITMENT = "commitment";
    private static final String TAG_MINISTRY = "ministry";
    private static final String TAG_START_HOUR = "start_hour";
    private static final String TAG_END_HOUR = "end_hour";
    private static final String TAG_DATE = "date";
    JSONArray appointmentsbooks = null;
    ArrayList<HashMap<String, String>> appointmentsList;
    //private ArrayList datesList;
    ArrayAdapter<String> spinnerAdapter = null;
    HashMap<String, String> teclist;
    private ArrayList<Dates> datesList;
    DatabaseHelper helper = new DatabaseHelper(this);
    int actual_month;
    String number;
    String month;
    String year_month;
    //String week_day;
    ImageView imglogo, imgline, imgline2;
    ListView lv;
    RelativeLayout RL;
    TextView txtappointmentsbook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointmentsbook);

        datesList = new ArrayList<Dates>();

        RL = (RelativeLayout)findViewById(R.id.Layout);
        //LL = (LinearLayout)findViewById(R.id.SLayout);
        spinner=(Spinner)findViewById(R.id.spinner);
        spinner.setBackgroundColor(Color.WHITE);
        lv = (ListView)findViewById(R.id.list);
        imglogo = (ImageView)findViewById(R.id.imglogo);
        imgline = (ImageView)findViewById(R.id.imgline);
        imgline2 = (ImageView)findViewById(R.id.imgline2);
        txtappointmentsbook = (TextView)findViewById(R.id.txtappointmentsbook);

        actual_month = getActualMonth();
        new GetDates().execute();

        //month = String.valueOf(getActualMonth());
        //setSpinner(Integer.parseInt(month));

        new GetAppointments().execute();

        //int pos = getSpinnerField().getAdapter().indexOf(actual_month);
        //getSpinnerField().setSelection(pos);


        number = helper.getSets();

        if(number.equals("1")) {

            imglogo.setImageResource(R.drawable.filadelfia);
            imgline.setImageResource(R.drawable.line);
            imgline2.setImageResource(R.drawable.line);
            RL.setBackgroundResource(R.drawable.background);
            txtappointmentsbook.setTextColor(Color.WHITE);
            //lv.setBackgroundColor(Color.BLACK);

        }

        if(number.equals("2")) {
            imglogo.setImageResource(R.drawable.filadelfiai);
            imgline.setImageResource(R.drawable.linei);
            imgline2.setImageResource(R.drawable.linei);
            RL.setBackgroundResource(R.drawable.backgroundi);
            txtappointmentsbook.setTextColor(Color.BLACK);
            //lv.setBackgroundColor(Color.WHITE);

        }

        if(number.equals("3")) {
            imglogo.setImageResource(R.drawable.filadelfiai);
            imgline.setImageResource(R.drawable.linei);
            imgline2.setImageResource(R.drawable.linei);
            RL.setBackgroundResource(R.drawable.backgroundc);
            txtappointmentsbook.setTextColor(Color.BLUE);
            //lv.setBackgroundColor(Color.argb(10, 51, 181, 229 ));

        }

    }

    void setSpinner(int month)
    {

        String monthString = null;
        monthString = monthString(String.valueOf(month));
        int spinnerPosition = spinnerAdapter.getPosition(monthString);
        //spinner.setSelection(yourArrayList.indexOf("Category 1"));
        spinner.setSelection(spinnerPosition);
    }

    private int getActualMonth() {

        Calendar now = Calendar.getInstance();

        int monthactual = now.get(Calendar.MONTH);

        return monthactual;

    }

    private String monthNumber(String year_month){

        String choosedMonth = null;

        if(year_month.equals("Marco/2016")){

            choosedMonth = "03";

        } else if(year_month.equals("Abril/2016")){

            choosedMonth = "04";

        } else if(year_month.equals("Maio/2016")){

            choosedMonth = "05";

        } else if(year_month.equals("Junho/2016")){

            choosedMonth = "06";

        } else if(year_month.equals("Julho/2016")){

            choosedMonth = "07";

        } else if(year_month.equals("Agosto/2016")){

            choosedMonth = "08";

        } else if(year_month.equals("Setembro/2016")){

            choosedMonth = "09";

        } else if(year_month.equals("Outubro/2016")){

            choosedMonth = "10";

        } else if(year_month.equals("Novembro/2016")){

            choosedMonth = "11";

        } else if(year_month.equals("Dezembro/2016")){

            choosedMonth = "12";

        }

        return choosedMonth;


    }

    private String monthString(String month){

        String choosedMonth = null;

        if(month.equals("3")){

            choosedMonth = "Marco/2016";

        } else if(month.equals("4")){

            choosedMonth = "Abril/2016";

        } else if(month.equals("5")){

            choosedMonth = "Maio/2016";

        } else if(month.equals("6")){

            choosedMonth = "Junho/2016";

        } else if(month.equals("7")){

            choosedMonth = "Julho/2016";

        } else if(month.equals("8")){

            choosedMonth = "Agosto/2016";

        } else if(month.equals("9")){

            choosedMonth = "Setembro/2016";

        } else if(month.equals("10")){

            choosedMonth = "Outubro/2016";

        } else if(month.equals("11")){

            choosedMonth = "Novembro/2016";

        } else if(month.equals("12")){

            choosedMonth = "Dezembro/2016";

        }

        return choosedMonth;

    }

    public String returnDayOfWeek(int year, int month, int day)
    {

        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        return searchDayOfWeek(dayOfWeek);
    }

    //faz a pesquisa, dado um inteiro de 1 a 7
    public String searchDayOfWeek(int _dayOfWeek)
    {
        String dayOfWeek = null;

        switch (_dayOfWeek)
        {

            case 1:
            {
                dayOfWeek = "Dom";
                break;
            }
            case 2:
            {
                dayOfWeek = "Seg";
                break;
            }
            case 3:
            {
                dayOfWeek = "Ter";
                break;
            }
            case 4:
            {
                dayOfWeek = "Qua";
                break;
            }
            case 5:
            {
                dayOfWeek = "Qui";
                break;
            }
            case 6:
            {
                dayOfWeek = "Sex";
                break;
            }
            case 7:
            {
                dayOfWeek = "Sab";
                break;
            }

        }
        return dayOfWeek;

    }

    private class GetDates extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            /*pDialog = new ProgressDialog(Appointmentsbook.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();*/

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
        /*ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);*/

        if(number.equals("1")) {

            spinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner, R.id.txtYear_Month, lables);
            //ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinner, R.id.txtYear_Month, lables);
            spinner.setAdapter(spinnerAdapter);

        } else if (number.equals("2")) {

            //ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinneri, R.id.txtYear_Month, lables);
            spinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinneri, R.id.txtYear_Month, lables);
            spinner.setAdapter(spinnerAdapter);
        } else {

            //ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinnerc, R.id.txtYear_Month, lables);
            spinnerAdapter = new ArrayAdapter<String>(this, R.layout.spinnerc, R.id.txtYear_Month, lables);
            spinner.setAdapter(spinnerAdapter);

        }

        month = String.valueOf(getActualMonth());
        setSpinner(Integer.parseInt(month));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent,
                View view, int pos, long id) {
            month = parent.getItemAtPosition(pos).toString();
            //month = String.valueOf(parent.getSelectedItem());
            //month = String.valueOf(spinner.getSelectedItem());
            year_month = month = String.valueOf(spinner.getSelectedItem());
            //Dates dates = (Dates)(parent.getItemAtPosition(pos));
            //textView2.setText(String.valueOf(dates.getMonths()));
            //month = dates.getMonths();

            month = monthNumber(year_month);
            new GetAppointments().execute();


        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub

        }

        });

    }

    private class GetAppointments extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Appointmentsbook.this);
            pDialog.setMessage("Por favor, Espere...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {

            ServiceHandler sh = new ServiceHandler();

            String jsonStr = sh.makeServiceCall(url + month, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    appointmentsbooks = jsonObj.getJSONArray(TAG_APPOINTMENTSBOOK);
                    appointmentsList = new ArrayList<HashMap<String, String>>();
                    // looping through All Contacts
                    for (int i = 0; i < appointmentsbooks.length(); i++) {
                        JSONObject c = appointmentsbooks.getJSONObject(i);

                        String id = c.getString(TAG_ID);
                        String appointment_date = c.getString(TAG_APPOINTMENT_DATE);
                        String commitment = c.getString(TAG_COMMITMENT);
                        String ministry = c.getString(TAG_MINISTRY);
                        String start_hour = c.getString(TAG_START_HOUR);
                        String end_hour = c.getString(TAG_END_HOUR);

                        //0123456789
                        //2016-04-17
                        int appointment_day = Integer.parseInt(appointment_date.substring(8, 10));
                        int appointment_month = Integer.parseInt(appointment_date.substring(5, 7));
                        int appointment_year = Integer.parseInt(appointment_date.substring(0, 4));

                        String week_day = returnDayOfWeek(appointment_year, appointment_month, appointment_day);

                        //studentsList = new ArrayList<HashMap<String, String>>();

                        // tmp hashmap for single contact
                        HashMap<String, String> appointment = new HashMap<String, String>();

                        // adding each child node to HashMap key => value
                        appointment.put(TAG_ID, id);
                        appointment.put(TAG_APPOINTMENT_DATE, appointment_date);
                        appointment.put(TAG_APPOINTMENT_DAY, String.valueOf(appointment_day));
                        appointment.put(TAG_APPOINTMENT_WEEK_DAY, week_day);
                        appointment.put(TAG_COMMITMENT, commitment);
                        appointment.put(TAG_MINISTRY, ministry);
                        appointment.put(TAG_START_HOUR, start_hour);
                        appointment.put(TAG_END_HOUR, end_hour);

                        appointmentsList.add(appointment);
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


            if(number.equals("1")) {

                ListAdapter adapter = new SimpleAdapter(Appointmentsbook.this, appointmentsList, R.layout.appointments_book_entry, new String[]{"id", "appointment_day", "week_day", "commitment", "ministry", "start_hour", "end_hour"}, new int[]{R.id.appointments_Id, R.id.appointments_day, R.id.appointments_day_week, R.id.appointments_commitment, R.id.appointments_ministry, R.id.appointments_start_hour, R.id.appointments_end_hour});
                lv.setAdapter(adapter);

            } else if (number.equals("2")) {

                ListAdapter adapter = new SimpleAdapter(Appointmentsbook.this, appointmentsList, R.layout.appointments_booki_entry, new String[]{"id", "appointment_day", "week_day", "commitment", "ministry", "start_hour", "end_hour"}, new int[]{R.id.appointments_Id, R.id.appointments_day, R.id.appointments_day_week, R.id.appointments_commitment, R.id.appointments_ministry, R.id.appointments_start_hour, R.id.appointments_end_hour});
                lv.setAdapter(adapter);

            } else {

                ListAdapter adapter = new SimpleAdapter(Appointmentsbook.this, appointmentsList, R.layout.appointments_bookc_entry, new String[]{"id", "appointment_day", "week_day", "commitment", "ministry", "start_hour", "end_hour"}, new int[]{R.id.appointments_Id, R.id.appointments_day, R.id.appointments_day_week, R.id.appointments_commitment, R.id.appointments_ministry, R.id.appointments_start_hour, R.id.appointments_end_hour});
                lv.setAdapter(adapter);

            }
        }

    }

}
