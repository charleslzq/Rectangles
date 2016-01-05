package indv.zqliu.Rectangles.DefaultImpl;

import indv.zqliu.Rectangles.Comparison.DefaultRectangleComparator;
import indv.zqliu.Rectangles.RectInterface.RectangleComparison;

public class RectangleFactory {
	private final RectangleComparison comparator;
	
	public RectangleFactory(){
		comparator = DefaultRectangleComparator.getInstance();
	}
	
	public RectangleFactory(RectangleComparison rc){
		comparator = rc;
	}
	
	/**
	 * 获取一个矩形
	 * @param x 顶点横坐标
	 * @param y 顶点纵坐标
	 * @param w 宽度
	 * @param h 高度
	 * @return 按参数设定的矩形矩形，横纵坐标可以为负，宽度高度如果为负则会转换成正值，同时转换横纵坐标
	 */
	public Rectangle getRectangle(double x, double y, double w, double h){
		x = w>0?x:x+w;
		y = h>0?y:y+h;
		w = w>0?w:-w;
		h = h>0?h:-h;
		if(w <= comparator.getThreshold()){
			if(h<=comparator.getThreshold())
				return new RectPoint(x,y,w,h);
			else
				return new RectVLine(x,y,w,h);
		}else{
			if(h<=comparator.getThreshold())
				return new RectHLine(x,y,w,h);
			else
				return new RectCell(x,y,w,h);
		}
	}
	
	/**
	 * 拷贝一个矩形
	 * @param rect 要拷贝的矩形
	 * @return 一个新的矩形，参数与原来的完全相同
	 */
	public Rectangle copy(Rectangle rect){
		double x = rect.getMinX();
		double y = rect.getMinY();
		double w = rect.getWidth();
		double h = rect.getHeight();
		return getRectangle(x,y,w,h);
	}
	
	/**
	 * 用于合并两个相连的矩形（参数位置任意）的通用方法，
	 * 内部不会做相连性判断
	 * @param r1 一个矩形
	 * @param r2 另一个矩形
	 * @return 新矩形，为包含两个矩形的最小矩形
	 */
	Rectangle merge(Rectangle r1, Rectangle r2){
		assert(r1!=null && r2!=null);
		double x = r1.getMinX()<r2.getMinX()?r1.getMinX():r2.getMinX();
		double y = r1.getMinY()<r2.getMinY()?r1.getMinY():r2.getMinY();
		double w = r1.getMaxX()>r2.getMaxX()?r1.getMaxX():r2.getMaxX() - x;
		double h = r1.getMaxY()>r2.getMaxY()?r1.getMaxY():r2.getMaxY() - y;
		return getRectangle(x,y,w,h);
	}
	
	/**
	 * 为矩形设定新的坐标值
	 * @param r 要更新的矩形
	 * @param x 新的x
	 * @param y 新的y
	 * @param w 新的宽度
	 * @param h 新的高度
	 * @return 更新后的矩形
	 */
	Rectangle update(Rectangle r, double x, double y, double w, double h){
		assert(r!=null);
		Rectangle tmp = getRectangle(x,y,w,h);
		if(!tmp.getClass().equals(r.getClass()))
			throw new ClassCastException("Cannot cast "+r.getClass().getName()+" to "+tmp.getClass().getName());
		return tmp;
	}

	/**
	 * 更新宽度，其它参数不变
	 * 如果更新后的矩形类型与原矩形类型（如RectVLine加大宽度后变成RectCell）
	 * 不一致会抛出ClassCaseException.
	 * @param r 原矩形
	 * @param w 新的宽度
	 * @return 新的矩形
	 */
	public Rectangle updateWidth(Rectangle r, int w) {
		// TODO Auto-generated method stub
		if(r == null)
			throw new NullPointerException();
		return update(r,r.getMinX(),r.getMinY(),w,r.getHeight());
	}
	
	/**
	 * 更新高度，其它参数不变。
	 * 如果更新后的矩形类型与原矩形类型（如RectHLine加大高度后变成RectCell）
	 * 不一致会抛出ClassCaseException.
	 * @param r 原矩形
	 * @param h 新的高度，不能小于0
	 * @return 新的矩形
	 */
	public Rectangle updateHeight(Rectangle r, int h){
		if(r == null)
			throw new NullPointerException();
		return update(r, r.getMinX(), r.getMinY(), r.getWidth(), h);
	}
}
