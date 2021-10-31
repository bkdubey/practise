package geeksforgeeks.array;

import geeksforgeeks.utility.PrintArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class FindPeak {
    public static void main(String[] args) {

        int array[]= {5, 10, 20, 15};
        findPeak(array);
        int array1[] = {10, 20, 15, 2, 23, 90, 67};
        findPeak(array1);
        int array2[] ={10, 20, 30, 40, 50};        findPeak(array2);

        int array3[] ={100, 80, 60, 50, 20};         findPeak(array3);

        int arr4[] = { 1, 3, 20, 4, 1, 0 };  findPeak(arr4);

        int ar1[] = {5, 1, 4, 3, 6, 8, 10, 7, 9}; perfectPeak(ar1);


        ArrayList<Integer> list =
                new ArrayList<Integer>(Arrays.asList(5,1,4,3,6,8,10,7,9));

        System.out.println("perfect peak exist "+perfectPeak(list));

        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(5,1,4,4));

        System.out.println("perfect peak exist "+perfectPeak(list1));

        ArrayList<Integer> list2 =
                new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 3, 10));

        System.out.println("perfect peak exist ---"+perfectPeak(list2));

        ArrayList<Integer> list3 =
                new ArrayList<Integer>(
                        Arrays.asList(23246, 2866, 15945, 25509, 27871, 28319, 9602, 28324, 18541, 28290 ));

        System.out.println("perfect peak exist ---"+perfectPeak(list3));

    }

    public static void findPeak(int arr[]){
      int peak=arr[0]; int size=arr.length;
       int next; int curr;
      for(int i=0;i<size-1;i++)
      {    curr=arr[i];
          next=arr[i+1];

      //    System.out.println("curr"+curr+"next "+ next +"peak"+ peak);
          if(curr < next  )
          {
              peak=next;

          }
      }
        System.out.println("peak is "+peak);
    }

    // not working
    public static int perfectPeak(int  arr[]) {
        int size =arr.length;
        int max=arr[0]; int peak=0;
        for(int i=0;i<size-1;i++)
        {
            if(max < arr[i+1]){
                System.out.println("peak "+max);
                peak=max;
            }
            if(arr[i] < arr[i+1] )
            {
                max=arr[i+1];
            }

        }
        System.out.println("peak is ");
        return 0;
    }


    public static int perfectPeak(ArrayList<Integer>  A) {
        int size =A.size();
        int maxArr[] =new int[A.size()];
        int minArr[] = new int[A.size()];


        //maxArr[0]=A.get(0);
        //minArr[size-1]=A.get(size-1);
        int max=Integer.MIN_VALUE; int min=Integer.MAX_VALUE;
        for(int i=0;i<size;i++)
        {
            max=Math.max(max,A.get(i));
            maxArr[i]=max;
        }

        for(int i=size-1;i>=0;i--)
        {
            min=Math.min(min,A.get(i));
            minArr[i]=min;
        }

        for(int i=1;i<size-1;i++)
        {
           // System.out.println("A.get(i)"+A.get(i)+"maxArr[i]"+ maxArr[i]+ "minArr[i]"+minArr[i]);
          //  if( map.containsKey(A.get(i)==maxArr[i] && A.get(i) ==minArr[i] && map.get(A.get(i))==1))
           // if(A.get(i)==maxArr[i] && A.get(i) ==minArr[i])
            if(A.get(i) > maxArr[i-1] && A.get(i) < minArr[i+1])

                {
                return 1;
            }
        }
        return 0;
    }

}
