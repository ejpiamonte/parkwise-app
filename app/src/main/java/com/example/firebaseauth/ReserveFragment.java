package com.example.firebaseauth;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ReserveFragment extends Fragment {

    EditText editTextName, editTextPlateNumber;
    Button buttonReserve;
    TextView ticketInfoTextView;
    private static final String TAG = "YourFragment";
    private FirebaseFirestore db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reserve, container, false);

        editTextName = view.findViewById(R.id.editTextName);
        editTextPlateNumber = view.findViewById(R.id.editTextPlateNumber);
        buttonReserve = view.findViewById(R.id.buttonReserve);
        ticketInfoTextView = view.findViewById(R.id.ticketInfoTextView);

        db = FirebaseFirestore.getInstance();

        buttonReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String plateNumber = editTextPlateNumber.getText().toString().trim();

                if (name.isEmpty() || plateNumber.isEmpty()) {
                    Toast.makeText(getActivity(), "Please fill out all fields", Toast.LENGTH_SHORT).show();
                } else {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a", Locale.getDefault());
                    String currentDateAndTime = dateFormat.format(new Date());

                    String ticketInfo = "Name: " + name + "\nPlate Number: " + plateNumber + "\nDate: " + currentDateAndTime;
                    ticketInfoTextView.setText(ticketInfo);

                    addUserToFirestore(name, plateNumber, currentDateAndTime);
                }
            }
        });

        return view;
    }

    private void addUserToFirestore(String name, String plateNumber, String timestamp) {
        Map<String, Object> user = new HashMap<>();
        user.put("Username", name);
        user.put("Plate Number", plateNumber);
        user.put("Timestamp", timestamp);

        db.collection("users")
                .document(name) // Use the user's name as the document ID
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + name);
                        // Handle success, e.g., show a success message
                        Toast.makeText(getActivity(), "Data added to Firestore", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                        // Handle failure, e.g., show an error message
                        Toast.makeText(getActivity(), "Error adding data to Firestore", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}

