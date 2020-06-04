package M;

import java.util.Scanner;

public class ScannerStr {

    Scanner scanner = new Scanner(System.in);

    public String readStr() {
        String str;
        str = scanner.next();
        scanner.close();
        return str;
    }
}
