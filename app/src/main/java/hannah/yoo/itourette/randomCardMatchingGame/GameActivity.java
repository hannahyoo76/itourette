package hannah.yoo.itourette.randomCardMatchingGame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import yoo.hannah.itourette.R;

public class GameActivity extends AppCompatActivity {
    //attributes
    ImageView curView = null;
    private int pairs = 0;
    final int[] fruitDesign = new int[] {
            R.drawable.orange,
            R.drawable.cherry,
            R.drawable.pineapple,
            R.drawable.apple,
            R.drawable.banana
    };

    int[] pos = {0,1,2,3,4,0,1,2,3,4};
    int currentPosition = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grcg);

        ImageAdapter imageAdapter = new ImageAdapter(this);
        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(imageAdapter);
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            if (currentPosition < 0) {
                currentPosition = position;
                curView = (ImageView) view;
                ((ImageView) view).setImageResource(fruitDesign[pos[position]]);
            } else {
                if (currentPosition == position) {
                    ((ImageView) view).setImageResource(R.drawable.cardback);
                } else if (pos[currentPosition] != pos[position]) {
                    curView.setImageResource(R.drawable.cardback);
                    Toast.makeText(GameActivity.this, "Try again!", Toast.LENGTH_LONG).show();
                } else {
                    ((ImageView) view).setImageResource(fruitDesign[pos[position]]);
                    pairs += 1;
                    if (pairs == 5) {
                        Toast.makeText(GameActivity.this, "Clear!", Toast.LENGTH_LONG).show();
                    }
                }
                currentPosition = -1;
            }
        }); // onCreate()
    }
}