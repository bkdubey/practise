package geeksforgeeks.search;

import geeksforgeeks.array.rotation.RotateArray;

public class Search {
    public static void main(String[] args) {
        //int a[] = {1, 2, 3, 4, 5, 6, 7};
        int a[] = {3,4,5,1,2};
        binarySearch(a, 5);
        int searchEle=1;
        a=rotation(a);
        RotateArray.printArray(a);
        System.out.println("element at"+binarySearchRecurse(a,0, a.length / 2, a.length-1 ,searchEle));

        //or refer for more sol -
        //search-an-element-in-a-sorted-and-pivoted-array/
    }

    public static void binarySearch(int arr[], int toSearch) {

    }
        static int result=-1;
    public static int binarySearchRecurse(int arr[],int low, int mid, int high ,int searchEle    ) {
        System.out.println("low"+low+"mid"+mid+"high"+high+"searchele"+searchEle);
        if(arr[mid]==searchEle){ result=mid;
            System.out.println("element found at index"+result);
            return result;
        }
        if(arr[high]==searchEle){ result=high;
            System.out.println("element found at index --"+result);
            return result;
        }
        if(arr[mid]>searchEle){
            binarySearchRecurse(arr,low,(low+mid)/2,mid,searchEle);
        }
        else if(arr[high]>searchEle) { low=(mid+high)/2;
                binarySearchRecurse(arr,low, (low+high)/2,high,searchEle);
        }
        return result;
    }

    public static int [] rotation(int a[])
    {   int lastIndx=a.length-1;
        while(a[0]>a[lastIndx]){
            int tempIndx=lastIndx; // this was before loop , and due to that prog was issue .
        int temp=a[lastIndx];
        for(int i=1;i<a.length;i++){
            a[tempIndx] =a[lastIndx-i];
            tempIndx=lastIndx-i;
            RotateArray.printArray(a);
        }
          a[0]=temp;
            System.out.println("values are "+ " "+a[0]+" "+a[lastIndx]);

        }
        return a;
    }
}
