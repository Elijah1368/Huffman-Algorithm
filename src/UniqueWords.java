
public class UniqueWords {

    private BookReader book;

    public UniqueWords() {
        book = new BookReader("WarAndPeace.txt");
        addUniqueWordsToTrie();
    }

    public void addUniqueWordsToTrie() {
        book.words.first();
        MyTrie trieUniqueWords = new MyTrie();

        long start = System.currentTimeMillis();
        String currWord = book.words.current();

        while (currWord != null) {
            if (!trieUniqueWords.find(currWord)) {
                trieUniqueWords.insert(currWord); 
            }
            currWord = book.words.next();
        }

        long time = System.currentTimeMillis() - start;
        System.out.printf("Adding unique words to a trie... in %d milliseconds%n", time);
        System.out.printf("%d unique words%n", trieUniqueWords.size());
        System.out.printf("%d comparisons%n", trieUniqueWords.comparisons);

        //Times sorting unique words
        start = System.currentTimeMillis();
        trieUniqueWords.toString();
        time = System.currentTimeMillis() - start;

        System.out.printf("Traversing the trie... in %d milliseconds%n%n", time);
        //System.out.println(linkedListUnique);
    }
    /*
    public void addUniqueWordsToLinkedList() {
        //Resets pointer to first word
        book.words.first();
        MyLinkedList<String> linkedListUnique = new MyLinkedList<String>();

        //Times adding unique words
        long start = System.currentTimeMillis();

        String currWord = book.words.current();
        while (currWord != null) {
            if (!linkedListUnique.contains(currWord)) {
               linkedListUnique.addBefore(currWord); 
            }
            currWord = book.words.next();
        }
        long time = System.currentTimeMillis() - start;
        System.out.printf("Adding unique words to linked list... in %d milliseconds%n", time);
        System.out.printf("%d unique words%n", linkedListUnique.size());
        System.out.printf("%d comparisons%n", linkedListUnique.comparisons);

        //Times sorting unique words
        start = System.currentTimeMillis();
        linkedListUnique.sort();
        time = System.currentTimeMillis() - start;

        System.out.printf("Quick sorting linked list... in %d milliseconds%n%n", time);
        //System.out.println(linkedListUnique);
    }

    public void addUniqueWordsToArrayList() {
        //resets pointer to first word
        book.words.first();
        MyArrayList<String> arrayListUnique = new MyArrayList<String>();

        long start = System.currentTimeMillis();
        
        String currWord = book.words.current();
        int index = 0;
        while (currWord != null) {
            if (!arrayListUnique.contains(currWord)) {
               arrayListUnique.insert(currWord, index++); 
            }
            currWord = book.words.next();
        }
        
        long time = System.currentTimeMillis() - start;
        System.out.printf("Adding unique words to an array list... in %d milliseconds%n", time);
        System.out.printf("%d unique words%n", arrayListUnique.size());
        System.out.printf("%d comparisons%n", arrayListUnique.comparisons);
        start = System.currentTimeMillis();
        arrayListUnique.sort();
        time = System.currentTimeMillis() - start;

        System.out.printf("Quick sorting array list... in %d milliseconds%n%n", time);
        //System.out.println(arrayListUnique);
    }

    public void addUniqueWordsToOrderedList() {
        //resets pointer to first word
        book.words.first();
        MyOrderedList<String> orderedListUnique = new MyOrderedList<String>();

        long start = System.currentTimeMillis();

        String currWord = book.words.current();
        while (currWord != null) {
            if (!orderedListUnique.binarySearch(currWord)) {
               orderedListUnique.add(currWord); 
            }
            currWord = book.words.next();
        }
        long time = System.currentTimeMillis() - start;
        System.out.printf("Adding unique words to an ordered list... in %d milliseconds%n", time);
        System.out.printf("%d unique words%n", orderedListUnique.size());
        System.out.printf("%d comparisons%n%n", orderedListUnique.comparisons);
        
        //System.out.println(orderedListUnique);
    }
    */
}
