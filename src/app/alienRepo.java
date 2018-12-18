package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class alienRepo {
	
	List <Alien> alienlist;
	
	public alienRepo() {
		alienlist=new ArrayList();
		
		Alien a1=new Alien();
		a1.setName("wasss");
		a1.setPoints(10);
		a1.setId(1);
		
		Alien a2=new Alien();
		a2.setName("vimu");
		a2.setPoints(20);
		a2.setId(2);
		
		alienlist.add(a1);
		alienlist.add(a2);
		
		
	}
	
	public Alien getalien(int id){
	   
		//Alien a=null;
		
		for(Alien a :alienlist) {
			if(a.getId()==id) {
				return a;
			}
			
		}
		return null;
	}

	public List<Alien> getaliens() {
		// TODO Auto-generated method stub
		return alienlist;
	}
	
}
