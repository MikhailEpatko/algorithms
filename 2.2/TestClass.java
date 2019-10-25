import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Arrays;

public class TestClass {

    public static void main(String[] args) {

        int input = 999282876;
        int[] array = toArray(input);

        while (array.length > 1) {
            int summ = 0;
            for (int i : array) {
                summ += i;
            }
            array = toArray(summ);
        }
        System.out.println(array[0]);

        System.out.println(1 + (input - 1) % 9);

        System.out.println((input != 0 && input % 9 == 0) ? 9 : input % 9);

        System.out.println(digital_root(input));
    }

    private static int[] toArray(int n) {
        int j = 0;
        int i = 1;
        while (n / i >= 10) {
            i *= 10;
            j++;
        }
        j++;
        int[] result = new int[j];
        for (; i >= 1; i /= 10) {
            result[--j] = n / i;
            n %= i;
        }
        return result;
    }

    private static int digital_root(int n) {
        while(n > 9){
            n = n / 10 + n % 10;
        }
        return(n);
    }
}

