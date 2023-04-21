package back;

public class BloodStatus {
    private int id;
    private String rhdPlusA;
    private String rhdPlusB;
    private String rhdPlusAB;
    private String rhdPlus0;
    private String rhdMinusA;
    private String rhdMinusB;
    private String rhdMinusAB;
    private String rhdMinus0;

    public BloodStatus(int id, String rhdPlusA, String rhdPlusB, String rhdPlusAB, String rhdPlus0,
                       String rhdMinusA, String rhdMinusB, String rhdMinusAB, String rhdMinus0) {
        this.id = id;
        this.rhdPlusA = rhdPlusA;
        this.rhdPlusB = rhdPlusB;
        this.rhdPlusAB = rhdPlusAB;
        this.rhdPlus0 = rhdPlus0;
        this.rhdMinusA = rhdMinusA;
        this.rhdMinusB = rhdMinusB;
        this.rhdMinusAB = rhdMinusAB;
        this.rhdMinus0 = rhdMinus0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRhdPlusA() {
        return rhdPlusA;
    }

    public void setRhdPlusA(String rhdPlusA) {
        this.rhdPlusA = rhdPlusA;
    }

    public String getRhdPlusB() {
        return rhdPlusB;
    }

    public void setRhdPlusB(String rhdPlusB) {
        this.rhdPlusB = rhdPlusB;
    }

    public String getRhdPlusAB() {
        return rhdPlusAB;
    }

    public void setRhdPlusAB(String rhdPlusAB) {
        this.rhdPlusAB = rhdPlusAB;
    }

    public String getRhdPlus0() {
        return rhdPlus0;
    }

    public void setRhdPlus0(String rhdPlus0) {
        this.rhdPlus0 = rhdPlus0;
    }

    public String getRhdMinusA() {
        return rhdMinusA;
    }

    public void setRhdMinusA(String rhdMinusA) {
        this.rhdMinusA = rhdMinusA;
    }

    public String getRhdMinusB() {
        return rhdMinusB;
    }

    public void setRhdMinusB(String rhdMinusB) {
        this.rhdMinusB = rhdMinusB;
    }

    public String getRhdMinusAB() {
        return rhdMinusAB;
    }

    public void setRhdMinusAB(String rhdMinusAB) {
        this.rhdMinusAB = rhdMinusAB;
    }

    public String getRhdMinus0() {
        return rhdMinus0;
    }

    public void setRhdMinus0(String rhdMinus0) {
        this.rhdMinus0 = rhdMinus0;
    }
}
