package hannah.yoo.itourette;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Timer;
import java.util.TimerTask;

public class FocusTracker extends AppCompatActivity {
    MediaPlayer audio;
    private FirebaseAuth mAuth;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.focustracker);

        audio = MediaPlayer.create(FocusTracker.this,R.raw.d1); // 일단은 d1 임시로 해놨어요

        Button buttonStart = findViewById(R.id.buttonStart);
        ImageButton trackButton = findViewById(R.id.trackbutton);

        // Visibility invisible 로 바꾸기 once button is clicked
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonStart.setVisibility(View.INVISIBLE);
            }
        });


        //1. firebase 코드 여기서 불러오기
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://itourette-default-rtdb.firebaseio.com/");
        DatabaseReference myRef = database.getReference("user/Level/");

        //2. tracker 하기 (first example)
        Timer m_timer = new Timer();
        TimerTask m_task = new TimerTask() {
            @Override
            public void run() {
                trackButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // flag?
                    }
                });
            }
        };
        m_timer.schedule(m_task, 1000);

    }

    public void PlayIT(View v) {
        audio.start();
    }


    public void onPause(){
        super.onPause();
        audio.release();
    }
}
