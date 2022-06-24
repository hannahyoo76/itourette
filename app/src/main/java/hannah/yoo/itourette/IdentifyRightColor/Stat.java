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
        TextView tv = findViewById(R.id.score);
        int a = getIntent().getIntExtra("count", 0);
        String tmp = Integer.toString(a);
        tv.setText(tmp);
    }
}
