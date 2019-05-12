package problems.practice;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author sushi
 *
 */
public class SpiralOrderingMatrix {

	public static void main(String[] args) {
		
		List<List<Integer>> squareMatrix = new ArrayList<>();
		
		List<Integer> list1= new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		
		List<Integer> list2= new ArrayList<>();
		list2.add(4);
		list2.add(5);
		list2.add(6);
		
		List<Integer> list3= new ArrayList<>();
		list3.add(7);
		list3.add(8);
		list3.add(9);
		
		squareMatrix.add(list1);
		squareMatrix.add(list2);
		squareMatrix.add(list3);
		List<Integer> spiralOrdering =matrixInSpiralOrder(squareMatrix);
		
		for(int temp : spiralOrdering) {
			System.out.println(temp);
		}

	}

	public static List<Integer> matrixInSpiralOrder(List<List<Integer>> squareMatrix){
		
		List<Integer> spiralOrdering = new ArrayList<>();
		
		int[][] SHIFT = {{0,1},{1,0},{0,-1},{-1,0}};
		int dir =0;
		int x =0;
		int y =0;
		
		for(int i=0;i<squareMatrix.size()*squareMatrix.size();++i) {
			spiralOrdering.add(squareMatrix.get(x).get(y));
			squareMatrix.get(x).set(y, 0);
			int nextX = x + SHIFT[dir][0];
			int nextY = y + SHIFT[dir][1];
			
			if(nextX < 0 || nextX >=squareMatrix.size() || nextY<0 || nextY>=squareMatrix.size() || squareMatrix.get(nextX).get(nextY)==0) {
				dir = (dir + 1) % 4;
				nextX = x + SHIFT[dir][0];
				nextY = y + SHIFT[dir][1];
			}
			
			x = nextX;
			y = nextY;
		}
		return spiralOrdering;
		
	}
	
	
	public static List<Integer> matrixInSpiralOrder1(List<List<Integer>> squareMatrix) {
			final int[][] SHIFT = {{0 , 1}, {1, 0} , {0, -1}, {-1, 0}};
			int dir = 0, x = 0 , y = 0 ;
			List<Integer> spiralOrdering = new ArrayList <>();
			for (int i = 0; i < squareMatrix.size() * squareMatrix.size(); ++i) {
			spiralOrdering.add(squareMatrix.get(x).get(y));
			squareMatrix.get(x).set(y , 0);
			int nextX = x + SHIFT[dir][0], nextY = y + SHIFT[dir][1];
			if (nextX < 0 || nextX >= squareMatrix.size()|| nextY < 0
			|| nextY >= squareMatrix.size()
			|| squareMatrix.get(nextX).get(nextY) == 0) {
			dir = (dir + 1) % 4;
			nextX = x + SHIFT[dir][0];
			nextY = y + SHIFT[dir][1];
			}
			x = nextX;
			y = nextY ;
			}
			return spiralOrdering;
			}
}
