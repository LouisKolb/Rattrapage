package controller;

public enum Case {

    BLACK(0),
    GRAY(1),
    RED(2);

    int type;

    Case(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public static Case getCaseType (int id) {
        for (Case groupEnum : values()) {
            if (groupEnum.getType() == id) {
                return groupEnum;
            }
        }
        return null;
    }

}
