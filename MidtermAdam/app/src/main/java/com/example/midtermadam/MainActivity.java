package com.example.midtermadam;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        TextView result = findViewById(R.id.result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText.getText().toString().isEmpty()) {
                    result.setText("Please enter a radius");
                    return;
                }

                if (editText.getText().toString().matches(".*[a-zA-Z]+.*")) {
                    result.setText("Please enter a number");
                    return;
                }

                double radius = Double.parseDouble((editText.getText().toString()));

                if (radius <= 0) {
                    result.setText("Radius must be greater than 0");
                    return;
                }

                double area = 3.14 * radius * radius;
                result.setText("The area of the circle is: " + area);
            }
        });
    }
}