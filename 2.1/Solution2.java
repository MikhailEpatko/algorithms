import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

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
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                sb.append(nums[i]);
                if (i < nums.length - 1) {
                    sb.append(" ");
                }
            }
            writer.print(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void mergeSort(int[] array) {
        int len = array.length;
        int n = 1;
        int shift;
        int two_size;
        int[] arr2;
        while (n < len) {
            shift = 0;
            while (shift < len) {
                if (shift + n >= len) {
                    break;
                }
                two_size = (shift + n * 2 > len) ? (len - (shift + n)) : n;
                arr2 = merge(Arrays.copyOfRange(array, shift, shift + n),
                        Arrays.copyOfRange(array, shift + n, shift + n + two_size));
                if (n + two_size >= 0) {
                    System.arraycopy(arr2, 0, array, shift, n + two_size);
                }
                shift += n * 2;
            }
            n *= 2;
        }
    }

    private static int[] merge(int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] result = new int[left.length + right.length];
        while (i < left.length || j < right.length) {
            if (i == left.length || (j < right.length && right[j] < left[i])) {
                result[k++] = right[j++];
            } else {
                result[k++] = left[i++];
            }
        }
        return result;
    }
}
