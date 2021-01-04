package DAO;

import java.util.List;

import model.Trip;

public interface TripDAO {
	public List<Trip> createTrip(Trip t);
	public Trip findTripById(int id);
	public boolean removeTrip(int id );
}
