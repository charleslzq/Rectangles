package indv.zqliu.Rectangles;

/**
 * �˳����������������ڽ��о��αȽϺ������жϲ���
 * @author ������
 * @version 1.0
 */
public interface RectangleComparator extends RectangleComparison,
		RectangleTypeProcessor {
	
	public double getError();
	public double getThreshold();

}