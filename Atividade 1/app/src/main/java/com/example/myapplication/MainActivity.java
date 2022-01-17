package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton1;
    EditText autoCompleteTextView1;
    EditText edtLog;
    MediaPlayer mySound;

    Spinner spnr;

    String[] times = {
            "São Paulo",
            "Corinthians",
            "Santos",
            "Palmeiras",
            "Flamengo",
            "Atlético-MG",
            "Fortaleza",
            "Ceará",
            "Vasco"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySound = MediaPlayer.create(this,R.raw.som);

        autoCompleteTextView1 = findViewById( R.id.autoCompleteTextView1 );
        edtLog = findViewById( R.id.edtLog );
        addListenerOnButton();

        AutoCompleteTextView t1 = (AutoCompleteTextView)
                findViewById(R.id.autoCompleteTextView1);

        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,times);

        t1.setThreshold(1);
        t1.setAdapter(adp);

        spnr = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, times);

        spnr.setAdapter(adapter);
        spnr.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> arg0, View arg1,
                                               int arg2, long arg3) {

                        int position = spnr.getSelectedItemPosition();
                        Toast.makeText(getApplicationContext(),"Você selecionou: "+times[+position],Toast.LENGTH_LONG).show();
                        // TODO Auto-generated method stub
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> arg0) {
                        // TODO Auto-generated method stub

                    }

                }
        );

        TextView txtView = (TextView) findViewById(R.id.txtView);
        txtView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(),
                        "Você apertou e segurou, muito bem! :)", 2000).show();
                return true;
            }
        });
        txtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(), "Você só apertou, não segurou :(",
                        1000).show();
            }
        });


    }

    public void onClickButton01( View view){

        String textoedtInput = autoCompleteTextView1.getText().toString();
        autoCompleteTextView1.setText("");

        String textoedtLog = edtLog.getText().toString();
        textoedtLog += " - " + textoedtInput;

        edtLog.setText( textoedtLog );

    }

    public void addListenerOnButton() {

        toggleButton1 = (ToggleButton) findViewById(R.id.toggleButton1);
        Button btnDisplay = (Button) findViewById(R.id.btnDisplay);

        btnDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                StringBuffer result = new StringBuffer();
                result.append("Botão 01 : ").append(toggleButton1.getText());

                Toast.makeText(MainActivity.this, result.toString(),
                        Toast.LENGTH_SHORT).show();

            }

        });
    }

        @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_1:
                    Toast.makeText(MainActivity.this, "Você clicou no de cima...", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_2:
                Toast.makeText(MainActivity.this, "Você clicou no de baixo...", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void playMusic(View view) {
        mySound.start();
    }
}
