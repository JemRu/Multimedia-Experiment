public class HuffTree {
	int wmin1,wmin2;//记录权重
	int min1,min2;//记录索引
	public HuffTree(HuffNode[] huffnode,int nodenum) {
		/*
		 * n个子节点 n-1个内部节点 
		 * n个子节点right left 为-1
		 * 内部节点left right parent 初值-1 weight初值为0
		 * 
		 */
		
		for (int n = nodenum; n < (2*nodenum - 1);n++) {
			
			/*
			 * 寻找有权重的节点中，最小的两个节点
			 * 记录最小的两个weight为wmin1 wmin2
			 * 记录这两个节点对应的数组中的索引 min1 min2
			 * 
			 */
			int i = 1;
			wmin1 = huffnode[0].weight;
			wmin2 = huffnode[1].weight;
			min1 = 0;
			min2 = 1;
			while (i < (2*nodenum - 1)) {
				
				if (huffnode[i].weight != -1) {
					//判断最小两节点
					if (huffnode[i].weight < wmin1) {
						wmin2 = wmin1;
						min2 = min1;
						wmin1 = huffnode[i].weight;
						min1 = i;
					} else {
						if (huffnode[i].weight <= wmin2) {
							wmin2 = huffnode[i].weight;
							min2 = i;
						}
					}
				}
				i++;
			}
			//合并节点
			huffnode[n].weight = wmin1 + wmin2;
			//System.out.println("weight:"+huffnode[n].weight+"\n"+min1+":"+min2+"\nw:"+wmin1+":"+wmin2);
			huffnode[n].rchild = min1;
			huffnode[n].lchild = min2;
			huffnode[min1].parent = n;
			huffnode[min2].parent = n;

			//清除循环中两最小节点 wight
			huffnode[min1].weight = 999;
			huffnode[min2].weight = 999;
			
		}
		
	}

}
