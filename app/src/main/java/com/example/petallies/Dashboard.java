package com.example.petallies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        ImageView imageProducts = findViewById(R.id.imageProducts);
        ImageView imageServices = findViewById(R.id.imageServices);
        ImageView imageProfile = findViewById(R.id.imageProfile);
        ImageView imageAboutUs = findViewById(R.id.imageAboutUs);

        String urlProducts = (String) imageProducts.getTag();
        String urlServices = (String) imageServices.getTag();
        String urlProfile = (String) imageProfile.getTag();
        String urlAboutUs = (String) imageAboutUs.getTag();

        Picasso.get().load(urlProducts).into(imageProducts);
        Picasso.get().load(urlServices).into(imageServices);
        Picasso.get().load(urlProfile).into(imageProfile);
        Picasso.get().load(urlAboutUs).into(imageAboutUs);


    }
}
