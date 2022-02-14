package com.test.app.common;

class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Point)) {
			System.out.println("캐스팅 안됨");
			return false;
		}
		Point p = (Point) obj;
		if(x == p.x && y == p.y) {
			return true;
		}
		
		return false;
	}
}



public class Test2 {

	public static void main(String[] args) {
		Point p1 = new Point(10,20);
		Point p2 = new Point(9,19);
	
		
		if(p1.equals(new A())) {
			System.out.println();
		}
		
		
		if(p1.equals(p2)) {  //비교연산자
			System.out.println("같다.");
		}
		else {
			System.out.println("다르다");
		}
	}
}
