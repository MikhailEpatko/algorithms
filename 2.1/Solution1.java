import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution1 {

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
            nums = mergeSort(nums);
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

    private static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int middle = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, middle);
        int[] right = Arrays.copyOfRange(array, middle, array.length);
        left = mergeSort(left);
        right = mergeSort(right);
        return  merge(left, right);
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
