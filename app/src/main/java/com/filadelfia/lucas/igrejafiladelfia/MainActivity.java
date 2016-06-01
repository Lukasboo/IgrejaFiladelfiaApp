package com.filadelfia.lucas.igrejafiladelfia;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageButton;

import java.lang.reflect.Array;

public class MainActivity extends Activity {

    String number;
    //Cursor config;
    DatabaseHelper helper = new DatabaseHelper(this);
    ImageButton ibtappointmentsbook, ibtwarning, ibtsite, ibtmessage;
    ImageButton ibtfacebook, ibtministry, ibtyouth, ibtleadership, ibtcontact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //number = helper.getSets();
        //Cursor config = helper.getConfig(Integer.parseInt(number));
        /*Cursor rs = mydb.getData(Value);
        id_To_Update = Value;*/
        //config.moveToFirst();


        ibtappointmentsbook = (ImageButton)findViewById(R.id.ibtappointmentsbook);

        ibtwarning = (ImageButton)findViewById(R.id.ibtwarning);

        ibtsite = (ImageButton)findViewById(R.id.ibtsite);

        ibtmessage = (ImageButton)findViewById(R.id.ibtmessage);

        ibtfacebook = (ImageButton)findViewById(R.id.ibtfacebook);

        ibtministry = (ImageButton)findViewById(R.id.ibtministry);

        ibtyouth = (ImageButton)findViewById(R.id.ibtyouth);

        ibtleadership = (ImageButton)findViewById(R.id.ibtleadership);

        ibtcontact = (ImageButton)findViewById(R.id.ibtcontact);

        /*if(number.equals("1")){

            ibtappointmentsbook.setImageResource(R.drawable.appointmentsbook);
            ibtwarning.setImageResource(R.drawable.warning);
            ibtsite.setImageResource(R.drawable.site);
            ibtmessage.setImageResource(R.drawable.message);
            ibtfacebook.setImageResource(R.drawable.facebook);
            ibtministry.setImageResource(R.drawable.ministry);
            ibtyouth.setImageResource(R.drawable.youth);
            ibtleadership.setImageResource(R.drawable.leadership);
            ibtcontact.setImageResource(R.drawable.contact);

        } else {

            ibtappointmentsbook.setImageResource(R.drawable.appointmentsbooki);
            ibtwarning.setImageResource(R.drawable.warningi);
            ibtsite.setImageResource(R.drawable.sitei);
            ibtmessage.setImageResource(R.drawable.messagei);
            ibtfacebook.setImageResource(R.drawable.facebooki);
            ibtministry.setImageResource(R.drawable.ministryi);
            ibtyouth.setImageResource(R.drawable.youthi);
            ibtleadership.setImageResource(R.drawable.leadershipi);
            ibtcontact.setImageResource(R.drawable.contacti);

        }*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_configurarion, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item1:

                Intent intent = new Intent(MainActivity.this, Configuration.class);
                startActivity(intent);

            case R.id.item2:
                //DeleteUser();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
