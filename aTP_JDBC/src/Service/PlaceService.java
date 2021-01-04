package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.PlaceDAO;
import SingleTon.SingConnection;
import model.Place;

public class PlaceService implements PlaceDAO {

	Connection connection = SingConnection.getConnection();

	@Override
	public List<Place> createPlace(Place p) {

		List<Place> places = new ArrayList<>();
		
		try {
			PreparedStatement prep = connection.prepareStatement("INSERT INTO Place(id,namePlace) VALUES (?,?);");
			prep.setInt(1, p.getId());
			prep.setString(2, p.getNamePlace());
			prep.executeUpdate();
			Statement statment = connection.createStatement();
			ResultSet rs = statment.executeQuery("SELECT * FROM Place ;");
			while(rs.next()) {
				Place place = new Place();
				place.setId(rs.getInt("id"));
				place.setNamePlace(rs.getString("namePlace"));
				places.add(place);
			}
			prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return places;
	}

	@Override
	public Place findPlaceById(int id) {
		Place place = new Place();
		try {
			Statement statment = connection.createStatement();
			ResultSet rs = statment.executeQuery("select * from Place where id = "+id+" ;");
			while(rs.next()) {
				
				place.setId(rs.getInt("id"));
				place.setNamePlace(rs.getString("namePlace"));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return place;
	}

	@Override
	public boolean updatePlace(int id,String namePlace) {
		boolean cle =  false;
		try {
			

			PreparedStatement prep = connection.prepareStatement("update Place set namePlace='"+namePlace+"' where id="+id+";");
			prep.executeUpdate();
			prep.close();
			cle=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cle;
	}

	@Override
	public boolean removePlace(int id ) {
		boolean cle =  false;
		try {
			PreparedStatement prep = connection.prepareStatement("DELETE FROM Place WHERE id ="+id+";");
			prep.executeUpdate();
			prep.close();
			cle=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cle;
	}

}
