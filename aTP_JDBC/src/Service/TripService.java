package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import DAO.TripDAO;
import SingleTon.SingConnection;
import model.Place;
import model.Trip;

public class TripService implements TripDAO {

	Connection connection = SingConnection.getConnection();
	PlaceService placeservice = new PlaceService();
	
	@Override
	public List<Trip> createTrip(Trip t) {
		List<Trip> trips = new ArrayList<>();
		try {
			PreparedStatement prep = connection.prepareStatement("INSERT INTO Trip(id,departure,destination,price) VALUES (?,?,?,?);");
			prep.setInt(1, t.getId());
			prep.setInt(2, t.getDeparture().getId());
			prep.setInt(3, t.getDestination().getId());
			prep.setDouble(4,t.getPrice());
			prep.executeUpdate();
			Statement statment = connection.createStatement();
			ResultSet rs = statment.executeQuery("SELECT * FROM Trip ;");
			while(rs.next()) {
				Trip trip = new Trip();
				trip.setId(rs.getInt("id"));
				Place departure = placeservice.findPlaceById(rs.getInt("departure"));
				trip.setDeparture(departure);
				Place destination = placeservice.findPlaceById(rs.getInt("destination"));
				trip.setDestination(destination);
				trip.setPrice(rs.getDouble("price"));
				trips.add(trip);
			}
			prep.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return trips;
	}

	@Override
	public Trip findTripById(int id) {
		Trip trip = new Trip();
		try {
			Statement statment = connection.createStatement();
			ResultSet rs = statment.executeQuery("select * from Trip where id = "+id+" ;");
			while(rs.next()) {
				trip.setId(rs.getInt("id"));
				Place departure = placeservice.findPlaceById(rs.getInt("departure"));
				trip.setDeparture(departure);
				Place destination = placeservice.findPlaceById(rs.getInt("destination"));
				trip.setDestination(destination);
				trip.setPrice(rs.getDouble("price"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trip;
	}

	@Override
	public boolean removeTrip(int id) {
		boolean cle =  false;
		try {
			PreparedStatement prep = connection.prepareStatement("DELETE FROM Trip WHERE id ="+id+";");
			prep.executeUpdate();
			prep.close();
			cle=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cle;
	} 

	
	
}
