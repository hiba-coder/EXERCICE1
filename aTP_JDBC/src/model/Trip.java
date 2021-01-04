package model;

public class Trip {
	public int id;
	public Place departure;
	public Place destination;
	public double price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id; 
	}
	public Place getDeparture() {
		return departure;
	}
	public void setDeparture(Place departure) {
		this.departure = departure;
	}
	public Place getDestination() {
		return destination;
	}
	public void setDestination(Place destination) {
		this.destination = destination;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "* nemero de la trip " + id +" de price : "+price+ "DH \n"
				+ "- departure=" + departure.getNamePlace()+ "\n"
				+ "- destination=" + destination.getNamePlace() + "\n";
				
	}
	
	
}
