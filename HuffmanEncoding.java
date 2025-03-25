import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Node class representing each character in Huffman tree
class HuffmanNode {
    char data;
    int frequency;
    HuffmanNode left, right;

    HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        this.left = this.right = null;
    }
}

// Comparator for priority queue
class HuffmanComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode node1, HuffmanNode node2) {
        return node1.frequency - node2.frequency;
    }
}

public class HuffmanEncoding {
    
    // Function to generate Huffman codes
    public static void generateHuffmanCodes(HuffmanNode root, String code, Map<Character, String> huffmanCodes) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            huffmanCodes.put(root.data, code);
        }

        generateHuffmanCodes(root.left, code + "0", huffmanCodes);
        generateHuffmanCodes(root.right, code + "1", huffmanCodes);
    }

    public static void main(String[] args) {
        // Sample input
        char[] characters = { 'A', 'B', 'C', 'D', '_' };
        int[] frequencies = { 5, 9, 12, 13, 16 };

        // Priority Queue to build Huffman tree
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(characters.length, new HuffmanComparator());

        // Create nodes and insert them into the queue
        for (int i = 0; i < characters.length; i++) {
            pq.add(new HuffmanNode(characters[i], frequencies[i]));
        }

        // Build Huffman Tree
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();

            HuffmanNode newNode = new HuffmanNode('-', left.frequency + right.frequency);
            newNode.left = left;
            newNode.right = right;

            pq.add(newNode);
        }

        // Root of Huffman Tree
        HuffmanNode root = pq.poll();

        // Generate Huffman Codes
        Map<Character, String> huffmanCodes = new HashMap<>();
        generateHuffmanCodes(root, "", huffmanCodes);

        // Print Huffman Codes
        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : huffmanCodes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
