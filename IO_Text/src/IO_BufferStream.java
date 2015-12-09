import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class IO_BufferStream {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("DSC01176.JPG"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("Œ“µƒ’’∆¨.JPG"));
		int len;
		while((len=bis.read())!=-1)
		{
			bos.write(len);
		}
		bis.close();
		bos.close();
	}

}
