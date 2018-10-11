package Liga;

import java.util.Date;

/**
 * @author iam26509397
 *
 */
public class Partido {
    public int scoreT1;
    public int scoreT2;
    public String referee;
    public int date;
    
    public Partido() {
        this.scoreT1 = -1;
        this.scoreT2 = -1;
        this.referee = "";
        this.date = 0;
    }
    
    public Partido(int scoreT1, int scoreT2, String referee, int date) {
        this.scoreT1 = scoreT1;
        this.scoreT2 = scoreT2;
        this.referee = referee;
        this.date = date;
    }

    public int getScoreT1() {
        return scoreT1;
    }

    public void setScoreT1(int scoreT1) {
        this.scoreT1 = scoreT1;
    }

    public int getScoreT2() {
        return scoreT2;
    }

    public void setScoreT2(int scoreT2) {
        this.scoreT2 = scoreT2;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
    
    
}
