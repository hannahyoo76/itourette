package hannah.yoo.itourette.ClicktheRightButton;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.Random;

import hannah.yoo.itourette.R;

public class Gctrb extends AppCompatActivity {

    TextView shapeText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.gctrb);

        shapeText = findViewById(R.id.shapeText);

    }

    public String randomizeShape(String[] shapes) {
        Random random = new Random();
        int randomizer = random.nextInt(4);
        String shapeChosen = shapes[randomizer];

        return shapeChosen;
    }

    public TextView getShapeView(String shape, TextView tv){
        switch(shape) {
            case "TRIANGLE":
                tv.setText("TRIANGLE");
                break;
            case "SQUARE":
                tv.setText("SQUARE");
                break;
            case "CIRCLE":
                tv.setText("CIRCLE");
                break;
            case "DIAMOND":
                tv.setText("DIAMOND");
                break;
        }
        return tv;
    }

    public int getShapeIndex(String correctShape) {
        int shapeIndex = 0;
        switch(correctShape) {
            case "TRIANGLE":
                shapeIndex = 0;
                break;
            case "SQUARE":
                shapeIndex = 1;
                break;
            case "CIRCLE":
                shapeIndex = 2;
                break;
            case "DIAMOND":
                shapeIndex = 3;
                break;
        }
        return shapeIndex;
    }

    boolean checkCorrect(Button[] buttonList, String shapeChosen) {
        boolean correct = true;
        Button correctButton;
        switch(shapeChosen) {
            case "TRIANGLE":
                correctButton = buttonList[0];
                break;
            case "SQUARE":
                correctButton = buttonList[1];
                break;
            case "CIRCLE":
                correctButton = buttonList[2];
                break;
            case "DIAMOND":
                correctButton = buttonList[3];
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + shapeChosen);
        }

        correctButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Gctrb.this, "Correct Color!", Toast.LENGTH_LONG).show();
            }
        });
        return correct;
    }
}
