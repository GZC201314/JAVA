import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Text_AllCopy {

	/**
	 * �����в���,��Ϊ����ļ��������ڴ�,�п��ܻ�����ڴ����
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("DSC01176.JPG");
		FileOutputStream fos = new FileOutputStream("�ҵ���Ƭ.JPG",true);	
		byte[] arr = new byte[fis.available()];
		fis.read(arr);
		fos.write(arr);
		fis.close();
		fos.close();
	}

}
