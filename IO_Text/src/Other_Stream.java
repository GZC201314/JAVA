import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;


public class Other_Stream {
		//�������������ǹ�־��
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedInputStream fis1 = new BufferedInputStream(new FileInputStream("��ٳ - �������.mp3") );
		BufferedInputStream fis2 = new BufferedInputStream(new FileInputStream("��ٳ��� - �紵����.mp3"));
		BufferedInputStream fis3 = new BufferedInputStream(new FileInputStream("С���� - ������.mp3"));
		Vector<BufferedInputStream> v = new Vector<>();
		v.add(fis1);
		v.add(fis2);
		v.add(fis3);
		Enumeration<BufferedInputStream> en = v.elements();
		SequenceInputStream sis = new SequenceInputStream(en);
		FileOutputStream fos = new FileOutputStream("��������.mp3");
		int b;
		while((b = sis.read()) != -1)
		{
			fos.write(b);
		}
		sis.close();
		fos.close();
	}

}
