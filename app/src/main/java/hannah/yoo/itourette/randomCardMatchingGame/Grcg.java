package hannah.yoo.itourette.randomCardMatchingGame;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import hannah.yoo.itourette.R;

public class Grcg extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grcg);
        openGame();
    }

    // runs when the game is opened
    public void openGame(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}