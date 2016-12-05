package number;


import org.testng.Assert;

/**
 * Created by bistros on 2016. 12. 5..
 *
 * int a, int b 의 더하기를 할 때 overflow가 일어나는지를 검사함
 */
public class OverflowCheck {

    /* MAX : 2147483647, 2^10:1024, 2^30:10억
       MIN : -2147483648
     */
    public static void main(String[] args) {
        System.out.println(checkSumOverflow(Integer.MAX_VALUE , 1));
        System.out.println(checkSumOverFlowJava18(Integer.MAX_VALUE , 1));
        System.out.println(checkSumOverflowUsingBit(Integer.MAX_VALUE , 1));
    }


    /* Java8의 Math.addExact 구현체를 가져온것이다 */
    public static boolean checkSumOverflowUsingBit(int a, int b ){
        int r = a + b;
        if (((a ^ r) & (b ^ r)) < 0) {
            return true;
        }
        return false;
    }

    public static boolean checkSumOverflow(int a, int b){
        if ( a> 0 && b > 0 && a+b < 0) {
            return true;
        } else if ( a < 0 && b < 0  && a+b > 0){
            return true;
        }
        return false;
    }

    public static boolean checkSumOverFlowJava18(int a, int b){
        try {
            Math.addExact(a, b);
        } catch(ArithmeticException ae){
            return true;
        }
        return false;
    }

}
