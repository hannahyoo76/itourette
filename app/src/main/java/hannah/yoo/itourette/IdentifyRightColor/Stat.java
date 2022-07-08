package hannah.yoo.itourette.IdentifyRightColor;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import hannah.yoo.itourette.R;


public class Stat extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stat);
        TextView real = findViewById(R.id.scoreValue);
        int b = getIntent().getIntExtra("cntCr",0);
        String act = Integer.toString(b);
        real.setText(act + "/5");


    }
}
