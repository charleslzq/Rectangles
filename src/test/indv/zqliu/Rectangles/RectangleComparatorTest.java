package test.indv.zqliu.Rectangles;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import indv.zqliu.Rectangles.DefaultRectangleComparator;
import indv.zqliu.Rectangles.Rectangle;
import indv.zqliu.Rectangles.RectangleFactory;

public class RectangleComparatorTest {
	List<Rectangle> rects;
	DefaultRectangleComparator comparator;
	RectangleFactory factory;
	
	@Before
	public void setup(){
		comparator = DefaultRectangleComparator.getInstance();
		factory = new RectangleFactory(comparator);
		Rectangle r1 = factory.getRectangle(10,10,1,10);
		Rectangle r2 = factory.getRectangle(10,20,10,1);
		Rectangle r3 = factory.getRectangle(20,10,1,1);
		Rectangle r4 = factory.getRectangle(20,20,10,10);
		rects = new ArrayList<Rectangle>();
		rects.add(r4);
		
		rects.add(r2);
		rects.add(r1);
		rects.add(r3);
		
		
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
		System.out.println("VH:");
		for(Rectangle sr:rects){
			System.out.println(sr.toString());
		}
	}

}
