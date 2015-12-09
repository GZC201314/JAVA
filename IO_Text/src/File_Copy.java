import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;


public class File_Copy {

	/**
	 * @param args
	 * @throws IOException  
	 */
	public static void main(String[] args) throws IOException {
//		demo1();	
		FileInputStream fis = new FileInputStream("DSC01176.JPG");
		File file = new File("我的照片.JPG");
		if(file.exists())
		{
			file.delete();
			System.out.println("文件删除了!!!");
		}
		FileOutputStream fos = new FileOutputStream("我的照片.JPG");
		byte[] arr = new byte[1024*85];
		int len;
		//System.out.println(System.currentTimeMillis());
		long first = System.currentTimeMillis();
		while((len=fis.read(arr))!=-1)
		{
			fos.write(arr, 0, len);
		}
		long end = System.currentTimeMillis();
		System.out.println(end-first);
	}

	private static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("DSC01176.JPG");
		FileOutputStream fos = new FileOutputStream("我的照片.JPG",true);	
		byte[] arr = new byte[2048];
		int len;
		while((len = fis.read(arr))!=-1)
		{
			fos.write(arr, 0, len);
		}
//		fis.read(arr);
//		fos.write(arr);
		fis.close();
		fos.close();
	}

}
