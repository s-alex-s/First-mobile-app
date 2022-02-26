package com.example.addperson;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TeacherActivity extends AppCompatActivity {
    EditText name;
    EditText iin;
    EditText subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        name = findViewById(R.id.teacher_name);
        iin = findViewById(R.id.iin_teacher);
        subject = findViewById(R.id.subject);
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

        boolean subject_isnot_digit = true;
        for (char temp : subject.getText().toString().toCharArray()) {
            if (Character.isDigit(temp)) {
                subject_isnot_digit = false;
                break;
            }
        }

        if (iin_is_digit && subject_isnot_digit && name_isnot_digit) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Notice");
            builder.setMessage("Save teacher?");
            builder.setCancelable(false);

            DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (i == DialogInterface.BUTTON_POSITIVE) {
                        Intent intent = new Intent();
                        Teacher teacher = new Teacher(name.getText().toString(),
                                iin.getText().toString());
                        teacher.setSubject(subject.getText().toString());
                        intent.putExtra("teacher", teacher);
                        setResult(3, intent);
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
            if (!subject_isnot_digit) {
                subject.setError("Incorrect subject");
            }
            if (!name_isnot_digit) {
                name.setError("Incorrect name");
            }
        }
    }
}