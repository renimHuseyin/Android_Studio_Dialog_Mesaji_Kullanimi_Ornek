package com.renim.dialog_mesaji;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text;
    EditText editText;
    Button btn_sil,btn_ekle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.metin);
        editText = findViewById(R.id.editTextText);
        btn_sil = findViewById(R.id.sil);
        btn_ekle = findViewById(R.id.ekle);

        btn_ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String KullaniciGirisi = editText.getText().toString();
                text.setText(KullaniciGirisi);
            }
        });

        btn_sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogMessage();
            }
        });

    }

    private void showDialogMessage() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("DELETE").setMessage("Do you want to delete text?")
                .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.cancel();
                    }
                })
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        text.setText("");
                        editText.setText("");
                        Toast.makeText(getApplicationContext(),"Yazılan metin başarıyla silinmiştir.",Toast.LENGTH_LONG).show();
                    }
                }).show();
        alertDialog.create();
    }
}