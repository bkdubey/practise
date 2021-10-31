package geeksforgeeks.array.rearrange;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

//note - if you are not able to understand , please do debug on Timsort .
//

public class ConstructBiggestNumber {
    /*
    * Given an array of numbers, arrange them in a way that yields the largest value.
    * For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value.
     * And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the
     * largest value.
     *
     * i/p- {54, 546, 548, 60} o/p -6054854654
     * i/p- {1, 34, 3, 98, 9, 76, 45, 4} o/p- 998764543431
    * */
    static Vector printLargest(Vector<String> arr)
    {

        Collections.sort(arr, new Comparator<String>()
        {
            // A comparison function which is used by
            // sort() in printLargest()
            @Override public int compare(String X, String Y)
            {
                System.out.println("val"+arr);
                // first append Y at the end of X
                String XY = X + Y;

                // then append X at the end of Y
                String YX = Y + X;
                System.out.println("round"+"xy "+XY+" yx "+YX);
                // Now see which of the two
                // formed numbers
                // is greater
                int result= XY.compareTo(YX) > 0 ? -1 : 1;
               //or   result= YX.compareTo(XY) ;
                return result;
            }
        });
        return arr;

    }

    // Driver code
    public static void main(String[] args)
    {

        Vector<String> arr;
        arr = new Vector<>();

        // output should be 6054854654
        //arr.add("54");
        arr.add("58");
        arr.add("546");
        arr.add("60");

        arr.add("548");
//       arr.add("60");
        // adding more ele for debugging
       /* arr.add("40");
        arr.add("30");
        arr.add("20");
        arr.add("10");
        arr.add("5");
        arr.add("9");*/

        arr=printLargest(arr);
        Iterator it = arr.iterator();

        while (it.hasNext())
            System.out.print(it.next());
    }
}
