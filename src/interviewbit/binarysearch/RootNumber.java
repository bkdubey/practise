package interviewbit.binarysearch;

public class RootNumber {
    public static void main(String[] args) {
        System.out.println("root is" + new RootNumber().rootOfNumber(64,2));
        System.out.println("root is" + new RootNumber().rootOfNumber(27,3));
        System.out.println("root is" + new RootNumber().rootOfNumber(121,2));
        System.out.println("root is" + new RootNumber().rootOfNumber(11,2));
        System.out.println("root is" + new RootNumber().rootOfNumber(20,2));
        System.out.println("root is" + new RootNumber().rootOfNumber(122,2));
        System.out.println("root is" + new RootNumber().rootOfNumber(243,2));
        System.out.println("root is" + new RootNumber().rootOfNumber(0,2));
        System.out.println("root is" + new RootNumber().rootOfNumber(1,2));
        System.out.println("root is" + new RootNumber().rootOfNumber(2,2));
        System.out.println("root is" + new RootNumber().rootOfNumber(3,2));
        System.out.println("root is" + new RootNumber().rootOfNumber(2147483647,2));



    }

    public long rootOfNumber(long number , int root ){
        long high=number; long low=1; double condtion=1e-6; long result=-1;
        if(number==0 || number ==1) return number;
        while(low <= high   )
        {
            long mid = low+(high-low)/2; long output=multiplyByNtime(mid,root);
            if(output==number) return  mid;
            if(output > number) { high =mid-1; }
            if(output < number) { low =mid+1; result= mid; // key point storing result , as we need floor in case of 11
            }
        }

        return result;
    }
    public long multiplyByNtime(long number , int ntimes){
        long result=1;
        for(int i=0;i<ntimes;i++){
            result=result*number;
        }
        return result;
    }

}
