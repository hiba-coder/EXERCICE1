package DAO;

import java.util.List;

import model.Place;

public interface PlaceDAO {
	public List<Place> createPlace(Place p);
	public Place findPlaceById(int id);
	public boolean updatePlace(int id,String namePlace);
	public boolean removePlace(int id);
}
