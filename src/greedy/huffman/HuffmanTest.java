package greedy.huffman;

import org.junit.Test;

/**
 * @Author Hui-min Lu
 * @Date 2021/1/7 10:57
 * @Version 1.0
 * @Description
 */
public class HuffmanTest {
    char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f'};
    int[] freq = {45, 13, 12, 16, 9, 5};


    @Test
    public void test() {
        Huffman huffman = new Huffman(alphabet, freq);
        huffman.solve();
    }
}
