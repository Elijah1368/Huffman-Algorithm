public class MyTrie {
    private Node root;
    private int size;
    public long comparisons;
    private final String CHARACTERS = "0123456789'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public MyTrie() {
        root = new Node();
        comparisons = 0;
    }

    public void insert(String item) {
        Node node = root; 
        MyOrderedList<Node> children = root.children;
        size++;
        //gets to last node
        
        for (int i = 0; i < item.length(); i++) { 
            comparisons++;
            if (children.isEmpty()) {
                node.addChildren();
            }
            
            node = children.binarySearch(new Node(item.charAt(i))); 
            children = node.children;
        }
        
        node.terminal = true;
    }

    public void remove(String item) {
        Node node = root; 
        MyOrderedList<Node> children = root.children;
        size--;
        //gets to last node
        for (int i = 0; i < item.length(); i++) { 
            if (children.isEmpty()) {
                return;
            }

            node = children.binarySearch(new Node(item.charAt(i))); 
            children = node.children;
        }
        
        node.terminal = false;
    } 
    
    public boolean find(String item) {
        Node node = root; 
        MyOrderedList<Node> children = root.children;
        //gets to last node
        for (int i = 0; i < item.length(); i++) { 
            comparisons++;
            if (children.isEmpty()) {
                return false;
            }
            
            node = children.binarySearch(new Node(item.charAt(i))); 
            children = node.children;
        }

        return node.terminal == true;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    
    public String toString(){
        StringBuilder words = new StringBuilder();
        addWords(root, "", words);
        return words.toString();
    }
    
    private void addWords(Node node, String str, StringBuilder output) {
        if (node.terminal) {
            output.append(str + "\n");
        }
        
        if (node.children.isEmpty()) {
            return;
        }
        
        Node child;
        for (int i = 0; i < CHARACTERS.length(); i++) {
            child = node.children.get(i);
            addWords(child, str + child.character, output);
        }
    }

    private class Node implements Comparable<Node> {
        public Boolean terminal;
        public char character;
        public MyOrderedList<Node> children; 
    
        public Node() {
            this.terminal = false;
            this.character = 0;
            this.children = new MyOrderedList<Node>();
        }

        public Node(char character) {
            this.terminal = false;
            this.character = character;
            this.children = new MyOrderedList<Node>();
        }
    
        public int compareTo(Node other) {
            return character - other.character;
        }
    
        public void addChildren(){
            for (char ch: CHARACTERS.toCharArray()){
                children.add(new Node(ch));
            }
        }

        public String toString(){
            return Character.toString(character);
        }
    }
    
}

