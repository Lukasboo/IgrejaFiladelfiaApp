package com.filadelfia.lucas.igrejafiladelfia.View;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.filadelfia.lucas.igrejafiladelfia.Model.DatabaseHelper;
import com.filadelfia.lucas.igrejafiladelfia.R;

public class Configuration extends Activity {

    RelativeLayout RL;
    String number;
    Button btconfig1, btconfig2, btconfig3;
    DatabaseHelper helper = new DatabaseHelper(this);
    ImageView imglogo, imgline, imgline2, imgline3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        RL = (RelativeLayout)findViewById(R.id.Layout);
        imglogo = (ImageView)findViewById(R.id.imglogo);
        imgline = (ImageView)findViewById(R.id.imglogo);
        imgline2 = (ImageView)findViewById(R.id.imgline2);
        imgline3 = (ImageView)findViewById(R.id.imgline3);
        btconfig1 = (Button)findViewById(R.id.btconfig1);
        btconfig2 = (Button)findViewById(R.id.btconfig2);
        btconfig3 = (Button)findViewById(R.id.btconfig3);

        btconfig1.setBackgroundColor(Color.BLACK);
        btconfig1.setTextColor(Color.WHITE);

        btconfig2.setBackgroundColor(Color.WHITE);
        btconfig2.setTextColor(Color.BLACK);

        btconfig3.setBackgroundColor(Color.BLUE);
        btconfig3.setTextColor(Color.WHITE);

        number = helper.getSets();

        if(number.equals("1")) {

            imglogo.setImageResource(R.drawable.filadelfia);
            imgline.setImageResource(R.drawable.line);
            imgline2.setImageResource(R.drawable.line);
            imgline3.setImageResource(R.drawable.line);
            RL.setBackgroundResource(R.drawable.background);

        }

        if(number.equals("2")) {
            imglogo.setImageResource(R.drawable.filadelfiai);
            imgline.setImageResource(R.drawable.linei);
            imgline2.setImageResource(R.drawable.linei);
            imgline3.setImageResource(R.drawable.linei);
            RL.setBackgroundResource(R.drawable.backgroundi);

        }

        if(number.equals("3")) {
            imglogo.setImageResource(R.drawable.filadelfiai);
            imgline.setImageResource(R.drawable.linei);
            imgline2.setImageResource(R.drawable.linei);
            imgline3.setImageResource(R.drawable.linei);
            RL.setBackgroundResource(R.drawable.backgroundc);

        }

        btconfig1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                helper.updateSet("1");
                Toast.makeText(getApplicationContext(), "Configuração atualizada com sucesso!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Configuration.this, MainActivity.class);
                startActivity(intent);

            }
        });

        btconfig2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                helper.updateSet("2");
                Toast.makeText(getApplicationContext(), "Configuração atualizada com sucesso!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Configuration.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btconfig3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               helper.updateSet("3");
                Toast.makeText(getApplicationContext(), "Configuração atualizada com sucesso!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Configuration.this, MainActivity.class);
                startActivity(intent);
            }
        });

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
                //UpdateUser();
                return true;
            case R.id.item2:
                //DeleteUser();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}