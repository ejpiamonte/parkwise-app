package com.example.firebaseauth;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Reserve extends AppCompatActivity {

    EditText editTextName, editTextPlateNumber;
    Button buttonReserve;
    TextView ticketInfoTextView;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_reserve);

        editTextName = findViewById(R.id.editTextName);
        editTextPlateNumber = findViewById(R.id.editTextPlateNumber);
        buttonReserve = findViewById(R.id.buttonReserve);
        ticketInfoTextView = findViewById(R.id.ticketInfoTextView);


        buttonReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input
                String name = editTextName.getText().toString().trim();
                String plateNumber = editTextPlateNumber.getText().toString().trim();

                if (name.isEmpty() || plateNumber.isEmpty()) {
                    Toast.makeText(Reserve.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Generate current date and time
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                    String currentDateAndTime = dateFormat.format(new Date());

                    // Display ticket information
                    String ticketInfo = "Name: " + name + "\nPlate Number: " + plateNumber + "\nDate: " + currentDateAndTime;
                    ticketInfoTextView.setText(ticketInfo);
                }
            }
        });
    }
}