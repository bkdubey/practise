package geeksforgeeks.array;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxUnsortedSubArray {
    /*1) If the input array is
    [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60],
    your program should be able to find that the subarray lies between the
     ----indexes 3 and 8.
            2) If the input array is
            [0, 1, 15, 25, 6, 7, 30, 40, 50],
    your program should be able to find that the subarray lies between the
    -------indexes 2 and 5.*/
    public static void main(String[] args) {

        int arr[] ={10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};

        //printIndexofUnbalnceArray(arr);
        int arr2[] ={0, 1, 15, 25, 6, 7, 30, 40, 50};
        //printIndexofUnbalnceArray(arr2);

        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1); A.add(3);A.add(2); A.add(4); A.add(5);
      //  System.out.println("subarray index  are "+ printUnbalanceSubArray(A));

        ArrayList<Integer> A1 = new ArrayList<Integer>();
        A1.add(0); A1.add(1);A1.add(15); A1.add(25); A1.add(6);
        A1.add(7); A1.add(30);A1.add(40); A1.add(50);// A1.add(6);
       //System.out.println("subarray index  are "+ printUnbalanceSubArray(A1));


        ArrayList<Integer> A2 = new ArrayList<Integer>();
        A2.add(1); A2.add(1);A2.add(10); A2.add(10); A2.add(15);
        A2.add(10); A2.add(15);A2.add(10); A2.add(10); A2.add(15); A2.add(10); A2.add(15);
        System.out.println("subarray index  are "+ printUnbalanceSubArray(A2));


    }

   public static void printIndexofUnbalnceArray(int arr[]){
        int subArrayStartIndex=0; int subArrayEndIndex=0; int size=arr.length;
        for(int i=0;i<size;i++)
        {
            if( ! (arr[i+1] > arr[i]))
            {   subArrayStartIndex=i;
                break;
            }
        }
       for(int i=size-1;i>=0;i--)
       {
           if( ! (arr[i-1] < arr[i]))
           {   subArrayEndIndex=i;
               break;
           }
       }
       System.out.println("subArrayStartIndex & subArrayEndIndex "+subArrayStartIndex+" -- "+subArrayEndIndex);
       int min=arr[subArrayStartIndex]; int max=arr[subArrayStartIndex];

       for(;subArrayStartIndex<subArrayEndIndex;)
       {    int curr=arr[subArrayStartIndex++];
           if( curr > max )
           {
               max=curr;
           }
           if(curr < min)
           {
               min= curr;
           }
       }
       System.out.println("max & min are "+ max +" --" + min);

       for(int i=0 ; i <subArrayEndIndex;i++ )
       {
           if(arr[i] > min)
           {
               System.out.println("start index "+i);
               break;
           }
       }

       for(int i=subArrayEndIndex ; i <size;i++ )
       {
           if(arr[i] < max )
           {
               System.out.println("end index "+ (i+1));
               break;
           }
       }

   }

    public static ArrayList<Integer> printUnbalanceSubArray(ArrayList<Integer> A){
        ArrayList<Integer> result= new ArrayList<Integer>();
        int subArrayStartIndex=0; int subArrayEndIndex=0; int size=A.size();
        int counter=0;
        for(int i=0;i<size-1;i++)
        {
            if((A.get(i+1)>=A.get(i))){counter++;}
            else break;
        }
        if(size==counter+1)
        {
             result.add(-1);
             return  result;
        }

        for(int i=0;i<size-1;i++)
        {
            if( ! (A.get(i+1) >= A.get(i)))
            {   subArrayStartIndex=i;
                break;
            }
        }
        for(int i=size-1;i>=0;i--)
        {
            System.out.println("debug "+A.get(i-1)+"...."+A.get(i));
            if( ! (A.get(i-1) <= A.get(i)))
            {   subArrayEndIndex=i;
                break;
            }
        }
        System.out.println("subArrayStartIndex & subArrayEndIndex "+subArrayStartIndex+" -- "+subArrayEndIndex);
        int min=A.get(subArrayStartIndex);
        int max=A.get(subArrayStartIndex);

        for(;subArrayStartIndex<=subArrayEndIndex;)
        {    int curr=A.get(subArrayStartIndex++);
            if( curr > max )
            {
                max=curr;
            }
            if(curr < min)
            {
                min= curr;
            }
        }
        System.out.println("max & min are "+ max +" --" + min);

        for(int i=0 ; i <subArrayEndIndex;i++ )
        {
            if(A.get(i) > min)
            {
                System.out.println("start index "+i);result.add(i);
                break;
            }
        }

        for(int i=size-1 ; i >0;i-- )
        {
            if(A.get(i) < max )
            {
                System.out.println("end index "+ (i)); result.add((i));
                break;
            }
        }

        return result;
    }


}





