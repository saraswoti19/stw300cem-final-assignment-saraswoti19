package com.example.studentmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TeacherLogin extends AppCompatActivity {
    EditText userId,password;
    Button button;
    Vibrator vibrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);
        userId=(EditText)findViewById(R.id.editText);
        password=(EditText)findViewById(R.id.editText2);
        button=(Button)findViewById(R.id.button3);
        vibrator= (Vibrator) getSystemService(VIBRATOR_SERVICE);
    }
    public void doOnClick(View view) {
        String user=userId.getText().toString().trim();
        String pass=password.getText().toString().trim();
        if(user.equals("hawa")&&pass.equals("softwarica")){
            if (Build.VERSION.SDK_INT>=26){
                vibrator.vibrate(VibrationEffect.createOneShot(200,VibrationEffect.DEFAULT_AMPLITUDE));
            }
            else {
                vibrator.vibrate(200);
            }
            Intent intent=new Intent(TeacherLogin.this,TeacherActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(TeacherLogin.this, "Wrong Password", Toast.LENGTH_SHORT).show();
        }
    }

}
