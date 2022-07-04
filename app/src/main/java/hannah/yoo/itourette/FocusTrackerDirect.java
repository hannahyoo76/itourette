import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import hannah.yoo.itourette.FocusTracker;
import hannah.yoo.itourette.R;

public class FocusTrackerDirect extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.focustrackerdirect);

        Button start = findViewById(R.id.buttonStart);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent s = new Intent(FocusTrackerDirect.this, FocusTracker.class);
                startActivity(s);
            }
        });

    }
}
