package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextAmount = findViewById(R.id.editTextAmount);
        Button btnCompute = findViewById(R.id.btnCompute);
        TextView textViewResult = findViewById(R.id.result);
        ListView listViewResults = findViewById(R.id.list);
        final List<String> data = new ArrayList<>();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        listViewResults.setAdapter(arrayAdapter);

        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double amount = Double.parseDouble(editTextAmount.getText().toString());
                double result = amount * 65;
                textViewResult.setText(String.valueOf(result));
                data.add(amount + " => " + result);
                arrayAdapter.notifyDataSetChanged();
                editTextAmount.setText("");
            }
        });
    }
}