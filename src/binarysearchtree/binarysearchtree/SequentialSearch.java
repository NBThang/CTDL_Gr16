package binarysearchtree;

public class SequentialSearch {
    public boolean sequentialSearch(int[] array, int key) {
        for (int num : array) {
            if (num == key) {
                return true;
            }
        }
        return false;
    }
}
