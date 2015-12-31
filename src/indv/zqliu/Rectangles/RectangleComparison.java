package indv.zqliu.Rectangles;

import java.util.Comparator;
import java.util.List;

/**
 * 此接口用于定义两个矩形间的位置比较操作，不包括相邻性的判断
 * @author 刘正亓
 * @version 1.0
 */
public interface RectangleComparison {
	/**
	 * 此方法用于判断矩形ro1是否在矩形ro2的左侧
	 * @param ro1 第一个矩形 
	 * @param ro2 第二个矩形
	 * @return true, 如果ro1在ro2的左侧；否则为false
	 * @throws NullPointerException ro1,ro2不能为空
	 */
	public boolean isOnLeft(Rectangle ro1, Rectangle ro2);
	
	/**
	 * 此方法用于判断矩形ro1是否在矩形ro2的上方
	 * @param ro1 第一个矩形 
	 * @param ro2 第二个矩形
	 * @return true, 如果ro1在ro2的上方；否则为false
	 * @throws NullPointerException ro1,ro2不能为空
	 */
	public boolean isOnTop(Rectangle ro1, Rectangle ro2);
	
	/**
	 * 此方法用于判断矩形ro1是否在矩形ro2的左上方，排序结果优先在上方的矩形
	 * @param ro1 第一个矩形 
	 * @param ro2 第二个矩形
	 * @return true, 如果ro1在ro2的左上方；否则为false
	 * @throws NullPointerException ro1和ro2不能为空
	 */
	public boolean isOnTopLeft(Rectangle ro1, Rectangle ro2);
	
	/**
	 * 此方法用于判断矩形ro1是否在矩形ro2的左上方，排序结果优先在左方的矩形
	 * @param ro1 第一个矩形 
	 * @param ro2 第二个矩形
	 * @return true, 如果ro1在ro2的左侧；否则为false
	 * @throws NullPointerException ro1和ro2不能为空
	 */
	public boolean isOnLeftTop(Rectangle ro1, Rectangle ro2);
	
	/**
	 * 此方法用于判断矩形ro1是否与矩形ro2左对齐
	 * @param ro1 第一个矩形 
	 * @param ro2 第二个矩形
	 * @return true, 如果ro1与ro2左对齐；否则为false
	 * @throws NullPointerException ro1,ro2不能为空
	 */
	public boolean isLeftAlignment(Rectangle ro1, Rectangle ro2);
	
	/**
	 * 此方法用于判断矩形ro1是否与矩形ro2右对齐
	 * @param ro1 第一个矩形 
	 * @param ro2 第二个矩形
	 * @return true, 如果ro1与ro2右对齐；否则为false
	 * @throws NullPointerException ro1,ro2不能为空
	 */
	public boolean isRightAlignment(Rectangle ro1, Rectangle ro2);
	
	/**
	 * 此方法用于判断矩形ro1是否与矩形ro2上对齐
	 * @param ro1 第一个矩形 
	 * @param ro2 第二个矩形
	 * @return true, 如果ro1与ro2上对齐；否则为false
	 * @throws NullPointerException ro1,ro2不能为空
	 */
	public boolean isTopAlignment(Rectangle ro1, Rectangle ro2);
	
	/**
	 * 此方法用于判断矩形ro1是否与矩形ro2下对齐
	 * @param ro1 第一个矩形 
	 * @param ro2 第二个矩形
	 * @return true, 如果ro1与ro2下对齐；否则为false
	 * @throws NullPointerException ro1,ro2不能为空
	 */
	public boolean isBottomAlignment(Rectangle ro1, Rectangle ro2);
	
	/**
	 * 此方法用于判断矩形ro1是否与矩形ro2在垂直方向上中心对齐
	 * @param ro1 第一个矩形 
	 * @param ro2 第二个矩形
	 * @return true, 如果ro1与ro2在垂直方向上中心对齐；否则为false
	 * @throws NullPointerException ro1,ro2不能为空
	 */
	public boolean isMiddleAligmentVertically(Rectangle ro1, Rectangle ro2);
	
	/**
	 * 此方法用于判断矩形ro1是否与矩形ro2在水平方向上中心对齐
	 * @param ro1 第一个矩形 
	 * @param ro2 第二个矩形
	 * @return true, 如果ro1与ro2在水平方向上中心对齐；否则为false
	 * @throws NullPointerException ro1,ro2不能为空
	 */
	public boolean isMiddleAligmentHorizontally(Rectangle ro1, Rectangle ro2);
	
	/**
	 * 此方法用于判断矩形ro1是否与矩形ro2能被视为同一个矩形
	 * @param ro1 第一个矩形 
	 * @param ro2 第二个矩形
	 * @return true, 如果ro1与ro2可以被视为同一个矩形；否则为false
	 * @throws NullPointerException ro1,ro2不能为空
	 */
	public boolean isSameRectangle(Rectangle ro1, Rectangle ro2);
	
	/**
	 * 此方法用于判断ro1和ro2是否在水平方向上相连
	 * @param ro1 第一个矩形
	 * @param ro2 第二个矩形
	 * @return true，如果它们是相连的；否则返回false
	 * @throws NullPointerException ro1,ro2不能为空
	 */
	public boolean isConnectedHorizontally(Rectangle ro1, Rectangle ro2);
	
	/**
	 * 此方法用于判断ro1和ro2是否在垂直方向上相连
	 * @param ro1 第一个矩形
	 * @param ro2 第二个矩形
	 * @return true，如果它们是相连的；否则返回false
	 * @throws NullPointerException ro1,ro2不能为空
	 */
	public boolean isConnectedVertically(Rectangle ro1, Rectangle ro2);
	
	/**
	 * 此方法用于判断矩形ro1是否被矩形ro2所包含
	 * @param ro1 第一个矩形 
	 * @param ro2 第二个矩形
	 * @return true, 如果ro1被ro2所包含；否则为false
	 * @throws NullPointerException ro1,ro2不能为空
	 */
	public boolean isContainedBy(Rectangle ro1, Rectangle ro2);
	
	/**
	 * 此方法用于判断矩形ro1是否包含点(x,y)
	 * @param ro 矩形 
	 * @param x 点的横坐标
	 * @param y 点的横坐标
	 * @return true, 如果ro包含该点；否则为false
	 * @throws NullPointerException ro1不能为空
	 * @throws IllegalArgumentException x,y不能为负
	 */
	public boolean isContainPoint(Rectangle ro, double x, double y);
	
	/**
	 * 根据该类定义的比较算法返回一个比较器，
	 * 该比较器应该先按矩形的X坐标排序，
	 * 对于X坐标相同的，按Y坐标排序
	 * @return 一个比较器
	 */
	public Comparator<?> generateHVComparator();
	
	/**
	 * 根据该类定义的比较算法返回一个比较器，
	 * 该比较器应该先按矩形的Y坐标排序，
	 * 对于Y坐标相同的，按X坐标排序
	 * @return 一个比较器
	 */
	public Comparator<?> generateVHComparator();
	
	/**
	 * 对矩形列表先按Y坐标从小到大排序，
	 * 对于Y坐标几乎相同的按X坐标从小到大排序
	 * @param rects 要排序的矩形的列表
	 */
	public void sortVH(List<? extends Rectangle> rects);
	
	/**
	 * 对矩形列表先按X坐标从小到大排序，
	 * 对于X坐标几乎相同的按Y坐标从小到大排序
	 * @param rects 要排序的矩形的列表
	 */
	public void sortHV(List<? extends Rectangle> rects);
}
