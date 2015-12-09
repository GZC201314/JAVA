import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Buffer_RW {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
//		demo1();
		BufferedReader br = new BufferedReader(new FileReader("¶·ÆÆ²Ôñ·.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("·´×ª.txt"));
		ArrayList<String> list = new ArrayList<>();
		String line;
		while((line =br.readLine()) != null)
		{
			list.add(line);
		}
		for(int i=list.size()-1;i>=0;i--)
		{
			bw.write(list.get(i));
			bw.newLine();
		}
		br.close();
		bw.close();

	}

	private static void demo1() throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("8823.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("¶·ÆÆ²Ôñ·.txt"));
		int len;
		while((len = br.read()) != -1)
		{
			bw.write(len);
		}
		br.close();
		bw.close();
	}

}
