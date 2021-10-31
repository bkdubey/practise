package geeksforgeeks.array.rotation;

import java.util.HashMap;
import java.util.HashSet;

public class FindSumPair {
    public static void main(String[] args) {
        //int arr[] = {11, 15, 6, 8, 9, 10};         int x = 16; // o/p true - exist
        //int arr[] = {11, 15, 26, 38, 9, 10};  int x = 45; // false
        int arr[] = {11, 15, 26, 38, 9, 10};
        int x = 35; // true

        System.out.println(pairExist(arr, x));
        // approach - minis the array element from sum .

        //use sorting and alternate approach
        int arrTemp[] = {6, 8, 9, 10, 11, 15};
        arr = arrTemp;
        x = 16; // pre-requisite sorting
        System.out.println("findSumPairUsing2Pointer - " + findSumPairUsing2Pointer(0, arrTemp.length - 1, arrTemp, x));
    // or without recursion .. . 2nd approch
        //while (l < r)  using iterative

        // 3rd approach , using hashing , optimized soln
        int arrt[] = {0, -1, 2, -3, 1};
        arr=arrt; x=-2;
        System.out.println("findSumPairUsingHashing - " + findSumPairUsingHashing(0, arr.length - 1, arr, x));
        System.out.println("findSumPairUsingHashing - " + findSumPairUsingHashing(0, arrTemp.length - 1, arrTemp, 16));
        /* visualize of step
        arr[] = {0, -1, 2, -3, 1}
        sum = -2
        Now start traversing:
        Step 1: For ‘0’ there is no valid number ‘-2’ so store ‘0’ in hash_map. (note -store as a key .. )
        Step 2: For ‘-1’ there is no valid number ‘-1’ so store ‘-1’ in hash_map.
        Step 3: For ‘2’ there is no valid number ‘-4’ so store ‘2’ in hash_map.
        Step 4: For ‘-3’ there is no valid number ‘1’ so store ‘-3’ in hash_map.  -->hm(-3, 4)
     Step 5: For ‘1’ there is a valid number ‘-3’ so answer is 1, -3     ---> 1-(-2) , 3 exist in map so return
        *
        * algo >
        * hm.add(arr[i]-sum,i)
        * for
        *   if(arr[i]-sum.contain in map ) return a[i], contains value , else add(arr[i]) .
        * */

    }

    public static boolean pairExist(int a[], int sum) {
        for (int i = 0; i < a.length; i++) {
            int tempSum = sum;
            //tempSum = tempSum - a[i];
            for (int j = i + 1; j < a.length; j++) {
                tempSum = tempSum - a[i] - a[j];
                if (tempSum == 0) {
                    return true;
                } else {
                    tempSum = sum;
                }

            }
        }
        return false;
    }

    public static String result="na";

    public static String findSumPairUsing2Pointer(int low, int high, int a[], int sum) {
        System.out.println("low " + low + "-" + a[low] + "high" + high + "-" + a[high] + "sum" + sum + "sum of val " + (a[low] + a[high]));
        if ((a[low] + a[high]) == sum) {
            result=low + "," + high;
            System.out.println("returning sum index "+result);
            return result;
        }
        if (low == high) {
            return "not available";
        }
        if ((a[low] + a[high]) > sum) {       high--;
            System.out.println("searching in if");
            findSumPairUsing2Pointer(low, high, a, sum);
        } else {              low++;
            System.out.println("searing in else");
            findSumPairUsing2Pointer(low, high, a, sum);
        }
        return result;
    }

    public static String findSumPairUsingHashing(int low, int high, int a[], int sum) {
        System.out.println("low -" + low + "-" + a[low] + "high" + high + "-" + a[high] + "sum" + sum + "sum of val " + (a[low] + a[high]));
        HashMap hm= new HashMap();
        int index=sum-a[0];
        hm.put(a[0],0); int temp;
        for(int i=1;i<a.length;i++)
        {   index=sum-a[i];
            if(hm.containsKey((index))){return "indexes are :"+i+","+hm.get(index)+"and value are "+a[i]+","+index;}
            else {
                hm.put(a[i],i);
            }
        }
                return "na";
    }


}
