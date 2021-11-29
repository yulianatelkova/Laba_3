import java.util.Objects;
import java.util.Scanner;

/**
 * @author Telkova Yuliana
 * @version 2021.2.1
 */
public class Main {
    /**
     * ������� main
     * @param args - ���������
     */
    public static void main(String[] args) {
        var in = new Scanner(System.in);
        System.out.println("������� ������ ������ � ���������� ��������:");
        var N = 0;
        var k = 0;

        try {
            N = in.nextInt();
            k = in.nextInt();
            if (N>=0 && k>=0)
            ParserResults.testPerformance(N, k);
            else System.out.println("�������� ����");
        } catch (Exception expected) {
            System.out.println(expected.getMessage());
        }
    }
}