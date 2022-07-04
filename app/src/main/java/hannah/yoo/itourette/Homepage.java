package hannah.yoo.itourette;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Homepage extends AppCompatActivity{
    FirebaseAuth mAuth;
    String uId;
    TextView tv;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.homepage);

        ImageButton focus_tracker = findViewById(R.id.focus_tracker);
        ImageButton games = findViewById(R.id.games);
        ImageButton analysis = findViewById(R.id.analysis);
        ImageButton information = findViewById(R.id.information);

        tv = findViewById(R.id.nameUser);

        focus_tracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hp = new Intent(Homepage.this, FocusTrackerDirect.class);
                startActivity(hp);
            }
        });

        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent games = new Intent(Homepage.this, GameMenu.class);
                startActivity(games);
            }
        });

        analysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent analysis = new Intent(Homepage.this, Analysis.class);
                startActivity(analysis);
            }
        });

        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent info = new Intent(Homepage.this, Information.class);
                startActivity(info);
            }
        });

    }

    public void getUsrname(String uId){
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://itourette-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference("user");
        myRef.child(uId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                User user = dataSnapshot.getValue(User.class);
                String usrname= String.valueOf(user.username);
                tv.setText(usrname);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        mAuth =  FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null){
            Intent it = new Intent(getApplicationContext(), Login.class);
            startActivity(it);
            finish();
        }
        Log.e("DATA >> ", currentUser.getUid());
        uId = currentUser.getUid();
        getUsrname(uId);

    }


}