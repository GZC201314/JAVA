import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Copy_Binary {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("DSC01176.JPG");
		FileOutputStream fos = new FileOutputStream("Œ“µƒ’’∆¨.JPG",true);
		int b;
		while((b=fis.read())!=-1)
		{
			fos.write(b);
		}
		fis.close();
		fos.close();
	}

}
