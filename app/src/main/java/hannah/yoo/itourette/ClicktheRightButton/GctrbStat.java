package hannah.yoo.itourette.ClicktheRightButton;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import hannah.yoo.itourette.R;

public class GctrbStat extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gctrbstat);
        TextView tv = findViewById(R.id.scoreValue);
        int a = getIntent().getIntExtra("cntCor",0);
        String act = Integer.toString(a);
        tv.setText(act + "/4");
    }
}
