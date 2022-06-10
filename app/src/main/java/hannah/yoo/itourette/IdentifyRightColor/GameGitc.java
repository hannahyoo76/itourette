package hannah.yoo.itourette.IdentifyRightColor;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import hannah.yoo.itourette.R;
import hannah.yoo.itourette.randomCardMatchingGame.GameActivity;

import java.util.Random;


/*
1. random choose the color
2. display color to user on R.layout.gitccolor
3. move to the button screen R.layout.gitcbutton
4. check if the user gets the square
5. IF the user passes, move back to the gitccolor screen
6. repeat 1-5 (for 6 times)
 */

public class GameGitc extends AppCompatActivity {
    // attributes
    ImageView colorsquare;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gitc);

        colorsquare = findViewById(R.id.colorImage);
        int score = 0;

        for(int i=0; i<6; i++) {
            openGame();
            score += 1;
        }

        Toast.makeText(GameGitc.this, "Game Over!" + score, Toast.LENGTH_LONG).show();

    }

    public void openGame(){

        String[] colors = {"red","yellow","orange","green","blue","purple"};

        Button redbutton = findViewById(R.id.redbutton);
        Button yellowbutton = findViewById(R.id.yellowbutton);
        Button orangebutton = findViewById(R.id.orangebutton);
        Button greenbutton = findViewById(R.id.greenbutton);
        Button bluebutton = findViewById(R.id.bluebutton);
        Button purplebutton = findViewById(R.id.purplebutton);
        Button[] buttonList = {redbutton,yellowbutton,orangebutton,greenbutton,bluebutton,purplebutton};

        int score = 0;

        // game is repeated 6 times
        String color = randomizeColor(colors);
        getColorView(color);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                disappear();
            }
        }, 3000);

        checkCorrect(buttonList, color);
    }

    /*
    methods
     */

    // randomize the color of the image + button for each round
    public String randomizeColor(String[] colors){
        Random random = new Random();
        int randomizer = random.nextInt(6);
        String colorChosen = colors[randomizer];

        return colorChosen;
    }

    // change the color of the image
    public ImageView getColorView(String color){
        switch(color) {
            case "red":
                colorsquare.setImageResource(R.drawable.redsquare);
                break;
            case "orange":
                colorsquare.setImageResource(R.drawable.orangesquare);
                break;
            case "yellow":
                colorsquare.setImageResource(R.drawable.yellowsquare);
                break;
            case "green":
                colorsquare.setImageResource(R.drawable.greensquare);
                break;
            case "blue":
                colorsquare.setImageResource(R.drawable.bluesquare);
                break;
            case "purple":
                colorsquare.setImageResource(R.drawable.purplesquare);
                break;
        } // closes the switch statement

        return colorsquare;
    }

    public void disappear() {
        // image disappears after five seconds (5000ms)

        colorsquare.setVisibility(View.INVISIBLE);
        Log.e("disappear", String.valueOf(colorsquare.getVisibility()));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                colorsquare.setVisibility(View.VISIBLE);
            }
        }, 3000);
    }

    boolean checkCorrect(Button[] buttonList, String colorChosen){
        boolean correct = true;
        Button correctButton;
        switch(colorChosen){
            case "red":
                correctButton = buttonList[0];
                break;
            case "yellow":
                correctButton = buttonList[1];
                break;
            case "orange":
                correctButton = buttonList[2];
                break;
            case "green":
                correctButton = buttonList[3];
                break;
            case "blue":
                correctButton = buttonList[4];
                break;
            case "purple":
                correctButton = buttonList[5];
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + colorChosen);
        }

        correctButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GameGitc.this, "Correct Color!", Toast.LENGTH_LONG).show();
            }
        });
        return correct;
    }
}
