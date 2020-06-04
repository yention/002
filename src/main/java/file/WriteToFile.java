package file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class WriteToFile {

    public void writeToFile() throws IOException {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        String txtToFile = "this txt will write to file NEW ! " + time;
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\sy039\\Desktop\\site\\1\\002.txt"));
        writer.write(txtToFile);
        writer.close();
    }
}
