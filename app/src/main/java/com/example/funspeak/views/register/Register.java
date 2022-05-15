package com.example.funspeak.views.register;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.funspeak.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference();
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText email = findViewById(R.id.ediTextEmail);
        final EditText password = findViewById(R.id.editTextPass);
        final EditText name = findViewById(R.id.editTextName);
        final EditText nickname = findViewById(R.id.editTextNickName);
        final EditText address = findViewById(R.id.editTextAddress);
        mAuth = FirebaseAuth.getInstance();

        final Button registerBtn = findViewById(R.id.btnRegister);

        if(mAuth.getCurrentUser() != null) {
            mAuth.getCurrentUser().getUid();
        }

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String emailtxt = email.getText().toString();
                final String passwordtxt = password.getText().toString();
                final String nametxt = name.getText().toString();
                final String nicknametxt = nickname.getText().toString();
                final String telefonotxt = address.getText().toString();

                if( emailtxt.isEmpty() || passwordtxt.isEmpty() || nametxt.isEmpty()|| nicknametxt.isEmpty()|| telefonotxt.isEmpty() ){
                    Toast.makeText(Register.this,"Llena todos los campos",Toast.LENGTH_SHORT).show();
                }
                else{
                    reference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //checa si esta registrado
                            if(snapshot.hasChild(emailtxt)) {
                                Toast.makeText(Register.this, "Email ya Registrado", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                reference.child("users").child(emailtxt).child("email").setValue(emailtxt);
                                reference.child("users").child(emailtxt) .child("name").setValue(nametxt);
                                reference.child("users").child(emailtxt).child("nickname").setValue(nicknametxt);
                                reference.child("users").child(emailtxt).child("password").setValue(passwordtxt);
                                reference.child("users").child(emailtxt).child("telefono").setValue(telefonotxt);

                                Toast.makeText(Register.this, "User Registered", Toast.LENGTH_SHORT).show();
                                finish();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    }


                    );

                }

            }
        });
    }

}
