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

    /* type identifier for each element
       That is, typeOfElements[i] == 0 means element i is an integer;
                                     1 means element i is a double;
                                     2 means element i is a String.
        Optional extra education in programming (not comp sci):
            replace these "magic numbers" with an "enumerated type".
     */
    private int[] typeOfElements;

    private static final int INITIAL_CAPACITY = 10;

    /**
      Construct an empty list with a small initial capacity.
     */
    public List_inArraySlots() {
        intElements = new int[INITIAL_CAPACITY];
        doubleElements = new double[INITIAL_CAPACITY];
        stringElements = new String[INITIAL_CAPACITY];
        typeOfElements = new int[INITIAL_CAPACITY];
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
            if (typeOfElements[index] == 0) output += intElements[index] + ",";
            if (typeOfElements[index] == 1) output += doubleElements[index] + ",";
            if (typeOfElements[index] == 2) output += stringElements[index] + ",";
        }
        return output + "]";
    }


    /**
      Appends @value to the end of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean add( int type   // same meaning as in typeOfElements
                       , int    intValue
                       , double doubleValue
                       , String stringValue
                       ) {
          if (filledElements == intElements.length)
              expand();
          if (type == 0) intElements[filledElements] = intValue;
          if (type == 1) doubleElements[filledElements] = doubleValue;
          if (type == 2) stringElements[filledElements] = stringValue;

          typeOfElements[filledElements] = type;
          filledElements++;
          return true;
     }


    /**
      Double the capacity of the List_inArraySlots,
      preserving existing data.
     */
     private void expand() {

       int[] expandedIntElements = new int[intElements.length * 2];
       double[] expandedDoubleElements = new double[doubleElements.length * 2];
       String[] expandedStringElements = new String[stringElements.length * 2];
       int[] expandedTypeElements = new int[typeOfElements.length * 2];
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
