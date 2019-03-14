/**
  Implement a list of diverse types, including
  integers, double-precision floating point numbers,
  and Strings.
 */

	
public class List_inArraySlots {

    private int[]    intElements;
    private double[] doubleElements;
    private String[] stringElements;
    private int filledElements; // the number of elements in this list
	
	private TypeOfElements[] typeOfElements;
    /* type identifier for each element
       That is, typeOfElements[i] == 0 means element i is an integer;
                                     1 means element i is a double;
                                     2 means element i is a String.
        Optional extra education in programming (not comp sci):
            replace these "magic numbers" with an "enumerated type".
     */
    //private String[] typeOfElements;

    private static final int INITIAL_CAPACITY = 10;

    /**
      Construct an empty list with a small initial capacity.
     */
    public List_inArraySlots() {
        intElements = new int[INITIAL_CAPACITY];
        doubleElements = new double[INITIAL_CAPACITY];
        stringElements = new String[INITIAL_CAPACITY];
        typeOfElements = new TypeOfElements[INITIAL_CAPACITY];
    }


    /**
      @return the number of elements in this list
     */
    public int size() {
        return filledElements;
    }


     /**
       @return a string representation of this list,
       in [a,b,c,] format
      */
    public String toString() {
        String output = "[";
        for (int index = 0; index < filledElements; index++) {
            if (typeOfElements[index] == TypeOfElements.INTEGER) output += intElements[index] + ",";
            if (typeOfElements[index] == TypeOfElements.DOUBLE) output += doubleElements[index] + ",";
            if (typeOfElements[index] == TypeOfElements.STRING) output += stringElements[index] + ",";
        }
        return output + "]";
    }


    /**
      Appends @value to the end of this list.
      @return true, in keeping with conventions yet to be discussed
     */
     public boolean add( String type   // same meaning as in typeOfElements
                       , int    intValue
                       , double doubleValue
                       , String stringValue
                       ) {
          if (filledElements == intElements.length)
              expand();
          if (TypeOfElements.valueOf(type) == TypeOfElements.INTEGER) intElements[filledElements] = intValue;
          if (TypeOfElements.valueOf(type) == TypeOfElements.DOUBLE) doubleElements[filledElements] = doubleValue;
          if (TypeOfElements.valueOf(type) == TypeOfElements.STRING) stringElements[filledElements] = stringValue;

          typeOfElements[filledElements] = TypeOfElements.valueOf(type);
          filledElements++;
          return true;
     }

     public Element get(int index) { // currently highly inefficient
         if (typeOfElements[index] == TypeOfElements.INTEGER) return new Element(intElements[index], -1.0, "junk", 0);
         if (typeOfElements[index] == TypeOfElements.DOUBLE) return new Element(-1, doubleElements[index], "junk", 1);
         if (typeOfElements[index] == TypeOfElements.STRING) return new Element(-1, -1.0, stringElements[index], 2);
         return new Element(-1, -1.0, "junk", 0); // in case of failure
     }
     /**
       Double the capacity of the List_inArraySlots,
       preserving existing data.
      */
     private void expand() {

       int[] expandedIntElements = new int[intElements.length * 2];
       double[] expandedDoubleElements = new double[doubleElements.length * 2];
       String[] expandedStringElements = new String[stringElements.length * 2];
       TypeOfElements[] expandedTypeElements = new TypeOfElements[typeOfElements.length * 2];
       // expand everything to avoid index out of range errors
       // intELements.length same as others.length

       for (int index = 0; index < intElements.length; index++) {
             expandedIntElements[index] = intElements[index];
             expandedDoubleElements[index] = doubleElements[index];
             expandedStringElements[index] = stringElements[index];
             expandedTypeElements[index] = typeOfElements[index];
             //System.out.println(intElements[index]);
       }

       intElements = expandedIntElements;
       doubleElements = expandedDoubleElements;
       stringElements = expandedStringElements;
       typeOfElements = expandedTypeElements;

     }
}
