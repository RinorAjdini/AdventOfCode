package Day5;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Day5 {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("input.txt");
        Scanner fileScanner = new Scanner(inputFile);
        long minVal = Long.MAX_VALUE, minVal2 = Long.MAX_VALUE;
        String line = fileScanner.nextLine();
        Scanner lineScanner = new Scanner(line.substring(line.indexOf(':') + 2));
        ArrayList<Long> values = new ArrayList<>();
        ArrayList<long[]> valuePairs = new ArrayList<>();
        while (lineScanner.hasNextLong()) {
            values.add(lineScanner.nextLong());
        }
        for (int i = 0; i < values.size(); i += 2) {
            valuePairs.add(new long[]{values.get(i), values.get(i) + values.get(i + 1) - 1});
        }
        lineScanner.close();
        fileScanner.nextLine();
        while (fileScanner.hasNextLine()) {
            fileScanner.nextLine(); // skip map title
            ArrayList<Long> newValues = new ArrayList<>(values);
            ArrayList<long[]> mappedValues = new ArrayList<>();
            while (fileScanner.hasNextLine() && (line = fileScanner.nextLine()).length() > 0) {
                lineScanner = new Scanner(line);
                long[] data = new long[3];
                for (int i = 0; i < 3; i++) {
                    data[i] = lineScanner.nextLong();
                }
                lineScanner.close();
                final long dest = data[0], src = data[1], len = data[2];
                for (int i = 0; i < values.size(); i++) {
                    long val = values.get(i);
                    if (val >= src && val < src + len) {
                        newValues.set(i, val + dest - src);
                    }
                }
                for (int i = 0; i < valuePairs.size(); i++) {
                    long start = valuePairs.get(i)[0], end = valuePairs.get(i)[1];
                    if (start < src + len && end >= src) { // ranges overlap
                        long[] m = {start + dest - src, end + dest - src};
                        boolean hasUnmapped = false;
                        if (start < src) { // split if input range starts before source range
                            m[0] = dest;
                            valuePairs.get(i)[0] = start;
                            valuePairs.get(i)[1] = src - 1;
                            hasUnmapped = true;
                        }
                        if (end >= src + len) { // split if input range ends after source range
                            m[1] = dest + len - 1;
                            if (hasUnmapped) {
                                valuePairs.add(new long[]{src + len, end});
                            } else {
                                valuePairs.get(i)[0] = src + len;
                                valuePairs.get(i)[1] = end;
                                hasUnmapped = true;
                            }
                        }
                        mappedValues.add(m);
                        if (!hasUnmapped) {
                            valuePairs.remove(i--);
                        }
                    }
                }
            }
            values = newValues;
            valuePairs.addAll(mappedValues);
        }
        fileScanner.close();
        for (long val : values) {
            if (val < minVal) {
                minVal = val;
            }
        }
        for (long[] valPair : valuePairs) {
            if (valPair[0] < minVal2) {
                minVal2 = valPair[0];
            }
        }
        System.out.println(minVal);
        System.out.println(minVal2);
    }
}