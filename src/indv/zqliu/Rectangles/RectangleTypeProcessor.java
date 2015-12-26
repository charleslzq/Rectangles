package indv.zqliu.Rectangles;


/**
 * �˽ӿ����ڶ�����εĵ����ͣ��㣬���ߣ����ߣ���Ԫ���ж�
 * @author ������
 * @version 1.0
 */
public interface RectangleTypeProcessor {
	public enum RectangleType {
		POINT,
		VLINE,
		HLINE,
		CELL
	}
	/**
	 * �趨�ж�����ֵ
	 * @param t �жϾ������͵���ֵ
	 * @throws IllegalArgumentException t<0
	 */
	public void setThreshold(double t) throws IllegalArgumentException;
	
	/**
	 * ��ȡ�ж�����ֵ
	 * @return �жϾ������͵���ֵ
	 */
	public double getThreshold();
	
	/**
	 * �жϾ��ε�����
	 * @param ro ����
	 * @return ���ε����ͣ��㣬���ߣ����ߣ���Ԫ��
	 * @throws IlleaglArgumentException ro����Ϊ��
	 */
	public RectangleType getType(Rectangle ro) throws IllegalArgumentException;
}
