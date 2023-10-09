package com.example.petallies;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);


        /* Bottom Navigation */
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_message);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_home) {
                startActivity(new Intent(getApplicationContext(), Dashboard.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_message) {
                return true;
            } else if (item.getItemId() == R.id.bottom_settings) {
                startActivity(new Intent(getApplicationContext(), Settings.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (item.getItemId() == R.id.bottom_logout) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Logout Confirmation")
                        .setMessage("Are you sure you want to logout and exit the app?")
                        .setPositiveButton("Yes", (dialog, id) -> {
                            // Handle positive button click event, e.g., logout and exit the app
                            finishAffinity();
                        })
                        .setNegativeButton("No", (dialog, id) -> {
                            // Handle negative button click event, e.g., dismiss the dialog
                            dialog.dismiss();
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            }
            return false;
        });
    }
}