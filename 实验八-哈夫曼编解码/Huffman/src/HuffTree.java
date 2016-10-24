public class HuffTree {
	int wmin1,wmin2;//��¼Ȩ��
	int min1,min2;//��¼����
	public HuffTree(HuffNode[] huffnode,int nodenum) {
		/*
		 * n���ӽڵ� n-1���ڲ��ڵ� 
		 * n���ӽڵ�right left Ϊ-1
		 * �ڲ��ڵ�left right parent ��ֵ-1 weight��ֵΪ0
		 * 
		 */
		
		for (int n = nodenum; n < (2*nodenum - 1);n++) {
			
			/*
			 * Ѱ����Ȩ�صĽڵ��У���С�������ڵ�
			 * ��¼��С������weightΪwmin1 wmin2
			 * ��¼�������ڵ��Ӧ�������е����� min1 min2
			 * 
			 */
			int i = 1;
			wmin1 = huffnode[0].weight;
			wmin2 = huffnode[1].weight;
			min1 = 0;
			min2 = 1;
			while (i < (2*nodenum - 1)) {
				
				if (huffnode[i].weight != -1) {
					//�ж���С���ڵ�
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
			//�ϲ��ڵ�
			huffnode[n].weight = wmin1 + wmin2;
			//System.out.println("weight:"+huffnode[n].weight+"\n"+min1+":"+min2+"\nw:"+wmin1+":"+wmin2);
			huffnode[n].rchild = min1;
			huffnode[n].lchild = min2;
			huffnode[min1].parent = n;
			huffnode[min2].parent = n;

			//���ѭ��������С�ڵ� wight
			huffnode[min1].weight = 999;
			huffnode[min2].weight = 999;
			
		}
		
	}

}
