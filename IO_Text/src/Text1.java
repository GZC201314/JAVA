import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class Text1 {
	public static void main(String[] args) throws IOException {
		File file = getfile();
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file.getName()));
		int len;
		while((len = bis.read()) !=-1)
		{
			bos.write(len);
		}
		bis.close();
		bos.close();
		
	}
public static File getfile()
{
	System.out.println("请输入一个文件路径:");
	while(true)
	{
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		File file = new File(line);
		if(!file.exists())
		{
			System.out.println("你输入的文件不存在.");
		}else if(file.isDirectory())
		{
			System.out.println("你输入的是一个文件夹路径.");
		}else
		{
			return file;
		}
	}
	
}

}
