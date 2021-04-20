package com.example.funspeak.views.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.funspeak.R;
import com.example.funspeak.views.login.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    private EditText editTextEmail;
    private EditText editTextPass;
    private EditText editTextName;
    private EditText editTextNickname;
    private EditText editTextAddress;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.editTextEmail = findViewById(R.id.ediTextEmail);
        this.editTextPass = findViewById(R.id.editTextPass);
        this.editTextName = findViewById(R.id.editTextName);
        this.editTextNickname = findViewById(R.id.editTextNickName);
        this.editTextAddress = findViewById(R.id.editTextAddress);
        this.mAuth = FirebaseAuth.getInstance();
    }

    // ButtonActions
    public void btnCancelAction(View view){
        finish();
    }

    public void btnRegisterAction(View view){
        //Toast.makeText(this, "btnRegisterAction", Toast.LENGTH_SHORT).show();
        String email = editTextEmail.getText().toString();
        String pass = editTextPass.getText().toString();
        if (email.length() > 0 && pass.length() > 0){
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Log.d("Register Success", "createUserWithEmail:success");
                        finish();
                    } else {
                        Log.w("Error Register User", "createUserWithEmail:failure", task.getException());
                        Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }else{
            Toast.makeText(this, "Es necesario llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

}