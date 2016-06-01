package com.filadelfia.lucas.igrejafiladelfia;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Configuration extends Activity {

    Button btconfig1, btconfig2;
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        btconfig1 = (Button)findViewById(R.id.btconfig1);
        btconfig1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                helper.insertSet("1");

            }
        });

        btconfig2 = (Button)findViewById(R.id.btconfig2);
        btconfig2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                helper.insertSet("2");

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
