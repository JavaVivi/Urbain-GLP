package test;
import processing.Route;
import processing.RouteAlreadyExistsException;
import processing.Trajectory;
import data.Particulars;

import java.util.ArrayList;

import processing.Point;
public class Test {
	public static void main(String[] args) {
		
		Trajectory plan =new Trajectory();
		
		Route r_1, r_2, r_3, r_4, r_5;
		
		Point dep1, inter1_1, inter2_1, inter3_1, inter4_1, end_1;
		Point dep2, inter1_2, inter2_2, end_2;
		Point dep3, inter1_3, inter2_3, inter3_3, end_3;
		Point dep4, inter1_4, inter2_4, inter3_4, inter4_4, end_4;
		Point dep5, inter1_5, inter2_5, inter3_5, inter4_5, inter5_5, end_5;
		
		dep1=new Point(0,0);dep2=new Point(10,0);dep3=new Point(20 ,0 );dep4=new Point(0 ,10 );dep5=new Point( 15,15 );
		inter1_1=new Point(0,5 );inter2_1=new Point( 5, 5);inter3_1=new Point(9 ,5 );inter4_1=new Point(9 , 0);
		inter1_2=new Point(15 ,0 );inter2_2=new Point(15 ,20 );
		inter1_3=new Point(20 , 5);inter2_3=new Point( 15,5 );inter3_3=new Point(15 , 3);
		inter1_4=new Point(15 , 10);inter2_4=new Point(15 ,5 );inter3_4=new Point( 20,5 );inter4_4=new Point(20 , 10);
		inter1_5=new Point(15 , 20);inter2_5=new Point(5 ,20 );inter3_5=new Point(5,10 );inter4_5=new Point(10,10 );inter5_5=new Point(10 ,15 );
		end_1=new Point(0 ,0 );end_2=new Point( 5,20 );end_3=new Point(5 ,3 );end_4=new Point(15 ,10 );end_5=new Point(15 ,15 );
		
		
		ArrayList<Point>parcours_1 =new ArrayList<Point>();
		ArrayList<Point>parcours_2 =new ArrayList<Point>();
		ArrayList<Point>parcours_3 =new ArrayList<Point>();
		ArrayList<Point>parcours_4 =new ArrayList<Point>();
		ArrayList<Point>parcours_5 =new ArrayList<Point>();
		
		
		parcours_1.add(dep1);parcours_1.add(inter1_1);parcours_1.add(inter2_1);parcours_1.add(inter3_1);parcours_1.add(inter4_1);parcours_1.add(end_1);
		parcours_2.add(dep2);parcours_2.add(inter1_2);parcours_2.add(inter2_2);parcours_2.add(end_2);
		parcours_3.add(dep3);parcours_3.add(inter1_3);parcours_3.add(inter2_3);parcours_3.add(inter3_3);parcours_3.add(end_3);
		parcours_4.add(dep4);parcours_4.add(inter1_4);parcours_4.add(inter2_4);parcours_4.add(inter3_4);parcours_4.add(inter4_4);parcours_4.add(end_4);
		parcours_5.add(dep5);parcours_5.add(inter1_5);parcours_5.add(inter2_5);parcours_5.add(inter3_5);parcours_5.add(inter4_5);parcours_5.add(inter5_5);parcours_1.add(dep1);parcours_5.add(end_5);
		
		
		String [] s_1 = {"R","D","R","U","L","L"};
		String [] s_2 = {"R","D","L"};
		String [] s_3 = {"D","R","U","L"};
		String [] s_4 = {"L","U","R","D","L"};
		String s_5 = "D-L-U-R-D-L";
		
		/*r_1= new Route("Lieu1-Lieu2", s_1,parcours_1);
		r_2= new Route("Lieu3-Lieu4", s_2,parcours_2);
		r_3= new Route("Lieu5-Lieu6", s_3,parcours_3);
		r_4= new Route("Lieu7-Lieu8", s_4,parcours_4);
		*/
		r_5= new Route("Lieu9-Lieu10", s_5,parcours_5);
	
		Particulars pop1 = new Particulars(0,0);
		Particulars pop2 = new Particulars(10,0);
		Particulars pop3 = new Particulars(20,0);
		Particulars pop4 = new Particulars(0,10);
		Particulars pop5 = new Particulars(15,15);
		
		/*try {
			plan.add(r_1);
		} catch (RouteAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			plan.add(r_2);
		} catch (RouteAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			plan.add(r_3);
		} catch (RouteAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			plan.add(r_4);
		} catch (RouteAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		try {
			plan.add(r_5);
		} catch (RouteAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		/*System.out.println(r_1.getName());
		r_1.trip(pop1);
		System.out.println(r_2.getName());
		r_2.trip(pop2);
		System.out.println(r_3.getName());
		r_3.trip(pop3);
		System.out.println(r_4.getName());
		r_4.trip(pop4);
		*/
		System.out.println(r_5.getName());
		r_5.trip(pop5);

		
	}
}
