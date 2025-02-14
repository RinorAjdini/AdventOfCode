package Day3;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        long res = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            for (int i = 0; i < s.length() - 6; i++) {
                if (s.substring(i, i + 4).equals("mul(")) {
                        String sx = "";
                        String sy = "";
                        int x = 0;
                        int y = 0;
                        int j = i + 4;

                        while (!s.substring(j, j + 1).equals(",")) {
                            sx += s.substring(j, j + 1);
                            j++;
                        }

                        try {
                            x = Integer.parseInt(sx);
                        } catch (NumberFormatException e) {
                            continue;

                        }

                        j++;

                        while (!s.substring(j, j + 1).equals(")")) {
                            sy += s.substring(j, j + 1);
                            j++;
                        }
                        try {
                            y = Integer.parseInt(sy);
                        } catch (NumberFormatException e) {
                            continue;
                        }
                        res += x * y;
                        i=j;
                    }
            }

        }
        System.out.println(res);
    }
}
