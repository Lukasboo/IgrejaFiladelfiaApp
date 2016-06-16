package com.filadelfia.lucas.igrejafiladelfia.View;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
    Boolean conection;
    Button btconfig1, btconfig2, btconfig3;
    DatabaseHelper helper = new DatabaseHelper(this);
    ImageView imglogo, imgline, imgline2, imgline3;
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        conection = isConnected();

        if (conection == false) {
            dialogConection();
        }

        RL = (RelativeLayout)findViewById(R.id.Layout);
        imglogo = (ImageView)findViewById(R.id.imglogo);
        imgline = (ImageView)findViewById(R.id.imgline);
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

            imglogo.setImageResource(R.drawable.filadelfias);
            imgline.setImageResource(R.drawable.lines);
            imgline2.setImageResource(R.drawable.lines);
            imgline3.setImageResource(R.drawable.lines);
            RL.setBackgroundResource(R.drawable.background);

        }

        if(number.equals("2")) {
            imglogo.setImageResource(R.drawable.filadelfiasi);
            imgline.setImageResource(R.drawable.linesi);
            imgline2.setImageResource(R.drawable.linesi);
            imgline3.setImageResource(R.drawable.linesi);
            RL.setBackgroundResource(R.drawable.backgroundi);

        }

        if(number.equals("3")) {
            imglogo.setImageResource(R.drawable.filadelfiasi);
            imgline.setImageResource(R.drawable.linesi);
            imgline2.setImageResource(R.drawable.linesi);
            imgline3.setImageResource(R.drawable.linesi);
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
            /*case R.id.item2:
                //DeleteUser();
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void dialogConection() {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define o titulo
        builder.setTitle("Erro na conexão!");
        //define a mensagem
        builder.setMessage("Conecte seu dispositivo a internet para utilizar o app!");
        //define um botão como positivo
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
                System.exit(0);
            }
        });
        //cria o AlertDialog
        alerta = builder.create();
        //Exibe
        alerta.show();
    }

    public boolean isConnected() {
        ConnectivityManager manager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            return true;
        } else {
            return false;

        }
    }

}
