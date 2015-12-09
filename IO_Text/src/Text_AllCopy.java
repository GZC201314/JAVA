import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Text_AllCopy {

	/**
	 * 开发中不用,因为如果文件过大会耗内存,有可能会造成内存溢出
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("DSC01176.JPG");
		FileOutputStream fos = new FileOutputStream("我的照片.JPG",true);	
		byte[] arr = new byte[fis.available()];
		fis.read(arr);
		fos.write(arr);
		fis.close();
		fos.close();
	}

}
