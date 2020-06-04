package M;

import TestShit.AbsClass;
import TestShit.ChildClass;
import file.WriteToFile;
import org.javatuples.Pair;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<Integer, Pair<String, String>> NAME_MAP = new HashMap<Integer, Pair<String, String>>();

    public static void main(String[] args) throws IOException {
//        M.ScannerStr scannerStr = new M.ScannerStr();
//        System.out.println(scannerStr.readStr());

//            file.ReadFromFile readFromFile = new file.ReadFromFile();
//            readFromFile.readFromFile();

//        WriteToFile writeToFile = new WriteToFile();
 //       writeToFile.writeToFile();
//
//        M.Stat stat = new M.Stat();
//        stat.arrayMethod();

//        ChildClass childClass = new ChildClass();
//        childClass.ABC();
//
//        AbsClass absClass = new AbsClass();
//        absClass.ar();

        NAME_MAP.put(0, new Pair<String, String>("The Internet","Opening a new window" ));
        NAME_MAP.put(1, new Pair<String, String>("New Window","New Window"));
        NAME_MAP.put(2, new Pair<String, String>("Elemental Selenium: Receive a Free, Weekly Tip on Using Selenium like a Pro","Elemental Selenium"));

        System.out.println(NAME_MAP.get(0).getValue0());

    }
}
