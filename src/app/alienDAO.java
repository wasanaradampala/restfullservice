package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class alienDAO {

	Connection con=null;
	public alienDAO() {
		
		String url="jdbc:mysql://localhost:3306/test";
		String username="root";
		String password="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Alien> getaliens() {
		List <Alien> alienlist=new ArrayList<>();
		String sql="select * from alien";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			//PreparedStatement st=con.prepareStatement(sql);
			//ResultSet rs=st.executeQuery();
			while(rs.next()) {
				Alien a1=new Alien();
				a1.setName(rs.getString(2));
				a1.setPoints(rs.getInt(3));
				a1.setId(rs.getInt(1));
				
				alienlist.add(a1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		return alienlist;
	}
	
	public Alien getalien(int id){
		
		String sql="select * from alien where id='"+id+"'";
		Alien a1=new Alien();
		try {
			Statement st=con.createStatement();
			//PreparedStatement st=con.prepareStatement(sql);
			
			ResultSet rs=st.executeQuery(sql);
		//	ResultSet rs=st.executeQuery();
			if(rs.next()) {
				
				a1.setName(rs.getString(2));
				a1.setPoints(rs.getInt(3));
				a1.setId(rs.getInt(1));
				
				//return a1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a1;
		
	}
	
	public void createAlien(Alien a) {
		String sql="insert into alien values (?,?,?)";
		Alien a1=new Alien();
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1,a.getId() );
			st.setString(2, a.getName());
			st.setInt(3,a.getPoints() );
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
