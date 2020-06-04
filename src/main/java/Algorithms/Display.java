package Algorithms;
import M.ScannerStr;

public class Display {

    static Sort sort = new Sort();
    static GenArr genArr = new GenArr();
    static ScannerStr scannerStr = new ScannerStr();

    public static void main(String[] args) {
//        Display display = new Display();
//        System.out.println("oneToFive------------------------");
//        display.oneToFive();
//        System.out.println("=================================");
//        int size = Integer.parseInt(scannerStr.readStr());
//        sort.bubble(genArr.genIntArray(size));
    Search search = new Search();

        System.out.println(search.binarySearch(genArr.sortedIntArray(100), 76));
    }

    public void oneToFive(){
        for ( int i =1; i<=5; i++){
            for ( int j = 1; j <=i; j++)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public void fibonachi(){

    }
}
