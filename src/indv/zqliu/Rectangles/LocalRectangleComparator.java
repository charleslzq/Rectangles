package indv.zqliu.Rectangles;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * 此类可用于对矩形进行位置比较和类型判断操作。
 * Y坐标从上到下，X坐标从左到右变大。
 * @author 刘正亓
 * @version 1.0
 */
public class LocalRectangleComparator implements RectangleComparator {
	private double threshold;
	private ApproximateCalculator  ac;
	public LocalRectangleComparator(double t, double e){
		threshold = t;
		ac = new ApproximateCalculator(e);
	}

	@Override
	public void setThreshold(double t) {
		// TODO Auto-generated method stub
		threshold = t;
	}

	@Override
	public double getThreshold() {
		// TODO Auto-generated method stub
		return threshold;
	}
	
	/**
	 * 设定坐标比较时所能允许的误差
	 * @param e 要设定的误差
	 */
	public void setError(double e){
		ac.setErr(e);
	}
	
	/**
	 * 获得坐标比较时所能允许的误差
	 * @return 误差
	 */
	public double getError(){
		return ac.getErr();
	}

	@Override
	public RectangleType getType(Rectangle ro) {
		// TODO Auto-generated method stub
		if(ro.getWidth() <= this.threshold){
			if(ro.getHeight() <= this.threshold)
				return RectangleType.POINT;
			return RectangleType.VLINE;
		}
		if(ro.getHeight() <= this.threshold)
			return RectangleType.HLINE;
		return RectangleType.CELL;
	}

	public boolean equalWithInLineWidth(double a, double b){
		return Math.abs(a-b)<=threshold;
	}

	@Override
	public boolean isOnLeft(Rectangle ro1, Rectangle ro2) {
		// TODO Auto-generated method stub
		return ac.strongLess(ro1.getMinX()+threshold, ro2.getMinX());
	}

	@Override
	public boolean isOnTop(Rectangle ro1, Rectangle ro2) {
		// TODO Auto-generated method stub
		return ac.strongLess(ro1.getMinY()+threshold, ro2.getMinY());
	}

	@Override
	public boolean isLeftAlignment(Rectangle ro1,
			Rectangle ro2) {
		// TODO Auto-generated method stub
		return this.equalWithInLineWidth(ro1.getMinX(), ro2.getMinX());
	}

	@Override
	public boolean isRightAlignment(Rectangle ro1,
			Rectangle ro2) {
		// TODO Auto-generated method stub
		return this.equalWithInLineWidth(ro1.getMaxX(), ro2.getMaxX());
	}

	@Override
	public boolean isTopAlignment(Rectangle ro1, Rectangle ro2) {
		// TODO Auto-generated method stub
		return this.equalWithInLineWidth(ro1.getMinY(), ro2.getMinY());
	}

	@Override
	public boolean isBottomAlignment(Rectangle ro1,
			Rectangle ro2) {
		// TODO Auto-generated method stub
		return this.equalWithInLineWidth(ro1.getMaxY(), ro2.getMaxY());
	}

	@Override
	public boolean isSameRectangle(Rectangle ro1,
			Rectangle ro2) {
		// TODO Auto-generated method stub
		return this.isLeftAlignment(ro1, ro2)
				&& this.isTopAlignment(ro1, ro2)
				&& this.isRightAlignment(ro1, ro2)
				&& this.isBottomAlignment(ro1, ro2);
	}

	@Override
	public boolean isContainedBy(Rectangle ro1, Rectangle ro2) {
		// TODO Auto-generated method stub
		return this.isContainPoint(ro2, ro1.getMinX(), ro1.getMinY()) 
				&& this.isContainPoint(ro2, ro1.getMaxX(), ro1.getMaxY());
	}

	@Override
	public boolean isContainPoint(Rectangle ro, double x, double y) {
		// TODO Auto-generated method stub
		if(x > ro.getMaxX())
			return false;
		if(x < ro.getMinX())
			return false;
		if(y > ro.getMaxY())
			return false;
		if(y < ro.getMinY())
			return false;
		return true;
	}

	@Override
	public boolean isMiddleAligmentVertically(Rectangle ro1,
			Rectangle ro2) {
		// TODO Auto-generated method stub
		return this.equalWithInLineWidth(ro1.getMidY(), ro2.getMidY());
	}

	@Override
	public boolean isMiddleAligmentHorizontally(Rectangle ro1,
			Rectangle ro2) {
		// TODO Auto-generated method stub
		return this.equalWithInLineWidth(ro1.getMidX(), ro2.getMidX());
	}

	@Override
	public boolean isOnTopLeft(Rectangle ro1, Rectangle ro2) {
		// TODO Auto-generated method stub
		if(this.isTopAlignment(ro1, ro2))
			return this.isOnLeft(ro1, ro2);
		else
			return this.isOnTop(ro1, ro2);
	}

	@Override
	public boolean isOnLeftTop(Rectangle ro1, Rectangle ro2) {
		// TODO Auto-generated method stub
		if(this.isLeftAlignment(ro1, ro2))
			return this.isOnTop(ro1, ro2);
		else
			return this.isOnLeft(ro1, ro2);
	}

	@Override
	public Comparator<Rectangle> generateHVComparator() {
		// TODO Auto-generated method stub
		return new HVComparator((RectangleComparison)this);
	}

	@Override
	public Comparator<Rectangle> generateVHComparator() {
		// TODO Auto-generated method stub
		return new VHComparator((RectangleComparison)this);
	}
	
	@Override
	public boolean isConnectedHorizontally(Rectangle ro1,
			Rectangle ro2) {
		// TODO Auto-generated method stub
		return ac.strongLess(Math.abs(ro1.getMaxX()-ro2.getMinX()), threshold);
	}

	@Override
	public boolean isConnectedVertically(Rectangle ro1,
			Rectangle ro2) {
		// TODO Auto-generated method stub
		return ac.strongLess(Math.abs(ro1.getMaxY()-ro2.getMinY()), threshold);
	}

	@Override
	public void sortVH(List<? extends Rectangle> rects) {
		// TODO Auto-generated method stub
		Comparator<Rectangle> cpt =  this.generateVHComparator();
		Collections.sort(rects, cpt);
	}

	@Override
	public void sortHV(List<? extends Rectangle> rects) {
		// TODO Auto-generated method stub
		Comparator<Rectangle> cpt =  this.generateHVComparator();
		Collections.sort(rects, cpt);
	}

	
}
