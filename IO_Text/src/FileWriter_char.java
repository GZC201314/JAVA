import java.io.FileWriter;
import java.io.IOException;


public class FileWriter_char {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("yyy.txt");
		fw.write("��Һ�,�ҵ������ǹ�־��.");
		fw.close();	}

}
