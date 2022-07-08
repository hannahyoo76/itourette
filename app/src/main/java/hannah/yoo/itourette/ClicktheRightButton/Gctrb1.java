package hannah.yoo.itourette.ClicktheRightButton;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import hannah.yoo.itourette.R;

public class Gctrb1 extends AppCompatActivity {
    int flag = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int cnt = getIntent().getIntExtra("counter",0);
        cnt++;

        setContentView(R.layout.gctrb);

        Handler handler = new Handler();

        int finalCnt = cnt;

        ImageButton triangle = findViewById(R.id.triangle);
        ImageButton square = findViewById(R.id.square);
        ImageButton circle = findViewById(R.id.circle);
        ImageButton diamond = findViewById(R.id.diamond);

        ImageButton[] buttons = {triangle,square,circle,diamond};

        Gctrb g = new Gctrb();

        TextView tv = findViewById(R.id.shapeText);

        String[] shapes = {"TRIANGLE","SQUARE","CIRCLE","DIAMOND"};

        // 1. randomize correct shape
        String correctShape = g.randomizeShape(shapes);

        // 2. declare and initialize correct button
        ImageButton correctButton;

        int correctShapeIndex = g.getShapeIndex(correctShape);

        correctButton = buttons[correctShapeIndex];

        // 3. get shape text view
        g.getShapeView(correctShape,tv);

        // 4. response when correct button is clicked
        correctButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = 1;
            }
        });

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(finalCnt < 10) {
                    Intent intent = new Intent(getApplication(), Gctrb1.class);
                    intent.putExtra("counter",finalCnt);
                    int cntCr = getIntent().getIntExtra("cntCor",0);
                    if(flag == 1) cntCr++;
                    intent.putExtra("cntCor",cntCr);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(),GctrbStat.class);
                    intent.putExtra("counter",finalCnt);
                    int cntCor = getIntent().getIntExtra("cntCor",0);
                    if(flag == 1) cntCor ++;
                    intent.putExtra("cntCor",cntCor);
                    startActivity(intent);
                    finish();
                }
            }
        }, 3000);

    }
}
