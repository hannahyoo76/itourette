package hannah.yoo.itourette;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import hannah.yoo.itourette.ClicktheRightButton.Gctrb;
import hannah.yoo.itourette.ClicktheRightButton.Gctrb1;
import hannah.yoo.itourette.IdentifyRightColor.GameGitc1;
import hannah.yoo.itourette.randomCardMatchingGame.Grcg;
public class GameMenu extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    int cnt =0 ;
    setContentView(R.layout.gamemenu);

    ImageButton keep_line_straight = findViewById(R.id.line_straight);
    ImageButton click_right_button = findViewById(R.id.right_button);
    ImageButton random_card_game = findViewById(R.id.card_game);
    ImageButton identify_the_color = findViewById(R.id.identify_color);

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
            Intent crb = new Intent(GameMenu.this, Gctrb1.class);
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
            Intent itc = new Intent(GameMenu.this, GameGitc1.class);
            itc.putExtra("count", cnt);
            startActivity(itc);
        }
    });
}
}

