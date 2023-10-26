package Assignments;

import java.util.Comparator;
import java.util.PriorityQueue;

class HuffmanNode{

    int data;
    char c;

    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(int data, char c) {
        this.data = data;
        this.c = c;
        this.left = this.right = null;
    }

}


//Write a program to implement Huffman Encoding using a greedy strategy
public class HuffmanEncoding {
    public static void main(String[] args) {

        char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] freqs = { 5, 9, 12, 13, 16, 45 };

        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>(new Comparator<HuffmanNode>() {
            @Override
            public int compare(HuffmanNode o1, HuffmanNode o2) {
                return o1.data - o2.data;
            }
        });

        //add every node to MinHeap
        for (int i = 0; i < chars.length; i++)
            minHeap.add(new HuffmanNode(freqs[i], chars[i]));


        huffmanEncoding(minHeap);
    }

    private static void huffmanEncoding(PriorityQueue<HuffmanNode> minHeap) {
        HuffmanNode root = null;
        //do this until only 1 node is left
        while (minHeap.size() > 1){

            //poll 2 nodes
            HuffmanNode x = minHeap.poll();
            HuffmanNode y = minHeap.poll();

            assert y != null;
            HuffmanNode newNode = new HuffmanNode((x.data+y.data), '-'); //insert some random char in it
            newNode.left = x;
            newNode.right = y;
            root = newNode;


            minHeap.add(newNode);
        }

        //finally, print the huffman tree
        printHuffmanTree(root, "");
    }

    private static void printHuffmanTree(HuffmanNode root, String s) {
        //base case
        if (root == null) return;
        //leaf node
        if (root.left == null && root.right == null){
            System.out.println(root.c + ": " + s);
            return;
        }

        printHuffmanTree(root.left, s+"0");
        printHuffmanTree(root.right, s+"1");
    }
}