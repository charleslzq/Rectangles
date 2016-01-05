package indv.zqliu.Rectangles.Comparison;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import indv.zqliu.Rectangles.RectInterface.RectangleComparable;
import indv.zqliu.Rectangles.RectInterface.RectangleComparison;


/**
 * 此类可用于对矩形进行位置比较和类型判断操作。
 * Y坐标从上到下，X坐标从左到右变大。
 * @author 刘正亓
 * @version 1.0
 */
public class LocalRectangleComparator implements RectangleComparison {
	private double threshold;
	private ApproximateCalculator  ac;
	
	public LocalRectangleComparator(double t, double e){
		if(t<0)
			throw new IllegalArgumentException("Threshold should not be less than 0.");
		threshold = t;
		ac = new ApproximateCalculator(e);
	}

	@Override
	public void setThreshold(double t) {
		// TODO Auto-generated method stub
		if(t<0)
			throw new IllegalArgumentException("Threshold should not be less than 0.");
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
		if(e<0)
			throw new IllegalArgumentException("Error should not be less than 0.");
		ac = new ApproximateCalculator(e);
	}
	
	/**
	 * 获得坐标比较时所能允许的误差
	 * @return 误差
	 */
	public double getError(){
		return ac.getErr();
	}

	public boolean equalWithInLineWidth(double a, double b){
		return Math.abs(a-b)<=threshold;
	}

	@Override
	public boolean isOnLeft(RectangleComparable ro1, RectangleComparable ro2){
		// TODO Auto-generated method stub
		if(ro1 == null || ro2==null)
			throw new NullPointerException("Argument can't be null");
		return ac.strongLess(ro1.getMinX()+threshold, ro2.getMinX());
	}

	@Override
	public boolean isOnTop(RectangleComparable ro1, RectangleComparable ro2){
		// TODO Auto-generated method stub
		if(ro1 == null || ro2==null)
			throw new NullPointerException("Argument can't be null");
		return ac.strongLess(ro1.getMinY()+threshold, ro2.getMinY());
	}

	@Override
	public boolean isLeftAlignment(RectangleComparable ro1,RectangleComparable ro2){
		// TODO Auto-generated method stub
		if(ro1 == null || ro2==null)
			throw new NullPointerException("Argument can't be null");
		return this.equalWithInLineWidth(ro1.getMinX(), ro2.getMinX());
	}

	@Override
	public boolean isRightAlignment(RectangleComparable ro1,RectangleComparable ro2){
		// TODO Auto-generated method stub
		if(ro1 == null || ro2==null)
			throw new NullPointerException("Argument can't be null");
		return this.equalWithInLineWidth(ro1.getMaxX(), ro2.getMaxX());
	}

	@Override
	public boolean isTopAlignment(RectangleComparable ro1, RectangleComparable ro2){
		// TODO Auto-generated method stub
		if(ro1 == null || ro2==null)
			throw new NullPointerException("Argument can't be null");
		return this.equalWithInLineWidth(ro1.getMinY(), ro2.getMinY());
	}

	@Override
	public boolean isBottomAlignment(RectangleComparable ro1,RectangleComparable ro2){
		// TODO Auto-generated method stub
		if(ro1 == null || ro2==null)
			throw new NullPointerException("Argument can't be null");
		return this.equalWithInLineWidth(ro1.getMaxY(), ro2.getMaxY());
	}

	@Override
	public boolean isSameRectangle(RectangleComparable ro1,RectangleComparable ro2){
		// TODO Auto-generated method stub
		if(ro1 == null || ro2==null)
			throw new NullPointerException("Argument can't be null");
		return this.isLeftAlignment(ro1, ro2)
				&& this.isTopAlignment(ro1, ro2)
				&& this.isRightAlignment(ro1, ro2)
				&& this.isBottomAlignment(ro1, ro2);
	}

	@Override
	public boolean isContainedBy(RectangleComparable ro1, RectangleComparable ro2){
		// TODO Auto-generated method stub
		if(ro1 == null || ro2==null)
			throw new NullPointerException("Argument can't be null");
		return this.isContainPoint(ro2, ro1.getMinX(), ro1.getMinY()) 
				&& this.isContainPoint(ro2, ro1.getMaxX(), ro1.getMaxY());
	}

	@Override
	public boolean isContainPoint(RectangleComparable ro, double x, double y){
		// TODO Auto-generated method stub
		if(ro == null || x<0 || y<0)
			throw new NullPointerException("Argument cannot be null");
		if(x<0 || y<0)
			throw new IllegalArgumentException("Coordinates cannot be negative");
		
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
	public boolean isMiddleAligmentVertically(RectangleComparable ro1,RectangleComparable ro2){
				// TODO Auto-generated method stub
				if(ro1 == null || ro2==null)
					throw new NullPointerException("Argument can't be null");
		return this.equalWithInLineWidth(ro1.getMidY(), ro2.getMidY());
	}

	@Override
	public boolean isMiddleAligmentHorizontally(RectangleComparable ro1,RectangleComparable ro2){
				// TODO Auto-generated method stub
		if(ro1 == null || ro2==null)
			throw new NullPointerException("Argument can't be null");
		return this.equalWithInLineWidth(ro1.getMidX(), ro2.getMidX());
	}

	@Override
	public boolean isOnTopLeft(RectangleComparable ro1, RectangleComparable ro2){
		// TODO Auto-generated method stub
		if(ro1 == null || ro2==null)
			throw new NullPointerException("Argument can't be null");
		if(this.isTopAlignment(ro1, ro2))
			return this.isOnLeft(ro1, ro2);
		else
			return this.isOnTop(ro1, ro2);
	}

	@Override
	public boolean isOnLeftTop(RectangleComparable ro1, RectangleComparable ro2){
		// TODO Auto-generated method stub
		if(ro1 == null || ro2==null)
			throw new NullPointerException("Argument can't be null");
		if(this.isLeftAlignment(ro1, ro2))
			return this.isOnTop(ro1, ro2);
		else
			return this.isOnLeft(ro1, ro2);
	}

	@Override
	public Comparator<RectangleComparable> generateHVComparator() {
		// TODO Auto-generated method stub
		return new HVComparator((RectangleComparison)this);
	}

	@Override
	public Comparator<RectangleComparable> generateVHComparator() {
		// TODO Auto-generated method stub
		return new VHComparator((RectangleComparison)this);
	}
	
	@Override
	public boolean isConnectedHorizontally(RectangleComparable ro1,RectangleComparable ro2){
				// TODO Auto-generated method stub
				if(ro1 == null || ro2==null)
					throw new NullPointerException("Argument can't be null");
		return ac.strongLess(Math.abs(ro1.getMaxX()-ro2.getMinX()), threshold);
	}

	@Override
	public boolean isConnectedVertically(RectangleComparable ro1,RectangleComparable ro2){
		// TODO Auto-generated method stub
		if(ro1 == null || ro2==null)
			throw new NullPointerException("Argument can't be null");
		return ac.strongLess(Math.abs(ro1.getMaxY()-ro2.getMinY()), threshold);
	}

	@Override
	public void sortVH(List<? extends RectangleComparable> rects) {
		// TODO Auto-generated method stub
		Comparator<RectangleComparable> cpt =  this.generateVHComparator();
		Collections.sort(rects, cpt);
	}

	@Override
	public void sortHV(List<? extends RectangleComparable> rects) {
		// TODO Auto-generated method stub
		Comparator<RectangleComparable> cpt =  this.generateHVComparator();
		Collections.sort(rects, cpt);
	}

	
}
