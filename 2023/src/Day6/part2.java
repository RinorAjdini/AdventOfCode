package Day6;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class part2 {
    public static String stringMath(String num1,String num2){
        return null;
    }
    public static BigInteger[] findFirstNumber(BigInteger time, BigInteger distance) {
        for (BigInteger i = BigInteger.ONE; i.compareTo(distance.divide(BigInteger.TWO)) <= 0; i = i.add(BigInteger.ONE)) {
            if ((time.subtract(i)).multiply(i).compareTo(distance) > 0) {
                return new BigInteger[]{i, time.subtract(i)};
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        BigInteger ans = BigInteger.ONE;
        String line1 = sc.nextLine().split(":")[1].trim();
        String[] parts = line1.split("\\s+");
        StringBuilder rez1 = new StringBuilder();
        for (String part : parts) {
            rez1.append(part);
        }
        String line2 = sc.nextLine().split(":")[1].trim();
        parts = line2.split("\\s+");
        StringBuilder rez2 = new StringBuilder();
        for (String part : parts) {
            rez2.append(part);
        }
        BigInteger num1 = new BigInteger(rez1.toString());
        BigInteger num2 = new BigInteger(rez2.toString());
        BigInteger[] res = findFirstNumber(num1, num2);
        if (res != null) {
            ans = res[1].subtract(res[0]).add(BigInteger.ONE);
        }
        System.out.println(ans);
        }
}

