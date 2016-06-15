package com.filadelfia.lucas.igrejafiladelfia.View;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

import java.io.IOException;
import java.io.InputStream;

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

        AssetManager assetManager = getAssets();


        /*try {

            if (number.equals("1")) {

                // get input stream
                InputStream ims = assetManager.open("appointmentsbooks.xml");


                // create drawable from stream
                Drawable d = Drawable.createFromStream(ims, null);

                // set the drawable to imageview
                ibtappointmentsbook.setImageDrawable(d);

            } else if (number.equals("2")) {

                // get input stream
                InputStream ims = assetManager.open("appointmentsbooki.xml");

                // create drawable from stream
                Drawable d = Drawable.createFromStream(ims, null);

                // set the drawable to imageview
                ibtappointmentsbook.setImageDrawable(d);

            } else {

                // get input stream
                InputStream ims = assetManager.open("appointmentsbookc.xml");

                // create drawable from stream
                Drawable d = Drawable.createFromStream(ims, null);

                // set the drawable to imageview
                ibtappointmentsbook.setImageDrawable(d);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /*try {
            // Specify the path (relative to the 'assets' folder)
            final SVG svg = SVGParser.getSVGFromAsset(getAssets(), "appointmentsbooksc.svg");
            ibtappointmentsbook.setImageDrawable(svg.createPictureDrawable());
        } catch (IOException e) {
            // Handle IOException here
        }*/

        /*SVGParser svg = SVGParser.getSVGFromResource(getResources(), R.drawable.example);
        //The following is needed because of image accelaration in some devices such as samsung
        imageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        imageView.setImageDrawable(svg.createPictureDrawable());*/

        /*SVG svg = SVGParser.getSVGFromResource(getResources(), R.raw.problemswithsynchronization);
        //Get a drawable from the parsed SVG and apply to ImageView
        ibtappointmentsbook.setImageDrawable(svg.createPictureDrawable());*/

        /*SVG svg = SVGParser.getSVGFromResource(getResources(), R.drawable.appointmentsbooksc);
        // Get a drawable from the parsed SVG and set it as the drawable for the ImageView
        ibtappointmentsbook.setImageDrawable(svg.createPictureDrawable());
        // Set the ImageView as the content view for the Activity
        setContentView(ibtappointmentsbook);*/

        if(number.equals("1")) {
            imglogo.setImageResource(R.drawable.filadelfias);
            imgline.setImageResource(R.drawable.lines);
            imgline2.setImageResource(R.drawable.lines);
            //RL.setBackgroundColor(Color.parseColor("#000000"));
            RL.setBackgroundResource(R.drawable.background);
            ibtappointmentsbook.setImageResource(R.drawable.appointmentsbooks);
            ibtwarning.setImageResource(R.drawable.warnings);
            ibtsite.setImageResource(R.drawable.sites);
            ibtmessage.setImageResource(R.drawable.messages);
            ibtfacebook.setImageResource(R.drawable.facebooks);
            ibtministry.setImageResource(R.drawable.ministrys);
            ibtyouth.setImageResource(R.drawable.youths);
            ibtleadership.setImageResource(R.drawable.leaderships);
            ibtcontact.setImageResource(R.drawable.contacts);
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
            imglogo.setImageResource(R.drawable.filadelfiasi);
            imgline.setImageResource(R.drawable.linesi);
            imgline2.setImageResource(R.drawable.linesi);
            //RL.setBackgroundColor(Color.parseColor("#FFFFFF"));
            RL.setBackgroundResource(R.drawable.backgroundi);
            ibtappointmentsbook.setImageResource(R.drawable.appointmentsbooksi);
            ibtwarning.setImageResource(R.drawable.warningsi);
            ibtsite.setImageResource(R.drawable.sitesi);
            ibtmessage.setImageResource(R.drawable.messagesi);
            ibtfacebook.setImageResource(R.drawable.facebooksi);
            ibtministry.setImageResource(R.drawable.ministrysi);
            ibtyouth.setImageResource(R.drawable.youthsi);
            ibtleadership.setImageResource(R.drawable.leadershipsi);
            ibtcontact.setImageResource(R.drawable.contactsi);
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
            imglogo.setImageResource(R.drawable.filadelfiasi);
            imgline.setImageResource(R.drawable.linesi);
            imgline2.setImageResource(R.drawable.linesi);
            //RL.setBackgroundColor(Color.parseColor("#FFFFFF"));
            RL.setBackgroundResource(R.drawable.backgroundc);
            //ibtappointmentsbook.setImageResource(R.drawable.appointmentsbookc);
            ibtappointmentsbook.setImageResource(R.drawable.appointmentsbooksc);
            ibtwarning.setImageResource(R.drawable.warningsc);
            ibtsite.setImageResource(R.drawable.sitesc);
            ibtmessage.setImageResource(R.drawable.messagesc);
            ibtfacebook.setImageResource(R.drawable.facebooksc);
            ibtministry.setImageResource(R.drawable.ministrysc);
            ibtyouth.setImageResource(R.drawable.youthsc);
            ibtleadership.setImageResource(R.drawable.leadershipsc);
            ibtcontact.setImageResource(R.drawable.contactsc);
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
