import java.util.Objects;
import java.util.Scanner;

/**
 * @author Telkova Yuliana
 * @version 2021.2.1
 */
public class Main {
    /**
     * функция main
     * @param args - аргументы
     */
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.println("Введите размер списка и количество итераций:");
        var N = 0;
        var k = 0;

        try {
            N = in.nextInt();
            k = in.nextInt();
            if (N>=0 && k>=0)
            ParserResults.testPerformance(N, k);
            else System.out.println("Неверный ввод");
        } catch (Exception expected) {
            System.out.println(expected.getMessage());
        }
    }
}