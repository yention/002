package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {

    public void readFromFile() throws IOException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("C:\\Users\\sy039\\Desktop\\site\\1\\002.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String txtFromFile = null;
        while ( (txtFromFile = bufferedReader.readLine()) != null){
            System.out.println(txtFromFile);
        }
        fileReader.close();

    }


}
