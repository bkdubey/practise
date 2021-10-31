package geeksforgeeks.array.rotation;

import geeksforgeeks.general.GCD;

public class RotateArray {
    static int  a[]={1,2,3,4,5,6,7};
    static int rotateBy = 3;
    public static void main(String[] args) {
        //rotate by d elements , by 2 ex - 3,4,5,6,7,1,2
        //1st way - using temp array
        rotate(a,rotateBy);
        System.out.println("rotate by n");
        rotateByN(a,rotateBy); // rotate n time , 2nd way
        printArray(a);

        //3rd way
        //using gcd and get rotate inside subset .
        //array-rotation/
        System.out.println("#################");
        int arr1[] ={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        printArray(rotationUsingGCD(arr1,3));

    }

    public static int[] rotationUsingGCD(int[] a,int d) {
        int gcd= GCD.gcd(a.length,d);
        System.out.println("gcd is "+gcd);
        int moveingIndex=a.length-gcd; int temp;int m1=gcd-1;
        for(int i=0;i<gcd;i++)
        {       temp=a[i];

            printArray(a);
            int j=i;
            while (true){
                a[j]=a[j+gcd];
                j=j+gcd;
                ; m1--;
                if(m1<0 ){  break;}

                System.out.println("prev"+a[j]+ " "+a[j+gcd]);
            }
            a[j]=temp; m1=gcd-1;

        }
        return a;
    }

    //time complexity - o(n) and space 0(d)
    //approach - by adding in temp array
    public static void rotate(int []arr, int d)
    {
        int temp[] = new int[arr.length];
        for(int i=d;i<arr.length;i++)
        {
            temp[i-d]=arr[i];
        }
        int tempVar=arr.length-d;
        for(int i=0;i<d;i++)
        {
            temp[tempVar++]=arr[i];
        }
        arr=temp;

        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+"_");
    }

    //time complexity - o(n*d) , d is number of rotation and space 0(1)
    //approach - by rotating array by 1 index till d

    public static void rotateByN(int arr[],int d){
        for(int i=0;i<d;i++){
            rotation(arr,d);
        }
    }
    public static void rotation(int arr[],int d){
        int temp=arr[0],i;
        for( i=0;i<arr.length-1;i++)
        {
            arr[i]= arr[i+1];

        }
        arr[i]=temp;
    }

    public static void rotate_1(int []arr, int d)
    {      int temp; int temp1=d;
        for(int i=0;i<arr.length-d-1;i++)
        {
            /*if(d > arr.length-1){
                d=0;
            }*/
            temp=arr[i];
            System.out.println("index are "+i+" "+d);
            arr[i]=arr[d];
            arr[d]=temp;

            d++;
        }
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+"&");
        for(int i= arr.length-1,m=2;m>1;m--)
        {
            /*if(d > arr.length-1){
                d=0;
            }*/
            temp=arr[i];
            System.out.println("temp "+temp);
            arr[i]=arr[i-1];
            arr[i-1]=temp;

        }

        for(int i=0;i<arr.length;i++)
        System.out.print(arr[i]+"_");
    }

   public static void printArray(int arr[])
    {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
