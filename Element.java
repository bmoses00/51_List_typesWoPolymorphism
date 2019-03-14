public class Element {
	private String type;
    private int intValue;
    private double doubleValue;
    private String stringValue;

    public Element(String type,
				   int intValue
                 , double doubleValue
                 , String stringValue) {
		this.type = type;
	    this.type = type;
        this.intValue = intValue;
        this.doubleValue = doubleValue;
        this.stringValue = stringValue;
    }

    public String toString() {
        if (TypeOfElements.valueOf(type) == TypeOfElements.INTEGER) return ""+intValue;
        if (TypeOfElements.valueOf(type) == TypeOfElements.DOUBLE) return ""+doubleValue;
        else return ""+stringValue;
    }
}
