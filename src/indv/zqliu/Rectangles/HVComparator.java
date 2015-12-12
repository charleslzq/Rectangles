package indv.zqliu.Rectangles;

import java.util.Comparator;

/**
 * 矩形的比较器，用于将矩形先按X坐标从小到大排序，
 * 对于X坐标基本一样的以Y坐标从小到大排序
 * 需要将JAVA内部排序方式改为之前的归并排序算法（Tim排序会出错）
 * @author zqliu
 * @version 1.0
 */
public class HVComparator implements Comparator<Rectangle> {
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
