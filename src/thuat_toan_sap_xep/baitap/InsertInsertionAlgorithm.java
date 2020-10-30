package thuat_toan_sap_xep.baitap;

public class InsertInsertionAlgorithm {
    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++){
            int currentElement = arr[i];
            int k;
            for(k = i - 1; k >=0 && arr[k] > currentElement; k--){
                arr[k+1] = arr[k];
            }
            arr[k+1] = currentElement;
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,4,2,9,6,4,3,2};
        insertionSort(arr);
        for(int i =0 ; i<arr.length; i++){
            System.out.print(arr[i]+",");

        }
    }
}
