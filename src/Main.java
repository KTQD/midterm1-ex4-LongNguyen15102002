class SumThread extends Thread {
    private int[] array;
    private long sum;

    public SumThread(int[] array) {
        this.array = array;
        this.sum = 0;
    }

    public long getSum() {
        return sum;
    }

    @Override
    public void run() {
        for (int num : array) {
            sum += num;
        }
    }
}

class MaxThread extends Thread {
    private int[] array;
    private int max;

    public MaxThread(int[] array) {
        this.array = array;
        this.max = Integer.MIN_VALUE;
    }

    public int getMax() {
        return max;
    }

    @Override
    public void run() {
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 6, 2, 7, 8, 0, 4, 3, 9, 2, 8, 1, 0, 5, 7, 4, 6, 9, 3, 2, 1, 8, 4, 0, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0};

        SumThread sumThread = new SumThread(numbers);
        MaxThread maxThread = new MaxThread(numbers);

        sumThread.start();
        maxThread.start();

        try {
            sumThread.join();
            maxThread.join();

            long sum = sumThread.getSum();
            int max = maxThread.getMax();

            System.out.println("Tổng của các phần tử trong mảng: " + sum);
            System.out.println("Phần tử lớn nhất trong mảng: " + max);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
