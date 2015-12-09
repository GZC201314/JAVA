import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Demo_JDK1_7 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		try (
				FileInputStream fis = new FileInputStream("xxx.txt");
				MyClose mc = new MyClose();
				FileOutputStream fos = new FileOutputStream("yyy.txt");
				) {
				int len;
				while ((len = fis.read()) != -1) {
				fos.write(len);
				}
		}
	}
static class MyClose implements AutoCloseable
{
	public void close()
	{
		System.out.println("¹Ø±ÕÁ÷!!!");
	}
}

}
