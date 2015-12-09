import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Picture_Encryption {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("Encryption.JPG"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Encryption2.JPG"));
		int len;
		while((len=bis.read()) !=-1)
		{
			bos.write(len ^123);
		}
		bis.close();
		bos.close();
	}

}
