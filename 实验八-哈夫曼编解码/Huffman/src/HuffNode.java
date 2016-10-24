public class HuffNode {
	public String c;//�ַ�
    public int weight; //Ȩ��
    public int parent;//���ڵ��������е�λ������
    public int lchild;//�����������е�λ������
    public int rchild;//�Һ����������е�λ������
	public HuffNode() {
		c = "0";
		weight = -1;
		parent = -1;
		lchild = -1;
		rchild = -1;
	}
	public HuffNode(String str,int w) {
		c = str;
		weight = w;
		parent = -1;
		lchild = -1;
		rchild = -1;
	}
	public void setC(String str) {
		c = str;
	}
	public void setLchild(int n) {
		lchild = n;
	}
	public void setRchild(int n) {
		rchild = n;
	}
//	public static void main(String[] args) {
//		HuffNode[] nodes = new HuffNode[3];
//		HuffNode node = new HuffNode();
//		nodes[0] = node;
//	}

}
