package hannah.yoo.itourette.IdentifyRightColor;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.security.identity.EphemeralPublicKeyNotFoundException;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import hannah.yoo.itourette.Homepage;
import hannah.yoo.itourette.R;

public class GameGitc1 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        int cnt = getIntent().getIntExtra("count",0);
        super.onCreate(savedInstanceState);
        cnt++;

        setContentView(R.layout.gitc);

        Handler handler = new Handler();
        int finalCnt = cnt;

        Button redbutton = findViewById(R.id.redbutton);
        Button yellowbutton = findViewById(R.id.yellowbutton);
        Button orangebutton = findViewById(R.id.orangebutton);
        Button greenbutton = findViewById(R.id.greenbutton);
        Button bluebutton = findViewById(R.id.bluebutton);
        Button purplebutton = findViewById(R.id.purplebutton);

        GameGitc gg = new GameGitc();

        ImageView colorsquare = findViewById(R.id.colorImage);

        Button[] buttons = {redbutton, yellowbutton,orangebutton,greenbutton,bluebutton,purplebutton};
        String[] colors = {"red","yellow","orange","green","blue","purple"};

        // 1. randomize correct color
        String correctColor = gg.randomizeColor(colors);

        // 2. declare and initialize correct button
        Button correctButton;

        int correctColorIndex = gg.getColorIndex(correctColor);

        correctButton = buttons[correctColorIndex];

        gg.getColorView(correctColor,colorsquare);

        correctButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GameGitc1.this, "Correct Color: " + correctColor + " !",Toast.LENGTH_LONG).show();
            }
        });

        // checkCorrect(userColor, correctColor);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (finalCnt < 5) {
                    Intent intent = new Intent(getApplicationContext(), GameGitc1.class);
                    intent.putExtra("count", finalCnt);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), Stat.class);
                    intent.putExtra("count", finalCnt);
                    startActivity(intent);
                    finish();
                    }
                }
            },5000); // use this
        }

    }

