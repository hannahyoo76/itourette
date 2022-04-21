package hannah.yoo.itourette;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import yoo.hannah.itourette.R;

public class Grcg extends AppCompatActivity{
    Random rand = new Random();
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // 1. View define
        setContentView(R.layout.grcg);
        ImageButton img1 = findViewById(R.id.imageButton1);
        ImageButton img2 = findViewById(R.id.imageButton2);
        ImageButton img3 = findViewById(R.id.imageButton3);
        ImageButton img4 = findViewById(R.id.imageButton4);
        ImageButton img5 = findViewById(R.id.imageButton5);
        ImageButton img6 = findViewById(R.id.imageButton6);
        ImageButton img7 = findViewById(R.id.imageButton7);
        ImageButton img8 = findViewById(R.id.imageButton8);
        ImageButton img9 = findViewById(R.id.imageButton9);
        ImageButton img10 = findViewById(R.id.imageButton10);

        ImageButton[] imgBtn = {img1, img2, img3, img4, img5, img6, img7, img8, img9, img10};

        List<String> fruits = Arrays.asList("Apple","Banana","Cherry","Orange","Pineapple","Apple","Banana","Cherry","Orange","Pineapple");

        List<Integer> fruitOrder = new ArrayList<Integer>() ;
        int counter = 0;
        for(ImageButton imageButton: imgBtn) {
            int randomIndex = rand.nextInt(fruits.size());
            String randomFruit = fruits.get(randomIndex);
            fruitOrder.add(customGetDrawable(randomFruit));
            setResource(imageButton, fruitOrder.get(counter));
            counter ++;
            //fruits.remove(randomFruit); // remove it from list once chosen once
            }

        } // closes onCreate

        public int customGetDrawable (String fruitType){
            switch(fruitType) {
                case "Apple":
                    return R.drawable.apple;
                case "Orange":
                    return R.drawable.orange;
                case "Banana":
                    return R.drawable.banana;
                case "Pineapple":
                    return R.drawable.pineapple;
                case "Cherry":
                    return R.drawable.cherry;
                default:
                    return -1;
            } // closes the switch statement
        }
        public void setResource (ImageButton img, int fruitType){
           img.setImageResource(fruitType);
           img.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }

}
        //2. setOnClickListener { set Image to element in array}

        //3. random : for loop (flag array)

        //4.click pair


/* 
turned around forever (card matched)

card not matched (turn around after round)

card not clicked (back face)

 */

// make a list for each card
