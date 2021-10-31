package interviewbit.binarysearch;

public class PowerFunction {
    public static void main(String[] args) {
        System.out.println(PowerFunction.power(2,4));
        System.out.println(new PowerFunction().pow(0,0,1)); // expected - 0
        System.out.println(new PowerFunction().pow(2,3,5)); // expected - 3
        System.out.println(new PowerFunction().pow(-1,1,20)); // expected - 19
        System.out.println(new PowerFunction().pow(71045970,41535484,64735492)); // expected - 20,805,472
        // mine - 63,921,200

       // System.out.println(Math.floorMod(-1,20));

    }

    public static long power(int base , int power){
        long result=1; boolean flag=false;
        if(power < 0 ) {power *=-1;  flag=true;}
        while (power>0)
        {
            if(power%2==0){ base=base*base; power /=2 ;}
            if(power%2==1){ result=result*base; power--; ;}


        }
        if(flag){ result=1/result;}

        return result;
    }

    public long pow(int x, int n, int d) {
        long base=x; int power =n;
        long result=1; boolean flag=false;
        if(base==0) {return  0;}
        if(power==0) {return 1;}
        //if(base < 0 ) {base *=-1;  flag=true;}
        if(power < 0 ) {power *=-1;  flag=true;}

        while (power>0)
        {
/*
            if(power%2==0){ base= Math.floorMod(base*base,d); power /=2 ;}
            if(power%2==1){ result= Math.floorMod(result*base,d); power--; ;}
*/
            if(power%2==0){ base= mod(mod(base,d)*mod(base,d),d); power /=2 ;}
            if(power%2==1){ result= mod(mod(result,d)*mod(base,d),d); power--; ;}


        }
        if(flag){ result=1/result;}
        if(result < 0) result *=-1;
        return result;
    }
    public static long mod(long value , int d){
        return ((value%d)+d)%d;
    }
}

