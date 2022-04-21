public class MyOrderedList<T extends Comparable<T>> {
    private MyArrayList<T> list;
    public long comparisons;
    
    public MyOrderedList(){
        list = new MyArrayList<T>();
        comparisons = 0;
    }

    public void add(T item){
        comparisons++;
        boolean inserted = false;
        for (int i = 0; i < list.size(); i++) {
            comparisons++;
            if (list.get(i).compareTo(item) >= 0) {
                list.insert(item, i);
                inserted = true;
                break;
            } 
            
        }
        
        
        if (!inserted) {
            list.insert(item, list.size());
        }
        
        /*
        faster implementation but returning the wrong number of comparisons so decided not to follow through it

        int insertIndex = findInsertIndex(0, list.size() - 1, item);
        list.insert(item, insertIndex);
        */
    }

    public T remove(T item) {
        if (list.size() == 0) return null;
        int insertIndex = findInsertIndex(0, list.size() - 1, item);
        
        if (list.get(insertIndex).compareTo(item) == 0) {
            return list.remove(insertIndex);
        }

        return null;
    } 

    public T get(int index) {
        return list.get(index);
    }
    
    public int size() {
        return list.size();
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public String toString(){
        return list.toString();
    }

    public T binarySearch(T item) {
        
        int left = 0; int right = list.size() - 1;
        comparisons++;
        while (left <= right) {
            
            int middle = (right + left) / 2;

            int comparison = list.get(middle).compareTo(item);

            if (comparison == 0) {
                comparisons++;
                return list.get(middle);
            } else if (comparison > 0) {
                comparisons++;comparisons++;
                right = middle - 1;
            } else {
                comparisons++;comparisons++;comparisons++;
                left = middle + 1;
            }

        }
        
        return null;
    }

    /*
    private boolean binarySearch(int left, int right, T elem) {
       

        if (left <= right) {
            int mid = left + ((right - left) / 2);
            
            if (list.get(mid).compareTo(elem) == 0) {
                comparisons++;
                return true;
            } else if (list.get(mid).compareTo(elem) > 0){
                comparisons++;
                comparisons++;
                return binarySearch(left, mid - 1, elem);
            } else {
                comparisons++;
                comparisons++;
                comparisons++;
                return binarySearch(mid + 1, right, elem);
            }
        }
        
        return false;
    }
    */
    
    //Like binary search but returns index instead of boolean
    //iterative implementation
    //makes remove method faster
    private int findInsertIndex(int left, int right, T elem){
       
        while (left <= right) {
            
            int middle = (right + left) / 2;

            int comparison = list.get(middle).compareTo(elem);

            if (comparison == 0) {
                return middle;
            } else if (comparison > 0) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return right + 1;
    }

}
