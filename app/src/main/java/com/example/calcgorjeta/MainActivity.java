package com.example.calcgorjeta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtValConta, edtGor10, edtGor15, edtGor20, edtValConta10, edtValConta15, edtValConta20, edtGorVar, edtValContaVar;
    TextView txtPercVal;
    SeekBar seekbar;
    double valConta = 0.0;
    int perConta = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponetes();
        edtValConta.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    valConta = Double.parseDouble(s.toString());//tudo que pega [e string, tem que converter pra double

                    calculaGorjetas();
                    calculaGorjetasVar();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                perConta = seekBar.getProgress();
                calculaGorjetasVar();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {


            }
        });

    }

    private void calculaGorjetasVar() {

        txtPercVal.setText(perConta + "%");
        double gorvar = valConta * (perConta * 0.01);
        double valcontavar = valConta + gorvar;

        /*Inserir nos objetos*/


        edtGorVar.setText(String.format("%.2f", gorvar));
        edtValContaVar.setText(String.format("%.2f", valcontavar));


    }

    private void calculaGorjetas() {

        double gor10 = valConta * 0.1;//10% do valor
        double gor15 = valConta * 0.15;//15% do valor
        double gor20 = valConta * 0.20;//20% do valor

        double vConta10 = valConta + gor10; //valor da conta com os 10%
        double vConta15 = valConta + gor15; // valor da conta com 15%
        double vConta20 = valConta + gor20; // valor da conta com 20%


        /* inserir nos objetos*/

        edtGor10.setText(String.format("%.02f", gor10));
        edtGor15.setText(String.format("%.02f", gor15));
        edtGor20.setText(String.format("%.02f", gor20));

        edtValConta10.setText(String.format("%.02f", vConta10));
        edtValConta15.setText(String.format("%.02f", vConta15));
        edtValConta20.setText(String.format("%.02f", vConta20));

    }


    private void initComponetes() {
        edtValConta = (EditText) findViewById(R.id.edtValConta);
        edtGor10 = (EditText) findViewById(R.id.edtGor10);
        edtGor15 = (EditText) findViewById(R.id.edtGor15);
        edtGor20 = (EditText) findViewById(R.id.edtGor20);
        edtValConta10 = (EditText) findViewById(R.id.edtValConta10);
        edtValConta15 = (EditText) findViewById(R.id.edtValConta15);
        edtValConta20 = (EditText) findViewById(R.id.edtValConta20);
        edtGorVar = (EditText) findViewById(R.id.edtGorVar);
        edtValContaVar = (EditText) findViewById(R.id.edtValContaVar);
        txtPercVal = (TextView) findViewById(R.id.txtPercVal);
        seekbar = (SeekBar) findViewById(R.id.seekBar);

    }
}
