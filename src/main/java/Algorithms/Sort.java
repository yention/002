package Algorithms;

public class Sort {

    public void bubble(int[] array){
        for (int i = 0; i< array.length; i++){
            for (int j=0; j<array.length-i-1; j++){
                if (array[j] > array[j+1]){
                    double tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = array[j];
                }
            }
        }
        for (int i : array) System.out.println(i);
    }

}
