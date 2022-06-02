package hannah.yoo.itourette.IdentifyRightColor;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import hannah.yoo.itourette.R;

import java.util.Random;


public class Helper {
    private final Context context;

    public Helper(Context context) {
        this.context = context;
    }

    // method 3: determine the correct button and return it to the program
    public Button userChoice(Button correctButton, String color) {
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
}
