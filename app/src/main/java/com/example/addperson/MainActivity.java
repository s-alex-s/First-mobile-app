package com.example.addperson;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final int RESULT_STUDENT = 2;
    public static final int RESULT_TEACHER = 3;
    TextView text;
    Intent intent;

    ActivityResultLauncher<Intent> ActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_STUDENT) {
                        intent = result.getData();
                        assert intent != null;
                        text.setText(intent.getSerializableExtra("student").toString());
                        Toast.makeText(MainActivity.this, "Student added",
                                Toast.LENGTH_SHORT).show();
                    } else if (result.getResultCode() == RESULT_TEACHER) {
                        intent = result.getData();
                        assert intent != null;
                        text.setText(intent.getSerializableExtra("teacher").toString());
                        Toast.makeText(MainActivity.this, "Teacher added",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.show_info);
    }

    @SuppressLint("NonConstantResourceId")
    public void clicked(View v) {
        switch (v.getId()) {
            case R.id.add_student:
                intent = new Intent(this, StudentActivity.class);
                ActivityResult.launch(intent);
                break;
            case R.id.add_teacher:
                intent = new Intent(this, TeacherActivity.class);
                ActivityResult.launch(intent);
                break;
        }
    }
}