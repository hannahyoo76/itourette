package hannah.yoo.itourette;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import yoo.hannah.itourette.R;

public class Grcg extends AppCompatActivity{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.grcg);
        ImageButton img1 = findViewById(R.id.imageButton1);
        img1.setImageResource(R.drawable.itc);
    }
}


        //1. View define
        //ImageButton imgBtn[] ~

        //2. setOnClickListener { set Image to element in array}

        //3. random : for loop (flag array)

        //4.click pair


