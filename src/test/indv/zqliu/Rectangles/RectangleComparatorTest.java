package test.indv.zqliu.Rectangles;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import indv.zqliu.Rectangles.DefaultRectangleComparator;
import indv.zqliu.Rectangles.Rectangle;

public class RectangleComparatorTest {
	List<Rectangle> rects;
	DefaultRectangleComparator comparator;
	
	@Before
	public void setup(){
		Rectangle r1 = new Rectangle(10,10,1,1);
		Rectangle r2 = new Rectangle(10,20,1,1);
		Rectangle r3 = new Rectangle(20,10,1,1);
		Rectangle r4 = new Rectangle(20,20,1,1);
		rects = new ArrayList<Rectangle>();
		rects.add(r4);
		
		rects.add(r2);
		rects.add(r1);
		rects.add(r3);
		
		comparator = DefaultRectangleComparator.getInstance();
	}

	@Test
	public void testSortHV() {
		//fail("Not yet implemented");
		comparator.sortHV(rects);
		System.out.println("HV:");
		for(Rectangle sr:rects)
			System.out.println("("+sr.getMinX()+","+sr.getMinY()+")");
	}

	@Test
	public void testSortVH() {
		//fail("Not yet implemented");
		comparator.sortVH(rects);
		comparator.setThreshold(-0.3);
		System.out.println("VH:");
		for(Rectangle sr:rects){
			System.out.println("("+sr.getMinX()+","+sr.getMinY()+"):"+comparator.getType(sr));
		}
	}

}
