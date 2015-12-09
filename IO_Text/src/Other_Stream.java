import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;


public class Other_Stream {
		//这个程序的作者是郭志超
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedInputStream fis1 = new BufferedInputStream(new FileInputStream("孙俪 - 爱如空气.mp3") );
		BufferedInputStream fis2 = new BufferedInputStream(new FileInputStream("孙俪、李健 - 风吹麦浪.mp3"));
		BufferedInputStream fis3 = new BufferedInputStream(new FileInputStream("小虎队 - 红蜻蜓.mp3"));
		Vector<BufferedInputStream> v = new Vector<>();
		v.add(fis1);
		v.add(fis2);
		v.add(fis3);
		Enumeration<BufferedInputStream> en = v.elements();
		SequenceInputStream sis = new SequenceInputStream(en);
		FileOutputStream fos = new FileOutputStream("歌曲串烧.mp3");
		int b;
		while((b = sis.read()) != -1)
		{
			fos.write(b);
		}
		sis.close();
		fos.close();
	}

}
