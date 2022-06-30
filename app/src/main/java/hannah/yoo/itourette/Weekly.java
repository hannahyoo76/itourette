package hannah.yoo.itourette;

import java.util.Date;

public class Weekly {
    public Date date;
    public int improvement;
    public int numAccuracy;

    public Weekly(Date date, int improvement, int numAccuracy){
        this.date = date;
        this.improvement = improvement;
        this.numAccuracy = numAccuracy;
    }
}
