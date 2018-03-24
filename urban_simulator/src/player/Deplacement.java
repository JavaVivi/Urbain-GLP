package player;

import java.util.ArrayList;

import processing.Point;
import processing.Route;
import processing.RouteAlreadyExistsException;
/**
 * 
 * @author François-Laurent
 *
 */

public class Deplacement {

	private Routebook routebook = new Routebook();
	
	public void move(Route route, Player player) {
		
		int i;
		
		String[] options;
		
		options= route.move.split("-");
		int lg  = options.length;
		
		
		for (i=0; i < lg ; i++) {
			String argument= options[i];
			
			  Point waypoint=route.journey.get(i);
			  Point end =route.journey.get(i+1);
			  
			  int wx = player.getX();
			  int wy = player.getY();
			  
			  int ex = end.getX();  
			  int ey = end.getY();
			  
			  
			  System.out.println("Depart");
			  if (argument.compareToIgnoreCase("L") == 0 ){
				  int x1;
				for(x1=wx ; x1 >ex ; x1-=40 ) {
					player.setX(x1);
					System.out.println(player.getX()+";"+player.getY());
				}
				
			  }
			
			  else if (argument.compareToIgnoreCase("R") == 0) {
				  int x2;
				  for(x2=wx ; x2 <ex ; x2+=40 ){
					  player.setX(x2);
					  System.out.println(player.getX()+";"+player.getY());
					}
				}
			  
			  else if (argument.compareToIgnoreCase("U") == 0) {
				   int y1;
				   for(y1=wy ; y1 >ey ; y1-=40 ) {
					player.setY(y1);
					System.out.println(player.getX()+";"+player.getY());
					}
				}
			  
			  else if (argument.compareToIgnoreCase("D") == 0) {
				  int y2;
				  System.out.println("D");
				  for(y2=wy ; y2 <ey ; y2+=40 ) {	
					player.setY(y2);
					System.out.println(player.getX()+";"+player.getY());
					}
			  	}
			  else {
				  
				  System.err.println("Lack of information");
			  
			  }
			  
			  
		}
	}
	
	
	public void setRoutebook() {
		/*chemin début la maison*/
		
		//home -> work 
		String h_w = "D-R-U";
		Point h_w1, h_w2, h_w3;
		h_w1=new Point(40, 520);h_w2=new Point(200,520);h_w3=new Point(200,360);
		ArrayList<Point>home_work =new ArrayList<Point>();
		home_work.add(h_w1);home_work.add(h_w2);home_work.add(h_w3);
		Route h_1 = new Route("home-work", h_w,home_work);
		//home -> salle de sport
		String h_s = "D-R-U";
		Point h_s1, h_s2, h_s3;
		h_s1=new Point(40, 200);h_s2=new Point(240,200);h_s3=new Point(240,120);
		ArrayList<Point>home_sport =new ArrayList<Point>();
		home_sport.add(h_s1);home_sport.add(h_s2);home_sport.add(h_s3);
		Route h_2 = new Route("home-sport", h_s,home_sport);
		
		//home -> salle de cinema
		String h_ci = "D-R-U";
		Point h_ci1, h_ci2, h_ci3;
		h_ci1=new Point(40, 200);h_ci2=new Point(400,200);h_ci3=new Point(400,120);
		ArrayList<Point>home_cine =new ArrayList<Point>();
		home_cine.add(h_ci1);home_cine.add(h_ci2);home_cine.add(h_ci3);
		Route h_3 = new Route("home-cinema", h_ci,home_cine);
		
		//home -> salle de concert
		String h_co = "D-R-U";
		Point h_co1, h_co2, h_co3;
		h_co1=new Point(40, 200);h_co2=new Point(560,200);h_co3=new Point(560,120);
		ArrayList<Point>home_concert =new ArrayList<Point>();
		home_concert.add(h_co1);home_concert.add(h_co2);home_concert.add(h_co3);
		Route h_4 = new Route("home-concert", h_co,home_concert);
		
		//home -> restaurant
		String h_r = "D-R-D-R";
		Point h_r1, h_r2, h_r3, h_r4;
		h_r1=new Point(40, 200);h_r2=new Point(360,200);h_r3=new Point(360,320);h_r4=new Point(440,320);
		ArrayList<Point>home_resto=new ArrayList<Point>();
		home_resto.add(h_r1);home_resto.add(h_r2);home_resto.add(h_r3);home_resto.add(h_r4);
		Route h_5= new Route("home-restaurant", h_r,home_resto);
		
		try {
			routebook.add(h_1);
		} catch (RouteAlreadyExistsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}try {
			routebook.add(h_2);
		} catch (RouteAlreadyExistsException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}try {
			routebook.add(h_3);
		} catch (RouteAlreadyExistsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}try {
			routebook.add(h_4);
		} catch (RouteAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			routebook.add(h_5);
		} catch (RouteAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*chemin début le travail*/
		//work -> home 
		String w_h = "D-L-U";
		Point w_h1, w_h2, w_h3;
		w_h1=new Point(200,520);w_h2=new Point(40, 520);w_h3=new Point(40,80);
		ArrayList<Point>work_home =new ArrayList<Point>();
		work_home.add(w_h1);work_home.add(w_h2);work_home.add(w_h3);
		Route w_1 = new Route("work-home", w_h,work_home);
		
		//work -> salle de sport
		String w_s = "D-R-U";
		Point w_s1, w_s2, w_s3;
		w_s1=new Point(40, 200);w_s2=new Point(240,200);w_s3=new Point(240,120);
		ArrayList<Point>work_sport =new ArrayList<Point>();
		work_sport.add(w_s1);work_sport.add(w_s2);work_sport.add(w_s3);
		Route w_2 = new Route("work-sport", w_s,work_sport);
				
		//work -> salle de cinema
		String w_ci = "D-R-U";
		Point w_ci1, w_ci2, w_ci3;
		w_ci1=new Point(40, 200);w_ci2=new Point(400,200);w_ci3=new Point(400,120);
		ArrayList<Point>work_cine =new ArrayList<Point>();
		work_cine.add(w_ci1);work_cine.add(w_ci2);work_cine.add(w_ci3);
		Route w_3 = new Route("work-cinema", w_ci,work_cine);
				
		//work -> salle de concert
		String w_co = "D-R-U";
		Point w_co1, w_co2, w_co3;
		w_co1=new Point(40, 200);w_co2=new Point(560,200);w_co3=new Point(560,120);
		ArrayList<Point>work_concert =new ArrayList<Point>();
		work_concert.add(w_co1);work_concert.add(w_co2);work_concert.add(w_co3);
		Route w_4 = new Route("work-concert", w_co,work_concert);
				
		//work -> restaurant
		String w_r = "D-R-D-R";
		Point w_r1, w_r2, w_r3, w_r4;
		w_r1=new Point(40, 200);w_r2=new Point(360,200);w_r3=new Point(360,320);w_r4=new Point(440,320);
		ArrayList<Point>work_resto=new ArrayList<Point>();
		work_resto.add(w_r1);work_resto.add(w_r2);work_resto.add(w_r3);work_resto.add(w_r4);
		Route w_5= new Route("work-restaurant", w_r,work_resto);		
		
		try {
			routebook.add(w_1);
		} catch (RouteAlreadyExistsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}try {
			routebook.add(w_2);
		} catch (RouteAlreadyExistsException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}try {
			routebook.add(w_3);
		} catch (RouteAlreadyExistsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}try {
			routebook.add(w_4);
		} catch (RouteAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			routebook.add(w_5);
		} catch (RouteAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*chemin début la salle de sport*/
		
		//salle de sport -> home 
		String s_h = "D-R-U";
		Point s_h1, s_h2, s_h3;
		s_h1=new Point(240,200);s_h2=new Point(40, 200);s_h3=new Point(40,80);
		ArrayList<Point>sport_home =new ArrayList<Point>();
		sport_home.add(s_h1);sport_home.add(s_h2);sport_home.add(s_h3);
		Route s_1 = new Route("work-home", s_h,sport_home);
				
		//salle de sport -> work
		String s_s = "D-R-U";
		Point s_w1, s_w2, s_w3, s_w4, s_w5;
		s_w1=new Point(280, 200);s_w2=new Point(400,200);s_w3=new Point(400,520);s_w4=new Point(200,520);s_w5=new Point(200,280);
		ArrayList<Point>sport_sport =new ArrayList<Point>();
		sport_sport.add(s_w1);sport_sport.add(s_w2);sport_sport.add(s_w3);sport_sport.add(s_w4);sport_sport.add(s_w5);
		Route s_2 = new Route("home-sport", s_s,sport_sport);
						
		//salle de sport -> salle de cinema
		String s_ci = "D-R-U";
		Point s_ci1, s_ci2, s_ci3;
		s_ci1=new Point(240, 200);s_ci2=new Point(400,200);s_ci3=new Point(400,40);
		ArrayList<Point>sport_cine =new ArrayList<Point>();
		sport_cine.add(s_ci1);sport_cine.add(s_ci2);sport_cine.add(s_ci3);
		Route s_3 = new Route("work-cinema", s_ci,sport_cine);
						
		//salle de sport -> salle de concert
		String s_co = "D-R-U";
		Point s_co1, s_co2, s_co3;
		s_co1=new Point(240, 200);s_co2=new Point(520,200);s_co3=new Point(520,40);
		ArrayList<Point>sport_concert =new ArrayList<Point>();
		sport_concert.add(s_co1);sport_concert.add(s_co2);sport_concert.add(s_co3);
		Route s_4 = new Route("work-concert", s_co,sport_concert);
						
		//salle de sport -> restaurant
		String s_r = "D-R-D-R";
		Point s_r1, s_r2, s_r3, s_r4;
		s_r1=new Point(240, 200);s_r2=new Point(360,200);s_r3=new Point(360,320);s_r4=new Point(480,320);
		ArrayList<Point>sport_resto=new ArrayList<Point>();
		sport_resto.add(s_r1);sport_resto.add(s_r2);sport_resto.add(s_r3);sport_resto.add(s_r4);
		Route s_5= new Route("work-restaurant", s_r,sport_resto);		
				
		try {
			routebook.add(s_1);
		} catch (RouteAlreadyExistsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}try {
			routebook.add(s_2);
		} catch (RouteAlreadyExistsException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}try {
			routebook.add(s_3);
		} catch (RouteAlreadyExistsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}try {
			routebook.add(s_4);
		} catch (RouteAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			routebook.add(s_5);
		} catch (RouteAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*chemin début la salle de concert*/
		
		//salle de concert -> home 
		String co_h = "D-R-U";
		Point co_h1, co_h2, co_h3;
		co_h1=new Point(200,520);co_h2=new Point(40, 520);co_h3=new Point(40,80);
		ArrayList<Point>concert_home =new ArrayList<Point>();
		concert_home.add(co_h1);concert_home.add(co_h2);concert_home.add(co_h3);
		Route co_1 = new Route("concert-home", co_h,concert_home);
				
		//salle de concert -> sport
		String co_s = "D-R-U";
		Point co_s1, co_s2, co_s3;
		co_s1=new Point(40, 200);co_s2=new Point(240,200);co_s3=new Point(240,120);
		ArrayList<Point>concert_sport =new ArrayList<Point>();
		concert_sport.add(co_s1);concert_sport.add(co_s2);concert_sport.add(co_s3);
		Route co_2 = new Route("concert-work", co_s,concert_sport);
						
		//salle de concert -> salle de cinema
		String co_ci = "D-R-U";
		Point co_ci1, co_ci2, co_ci3;
		co_ci1=new Point(40, 200);co_ci2=new Point(400,200);co_ci3=new Point(400,120);
		ArrayList<Point>concert_cine =new ArrayList<Point>();
		concert_cine.add(co_ci1);concert_cine.add(co_ci2);concert_cine.add(co_ci3);
		Route co_3 = new Route("concert-cinema", co_ci,concert_cine);
						
		//salle de concert -> work
		String co_w = "D-R-U";
		Point co_w1, co_w2, co_w3;
		co_w1=new Point(40, 200);co_w2=new Point(560,200);co_w3=new Point(560,120);
		ArrayList<Point>concert_work =new ArrayList<Point>();
		concert_work.add(co_w1);concert_work.add(co_w2);concert_work.add(co_w3);
		Route co_4 = new Route("concert-sport", co_w,concert_work);
						
		//salle de concert -> restaurant
		String co_r = "D-R-D-R";
		Point co_r1, co_r2, co_r3, co_r4;
		co_r1=new Point(40, 200);co_r2=new Point(360,200);co_r3=new Point(360,320);co_r4=new Point(440,320);
		ArrayList<Point>concert_resto=new ArrayList<Point>();
		concert_resto.add(co_r1);concert_resto.add(co_r2);concert_resto.add(co_r3);concert_resto.add(co_r4);
		Route co_5= new Route("concert-restaurant", co_r,concert_resto);		
				
		try {
			routebook.add(s_1);
		} catch (RouteAlreadyExistsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}try {
			routebook.add(s_2);
		} catch (RouteAlreadyExistsException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}try {
			routebook.add(s_3);
		} catch (RouteAlreadyExistsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}try {
			routebook.add(s_4);
		} catch (RouteAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			routebook.add(s_5);
		} catch (RouteAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
/*chemin début la cinema*/
		
		//cinema -> home 
		String ci_h = "D-R-U";
		Point ci_h1, ci_h2, ci_h3;
		ci_h1=new Point(200,520);ci_h2=new Point(40, 520);ci_h3=new Point(40,80);
		ArrayList<Point>cine_home =new ArrayList<Point>();
		cine_home.add(ci_h1);cine_home.add(ci_h2);cine_home.add(ci_h3);
		Route ci_1 = new Route("cinema-home", ci_h,cine_home);
				
		//cinema -> work
		String ci_w = "D-R-U";
		Point ci_w1, ci_w2, ci_w3;
		ci_w1=new Point(40, 200);ci_w2=new Point(240,200);ci_w3=new Point(240,120);
		ArrayList<Point>cine_sport =new ArrayList<Point>();
		cine_sport.add(ci_w1);cine_sport.add(ci_w2);cine_sport.add(ci_w3);
		Route ci_2 = new Route("cinema-sport", ci_w,cine_sport);
						
		//cinema -> salle de cinema
		String ci_s = "D-R-U";
		Point ci_s1, ci_s2, ci_s3;
		ci_s1=new Point(40, 200);ci_s2=new Point(400,200);ci_s3=new Point(400,120);
		ArrayList<Point>cine_sne =new ArrayList<Point>();
		cine_sne.add(ci_s1);cine_sne.add(ci_s2);cine_sne.add(ci_s3);
		Route ci_3 = new Route("cinema-cinema", ci_s,cine_sne);
						
		//cinema -> salle de concert
		String ci_co = "D-R-U";
		Point ci_co1, ci_co2, ci_co3;
		ci_co1=new Point(40, 200);ci_co2=new Point(560,200);ci_co3=new Point(560,120);
		ArrayList<Point>cine_concert =new ArrayList<Point>();
		cine_concert.add(ci_co1);cine_concert.add(ci_co2);cine_concert.add(ci_co3);
		Route ci_4 = new Route("cinema-concert", ci_co,cine_concert);
						
		//cinema -> restaurant
		String ci_r = "D-R-D-R";
		Point ci_r1, ci_r2, ci_r3, ci_r4;
		ci_r1=new Point(40, 200);ci_r2=new Point(360,200);ci_r3=new Point(360,320);ci_r4=new Point(440,320);
		ArrayList<Point>cine_resto=new ArrayList<Point>();
		cine_resto.add(ci_r1);cine_resto.add(ci_r2);cine_resto.add(ci_r3);cine_resto.add(ci_r4);
		Route ci_5= new Route("cinema-restaurant", ci_r,cine_resto);		
				
		try {
			routebook.add(ci_1);
		} catch (RouteAlreadyExistsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}try {
			routebook.add(ci_2);
		} catch (RouteAlreadyExistsException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}try {
			routebook.add(ci_3);
		} catch (RouteAlreadyExistsException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}try {
			routebook.add(ci_4);
		} catch (RouteAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			routebook.add(ci_5);
		} catch (RouteAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
/*chemin début la restaurant*/
		
		//restaurant -> home 
		String r_h = "D-R-U";
		Point r_h1, r_h2, r_h3;
		r_h1=new Point(200,520);r_h2=new Point(40, 520);r_h3=new Point(40,80);
		ArrayList<Point>r_home =new ArrayList<Point>();
		r_home.add(r_h1);r_home.add(r_h2);r_home.add(r_h3);
		Route r_1 = new Route("restaurant-home", r_h,r_home);
				
		//restaurant -> work
		String r_w = "D-R-U";
		Point r_w1, r_w2, r_w3;
		r_w1=new Point(40, 200);r_w2=new Point(240,200);r_w3=new Point(240,120);
		ArrayList<Point>r_sport =new ArrayList<Point>();
		r_sport.add(r_w1);r_sport.add(r_w2);r_sport.add(r_w3);
		Route r_2 = new Route("restaurant-sport", r_w,r_sport);
						
		//restaurant -> salle de sport
		String r_s = "D-R-U";
		Point r_s1, r_s2, r_s3;
		r_s1=new Point(40, 200);r_s2=new Point(400,200);r_s3=new Point(400,120);
		ArrayList<Point>r_sne =new ArrayList<Point>();
		r_sne.add(r_s1);r_sne.add(r_s2);r_sne.add(r_s3);
		Route r_3 = new Route("restaurant-restaurant", r_s,r_sne);
						
		//restaurant -> salle de concert
		String r_co = "D-R-U";
		Point r_co1, r_co2, r_co3;
		r_co1=new Point(40, 200);r_co2=new Point(560,200);r_co3=new Point(560,120);
		ArrayList<Point>r_concert =new ArrayList<Point>();
		r_concert.add(r_co1);r_concert.add(r_co2);r_concert.add(r_co3);
		Route r_4 = new Route("restaurant-concert", r_co,r_concert);
		
		
		
		
	}
	
	public void goWork (Player player) {
		
		String lieu = player.getLieu()+"-work";
		
		Route route =routebook.recherchechemin(lieu);
		
		move(route, player);
	}
	
	public void goSport (Player player) {
		
		String lieu = player.getLieu()+"-sport";
		
		Route route =routebook.recherchechemin(lieu);
		
		move(route, player);
	}
	
	public void goHome (Player player) {
		
		String lieu = player.getLieu()+"-home";
		
		Route route =routebook.recherchechemin(lieu);
		
		move(route, player);
	}
	
	public void goResto (Player player) {
		
		String lieu = player.getLieu()+"-restaurant";
		
		Route route =routebook.recherchechemin(lieu);
		
		move(route, player);
	}
	
	public void goCine (Player player) {
		
		String lieu = player.getLieu()+"-cinema";
		
		Route route =routebook.recherchechemin(lieu);
		
		move(route, player);
	}
	
	public void goConcert (Player player) {
		
		String lieu = player.getLieu()+"-concert";
		
		Route route =routebook.recherchechemin(lieu);
		
		move(route, player);
	}
	
	
}
