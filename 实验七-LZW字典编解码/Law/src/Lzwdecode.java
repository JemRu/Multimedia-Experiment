import java.awt.List;
import java.util.Arrays;
import java.util.Scanner;
public class Lzwdecode {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("��������Ҫ�����ַ�����");
		String prestr = input.nextLine();
		String prostr = "";//��ѹ��������ַ���
		String[] dic = new String[30];
		String fixchar = "";
		String fixstr = "";
		//�ֵ��ʼ��
		dic[0]="A";
		dic[1]="B";
		dic[2]="C";
		String code = prestr.substring(0, 1);//ǰһ��code
		prostr = prostr.concat(dic[Integer.parseInt(code)]);
		String ncode = "";//��һ��code
		int n = 1; //ָʾncode
		int offset = 0;//ָʾ�ֵ�λ��
		//��ѹ
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
		System.out.println("������ַ���Ϊ��"+prostr+"\n�ֵ�����Ϊ��");
		int i=0;
		while (dic[i]!=null) {
			System.out.println(i+":"+dic[i]);
			i++;
		}
		

	}

}
