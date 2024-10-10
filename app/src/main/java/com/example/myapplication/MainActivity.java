package com.example.myapplication;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

    TextView textView;

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

        Topic cpp = new Topic("C++", new ArrayList<>(Arrays.asList("C++ Programming", "C++ Programming Cookbook", "C++ Programming for Beginners", "C++ Programming for Dummies")));
        Topic java = new Topic("Java", new ArrayList<>(Arrays.asList("Java Programming", "Java Programming Cookbook", "Java Programming for Beginners", "Java Programming for Dummies")));
        Topic python = new Topic("Python", new ArrayList<>(Arrays.asList("Python Programming", "Python Programming Cookbook", "Python Programming for Beginners", "Python Programming for Dummies")));
        Topic[] topics = {cpp, java, python};

        // Inject topics into spinner
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        for (Topic topic : topics) {
            adapter.add(topic.getName());
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        button.setOnClickListener(v -> {
            String text = spinner.getSelectedItem().toString();
            String books = "";
            // Get books for selected topic
            for (Topic topic : topics) {
                if (topic.getName().equals(text)) {
                    // Join books with newline
                    books = String.join("\n", topic.getBookList());
                    break;
                }
            }
            textView.setText(books);
        });
    }


}