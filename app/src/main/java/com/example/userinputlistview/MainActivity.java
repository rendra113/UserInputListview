package com.example.userinputlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText bil1;
    private EditText bil2;
    private TextView hasil;
    private Button btnHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initUI();
        initEvent();
    }
    private void initUI(){
        bil1 = (EditText) findViewById(R.id.txtbil1);
        bil2 = (EditText) findViewById(R.id.txtbil2);
        hasil = (EditText) findViewById(R.id.hasil);
        btnHasil = (Button) findViewById(R.id.btnCekBil);
    }
    private void initEvent(){
        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungJumlah();
            }
        });
    }

    private void hitungJumlah(){
        int angka1 = Integer.parseInt(bil1.getText().toString());
        int angka2 = Integer.parseInt(bil2.getText().toString());
        int total = angka1 + angka2;
        hasil.setText(total+"");
    }
}
