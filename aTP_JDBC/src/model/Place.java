package model;

public class Place {
	public int id;
	public String namePlace;
	 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNamePlace() {
		return namePlace;
	}
	public void setNamePlace(String namePlace) {
		this.namePlace = namePlace;
	}
	@Override
	public String toString() {
		return " * numero de la place " + id + ", namePlace=" + namePlace+"\n" ;
	}
	
}
