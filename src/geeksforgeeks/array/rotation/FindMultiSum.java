package geeksforgeeks.array.rotation;

public class FindMultiSum {
    //Sum( i*arr[i])  , need to get max by rotation only
    /*      Input: arr[] = {1, 20, 2, 10}
Output: 72
We can get 72 by rotating array twice.
{2, 10, 1, 20}
20*3 + 1*2 + 10*1 + 2*0 = 72
      *
       * */
    public static void main(String[] args) {
    int arr[] = {10,1,2,3,4,5,6,7,8,9};
    //int arr[]= {1, 20, 2, 10};

        System.out.println("max element is at index "+findMax(arr));
        int requireRotation= (arr.length-1)-findMax(arr);
        System.out.println("required rotation "+requireRotation);
        arr=rotateNtime(arr,requireRotation);
        RotateArray.printArray(arr);
        System.out.println("calculation of sum(i*a[*])"+sumMulti(arr));

    }
    public static int sumMulti(int a[])
    {   int sumMult=0;
        for(int i=0;i<a.length;i++)
        {
            sumMult=sumMult+i*a[i];
        }
        return sumMult;
    }

    public static int [] rotateNtime(int a[],int rotation){
        //logic is -- first store last element in temp , then push a[length] = a[legth-1]
        int temp=-1;
        int j=0; int length=a.length-1;
        while (j<rotation){
            temp= a[a.length-1];
            for (int i = 0; i < length ; i++) {
                a[length-i]=a[length-i-1];
            }
            a[0]=temp;
            j++;}

        return a;
    }
    public void multiSum(){

    }
    public static int findMax(int a[]){
        int max=a[0]; int index=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i]>max){ max=a[i]; index=i;}
        }
        System.out.println("max element"+max);
        return index;
    }
}
