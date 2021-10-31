package interviewbit.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        System.out.println(binarySearch(arr,4));
        System.out.println(binarySearch(arr,2));
        System.out.println(binarySearch(arr,3));

        int arr1[]={11,12,13,14};
        System.out.println(binarySearch(arr1,11));
        System.out.println(binarySearch(arr1,12));
        System.out.println(binarySearch(arr1,14));

    }

    public static int binarySearch(int arr[] , int elementToSearch){
       int size=arr.length;
        int low=0; int high= size-1;
        int mid;
        while(low<=high){
            mid=low+(high-low)/2;
            //if(arr[low]==elementToSearch ){ return low;}
            //if(arr[high]==elementToSearch ){ return high;}

            if(arr[mid]==elementToSearch ){ return mid;}
            else if(arr[mid] > elementToSearch)
            {
               // low++; not required here to increase
                high=mid-1;
            }
            else if(arr[mid] < elementToSearch)
            {
                //high--;
                low=mid+1;
            }


        }

        return -1;
    }

}
