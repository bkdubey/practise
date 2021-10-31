package interviewbit.binarysearch;

import java.util.ArrayList;

public class woodCut {
    public static void main(String[] args) {
        int arr [] = {20,15,10,17};
        //wood should not be wasted , give me correct height
        System.out.println("able to cut at hight level ---"+ new  woodCut().woodcut(arr,7));  //expected 15

        int arr1 [] = {4, 42, 40, 26, 46};
        //wood should not be wasted , give me correct height
        System.out.println("able to cut at hight level ---"+ new  woodCut().woodcut(arr1,20));  //expected 36

    }

    public long woodcut(int tree[], long requiredWood){
        int minArr=0; int maxArr=Integer.MIN_VALUE;
        int size= tree.length;
        for(int i=0;i<size;i++) // calculating max
        {
           // minArr=Math.min(minArr,tree[i]);
            maxArr=Math.max(maxArr,tree[i]);
        }
        System.out.println("max "+maxArr + "min "+minArr);
        int result=-1;
        while(minArr <= maxArr){ // calculating wood from min to max
            int mid= minArr +  ((maxArr-minArr)/2);
            long wood =0;
            for(int i=0; i < size;i++) // calculating wood at given level , for each index(tree) of array
            {
               // this is imp condition .......
                if(tree[i]-mid>0){ // tree height should be greater for cutting axe ,
                   // if it's not binary then substract level i.e. tree[i]-level
                    // ** very good ex. like your height of tree is 10 and axe level is 15 so it can not cut tree ...so ignore
                wood = wood+tree[i]-mid; // ex - 20 ,15,10,17 -->say when reached 15 --> 5+0+0+2=7
                    // like   20-15+ 15-15 + 10-15 + 17-15 = 7 , now 10-15 will be -ve so ignored in if condition
                    // note - if level(mid) will increases then wood will be less .
               }
            }
            if(wood >=requiredWood) { // this can true at height of 0,5,10,15
                minArr = mid+1;
                result =Math.max(result,mid);

            }else {
                maxArr = mid-1;
            }

        }



        return result;
    }

    public long woodcut(ArrayList<Integer> A, int B)
{
    int[] tree =  A.stream().mapToInt(i -> i).toArray();;long requiredWood=B;
    int minArr=0; int maxArr=Integer.MIN_VALUE;
    int size= tree.length;
    for(int i=0;i<size;i++)  // finding max
    {
        // minArr=Math.min(minArr,tree[i]);
        maxArr=Math.max(maxArr,tree[i]);
    }
   // System.out.println("max "+maxArr + "min "+minArr);
    int result=-1;
    while(minArr <= maxArr){ // calculating wood from min to max
        int mid= minArr +  ((maxArr-minArr)/2);
        long wood =0;
        for(int i=0; i < size;i++) // calculating wood at given level
        {
            if(tree[i]-mid>0){
                wood = wood+tree[i]-mid;}
        }
        if(wood >=requiredWood) { // this can true at height of 0,5,10,15
            minArr = mid+1;
            result =Math.max(result,mid);

        }else {
            maxArr = mid-1;
        }

    }



    return result;
}

}
