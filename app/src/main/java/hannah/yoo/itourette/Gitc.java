package hannah.yoo.itourette;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.Random;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import yoo.hannah.itourette.R;

public class Gitc extends AppCompatActivity {

    // ATTRIBUTES
    // set the ImageView attribute to the colorImage button
    ImageView colorImage = (ImageView) findViewById(R.id.colorImage);
    String color = "";
    Button correctButton = (Button) findViewById(R.id.redbutton); // dummy for now

    // VISIBILITY OF PAGES
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        // game();
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
        @Override public void run() {
        buttonpg.setVisibility(View.VISIBLE);
        }
        }, 1000);
         */

    }

    // method 1: game goes on for ten rounds
    public void game(){
        for (int i = 0; i < 10; i++) {
            color = randomizeColor(); // 1. randomize color
            colorImage = getColorView(colorImage, color); // 2. change the color of image
            correctButton = getCorrectButton(correctButton, color); // 3. changes the correct button
            }
        }
    // ---------------------------------methods--------------------------------------------------

    // method 2: determines the color through randomization
    public String randomizeColor(){
        String[] colors = {"red","orange","yellow","green","blue","purple"};
        Random random = new Random();

        int randomizer = random.nextInt(6);
        String colorChosen = colors[randomizer];

        return colorChosen;
    } // closes randomizeColor method

    // method 3: return the correct image display for the randomized color
    public ImageView getColorView(ImageView colorImage,String color){
        switch(color) {
            case "red":
                colorImage.setImageResource(R.drawable.redSquare);
                break;
            case "orange":
                colorImage.setImageResource(R.drawable.orangeSquare);
                break;
            case "yellow":
                colorImage.setImageResource(R.drawable.yellowSquare);
                break;
            case "green":
                colorImage.setImageResource(R.drawable.greenSquare);
                break;
            case "blue":
                colorImage.setImageResource(R.drawable.blueSquare);
                break;
            case "purple":
                colorImage.setImageResource(R.drawable.purpleSquare);
                break;
        } // closes the switch statement

        return colorImage;
    }

    // method 4: determine the correct button and return it to the program
    public Button getCorrectButton(Button correctButton, String color) {
        switch(color) {
            case "red":
                correctButton.findViewById(R.id.redbutton);
                break;
            case "orange":
                correctButton.findViewById(R.id.orangebutton);
                break;
            case "yellow":
                correctButton.findViewById(R.id.yellowbutton);
                break;
            case "green":
                correctButton.findViewById(R.id.greenbutton);
                break;
            case "blue":
                correctButton.findViewById(R.id.bluebutton);
                break;
            case "purple":
                correctButton.findViewById(R.id.purplebutton);
                break;
        } // closes the switch statement

        return correctButton;
    }

    // method 5:
} // closes class
