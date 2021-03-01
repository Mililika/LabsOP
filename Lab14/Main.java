import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        LongestString ls = new LongestString("/Applications/1.Disk/KPI/Labs_OP/Lab14/src/Test.txt");
//        System.out.println("Найдовший рядок:  " + ls.firstLongestString(ls.FileName));
        ProcessFile pf = new ProcessFile();
        CoderAndDecoder cad = new CoderAndDecoder("test");
        String filePath = "/Applications/1.Disk/KPI/Labs_OP/Lab14/src/Cyphertest.txt";

        String cryptedFilePath = "/Applications/1.Disk/KPI/Labs_OP/Lab14/src/CryptedDate.txt";

        String decryptedFilePath = "/Applications/1.Disk/KPI/Labs_OP/Lab14/src/DeCryptedData.txt";

        byte[] hron = pf.getFileData(filePath);
        byte[] cryptedData = cad.encode(hron);
        pf.setFileData(cryptedFilePath,cryptedData);

        byte[] cryptedFile = pf.getFileData(cryptedFilePath);
        byte[] decryptedData = cad.encode(cryptedFile);
        pf.setFileData(decryptedFilePath,decryptedData);

    }
}
