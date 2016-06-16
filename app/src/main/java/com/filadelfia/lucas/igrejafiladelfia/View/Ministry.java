package com.filadelfia.lucas.igrejafiladelfia.View;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

            imglogo.setImageResource(R.drawable.filadelfias);
            imgline.setImageResource(R.drawable.lines);
            imgline2.setImageResource(R.drawable.lines);
            RL.setBackgroundResource(R.drawable.background);
            txtministry.setTextColor(Color.WHITE);
            txtministrys.setTextColor(Color.WHITE);
            //lv.setBackgroundColor(Color.BLACK);

        }

        if(number.equals("2")) {
            imglogo.setImageResource(R.drawable.filadelfiasi);
            imgline.setImageResource(R.drawable.linesi);
            imgline2.setImageResource(R.drawable.linesi);
            RL.setBackgroundResource(R.drawable.backgroundi);
            txtministry.setTextColor(Color.BLACK);
            txtministrys.setTextColor(Color.BLACK);
            //lv.setBackgroundColor(Color.WHITE);

        }

        if(number.equals("3")) {
            imglogo.setImageResource(R.drawable.filadelfiasi);
            imgline.setImageResource(R.drawable.linesi);
            imgline2.setImageResource(R.drawable.linesi);
            RL.setBackgroundResource(R.drawable.backgroundc);
            txtministry.setTextColor(Color.BLUE);
            txtministrys.setTextColor(Color.BLUE);
            //lv.setBackgroundColor(Color.argb(10, 51, 181, 229 ));

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

                intent = new Intent(Ministry.this, Configuration.class);
                startActivity(intent);
                return true;

            case R.id.item2:

                intent = new Intent(Ministry.this, Develop.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
