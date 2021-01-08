package greedy.huffman;

import java.util.*;

/**
 * @Author Hui-min Lu
 * @Date 2021/1/7 10:52
 * @Version 1.0
 * @Description
 */
public class Huffman {
    /**
     * input：
     * alphabet.length = freq.length =N
     * alphabet[i]表示第i个字符  i in[0,N)
     * freq[i]表示第i个字符的频数  i in[0,N)
     */
    private char[] alphabet;
    private int[] freq;


    /*辅助变量*/
    /**
     * 字符集的字符总数
     */
    int N;

    /**
     * 辅助数组:用于对字符集按照频数排序
     */

    int[][] arr;

    public Huffman(char[] alphabet, int[] freq) {
        this.alphabet = alphabet;
        this.freq = freq;

    }

    public void solve() {

        /*记录字符集字符总数*/
        this.N = alphabet.length;
        /*初始化辅助数组 并按照频次升序排序*/
        this.arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i][0] = i;
            arr[i][1] = freq[i];
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //频次相同 则按照字母序顺序
                if (o1[1] == o2[1]) {
                    return alphabet[o1[0]] - alphabet[o2[0]];
                }

                return o1[1] - o2[1];
            }
        });
        /*使用小根堆来模拟确定编码的过程*/
        Queue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.freq - o2.freq;
            }
        });
        for (int i = 0; i < N; i++) {
            Node node = new Node();
            node.setIndex(arr[i][0]);
            node.setFreq(arr[i][1]);
            queue.offer(node);
        }

        Node dummy = new Node();

        while (!queue.isEmpty() ) {
            Node nx = new Node();
            Node l = queue.poll();
            l.setCode(0);
            nx.left = l;
            nx.setFreq(l.freq);
            if (!queue.isEmpty()) {
                Node r = queue.poll();
                r.setCode(1);
                nx.setFreq(nx.getFreq() + r.freq);
                nx.right = r;
            }
            dummy = nx;
            if (queue.isEmpty()) {
                nx.freq = -1;
                break;
            }
            queue.offer(nx);
        }

        dummy.code=8;
        dfs(dummy,"");

    }


    private void dfs(Node node, String code) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                System.out.println(alphabet[node.index] + ":的编码为: " + (code+node.code  ));
            }else {
                String curcode=code+node.code;
                dfs(node.left,curcode);
                dfs(node.right,curcode);
            }
        }
    }

    private class Node {
        /*在alphabet中的索引*/
        private Integer index;
        /*对应的编码*/
        private Integer code;

        /*频数*/
        private int freq;

        Node left;

        Node right;


        public Node() {
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public int getFreq() {
            return freq;
        }

        public void setFreq(int freq) {
            this.freq = freq;
        }
    }
}
