import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;
public class HuffCode {

	public static void main(String[] args) {
		
		//input
		Scanner input = new Scanner(System.in);
		System.out.println("请输入需要编码的字符串：");
		String prestr = input.nextLine();
		
		//遍历输入字符中出现的字符
		Set<String> chars = new HashSet<String>();
		int i = 0; 
		while (i < prestr.length()) {
			chars.add(prestr.substring(i,i+1));
			//System.out.println("add:"+prestr.substring(i,i+1));
			i++;
		}
		
		//初始构造Huffman树节点
		HuffNode[] nodes = new HuffNode[2*(chars.size())-1];
		int q = 0;
		for (String str : chars) {
			
			//字符在字符串中出现的个数
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
		
		//构造Huffman树
		HuffTree tree = new HuffTree(nodes,chars.size());
		
		//output 字符编码
		//确定每个字符的编码 从根节点开始 思路见流程图
		// 字典与set集合中的字符相对应
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
		System.out.println("从根节点依次输出为:");
		int m = 0;
		while (m < nodes.length) {
			System.out.println("节点字符值为:"+nodes[m].c);
			System.out.println("该节点左子节点索引为："+nodes[m].rchild+"\n该节点右子节点索引为："+nodes[m].lchild+"\n该节点父节点索引为："+nodes[m].parent);
			m++;
		}
		
		//output dic
		System.out.println("---------------------------------------\n依次输出字符二进制编码:");
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
		System.out.println("---------------------------------------\n字符串经过编码后为：\n"+prostr);
		
	}

}
