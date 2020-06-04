package M;

import java.util.ArrayList;
import java.util.Iterator;

public class Stat {

    ArrayList arrayList = new ArrayList();

    public void arrayMethod(){
        arrayList.add(123); //0
        arrayList.add("asd"); //1
        arrayList.add(2, "new"); //2

        Iterator itr = arrayList.iterator();

        System.out.println("BEFORE");
        for (Object o: arrayList)
            System.out.println(o);

        System.out.println("AFTER");
        for (int i = 0; i< 10; i++){
           if (!itr.hasNext()){
               arrayList.add(i+1, i *100);
               continue;
           }
        }
        for (Object o: arrayList)
            System.out.println(o);
//        while (itr.hasNext()){
//            Object value = itr.next();
//            System.out.println(value);
//        }
    }


}
