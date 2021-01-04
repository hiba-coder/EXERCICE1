package Test;

import java.util.List;
import java.util.Scanner;

import Service.PlaceService;
import Service.TripService;
import model.Place;
import model.Trip;

public class MainTest {

	public static void main(String[] args) {
		
		boolean cont = true;
		PlaceService placeservice = new PlaceService();
		TripService tripservice = new TripService();
		System.out.println("Welcome aboard ! ");
		System.out.println("What do you want to do ?");
		System.out.println("1 -> Add a place \n "
				+ "2 -> Find a place \n "
				+ "3 -> Edit a place \n "
				+ "4 -> Remove a place \n "
				+ "5 -> Add a trip \n"
				+ "6 -> Find a trip \n "
				+ "7 -> Remove a trip \n"
				+ "8 -> Quit \n");
		Scanner S = new Scanner(System.in);
		
        while(cont==true) {
        		System.out.print("Entrez un nombre corespond  votre opperation : ");
        		int i = S.nextInt();
				if(i==1) {
				Place place = new Place();
				System.out.print("the place code : ");
				place.setId(S.nextInt());
				System.out.print("the place name : ");
				place.setNamePlace(S.next());
				List<Place> places = placeservice.createPlace(place);
				System.out.println("THE PLACE WAS SUCCESSFULLY ADD ");
					for(Place p : places) {
						System.out.print(p);;
					}
			    }
			if(i==2) {
				System.out.print("Voulez vous chercher une place , Saisir le code donc  : ");
				int code = S.nextInt();
				Place place = placeservice.findPlaceById(code);
				System.out.println(place);
			}
			if(i==3) {
				boolean cle= false; 
				System.out.print("Voulez vous modifier une place , Saisir le code donc :  ");
				int code = S.nextInt();
				System.out.print("Saisir le nom de la place : ");
				cle = placeservice.updatePlace(code, S.next());
				
				if(cle==true) {
					System.out.print("Votre modification sont enregistrées :) ");
				}
				if(cle==false) {
					System.out.print("Verfiez vos données et essayez entre fois !");
				}
			}
			if(i==4) {
				boolean cle= false;
				System.out.print("Voulez vous supprimer une place  , Saisir le code donc :  ");
				int code = S.nextInt();
				Place place = placeservice.findPlaceById(code);
				System.out.print("Voulez vous vraiment supprimer la place de code :"+place.getId()+" et de nom : "+place.getNamePlace()+" ??(oui/non)");
				String rep = S.next();
				if(rep.equals("oui")) {
					cle = placeservice.removePlace(code);
				}
				
				System.out.print("cette place est supprimée :) ");
				
			}
			if(i==5) {
				Trip trip = new Trip();
				System.out.print("the trip code : ");
				trip.setId(S.nextInt());
				System.out.print("the trip code departure : ");
				Place departure = placeservice.findPlaceById(S.nextInt());
				trip.setDeparture(departure);
				System.out.print("the trip code destination: ");
				Place destination = placeservice.findPlaceById(S.nextInt());
				trip.setDestination(destination);
				System.out.print("the Trip price  : ");
				trip.setPrice(S.nextDouble());
				List<Trip> trips = tripservice.createTrip(trip);
				System.out.println("THE TRIP WAS SUCCESSFULLY ADD ");
				System.out.println("la list des Trips plannifiés : \n  ");
				for(Trip t : trips) {
					System.out.print(t);;
				}
			}
			if(i==6) {
				System.out.print("Voulez vous chercher une Trip , Saisir le code donc  : ");
				int code = S.nextInt();
				Trip trip = tripservice.findTripById(code);
				System.out.println(trip);
			}
			if(i==7) {
				boolean cle= false;
				System.out.print("Voulez vous supprimer une trip  , Saisir le code donc :  ");
				int code = S.nextInt();
				Trip trip = tripservice.findTripById(code);
				System.out.print("Voulez vous vraiment supprimer la trip de code :"+trip.getId()+" de "+trip.getDeparture().getNamePlace()+"vers"+trip.getDestination().getNamePlace()
						+" et de nom : "+trip.getPrice()+"DH ??(oui/non)");
				String rep = S.next();
				if(rep.equals("oui")) {
					cle = tripservice.removeTrip(code);
				}
				
				System.out.print("cette trip est supprimée :) ");
			}
			if(i==8) {
				cont = false;
			}
    }
        
	}
}
