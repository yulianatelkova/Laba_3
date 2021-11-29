import java.util.*;

/**
 * ���� ����� ��������� �������� ������� ������
 */
public class Tester {

    /**
     * ���������� ��������, ������� ������������ � ������������: ����������, ��������, ���������
     */
    public int k;

    /**
     * ������, ������� �������� ������������
     */
    private List<Object> list;

    /**
     * �����������
     * @param list - ������
     * @param N - ��������� ������ ������
     * @param k - ���������� ��������
     */
    public Tester(List<Object> list, int N, int k) {
        this.list = list;
        this.k = k;
        setup(N);
    }

    /**
     * ���� ����� ��������� N �������� � ������
     * @param N - ��������� ������ ������
     */
    protected void setup(int N) {
        for (int i = 0; i < N; i++) {
            list.add(new Object());
        }
    }

    /**
     * ���� ����� ���������� map �������� ������ ���������� � ������, �������� � ����� ������
     * @return map
     */
    public Map<Position, Long> testAdd() {
        Map<Position, Long> map = new HashMap<>();
        map.put(Position.BEGIN, testAddTo(Position.BEGIN));
        map.put(Position.MIDDLE, testAddTo(Position.MIDDLE));
        map.put(Position.END, testAddTo(Position.END));
        return map;
    }

    /**
     * ���� ����� ���������� ����� �������� ������ ��������� �� ������, �������� � ����� ������
     * @return map
     */
    public Map<Position, Long> testGet() {
        Map<Position, Long> map = new HashMap<>();
        map.put(Position.BEGIN, testGetFrom(Position.BEGIN));
        map.put(Position.MIDDLE, testGetFrom(Position.MIDDLE));
        map.put(Position.END, testGetFrom(Position.END));
        return map;
    }

    /**
     * ���� ����� ���������� ����� �������� ������ �������� �� ������, �������� � ����� ������
     * @return map
     */
    public Map<Position, Long> testDelete() {
        Map<Position, Long> map = new HashMap<>();
        map.put(Position.BEGIN, testDeleteFrom(Position.BEGIN));
        map.put(Position.MIDDLE, testDeleteFrom(Position.MIDDLE));
        map.put(Position.END, testDeleteFrom(Position.END));
        return map;
    }

    /**
     * ���� ����� ���������� �����, ����������� ��� ���������� k ��������� �� �������
     * @param position - �����, ���� ����������� ��������
     * @return time
     */
    protected long testAddTo(Position position) {
        long start = System.nanoTime();
        for(int i = 0; i < k; i++) {
            list.add(defineIndex(position), new Object());
        }
        long finish = System.nanoTime();
        return finish - start;
    }

    /**
     * ���� ����� ���������� �����, ����������� ��� ��������� k ���������
     * @param position - �����, ���� ����������� ��������
     * @return time
     */
    protected long testGetFrom(Position position) {
        long start = System.nanoTime();
        for(int i = 0; i < k; i++) {
            Object object = list.get(defineIndex(position));
        }
        long finish = System.nanoTime();
        return finish - start;
    }

    /**
     * ���� ����� ���������� �����, ����������� ��� �������� k ���������
     * @param position - �����, ���� ����������� ��������
     * @return time
     */
    protected long testDeleteFrom(Position position) {
        long start = System.nanoTime();
        for(int i = 0; i < k; i++) {
            list.remove(defineIndex(position));
        }
        long finish = System.nanoTime();
        return finish - start;
    }

    /**
     * �������������� �������� ������������ � ������ ��� ������
     * @param position - ������� ���������� ���������
     * @return index
     */
    protected int defineIndex(Position position) {
        switch (position) {
            case BEGIN: {
                return 0;
            }
            case MIDDLE: {
                return list.size() / 2;
            }
            case END: {
                return list.size() - 1;
            }
            default:
                throw new IllegalStateException("����������� ��������: " + position);
        }
    }
}