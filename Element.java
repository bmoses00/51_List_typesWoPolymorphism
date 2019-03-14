public class Element {
    private int intValue;
    private double doubleValue;
    private String stringValue;
    private int type;

    public Element(int intValue
                 , double doubleValue
                 , String stringValue
                 , int type) {
        this.intValue = intValue;
        this.doubleValue = doubleValue;
        this.stringValue = stringValue;
        this.type = type;
    }

    public String toString() {
        if (type == 0) return ""+intValue;
        if (type == 1) return ""+doubleValue;
        if (type == 2) return ""+stringValue;
        return ""; // in case of failure
    }
}
