package coding.challenge.basic.search;

public class BinarySearch {

    boolean search(int[] arr, int key) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return true;
            } else if (arr[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {6,2,1,5,4,3,8,7};
        BinarySearch binarySearch = new BinarySearch();
        boolean result = binarySearch.search(arr, 8);
        System.out.printf("BinarySearch Search Result: " + result);
    }
}
