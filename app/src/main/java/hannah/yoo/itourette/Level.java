package hannah.yoo.itourette;

import java.util.ArrayList;

public class Level {

    public int Red_Dots;
    public int Time;
    public String Red_dot_str;
    public ArrayList<Integer> d1 = new ArrayList<>();
    public ArrayList<Integer> D2;
    public ArrayList<Integer> D3;
    public ArrayList<Integer> D4;
    public ArrayList<Integer> D5;

    public Level() {
        //d1.add(1000,12000,19000,);
    }

    public Level(int Red_Dots, int blabla) {
        this.Red_Dots = Red_Dots;
        this.Time = blabla;
        this.Red_dot_str = String.valueOf( this.Red_Dots);
    }

    public String returnLevel(String curLevel){
        String currentLevel = curLevel;
        String nextLevel = "";
        switch(currentLevel){
            case "D0":
                nextLevel = "D1";
                break;
            case "D1":
                nextLevel = "D2";
                break;
            case "D2":
                nextLevel = "D3";
                break;
            case "D3":
                nextLevel = "D4";
                break;
            case "D4":
                nextLevel = "D5";
                break;
        }
        return nextLevel;
    }
}