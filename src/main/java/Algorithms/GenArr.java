package Algorithms;

public class GenArr {

    int [] array;

    public int[] genIntArray(int n){
        array = new int[n];
        for (int i=0; i<array.length; i++){
            array[i] = (int) (Math.random() * 320 + 31);
        }
        return array;
    }

    public int[] sortedIntArray(int n){
        array = new int[n];
        for (int i=0; i<array.length; i++){
            array[i] = i+1;
        }
        return array;
    }
}
