import java.awt.List;
import java.util.Arrays;
import java.util.Scanner;
public class Lzwdecode {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入需要解码字符串：");
		String prestr = input.nextLine();
		String prostr = "";//解压后输出的字符串
		String[] dic = new String[30];
		String fixchar = "";
		String fixstr = "";
		//字典初始化
		dic[0]="A";
		dic[1]="B";
		dic[2]="C";
		String code = prestr.substring(0, 1);//前一个code
		prostr = prostr.concat(dic[Integer.parseInt(code)]);
		String ncode = "";//下一个code
		int n = 1; //指示ncode
		int offset = 0;//指示字典位置
		//解压
		while (n<prestr.length()) {
			
			ncode = prestr.substring(n,n+1);
			//System.out.println("ncode:"+ncode);
			if (dic[Integer.parseInt(ncode)] != null) {
				fixstr = dic[Integer.parseInt(ncode)];
			} else {
				fixstr = dic[Integer.parseInt(code)];
				fixstr = fixchar;
			}
			//System.out.println("fixstr:"+fixstr);
			prostr = prostr.concat(fixstr);
			fixchar = fixstr.substring(0, 1);
			dic[3+offset] = dic[Integer.parseInt(code)].concat(fixchar);
			offset++;
			code = ncode;
			
			n++;
		}
		
		//ouput
		System.out.println("解码后字符串为："+prostr+"\n字典内容为：");
		int i=0;
		while (dic[i]!=null) {
			System.out.println(i+":"+dic[i]);
			i++;
		}
		

	}

}
