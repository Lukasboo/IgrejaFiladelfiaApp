package com.filadelfia.lucas.igrejafiladelfia.View;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.filadelfia.lucas.igrejafiladelfia.Model.DatabaseHelper;
import com.filadelfia.lucas.igrejafiladelfia.R;

public class Contact extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    ImageView imglogo, imgline, imgline2;
    RelativeLayout RL;
    TextView txtcontact, txtcontacts;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        RL = (RelativeLayout)findViewById(R.id.Layout);
        imglogo = (ImageView)findViewById(R.id.imglogo);
        imgline = (ImageView)findViewById(R.id.imgline);
        imgline2 = (ImageView)findViewById(R.id.imgline2);
        txtcontact = (TextView)findViewById(R.id.txtcontact);
        txtcontacts = (TextView)findViewById(R.id.txtcontacts);

        number = helper.getSets();

        if(number.equals("1")) {

            imglogo.setImageResource(R.drawable.filadelfias);
            imgline.setImageResource(R.drawable.lines);
            imgline2.setImageResource(R.drawable.lines);
            RL.setBackgroundResource(R.drawable.background);
            txtcontact.setTextColor(Color.WHITE);
            txtcontacts.setTextColor(Color.WHITE);
            //lv.setBackgroundColor(Color.BLACK);

        }

        if(number.equals("2")) {
            imglogo.setImageResource(R.drawable.filadelfiasi);
            imgline.setImageResource(R.drawable.linesi);
            imgline2.setImageResource(R.drawable.linesi);
            RL.setBackgroundResource(R.drawable.backgroundi);
            txtcontact.setTextColor(Color.BLACK);
            txtcontacts.setTextColor(Color.BLACK);
            //lv.setBackgroundColor(Color.WHITE);

        }

        if(number.equals("3")) {
            imglogo.setImageResource(R.drawable.filadelfiasi);
            imgline.setImageResource(R.drawable.linesi);
            imgline2.setImageResource(R.drawable.linesi);
            RL.setBackgroundResource(R.drawable.backgroundc);
            txtcontact.setTextColor(Color.BLUE);
            txtcontacts.setTextColor(Color.BLUE);
            //lv.setBackgroundColor(Color.argb(10, 51, 181, 229 ));

        }
    }
}
