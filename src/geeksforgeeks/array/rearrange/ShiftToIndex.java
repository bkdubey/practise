package geeksforgeeks.array.rearrange;

import geeksforgeeks.utility.PrintArray;

public class ShiftToIndex {
    /*
    * Input: arr[]  = {1, 3, 0, 2};
    Output: arr[] = {2, 0, 3, 1};
    Explanation for the above output.
    Since arr[0] is 1, arr[1] is changed to 0
    Since arr[1] is 3, arr[3] is changed to 1
    Since arr[2] is 0, arr[0] is changed to 2
    Since arr[3] is 2, arr[2] is changed to 3

    * */
    public static void main(String[] args) {
        int arr[]  = {1, 3, 0, 2};
        System.out.println();
        PrintArray.printArray(arrange(arr));
        System.out.println();
        int arr1[]  = {2, 0, 1, 4, 5, 3}; // o/p -Output: arr[] = {1, 2, 0, 5, 3, 4};
        PrintArray.printArray(arrange(arr1));
        System.out.println();
        int arr2[]  = {3, 2, 1, 0};; // o/p -Output: arr[] = {1, 2, 0, 5, 3, 4};
        PrintArray.printArray(arrange(arr2));

        //
        System.out.println();
        System.out.println("2nd approach");
        int arr3[]  = {1, 3, 0, 2};

        PrintArray.printArray(rearrangeBySpecialShuffle(arr3));


    }

    public static int[] arrange(int arr[])
    {
        int temp[]=new int[arr.length];

        for(int i=0;i<arr.length;i++){
               temp[arr[i]]=i ;
        }
        return temp;
    }


    /*
    * For example, Suppose an element’s new value is 2, the old value is 1 and n is 3,
    * then the element’s value is stored as 1 + 2*3 = 7.
    * We can retrieve its old value by 7%3 = 1 and its new value by 7/3 = 2.
    * */
    public static int[] rearrangeBySpecialShuffle(int arr[]){
        int n=arr.length;
        for (int i = 0; i < n; i++) {

            // retrieving old value and
            // storing with the new one
            //System.out.println("arr[arr[i] % n]"+arr[arr[i] % n]);
            System.out.print("before operation -->");
            PrintArray.printArray(arr);
            //System.out.println();
            arr[arr[i] % n] += i * n;
            System.out.print("after operation  -->");
            PrintArray.printArray(arr);
            /* arr= 1 3 0 2
            arr[arr[i] % n] = arr[arr[i] % n]+ i * n => arr[arr[1]%4] => arr[3%4] => a[3] => 2+i(1)+4=> 6
            //arr[3] = 2+1*4 =6
            */
            System.out.println();
           // System.out.println("arr[arr[i] % n]"+arr[arr[i] % n]+"arr[i]"+arr[i]);
        }

        for (int i = 0; i < n; i++) {

            // retrieving new value
            arr[i] /= n;
        }
        return  arr;
    }
}
