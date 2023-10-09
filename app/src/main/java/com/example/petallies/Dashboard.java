package com.example.petallies;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        ImageView imageLogo = findViewById(R.id.imageLogo);
        ImageView imageProducts = findViewById(R.id.imageProducts);
        ImageView imageServices = findViewById(R.id.imageServices);
        ImageView imageProfile = findViewById(R.id.imageProfile);
        ImageView imageAboutUs = findViewById(R.id.imageAboutUs);

        String urlLogo = (String) imageLogo.getTag();
        String urlProducts = (String) imageProducts.getTag();
        String urlServices = (String) imageServices.getTag();
        String urlProfile = (String) imageProfile.getTag();
        String urlAboutUs = (String) imageAboutUs.getTag();

// Gumamit ng Picasso para sa pag-load at caching ng mga larawan
        Picasso.get()
                .load(urlLogo)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE) // Pumipigil sa memory caching
                .networkPolicy(NetworkPolicy.NO_CACHE) // Pumipigil sa network caching
                .into(imageLogo);

        Picasso.get()
                .load(urlProducts)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(imageProducts);

        Picasso.get()
                .load(urlServices)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(imageServices);

        Picasso.get()
                .load(urlProfile)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(imageProfile);

        Picasso.get()
                .load(urlAboutUs)
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .into(imageAboutUs);


        /* Bottom Navigation */
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.bottom_home);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.bottom_home) {
                return true;
            } else if (item.getItemId() == R.id.bottom_message) {
                startActivity(new Intent(getApplicationContext(), Message.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
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
