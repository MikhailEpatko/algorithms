import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

//O(n * log(n))
public class Solution2 {

    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";
        try (Scanner scanner = new Scanner(new File(inputFileName));
             PrintWriter writer = new PrintWriter(new File(outputFileName))) {
            scanner.nextLine();
            String[] tokens = scanner.nextLine().split("\\s");
            int[] nums = new int[tokens.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(tokens[i]);
            }
            mergeSort(nums);
            writer.print(count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void mergeSort(int[] array) {
        int length = array.length;
        int n = 1;
        int shift;
        int size2;
        int[] array2;
        while (n < length) {
            shift = 0;
            while (shift < length) {
                if (shift + n >= length) {
                    break;
                }
                size2 = (shift + n * 2 > length) ? (length - (shift + n)) : n;
                array2 = merge(Arrays.copyOfRange(array, shift, shift + n),
                        Arrays.copyOfRange(array, shift + n, shift + n + size2));
                if (n + size2 >= 0) {
                    System.arraycopy(array2, 0, array, shift, n + size2);
                }
                shift += n * 2;
            }
            n *= 2;
        }
    }

    private static int count = 0;

    private static int[] merge(int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] result = new int[left.length + right.length];
        while (i < left.length || j < right.length) {
            if (i == left.length || (j < right.length && right[j] < left[i])) {
                result[k++] = right[j++];
                count += left.length - i;
            } else {
                result[k++] = left[i++];
            }
        }
        return result;
    }
}
