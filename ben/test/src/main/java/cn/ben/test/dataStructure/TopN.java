package cn.ben.test.dataStructure;

import java.util.Random;

public class TopN {

    private int parent(int n) {
        return (n - 1) / 2;
    }

    private int left(int n) {
        return n * 2 + 1;
    }

    private int right(int n) {
        return n * 2 + 2;
    }

    /**
     * 构件堆
     */
    private void buildHeap(int n, int[] data) {
        for (int i = 1; i < n; i++) {
            int t = i;
            //调整堆
            while (t != 0 && data[parent(t)] > data[t]) {
                int temp = data[t];
                data[t] = data[parent(t)];
                data[parent(t)] = temp;
                t = parent(t);
            }
        }
    }

    private void adjust(int i, int n, int[] data) {
        if (data[i] <= data[0]) {
            return;
        }
        //置换堆顶
        int temp = data[i];
        data[i] = data[0];
        data[0] = temp;
        //调整堆顶
        int t = 0;
        while ((left(t) < n && data[t] > data[left(t)]) ||
                (right(t) < n && data[t] > data[right(t)])) {
            if (right(t) < n && data[right(t)] < data[left(t)]) {
                temp = data[t];
                data[t] = data[right(t)];
                data[right(t)] = temp;
                t = right(t);
            } else {
                temp = data[t];
                data[t] = data[left(t)];
                data[left(t)] = temp;
                t = left(t);
            }
        }
    }

    private void findTopN(int n, int[] data) {
        //构件n个数的小顶堆
        buildHeap(n, data);
        // n往后的数进行调整
        for (int i = n; i < data.length; i++) {
            adjust(i, n, data);
        }
    }

    private void print(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TopN topN = new TopN();
        //测试1
        {
            int[] array1 = new int[]{234, 43, 232, 234, 324, 234, 54, 75, 678, 89, 67, 45, 45, 335, 5667, 8, 8, 4, 5345};
            System.out.println("原数组：");
            topN.print(array1);
            topN.findTopN(10, array1);
            System.out.println("调整后的数组：");
            topN.print(array1);
        }
        //测试2
        {
            int[] array2 = new int[1000];
            for (int i = 0; i < array2.length; i++) {
                array2[i] = i + 1;
            }
            System.out.println("原数组：");
            topN.print(array2);
            topN.findTopN(30, array2);
            System.out.println("调整后的数组：");
            topN.print(array2);
        }
        //测试3
        {
            Random random = new Random();
            int[] array3 = new int[1000];
            for (int i=0;i<array3.length;i++){
                array3[i] = random.nextInt();
            }
            System.out.println("原数组：");
            topN.print(array3);
            topN.findTopN(30, array3);
            System.out.println("调整后的数组：");
            topN.print(array3);
        }
    }
}
