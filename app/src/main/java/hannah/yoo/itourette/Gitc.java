package hannah.yoo.itourette;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import yoo.hannah.itourette.R;

public class Gitc extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gitccolor);
        LinearLayout colorpg = findViewById(R.id.colorpg);
        LinearLayout buttonpg = findViewById(R.id.buttonpg);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                colorpg.setVisibility(View.INVISIBLE);
            }
        }, 3000);
        /**
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                buttonpg.setVisibility(View.VISIBLE);
            }
        }, 1000);
        */
    }
}
