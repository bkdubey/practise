package geeksforgeeks.array;

import java.util.ArrayList;
import java.util.Arrays;

public class BalanceArray {
    public static void main(String[] args) {
    ArrayList<Integer> arr=  new ArrayList<Integer>(Arrays.asList(2,1,6,4));
        System.out.println("balance array count "+balanceArray(arr));
        ArrayList<Integer> arr1=  new ArrayList<Integer>(Arrays.asList(5,5,2,5,8));
        System.out.println("balance array count "+balanceArray(arr1));

        // wrong ...... also  , it's not working for below case ... need to revisit ....
        //self creating test case now
        ArrayList<Integer> arr2=  new ArrayList<Integer>(Arrays.asList(2, 8, 2, 2, 6, 3));
        System.out.println("balance array count "+balanceArray(arr2));
    }
    public static int balanceArray(ArrayList<Integer> A){
        if(A.size()==1){return 1 ; }
        int evenSum=0; int oddSum=0; int output=0;
        for(int i=0;i<A.size();i++)
        {
            if(i%2==0) { evenSum=A.get(i)+evenSum;}
            if(!(i%2==0) || i==0) { oddSum=A.get(i)+oddSum;}
        }

        for(int i=0;i<A.size()/2;i++)
        {
            if(evenSum-A.get(i)==oddSum){ output++;}
            if(oddSum-A.get(i)==evenSum){ output++;}
            if(oddSum-A.get(i) == evenSum-A.get(i)){ output++;}

        }
       System.out.println("o/p is"+output);

        System.out.println("even "+evenSum+"odd "+oddSum);

        return output;
    }
}
