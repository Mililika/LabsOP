import java.io.*;

public class ProcessFile {
    public byte[] getFileData(String path) throws IOException {
        try(FileInputStream fin=new FileInputStream(path))
        {
            System.out.printf("File size: %d bytes \n", fin.available());

            byte[] buffer = new byte[fin.available()];
            fin.read(buffer,0, fin.available());
            return buffer;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    public void setFileData(String path,byte[] data){
        try(FileOutputStream fos=new FileOutputStream(path))
        {
            fos.write(data ,0, data.length);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("The file has been written");
    }

}
