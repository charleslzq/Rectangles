package indv.zqliu.Rectangles;

import java.util.Comparator;

/**
 * ���εıȽ��������ڽ������Ȱ�X�����С��������
 * ����X�������һ������Y�����С��������
 * ��Ҫ��JAVA�ڲ�����ʽ��Ϊ֮ǰ�Ĺ鲢�����㷨��Tim��������
 * @author zqliu
 * @version 1.0
 */
class HVComparator implements Comparator<Rectangle> {
	RectangleComparison rc;
	
	public HVComparator(RectangleComparison method){
		rc = method;
	}

	@Override
	public int compare(Rectangle ro1, Rectangle ro2) {
		// TODO Auto-generated method stub
		if(rc.isOnLeftTop(ro1, ro2))
			return -1;
		if(rc.isOnLeftTop(ro2, ro1))
			return 1;
		return 0;
	}

}
