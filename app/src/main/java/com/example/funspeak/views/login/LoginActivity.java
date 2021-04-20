package com.example.funspeak.views.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.funspeak.R;
import com.example.funspeak.views.LanguageSelection;
import com.example.funspeak.views.register.RegisterActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextEmail;
    private EditText editTextPass;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.editTextEmail = findViewById(R.id.ediTextEmail);
        this.editTextPass = findViewById(R.id.editTextPassword);
        this.mAuth = FirebaseAuth.getInstance();
    }

    public void showHome(){
        ///LanguageSelection
        Intent intent = new Intent(this, LanguageSelection.class);
        intent.putExtra("user", mAuth.getCurrentUser().getUid());
        startActivity(intent);
        finish();
    }

    // ButtonActions
    public void btnLoginAction(View view){
        String email = this.editTextEmail.getText().toString();
        String pass = this.editTextPass.getText().toString();
        if (email.length() > 0 && pass.length() > 0) {
            this.mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Log.d("LoginSucessful", "signInWithEmail:success");
                        showHome();
                    }else{
                        Log.w("LoginError", "signInWithEmail:failure", task.getException());
                        Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }else{
            Toast.makeText(this, "Es necesario llenar ambos campos", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnRegisterAction(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

}