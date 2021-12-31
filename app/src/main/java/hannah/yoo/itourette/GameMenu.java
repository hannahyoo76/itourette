package hannah.yoo.itourette;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import yoo.hannah.itourette.R;
public class GameMenu extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    setContentView(R.layout.gamemenu);

    Button keep_line_straight = findViewById(R.id.line_straight);
    Button click_right_button = findViewById(R.id.right_button);
    Button random_card_game = findViewById(R.id.card_game);
    Button identify_the_color = findViewById(R.id.identify_color);
    TextView tv = findViewById(R.id.games_tv);

        keep_line_straight.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent kls = new Intent(GameMenu.this, Gktls.class);
            startActivity(kls);
        }
    });

        click_right_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent crb = new Intent(GameMenu.this, Gctrb.class);
            startActivity(crb);
        }
    });

        random_card_game.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent rcg = new Intent(GameMenu.this, Grcg.class);
            startActivity(rcg);
        }
    });

        identify_the_color.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent itc = new Intent(GameMenu.this, Gitc.class);
            startActivity(itc);
        }
    });
}
}

