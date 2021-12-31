package hannah.yoo.itourette;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import yoo.hannah.itourette.R;

public class Homepage extends AppCompatActivity{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.homepage);

        TextView iTourette = findViewById(R.id.iTourette);

        ImageButton focus_tracker = findViewById(R.id.focus_tracker);
        ImageButton games = findViewById(R.id.games);
        ImageButton analysis = findViewById(R.id.analysis);
        ImageButton information = findViewById(R.id.information);

        focus_tracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hp = new Intent(Homepage.this, FocusTracker.class);
                startActivity(hp);
            }
        });

        games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent games = new Intent(Homepage.this, GameMenu.class);
                startActivity(games);
            }
        });

        analysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent analysis = new Intent(Homepage.this, Analysis.class);
                startActivity(analysis);
            }
        });

        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent info = new Intent(Homepage.this, Information.class);
                startActivity(info);
            }
        });

    }}