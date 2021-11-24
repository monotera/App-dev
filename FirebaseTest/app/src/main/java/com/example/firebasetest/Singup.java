package com.example.firebasetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Singup extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference myRef;
    EditText mName, mEmail, mPass, mAge;
    Button mBtn;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mName = findViewById(R.id.signupName);
        mEmail = findViewById(R.id.signupEmail);
        mPass = findViewById(R.id.signupPassword);
        mAge = findViewById(R.id.signupAge);

        mAuth = FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        mBtn = findViewById(R.id.signup);
        mBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onSignup();
            }
        });

        Intent intent = new Intent(Singup.this,MyIntentService.class);
        startService(intent);
    }

    @Override
    protected void onStart() {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    private void updateUI(FirebaseUser currentUser){
        if(currentUser!=null){
            Intent intent = new Intent(this, Home.class);
            startActivity(intent);
        } else {
            mName.setText("");
            mAge.setText("");
            mPass.setText("");
            mEmail.setText("");
        }
    }

    private void createAccount(String email, String password) {
        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();

                            if(user!=null){
                                // uploadImageToFirebase(user.getUid());

                               User newUser = new User();
                               newUser.setEmail(user.getEmail());
                               newUser.setName(mName.getText().toString());
                               newUser.setAge(Integer.valueOf(mAge.getText().toString()));

                                myRef=database.getReference(DatabasePaths.USER + user.getUid());
                                myRef.setValue(newUser);
                                updateUI(user);

                            }
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Singup.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
        // [END create_user_with_email]
    }

    public void onSignup(){
        if(mEmail == null || mAge == null || mPass == null || mAge == null)
            Toast.makeText(Singup.this, "There is an empty field",
                    Toast.LENGTH_SHORT).show();

        if(!isEmailValid(mEmail.getText().toString()))
            Toast.makeText(Singup.this, "Invalid email",
                    Toast.LENGTH_SHORT).show();
        createAccount(mEmail.getText().toString(),mPass.getText().toString());
    }
    public static boolean isEmailValid(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

}