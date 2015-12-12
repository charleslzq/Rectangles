package indv.zqliu.Rectangles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.Properties;

/**
 * 该类用于提供矩形比较和类型判断的默认操作。
 * 单例类，参数默认。
 * 需要改变参数请使用LocalRectangleComparator.
 * Y坐标从上到下，X坐标从左到右变大。
 * @author 刘正亓
 * @version 1.0
 */
public class DefaultRectangleComparator implements RectangleComparator {
	private final double threshold;
	private final ApproximateCalculator  ac;
	private static DefaultRectangleComparator instance;
	
	private DefaultRectangleComparator(double t, double e){
		threshold = t;
		ac = new ApproximateCalculator(e);
	}
	
	public static DefaultRectangleComparator getInstance(){
		if(instance == null){
			Properties properties = new Properties();
			try {
				FileInputStream fis = new FileInputStream("resources/DefaultRectangleComparisonSetting.xml");
				properties.loadFromXML(fis);
				double threshold = Double.valueOf(properties.getProperty("Threshold"));
				double error = Double.valueOf(properties.getProperty("Error"));
				instance = new DefaultRectangleComparator(threshold,error);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;
	}

	@Override
	/**
	 * 没有用
	 */
	public void setThreshold(double t) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public double getThreshold() {
		// TODO Auto-generated method stub
		return threshold;
	}
	
	public boolean equalWithInLineWidth(double a, double b){
		return Math.abs(a-b)<=threshold;
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
	public double getError() {
		// TODO Auto-generated method stub
		return ac.getErr();
	}

}
