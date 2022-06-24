package hannah.yoo.itourette;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {
    private FirebaseAuth mAuth;

    Button b1,b2;
    TextInputEditText text1, text2;
    TextView tx1;
    int counter = 3;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

        b1 = (Button)findViewById(R.id.loginButton);
        text1 = findViewById(R.id.email);
        text2 = findViewById(R.id.password);


        b2 = (Button) findViewById(R.id.backButton);
        tx1 = (TextView) findViewById(R.id.counts);
        tx1.setVisibility(View.GONE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth = FirebaseAuth.getInstance();
                String email = text1.getText().toString();
                String pwd = text2.getText().toString();
                Log.e("login >> " , email + " / " + pwd);
                mAuth.signInWithEmailAndPassword(email, pwd)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(Login.this, Homepage.class);
                                    startActivity(intent);

                                } else {
                                    Toast.makeText(Login.this, "로그인 오류", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        }

        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signup = new Intent(Login.this, Signup.class);
                startActivity(signup);
            }
        });
        }
    }

