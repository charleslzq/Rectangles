package indv.zqliu.Rectangles.Comparison;

import java.util.Comparator;

import indv.zqliu.Rectangles.RectInterface.RectangleComparable;
import indv.zqliu.Rectangles.RectInterface.RectangleComparison;

/**
 * 矩形的比较器，用于将矩形先按Y坐标从小到大排序，
 * 对于Y坐标基本一样的以X坐标从小到大排序
 * 需要将JAVA内部排序方式改为之前的归并排序算法（Tim排序会出错）
 * @author zqliu
 * @version 1.0
 */
class VHComparator implements Comparator<RectangleComparable> {
	RectangleComparison rc;
	
	public VHComparator(RectangleComparison method){
		rc = method;
	}

	@Override
	public int compare(RectangleComparable ro1, RectangleComparable ro2) {
		// TODO Auto-generated method stub
		if(rc.isOnTopLeft(ro1, ro2))
			return -1;
		if(rc.isOnTopLeft(ro2, ro1))
			return 1;
		return 0;
	}

}

