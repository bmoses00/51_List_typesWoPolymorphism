/**
  Implement a list of diverse types, including
  integers, double-precision floating point numbers,
  and Strings.
 */

public class List_inArraySlots {

    private Element[] elements;
    private int filledElements; // the number of elements in this list

    private static final int INITIAL_CAPACITY = 10;

    /**
      Construct an empty list with a small initial capacity.
     */
    public List_inArraySlots() {
        elements = new Element[INITIAL_CAPACITY];
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
            output += elements[index] + ",";
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
          if (filledElements == elements.length)
              expand();
          elements[filledElements] = new Element(type, intValue, doubleValue, stringValue);

          filledElements++;
          return true;
     }


     public Element get(int index) { // currently highly inefficient
         return elements[index]; // in case of failure
     }
	 
	 
     /**
       Double the capacity of the List_inArraySlots,
       preserving existing data.
      */
     private void expand() {
		 Element[] expandedElements = new Element[elements.length * 2];

		 for (int index = 0; index < elements.length; index++) {
             expandedElements[index] = elements[index];
	     }
		 elements = expandedElements;
     }
}
