package controller;

public class CaseObject {

    private Case type;
    private int x, y, number, i;
    private boolean ib;

    public CaseObject(Case type, int x, int y, int number) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.number = number;
        i = 0;
    }

    public Case getType() {
        return type;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getNumber() {
        return number;
    }

    public void incrementI() {
        i++;
        if (ib)
            if (i == 5)
                this.type = Case.BLACK;
    }

    public void setIb() {
        this.ib = true;
    }

    public boolean isIb() {
        return ib;
    }

    public void setType(Case type) {
        this.type = type;
    }
}
