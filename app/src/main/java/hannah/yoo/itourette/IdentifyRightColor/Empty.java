package hannah.yoo.itourette.IdentifyRightColor;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import hannah.yoo.itourette.R;

public class Empty extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.empty);
        int cnt = getIntent().getIntExtra("count",0);
        cnt ++;

        int finalCnt = cnt;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(getApplicationContext(), GameGitc1.class);
                intent.putExtra("count", finalCnt);
                startActivity(intent);
                finish();

            }
        },3000); // use this
    }

    }

