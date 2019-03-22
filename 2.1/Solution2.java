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
        for (int size = 1; size <= array.length; size *= 2) {

        }
    }

    private static int[] merge(int[] left, int[] right) {

        return result;
    }
}
