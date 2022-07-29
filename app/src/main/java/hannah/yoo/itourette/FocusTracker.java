package hannah.yoo.itourette;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class FocusTracker extends AppCompatActivity {
    MediaPlayer audio;
    long tmp; // time when button is clicked
    String uID;
    Map<String,Integer> map;
    FirebaseAuth mAuth;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        long t1 = System.currentTimeMillis(); // time when the page starts

        LocalDate now = LocalDate.now();
        String date = now.toString()+"_key";


        setContentView(R.layout.focustracker);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        uID = currentUser.getUid();

        FirebaseDatabase database = FirebaseDatabase.getInstance("https://itourette-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference("user");
        myRef.child(uID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                map = user.map;
                map.put(date,0);

                //myRef.child("");

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        audio = MediaPlayer.create(FocusTracker.this, R.raw.d1); // 일단은 d1 임시로 해놨어요

        Button buttonStart = findViewById(R.id.buttonStart);
        ImageButton trackButton = findViewById(R.id.trackbutton);

        // Visibility invisible 로 바꾸기 once button is clicked
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonStart.setVisibility(View.INVISIBLE);
                PlayIT(v);
            }
        });


        //2. tracker 하기 (first example)

        setOnClick(trackButton, System.currentTimeMillis(),t1,date, myRef);
    }

    public void PlayIT(View v) {
        audio.start();
    }


    private void setOnClick(ImageButton btn, long tmp, long t1, String date, DatabaseReference myRef){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                myRef.child(uID).child("map").child(date).setValue(5);
                /*
                if(Math.abs(tmp - t1) <= 1000) {
                    Integer i = map.get(date);
                    i++;
                    map.replace(date,i);
                }
                */

            }
        });
    }

    public void onPause(){
        super.onPause();
        audio.release();
    }
}
