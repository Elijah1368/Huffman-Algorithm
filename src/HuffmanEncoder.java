public class HuffmanEncoder {
    private String inputFileName;
    private String outputFileName;
    private String codesFileName;
    private BookReader book;
    private MyOrderedList<FrequencyNode> frequencies;
    private HuffmanNode huffmanTree;
    private MyOrderedList<CodeNode> codes;
    private byte[] encodedText;

    public HuffmanEncoder() {
        inputFileName="./WarAndPeace.txt";
        outputFileName="./WarAndPeace-compressed.bin";
    }



    private class FrequencyNode implements Comparable<FrequencyNode> {
        public Character character;
        public Integer count;
    
        public FrequencyNode(Character character) {
            this.character = character;
        }
    
        public int compareTo(FrequencyNode other) {
            return this.count - other.count;
        }
    
        public String toString() {
            return character + ":" + count;
        }
    }

    private class HuffmanNode implements Comparable<HuffmanNode> {
        public Character character;
        public Integer weight;
        public HuffmanNode left;
        public HuffmanNode right;

        public HuffmanNode(Character ch, Integer wt) {
            this.character = ch;
            this.weight = wt;
        }

        public HuffmanNode(HuffmanNode left, HuffmanNode right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(HuffmanNode other) {
            return this.weight - other.weight;
        }

        public String toString() {
            return character + ":" + weight;
        }
    }

    private class CodeNode implements Comparable<FrequencyNode> {
        public Character character;
        public Integer count;
    
        public CodeNode(Character character) {
            this.character = character;
        }
    
        public int compareTo(FrequencyNode other) {
            return this.count - other.count;
        }
    
        public String toString() {
            return character + ":" + count;
        }
    }
}
