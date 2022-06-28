package hannah.yoo.itourette;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makeaccount);

        TextInputEditText text1, text2, text3;
        Button b1;

        text1 = findViewById(R.id.emailSet);
        text2 = findViewById(R.id.passwordSet);
        text3 = findViewById(R.id.usernameSet);

        b1 = (Button) findViewById(R.id.makeAccount);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = text1.getText().toString();
                String password = text2.getText().toString();
                String username = text3.getText().toString();

                mAuth =  FirebaseAuth.getInstance();
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(" s i", "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    User userA = new User(email, password, username, user.getUid());
                                    saveUser(userA);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w("s i ", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(Signup.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    //updateUI(null);
                                }
                            }
                        });
            }
        });


    }

    public void saveUser(User user){
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://itourette-default-rtdb.firebaseio.com/" );
        DatabaseReference myRef = database.getReference();
        myRef.child("user/"+user.uid).setValue(user);
    }


}






