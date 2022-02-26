package com.example.addperson;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class StudentActivity extends AppCompatActivity {
    EditText name;
    EditText iin;
    EditText gpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        name = findViewById(R.id.student_name);
        iin = findViewById(R.id.iin);
        gpa = findViewById(R.id.gpa);
    }

    public void clicked(View v) {
        boolean name_isnot_digit = true;
        for (char temp : name.getText().toString().toCharArray()) {
            if (Character.isDigit(temp)) {
                name_isnot_digit = false;
                break;
            }
        }

        boolean iin_is_digit = true;
        for (char temp : iin.getText().toString().toCharArray()) {
            if (!Character.isDigit(temp)) {
                iin_is_digit = false;
                break;
            }
        }

        boolean gpa_is_digit = true;
        for (char temp : gpa.getText().toString().toCharArray()) {
            if (!Character.isDigit(temp)) {
                gpa_is_digit = false;
                break;
            }
        }

        if (iin_is_digit && gpa_is_digit && name_isnot_digit) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Notice");
            builder.setMessage("Save student?");
            builder.setCancelable(false);

            DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (i == DialogInterface.BUTTON_POSITIVE) {
                        Intent intent = new Intent();
                        Student student = new Student(name.getText().toString(),
                                iin.getText().toString());
                        student.setGPA(gpa.getText().toString());
                        intent.putExtra("student", student);
                        setResult(2, intent);
                        finish();
                    }
                }
            };

            builder.setPositiveButton("Yes", listener);
            builder.setNegativeButton("No", listener);
            builder.create().show();

        } else {
            if (!iin_is_digit) {
                iin.setError("Incorrect iin");
            }
            if (!gpa_is_digit) {
                gpa.setError("Incorrect gpa");
            }
            if (!name_isnot_digit) {
                name.setError("Incorrect name");
            }
        }
    }
}