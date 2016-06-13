package com.filadelfia.lucas.igrejafiladelfia.View;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.filadelfia.lucas.igrejafiladelfia.Controller.Dates;
import com.filadelfia.lucas.igrejafiladelfia.Model.DatabaseHelper;
import com.filadelfia.lucas.igrejafiladelfia.R;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

public class Ministry extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    ImageView imglogo, imgline, imgline2;
    RelativeLayout RL;
    TextView txtministry, txtministrys;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ministry);

        RL = (RelativeLayout)findViewById(R.id.Layout);
        imglogo = (ImageView)findViewById(R.id.imglogo);
        imgline = (ImageView)findViewById(R.id.imgline);
        imgline2 = (ImageView)findViewById(R.id.imgline2);
        txtministry = (TextView)findViewById(R.id.txtministry);
        txtministrys = (TextView)findViewById(R.id.txtministrys);

        number = helper.getSets();

        if(number.equals("1")) {

            imglogo.setImageResource(R.drawable.filadelfia);
            imgline.setImageResource(R.drawable.line);
            imgline2.setImageResource(R.drawable.line);
            RL.setBackgroundResource(R.drawable.background);
            txtministry.setTextColor(Color.WHITE);
            txtministrys.setTextColor(Color.WHITE);
            //lv.setBackgroundColor(Color.BLACK);

        }

        if(number.equals("2")) {
            imglogo.setImageResource(R.drawable.filadelfiai);
            imgline.setImageResource(R.drawable.linei);
            imgline2.setImageResource(R.drawable.linei);
            RL.setBackgroundResource(R.drawable.backgroundi);
            txtministry.setTextColor(Color.BLACK);
            txtministrys.setTextColor(Color.BLACK);
            //lv.setBackgroundColor(Color.WHITE);

        }

        if(number.equals("3")) {
            imglogo.setImageResource(R.drawable.filadelfiai);
            imgline.setImageResource(R.drawable.linei);
            imgline2.setImageResource(R.drawable.linei);
            RL.setBackgroundResource(R.drawable.backgroundc);
            txtministry.setTextColor(Color.BLUE);
            txtministrys.setTextColor(Color.BLUE);
            //lv.setBackgroundColor(Color.argb(10, 51, 181, 229 ));

        }
    }
}
