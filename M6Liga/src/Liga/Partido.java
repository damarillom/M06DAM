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
    public int day;
    public int month;
    public int year;
    public int eLocal;
    public int eVisit;
    
    public Partido(int eLocal, int eVisit) {
        this.scoreT1 = -1;
        this.scoreT2 = -1;
        this.referee = "PRUEBA";
        this.day = 1;
        this.month = 1;
        this.year = 2000;
        this.eLocal = eLocal;
        this.eVisit = eVisit;
    }
    
    public Partido() {
    	this.scoreT1 = -1;
        this.scoreT2 = -1;
        this.referee = "PRUEBA";
        this.day = 1;
        this.month = 1;
        this.year = 2000;
        this.eLocal = -1;
        this.eVisit = -1;
	}

	public Partido(int scoreT1, int scoreT2, String referee, int day, int month, int year, int eLocal, int eVisit) {
        this.scoreT1 = scoreT1;
        this.scoreT2 = scoreT2;
        this.referee = referee;
        this.day = day;
        this.month = month;
        this.year = year;
        this.eLocal = eLocal;
        this.eVisit = eVisit;
    }

    public int geteLocal() {
		return eLocal;
	}

	public void seteLocal(int eLocal) {
		this.eLocal = eLocal;
	}

	public int geteVisit() {
		return eVisit;
	}

	public void seteVisit(int eVisit) {
		this.eVisit = eVisit;
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

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

    
    
    
}
