package com.example.dialog_pivovarov;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.dialog_pivovarov.R.string.green;
import static com.example.dialog_pivovarov.R.string.yellow;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnFon;
    ConstraintLayout constraintLayout;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFon = (Button)findViewById(R.id.idbtn);
        constraintLayout = (ConstraintLayout)findViewById(R.id.idconstl);
        context = MainActivity.this;
        btnFon.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        final CharSequence[] items = {getText(R.string.red),
                getText(R.string.yellow), getText(R.string.green)
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.message);

        builder.setItems(items, new DialogInterface.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(DialogInterface dialog, int item) {
                switch (item) {
                    case  0:
                        constraintLayout.setBackgroundResource(R.color.red);
                        Toast.makeText(context, R.string.red, Toast.LENGTH_LONG).show();

                        break;
                    case  1:
                        constraintLayout.setBackgroundResource(R.color.yellow);
                        Toast.makeText(context, yellow, Toast.LENGTH_LONG).show();

                        break;
                    case  2:
                        constraintLayout.setBackgroundResource(R.color.green);
                        Toast.makeText(context, green, Toast.LENGTH_LONG).show();

                        break;
                }

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}