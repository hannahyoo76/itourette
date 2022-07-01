package hannah.yoo.itourette.IdentifyRightColor;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.security.identity.EphemeralPublicKeyNotFoundException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import hannah.yoo.itourette.Homepage;
import hannah.yoo.itourette.R;
import hannah.yoo.itourette.User;

public class GameGitc1 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        int cnt = getIntent().getIntExtra("count",0);


        super.onCreate(savedInstanceState);
        cnt++;


        setContentView(R.layout.gitc);

        Handler handler = new Handler();
        int finalCnt = cnt;


        Button redbutton = findViewById(R.id.redbutton);
        Button yellowbutton = findViewById(R.id.yellowbutton);
        Button orangebutton = findViewById(R.id.orangebutton);
        Button greenbutton = findViewById(R.id.greenbutton);
        Button bluebutton = findViewById(R.id.bluebutton);
        Button purplebutton = findViewById(R.id.purplebutton);

        GameGitc gg = new GameGitc();

        ImageView colorsquare = findViewById(R.id.colorImage);

        Button[] buttons = {redbutton, yellowbutton,orangebutton,greenbutton,bluebutton,purplebutton};
        String[] colors = {"red","yellow","orange","green","blue","purple"};

        // 1. randomize correct color
        String correctColor = gg.randomizeColor(colors);

        // 2. declare and initialize correct button
        Button correctButton;

        int correctColorIndex = gg.getColorIndex(correctColor);

        correctButton = buttons[correctColorIndex];

        // 3. get the color view
        gg.getColorView(correctColor,colorsquare);

        // 4. response when correct button is clicked
        correctButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://itourette-default-rtdb.firebaseio.com/");
                DatabaseReference myRef = database.getReference("user");
                myRef.child("D0DHRMd0kGPv9PNAoMJhguXHshO2").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        User user = dataSnapshot.getValue(User.class);
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
                myRef.setValue(myRef)
            }
        });

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (finalCnt < 5) {
                    Intent intent = new Intent(getApplicationContext(), GameGitc1.class);
                    intent.putExtra("count", finalCnt);

                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), Stat.class);
                    intent.putExtra("count", finalCnt);
                  //  intent.putExtra("correctCnt",finalCorrectCnt);
                    startActivity(intent);
                    finish();
                    }
                }
            },5000); // use this
        }

    }

