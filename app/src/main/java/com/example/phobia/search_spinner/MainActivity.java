package com.example.phobia.search_spinner;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;

public class MainActivity extends AppCompatActivity {
    private Button button;

    ArrayList<String> item = new ArrayList<>();
    SpinnerDialog spinnerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                View view1 = getLayoutInflater().inflate(R.layout.dialog_spinner,null);

                //Title
                builder.setTitle("Spinners");

                //Blind Widget
                final Spinner mspinner = (Spinner) view1.findViewById(R.id.spinner);


                //Adapter
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.restaurantList));
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mspinner.setAdapter(adapter);

                //button submit
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (mspinner.getSelectedItem().toString().equalsIgnoreCase("Choose  a restaurant…")) {
                            Toast.makeText(MainActivity.this, mspinner.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
                            dialogInterface.dismiss();
                        }

                    }
                });

                //SetButton Cancel
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                      dialogInterface.dismiss();
                    }
                });

                //ShowDialog
                builder.setView(view1);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
