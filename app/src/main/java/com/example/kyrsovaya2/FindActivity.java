package com.example.kyrsovaya2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class FindActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private RecyclerView recyclerView;
    private ArrayList<String> imageNames;
    private ArrayList<String> imageAddresses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Получение списка названий и адресов изображений из папки drawable
        getImageData();

        // Создание и установка адаптера для RecyclerView
        RecyclerView.Adapter<ImageViewHolder> adapter = new RecyclerView.Adapter<ImageViewHolder>() {
            @NonNull
            @Override
            public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
                return new ImageViewHolder(view);
            }

            @Override
            public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
                String imageName = imageNames.get(position);
                String imageAddress = imageAddresses.get(position);

                holder.imageNameTextView.setText(imageName);
                holder.imageAddressTextView.setText(imageAddress);
            }

            @Override
            public int getItemCount() {
                return imageNames.size();
            }
        };

        recyclerView.setAdapter(adapter);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        // Handle profile selection
                        Intent intentProf = new Intent(FindActivity.this, Profile.class);
                        startActivity(intentProf);
                        return true;
                    case R.id.add:
                        // Handle add selection
                        return true;
                    case R.id.find:
                        // Handle find selection
                        return true;
                    case R.id.gall_id:
                        // Handle gallery selection
                        Intent intentGall = new Intent(FindActivity.this, Gallery.class);
                        startActivity(intentGall);
                        return true;
                }
                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.find);
    }

    private void getImageData() {
        imageNames = new ArrayList<>();
        imageAddresses = new ArrayList<>();

        Field[] fields = R.drawable.class.getFields();
        for (Field field : fields) {
            String name = field.getName();
            if (!name.equals("ic_launcher_background")) { // Пропустите стандартный ресурс иконки приложения
                imageNames.add(name);

                int resourceId = getResources().getIdentifier(name, "drawable", getPackageName());
                String address = "android.resource://" + getPackageName() + "/" + resourceId;
                imageAddresses.add(address);
            }
        }
    }

    private static class ImageViewHolder extends RecyclerView.ViewHolder {
        TextView imageNameTextView;
        TextView imageAddressTextView;

        ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            imageNameTextView = itemView.findViewById(R.id.imageNameTextView);
            imageAddressTextView = itemView.findViewById(R.id.imageAddressTextView);
        }
    }
}