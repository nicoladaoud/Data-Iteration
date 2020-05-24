package application;

import java.util.ArrayList;

import javafx.scene.control.TreeItem;

public class TreeviewHelper {

	public TreeviewHelper() 
	{
	}
	
	public ArrayList<TreeItem> getRooms(){
		
		ArrayList<TreeItem> Rooms = new ArrayList<>();
		
		/*
		 * Default rooms.
		 * 
		 * 1. Living room --> Television, Digital Watch, Air Conditioner.
		 * 2. Kitchen     --> Microwave, Pressure Cooker, Oven
		 * 3. Bathroom    --> Shower Faucet, Hand Drier, Hair Drier
		 * 
		 */
		TreeItem livingroom = new TreeItem("Living Room");
		livingroom.getChildren().addAll(get_living_room_appl());
		
		TreeItem kitchen = new TreeItem("Kitchen");
		kitchen.getChildren().addAll(get_kitchen_appl());
		
		TreeItem bathroom = new TreeItem("Bathroom");
		bathroom.getChildren().addAll(get_bathroom_appl());
		
		Rooms.add(livingroom);
		Rooms.add(kitchen);
		Rooms.add(bathroom);
		
		return Rooms;
	}
	
	private ArrayList<TreeItem> get_living_room_appl(){
		
		ArrayList<TreeItem> LRAppliance = new ArrayList<>();
		
		TreeItem tv = new TreeItem("TV");
		TreeItem dwatch = new TreeItem("Digital Watch");
		TreeItem AC = new TreeItem("Air Conditioner");
		
		LRAppliance.add(tv);
		LRAppliance.add(dwatch);
		LRAppliance.add(AC);
		
		return LRAppliance;
	
	}

	private ArrayList<TreeItem> get_kitchen_appl(){
		ArrayList<TreeItem> kitchenAppl = new ArrayList<>();
		
		TreeItem microwave = new TreeItem("Microwave");
		TreeItem pressure_cooker = new TreeItem("Pressure Cooker");
		TreeItem oven = new TreeItem("Oven");
		
		kitchenAppl.add(microwave);
		kitchenAppl.add(pressure_cooker);
		kitchenAppl.add(oven);
		
		return kitchenAppl;
		
	}

	private ArrayList<TreeItem> get_bathroom_appl(){
		ArrayList<TreeItem> bathroom_Appl = new ArrayList<>();
		
		TreeItem shower_faucet = new TreeItem("Shower Faucet");
		TreeItem hand_drier = new TreeItem("Hand Drier");
		TreeItem hair_drier = new TreeItem("Hair Drier");
		
		bathroom_Appl.add(shower_faucet);
		bathroom_Appl.add(hand_drier);
		bathroom_Appl.add(hair_drier);

		return bathroom_Appl;
	}
}
