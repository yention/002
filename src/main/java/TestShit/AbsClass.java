package TestShit;

import java.util.ArrayList;
import java.util.Arrays;

public class AbsClass {

    String name = "Al";


    public void ar (){
        String [] array= {"Ray", "Bob", "Gol"};
        String [] array1= {"Ray1", "Bob1", "Gol1"};

        for (String str : array){
            System.out.println(str);
        }
        System.out.println(" \n");

        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(array));

        System.out.println(arrayList);
        arrayList.addAll(2,Arrays.asList(array1));
        System.out.println(arrayList);

    }
}
