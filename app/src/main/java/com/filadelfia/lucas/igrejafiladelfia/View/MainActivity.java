package com.filadelfia.lucas.igrejafiladelfia.View;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.filadelfia.lucas.igrejafiladelfia.Model.DatabaseHelper;
import com.filadelfia.lucas.igrejafiladelfia.R;

public class MainActivity extends AppCompatActivity {

    RelativeLayout RL;
    String number, logo, background, line, appointmentsbook, warning, site, message, facebook, ministry, youth, leadership, contact;
    //Cursor config;
    DatabaseHelper helper = new DatabaseHelper(this);
    ImageButton ibtappointmentsbook, ibtwarning, ibtsite, ibtmessage;
    ImageButton ibtfacebook, ibtministry, ibtyouth, ibtleadership, ibtcontact;
    ImageView imglogo, imgline, imgline2;
    TextView txtappointmentsbook, txtwarning, txtsite, txtmessage, txtfacebook, txtministry, txtyouth, txtleadership, txtcontact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RL = (RelativeLayout)findViewById(R.id.Layout);
        ibtappointmentsbook = (ImageButton)findViewById(R.id.ibtappointmentsbook);
        ibtappointmentsbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Appointmentsbook.class);
                startActivity(intent);

            }
        });

        ibtwarning = (ImageButton)findViewById(R.id.ibtwarning);
        ibtwarning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Warning.class);
                startActivity(intent);

            }
        });

        ibtsite = (ImageButton)findViewById(R.id.ibtsite);
        ibtsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri = Uri.parse("http://www.filadelfiafranca.com.br/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        ibtmessage = (ImageButton)findViewById(R.id.ibtmessage);
        ibtmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Message.class);
                startActivity(intent);

            }
        });

        ibtfacebook = (ImageButton)findViewById(R.id.ibtfacebook);
        ibtfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri = Uri.parse("https://www.facebook.com/ipfiladelfia?fref=ts");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });

        ibtministry = (ImageButton)findViewById(R.id.ibtministry);
        ibtministry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Ministry.class);
                startActivity(intent);

            }
        });

        ibtyouth = (ImageButton)findViewById(R.id.ibtyouth);
        ibtyouth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Youth.class);
                startActivity(intent);

            }
        });

        ibtleadership = (ImageButton)findViewById(R.id.ibtleadership);
        ibtleadership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Leadership.class);
                startActivity(intent);

            }
        });

        ibtcontact = (ImageButton)findViewById(R.id.ibtcontact);
        ibtcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, Contact.class);
                startActivity(intent);

            }
        });


        number = helper.getSets();
        //Configurations config = helper.getConfig(number);
        /*Cursor rs = mydb.getData(Value);
        id_To_Update = Value;*/
        //config.moveToFirst();

        //logo = config.getString(config.getColumnIndex("logo"));
        /*logo = config.getLogo();
        background = config.getBackground();
        line = config.getLine();
        appointmentsbook = config.getAppointmentsbook();
        warning = config.getWarning();
        site = config.getSite();
        message = config.getMessage();
        facebook = config.getFacebook();
        ministry = config.getMinistry();
        youth = config.getYouth();
        leadership = config.getLeadership();
        contact = config.getContact();*/

        imglogo = (ImageView)findViewById(R.id.imglogo);
        imgline = (ImageView)findViewById(R.id.imgline);
        imgline2  = (ImageView)findViewById(R.id.imgline2);
        //ibtappointmentsbook = (ImageButton)findViewById(R.id.ibtappointmentsbook);
        ibtwarning = (ImageButton)findViewById(R.id.ibtwarning);
        ibtsite = (ImageButton)findViewById(R.id.ibtsite);
        ibtmessage = (ImageButton)findViewById(R.id.ibtmessage);
        ibtfacebook = (ImageButton)findViewById(R.id.ibtfacebook);
        ibtministry = (ImageButton)findViewById(R.id.ibtministry);
        ibtyouth = (ImageButton)findViewById(R.id.ibtyouth);
        ibtleadership = (ImageButton)findViewById(R.id.ibtleadership);
        ibtcontact = (ImageButton)findViewById(R.id.ibtcontact);
        txtappointmentsbook = (TextView) findViewById(R.id.txtappointmentsbook);
        txtwarning = (TextView) findViewById(R.id.txtwarning);
        txtsite = (TextView) findViewById(R.id.txtsite);
        txtmessage = (TextView) findViewById(R.id.txtmessage);
        txtfacebook = (TextView) findViewById(R.id.txtfacebook);
        txtministry = (TextView) findViewById(R.id.txtministry);
        txtyouth = (TextView) findViewById(R.id.txtyouth);
        txtleadership = (TextView) findViewById(R.id.txtleadership);
        txtcontact = (TextView) findViewById(R.id.txtcontact);

        if(number.equals("1")) {
            imglogo.setImageResource(R.drawable.filadelfia);
            imgline.setImageResource(R.drawable.line);
            imgline2.setImageResource(R.drawable.line);
            //RL.setBackgroundColor(Color.parseColor("#000000"));
            RL.setBackgroundResource(R.drawable.background);
            ibtappointmentsbook.setImageResource(R.drawable.appointmentsbook);
            ibtwarning.setImageResource(R.drawable.warning);
            ibtsite.setImageResource(R.drawable.site);
            ibtmessage.setImageResource(R.drawable.message);
            ibtfacebook.setImageResource(R.drawable.facebook);
            ibtministry.setImageResource(R.drawable.ministry);
            ibtyouth.setImageResource(R.drawable.youth);
            ibtleadership.setImageResource(R.drawable.leadership);
            ibtcontact.setImageResource(R.drawable.contact);
            txtappointmentsbook.setTextColor(Color.WHITE);
            txtwarning.setTextColor(Color.WHITE);
            txtsite.setTextColor(Color.WHITE);
            txtmessage.setTextColor(Color.WHITE);
            txtfacebook.setTextColor(Color.WHITE);
            txtministry.setTextColor(Color.WHITE);
            txtyouth.setTextColor(Color.WHITE);
            txtleadership.setTextColor(Color.WHITE);
            txtcontact.setTextColor(Color.WHITE);
        }

        if(number.equals("2")) {
            imglogo.setImageResource(R.drawable.filadelfiai);
            imgline.setImageResource(R.drawable.linei);
            imgline2.setImageResource(R.drawable.linei);
            //RL.setBackgroundColor(Color.parseColor("#FFFFFF"));
            RL.setBackgroundResource(R.drawable.backgroundi);
            ibtappointmentsbook.setImageResource(R.drawable.appointmentsbooki);
            ibtwarning.setImageResource(R.drawable.warningi);
            ibtsite.setImageResource(R.drawable.sitei);
            ibtmessage.setImageResource(R.drawable.messagei);
            ibtfacebook.setImageResource(R.drawable.facebooki);
            ibtministry.setImageResource(R.drawable.ministryi);
            ibtyouth.setImageResource(R.drawable.youthi);
            ibtleadership.setImageResource(R.drawable.leadershipi);
            ibtcontact.setImageResource(R.drawable.contacti);
            txtappointmentsbook.setTextColor(Color.BLACK);
            txtwarning.setTextColor(Color.BLACK);
            txtsite.setTextColor(Color.BLACK);
            txtmessage.setTextColor(Color.BLACK);
            txtfacebook.setTextColor(Color.BLACK);
            txtministry.setTextColor(Color.BLACK);
            txtyouth.setTextColor(Color.BLACK);
            txtleadership.setTextColor(Color.BLACK);
            txtcontact.setTextColor(Color.BLACK);
        }

        if(number.equals("3")) {
            imglogo.setImageResource(R.drawable.filadelfiai);
            imgline.setImageResource(R.drawable.linei);
            imgline2.setImageResource(R.drawable.linei);
            //RL.setBackgroundColor(Color.parseColor("#FFFFFF"));
            RL.setBackgroundResource(R.drawable.backgroundc);
            ibtappointmentsbook.setImageResource(R.drawable.appointmentsbookc);
            ibtwarning.setImageResource(R.drawable.warningc);
            ibtsite.setImageResource(R.drawable.sitec);
            ibtmessage.setImageResource(R.drawable.messagec);
            ibtfacebook.setImageResource(R.drawable.facebookc);
            ibtministry.setImageResource(R.drawable.ministryc);
            ibtyouth.setImageResource(R.drawable.youthc);
            ibtleadership.setImageResource(R.drawable.leadershipc);
            ibtcontact.setImageResource(R.drawable.contactc);
            txtappointmentsbook.setTextColor(Color.BLUE);
            txtwarning.setTextColor(Color.BLUE);
            txtsite.setTextColor(Color.BLUE);
            txtmessage.setTextColor(Color.BLUE);
            txtfacebook.setTextColor(Color.BLUE);
            txtministry.setTextColor(Color.BLUE);
            txtyouth.setTextColor(Color.BLUE);
            txtleadership.setTextColor(Color.BLUE);
            txtcontact.setTextColor(Color.BLUE);
        }

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
        Intent intent;

        switch (item.getItemId()) {
            case R.id.item1:

                intent = new Intent(MainActivity.this, Configuration.class);
                startActivity(intent);

            case R.id.item2:

                intent = new Intent(MainActivity.this, Developer.class);
                startActivity(intent);

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
