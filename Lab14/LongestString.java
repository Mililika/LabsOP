import java.io.*;
import java.io.IOException;

public class LongestString {
    String FileName;
    public String firstLongestString(String FileName) throws IOException {
        try (FileReader fr = new FileReader(FileName);
        BufferedReader br = new BufferedReader(fr)){
            String str;
            String maxString = "";
            int length;
            int max = 0;
            while((str = br.readLine()) != null){
                length = str.length();
                if(length > max){
                    max = str.length();
                    maxString = str;

                }
            }
            return maxString;

        }

    }

  public LongestString(String fileName) {
        this.FileName = fileName;
    }
}
