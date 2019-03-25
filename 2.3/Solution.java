import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";
        try (Scanner scanner = new Scanner(new File(inputFileName));
             PrintWriter writer = new PrintWriter(new File(outputFileName))) {
            String[] tokens = scanner.nextLine().split("\\s");
            int length = Integer.parseInt(tokens[0]);
            int step = Integer.parseInt(tokens[1]);
            tokens = scanner.nextLine().split("\\s");
            int[] nums = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                nums[i] = Integer.parseInt(tokens[i]);
            }
            if (noNeedToSort(nums)) {
                writer.print("YES");
                return;
            }
            String answer = "NO";
            for (int i = 0; i < nums.length - step; i++) {
                if (nums[i] > nums[i + step]) {
                    int tmp = nums[i];
                    nums[i] = nums[i + step];
                    nums[i + step] = tmp;
                    if (noNeedToSort(nums)) {
                        answer = "YES";
                        break;
                    }
                }
            }
            writer.print(answer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean noNeedToSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
