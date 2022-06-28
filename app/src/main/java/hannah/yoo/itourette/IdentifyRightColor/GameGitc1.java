package hannah.yoo.itourette.IdentifyRightColor;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.security.identity.EphemeralPublicKeyNotFoundException;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import hannah.yoo.itourette.Homepage;
import hannah.yoo.itourette.R;

public class GameGitc1 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        int cnt = getIntent().getIntExtra("count",0);
        cnt ++;
        super.onCreate(savedInstanceState);

        setContentView(R.layout.gitc);

// line 18-32 used to splash; change line 22 for class used (getApplicationContext(),_nextclassused_);
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
        String[] colors = {"red","yellow","orange","green","blue","purple"};

        String color = gg.randomizeColor(colors);
        gg.getColorView(color,colorsquare);
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
        },3000); // use this
    }



    }

