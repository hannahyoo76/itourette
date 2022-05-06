package hannah.yoo.itourette.randomCardMatchingGame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import com.squareup.picasso.Picasso;

import yoo.hannah.itourette.R;

public class GameActivity extends AppCompatActivity implements TaskDone{
    //attributes
    ArrayList<Integer> fruits;
    final int NUM_IMGS = 5; // 5 different types of fruits

    AlertDialog.Builder builder;
    ArrayList<ImageButton> cards;
    Map<ImageButton, Card> x;
    Set<ImageButton> matched;

    boolean isLocked;
    ImageButton card1;
    ImageButton card2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grcg);

        builder = new AlertDialog.Builder(this);
    }

    // assign fruits to each card
    @Override
    public void onTaskComplete() {
        getFruitList();
        Button shuffle = null;
        // display fruit on each card
        cards = new ArrayList<>();
        initializeBoard(cards);

        shuffle.setOnClickListener(new View.OnClickListener() {
        // shuffle cards automatically
        public void onClick (View v){
            for (ImageButton card : cards) {
                Random random = new Random();
                int index = random.nextInt(cards.size());
                if (!matched.contains(card) && !matched.contains(cards.get(index))) {
                    Card temp = x.get(card);
                    x.put(card, x.get(fruits.get(index)));
                    x.put(cards.get(index), temp);
                }
            }
        }
    });
}

    private void getFruitList() {
        fruits = new ArrayList<>();

        fruits.add(R.drawable.apple);
        fruits.add(R.drawable.orange);
        fruits.add(R.drawable.pineapple);
        fruits.add(R.drawable.cherry);
        fruits.add(R.drawable.orange);
    }

    private void initializeBoard(ArrayList<ImageButton> cards) {
        // assign fruits to cards
        cards.add((ImageButton) findViewById(R.id.imageButton1));
        cards.add((ImageButton) findViewById(R.id.imageButton2));
        cards.add((ImageButton) findViewById(R.id.imageButton3));
        cards.add((ImageButton) findViewById(R.id.imageButton4));
        cards.add((ImageButton) findViewById(R.id.imageButton5));
        cards.add((ImageButton) findViewById(R.id.imageButton6));
        cards.add((ImageButton) findViewById(R.id.imageButton7));
        cards.add((ImageButton) findViewById(R.id.imageButton8));
        cards.add((ImageButton) findViewById(R.id.imageButton9));
        cards.add((ImageButton) findViewById(R.id.imageButton10));


        Collections.shuffle(cards, new Random());

        x = new HashMap<>();
        matched = new HashSet<>();
        isLocked = false;
        card1 = null;

        // assign each image to two of the cards
        // onClickListener: for every two cards flipped, check if they are a match
        for (int i = 0; i < cards.size(); i++) {
            final int fruitType = i % fruits.size();
            final ImageButton card = cards.get(i);

            x.put(card, new Card(fruitType, true));

            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!canFlipCard(card))
                        return;

                    if (card1 == null) {
                        card1 = card;

                        Picasso.get().load(fruits.get(x.get(card1).fruitType)).into(card);
                        processedCardMatch(card1, card);


                    } else {
                        processCardNoMatch(card1, card);
                    }
                }

                private boolean canFlipCard(ImageButton card) {
                    return !isLocked && (card != card1) && !matched.contains(card);
                }

                private void processedCardMatch(ImageButton cardA, ImageButton cardB) {
                    matched.add(cardA);
                    matched.add(cardB);
                    cardA.setEnabled(false);
                    cardB.setEnabled(false);
                    card1 = null;
                    // check if the user matched all
                    if (matched.size() == 2 * NUM_IMGS) {
                        builder.setMessage("Goodbye!");

                    }
                }

                private void processCardNoMatch(ImageButton cardA, ImageButton cardB) {
                    isLocked = true;
                    card1 = cardA;
                    card2 = cardB;
                    Picasso.get().load(fruits.get(x.get(card2).fruitType)).into(card2);
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            card1.setImageResource(R.drawable.cardback);
                            card2.setImageResource(R.drawable.cardback);
                            card1 = null;
                            card2 = null;
                            isLocked = false;
                        }
                    }, 1000);
                }

            });

        } // closes the for loop

    }

}