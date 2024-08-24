package com.example.adapterdemolistview;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
        //Here listview is the adapter-view
        listView = findViewById(R.id.listView);

        //Adding the datasource
        String[] countries = {"India", "China", "Bangladesh", "Srilanka", "Nepal", "Bhutan",
                              "India", "China", "Bangladesh", "Srilanka", "Nepal", "Bhutan",
                                "India", "China", "Bangladesh", "Srilanka", "Nepal", "Bhutan", "India",
                                "China", "Bangladesh", "Srilanka", "Nepal", "Bhutan", "India",
                "China", "Bangladesh", "Srilanka", "Nepal", "Bhutan"};

        //Creating Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);

        //Link listview with adapter
        listView.setAdapter(adapter);
    }
}