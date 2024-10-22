package com.example.myapplication;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Button button;

    Spinner spinner;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ArrayList<Brands> brands = initBrands();

        // Inject topics into spinner
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        for (Brands brand : brands) {
            adapter.add(brand.getName());
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        button.setOnClickListener(v -> {
            String text = spinner.getSelectedItem().toString();
            for (Brands brand : brands) {
                if (brand.getName().equals(text)) {
                    ArrayAdapter<Glasses> glassesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, brand.getGlasses());
                    listView.setAdapter(glassesAdapter);
                }
            }
        });
    }

    public ArrayList<Brands> initBrands() {
        ArrayList<Glasses> rayBanGlasses = new ArrayList<>(Arrays.asList(
            new Glasses("Ray-Ban Aviator", 150.0),
            new Glasses("Ray-Ban Wayfarer", 120.0),
            new Glasses("Ray-Ban Clubmaster", 130.0)
        ));

        ArrayList<Glasses> oakleyGlasses = new ArrayList<>(Arrays.asList(
            new Glasses("Oakley Holbrook", 160.0),
            new Glasses("Oakley Frogskins", 140.0),
            new Glasses("Oakley Sutro", 180.0)
        ));

        ArrayList<Glasses> gucciGlasses = new ArrayList<>(Arrays.asList(
            new Glasses("Gucci GG0061S", 300.0),
            new Glasses("Gucci GG0113S", 320.0),
            new Glasses("Gucci GG0062S", 310.0)
        ));

        ArrayList<Brands> brands = new ArrayList<>(Arrays.asList(
            new Brands("Ray-Ban", rayBanGlasses),
            new Brands("Oakley", oakleyGlasses),
            new Brands("Gucci", gucciGlasses)
        ));

        return brands;
    }

}