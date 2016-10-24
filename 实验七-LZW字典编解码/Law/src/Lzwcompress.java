import java.awt.List;
import java.util.Arrays;
import java.util.Scanner;
public class Lzwcompress {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("ÇëÊäÈë×Ö·û´®£º");
		String predata =  input.nextLine();
		String prodata = "";
		String fixstr = ""; 
		String fixchar = ""; 
		String[] dic = new String[30];
		//×Öµä³õÊ¼»¯
		dic[0]="A";
		dic[1]="B";
		dic[2]="C";
		
		//Ñ¹Ëõ
		fixstr = predata.substring(0,1);
		int n=1;
		int offset=0;
		//System.out.println(predata.length());
		while (n<predata.length()) {
			fixchar = predata.substring(n,n+1);
			String fixtwo = fixstr.concat(fixchar);
			//System.out.println("fixtwo"+fixtwo);
			if (Arrays.asList(dic).contains(fixtwo)) {
				fixstr = fixtwo;
			} else {
				prodata = prodata.concat(""+Arrays.asList(dic).indexOf(fixstr));
				dic[3+offset] = fixtwo;
				fixstr = fixchar;
				offset++;
			}
			n++;
		}
		prodata = prodata.concat(""+Arrays.asList(dic).indexOf(fixstr));
		//±àÂëºóÊä³ö
		System.out.println("±àÂëºó£º"+prodata+"\n×ÖµäÎªÄÚÈİÈçÏÂ£º");
		//×Öµä
		int i=0;
		while (dic[i]!=null) {
			System.out.println(i+":"+dic[i]);
			i++;
		}
	}

}