public class HuffNode {
	public String c;//字符
    public int weight; //权重
    public int parent;//父节点在数组中的位置索引
    public int lchild;//左孩子在数组中的位置索引
    public int rchild;//右孩子在数组中的位置索引
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
