import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;
public class HuffCode {

	public static void main(String[] args) {
		
		//input
		Scanner input = new Scanner(System.in);
		System.out.println("��������Ҫ������ַ�����");
		String prestr = input.nextLine();
		
		//���������ַ��г��ֵ��ַ�
		Set<String> chars = new HashSet<String>();
		int i = 0; 
		while (i < prestr.length()) {
			chars.add(prestr.substring(i,i+1));
			//System.out.println("add:"+prestr.substring(i,i+1));
			i++;
		}
		
		//��ʼ����Huffman���ڵ�
		HuffNode[] nodes = new HuffNode[2*(chars.size())-1];
		int q = 0;
		for (String str : chars) {
			
			//�ַ����ַ����г��ֵĸ���
			int count = 0;
			for (int n=0;n < prestr.length();n++) {
				if (str.equals(prestr.substring(n,n+1)))
					count++;
			}
			//System.out.println("count:"+count);
			
			HuffNode node = new HuffNode(str,count);
			nodes[q] = node;
			
			q++;
		}
		for (int n = chars.size();n < 2*(chars.size())-1 ;n++) {
			HuffNode node = new HuffNode();
			nodes[n] = node;
		}
		
		//����Huffman��
		HuffTree tree = new HuffTree(nodes,chars.size());
		
		//output �ַ�����
		//ȷ��ÿ���ַ��ı��� �Ӹ��ڵ㿪ʼ ˼·������ͼ
		// �ֵ���set�����е��ַ����Ӧ
		String[] dic = new String[chars.size()];
		HuffNode fixnode = new HuffNode();
		for(int index = 0 ;index < chars.size();index++) {
			String fixstr = "";
			fixnode = nodes[index];
			int indexnode = index;
			while (fixnode.parent != -1) {
				if (nodes[fixnode.parent].rchild == indexnode) {
					fixstr = "0".concat(fixstr);
				} else {
					fixstr = "1".concat(fixstr);
				}
				indexnode = fixnode.parent;
				fixnode = nodes[fixnode.parent];
			}
			//System.out.println("str:"+fixstr);
			dic[index] = fixstr;
		}
		
		//output HuffmanTree
		System.out.println("�Ӹ��ڵ��������Ϊ:");
		int m = 0;
		while (m < nodes.length) {
			System.out.println("�ڵ��ַ�ֵΪ:"+nodes[m].c);
			System.out.println("�ýڵ����ӽڵ�����Ϊ��"+nodes[m].rchild+"\n�ýڵ����ӽڵ�����Ϊ��"+nodes[m].lchild+"\n�ýڵ㸸�ڵ�����Ϊ��"+nodes[m].parent);
			m++;
		}
		
		//output dic
		System.out.println("---------------------------------------\n��������ַ������Ʊ���:");
		int k=0;
		while (k < chars.size()) {
			System.out.println(nodes[k].c+":"+dic[k]);
			k++;
		}
		
		//output prostring
		int w = 0; 
		String fixchar = "";
		String prostr = "";
		while (w < prestr.length()) {
			fixchar = prestr.substring(w,w+1);
			w++;
			int inchar = 0;
			while (inchar < chars.size()) {
				if (fixchar.equals(nodes[inchar].c)) {
					break;
				} else {
					inchar ++;
				}
			}
			prostr = prostr.concat(dic[inchar]);
		}
		System.out.println("---------------------------------------\n�ַ������������Ϊ��\n"+prostr);
		
	}

}
