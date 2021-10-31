package geeksforgeeks.array.rearrange;

import geeksforgeeks.utility.PrintArray;

public class RearragnefoIndex {
    public static void main(String[] args) {
        int arr[] = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
            //o/pOutput : [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]  // number to move it it's index position
        /* 1st approach
        A Simple Solution is to create a temporary array and
        one by one copy ‘i’ to ‘temp[arr[i]]’ where i varies from 0 to n-1.
         time - o(n) space - o(n)
         */

        PrintArray.printArray(rearrange(arr)); //

        //2nd approch using swapping . a=a+b*n


    }
    public static int [] rearrange(int arr[]){
        int temp[] = new int[arr.length]; boolean flag=false;
        for(int i=0;i<arr.length;i++){

            if(arr[i]>0) {temp[arr[i]]=arr[i]; }
            if(arr[i]==0){flag=true;}
        }

        for(int i=0;i<arr.length;i++){
         if(temp[i]==0){ temp[i]=-1;}
        }
        if(flag){temp[0]=0;}


        return temp;
    }

}
