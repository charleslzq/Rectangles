package indv.zqliu.Rectangles;


/**
 * �˽ӿ����ڶ�����εĵ����ͣ��㣬���ߣ����ߣ���Ԫ���ж�
 * @author ������
 * @version 1.0
 */
public interface RectangleTypeProcessor {
	/**
	 * �趨�ж�����ֵ
	 * @param t �жϾ������͵���ֵ
	 */
	public void setThreshold(double t);
	
	/**
	 * ��ȡ�ж�����ֵ
	 * @return �жϾ������͵���ֵ
	 */
	public double getThreshold();
	
	/**
	 * �жϾ��ε�����
	 * @param ro ����
	 * @return ���ε����ͣ��㣬���ߣ����ߣ���Ԫ��
	 */
	public RectangleType getType(Rectangle ro);
}
