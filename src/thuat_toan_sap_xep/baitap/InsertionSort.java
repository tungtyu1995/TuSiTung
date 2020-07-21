package thuat_toan_sap_xep.baitap;

public class InsertionSort {

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++){
            System.out.println("vong lap thu " + i);
            int currentElement = arr[i];
            System.out.println("gia tri nho nhat: "+ arr[i]);
            int k;
            for(k = i - 1; k >=0 && arr[k] > currentElement; k--){
                System.out.println("so sanh " +k+ " voi "+currentElement);
                arr[k+1] = arr[k];
            }
            arr[k+1] = currentElement;
            System.out.println("vi tri: " +(k+1)+ " "+"co gia tri: "+ currentElement);
            System.out.println("______________");
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,4,2,9,6,4,3,2};
        insertionSort(arr);
        for(int i =0 ; i<arr.length;i++){
            System.out.print(arr[i]+",");

        }
    }
}
