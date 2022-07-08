package hannah.yoo.itourette;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FocusTracker extends AppCompatActivity {
    MediaPlayer audio;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.focustracker);

        audio = MediaPlayer.create(FocusTracker.this,R.raw.d1); // 일단은 d1 임시로 해놨어요

        Button buttonStart = findViewById(R.id.buttonStart);

        // Visibility invisible 로 바꾸기 once button is clicked
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonStart.setVisibility(View.INVISIBLE);
            }
        });


        //1. firebase 코드 여기서 불러오기
        //2.

    }


    public void PlayIT(View v) {
        audio.start();
    }


    public void onPause(){
        super.onPause();
        audio.release();
    }
}
