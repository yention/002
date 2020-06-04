package Algorithms;

import com.sun.xml.internal.bind.v2.model.core.NonElement;

public class Search {

    public int binarySearch(int[] array, int item){
        int high = array.length -1;
        int low = 0;
        int mid;
        int guess;

        while (low <= high){
            mid = (high + low) /2;
            guess = array[mid];
            if (guess == item)
                return guess;
            if (guess> item)
                high = mid -1;
            else low = mid +1;
        }
        return 0;
    }
}
