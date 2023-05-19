package domain;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MapRecordIO implements Recordable{
	String fileName = "output_map.dat";
	public void saveTheMapIO(Map map) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(map.getTerritories());
            oos.close();
            fos.close();
            System.out.println("Map has been saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error occurred while saving the map to " + fileName);
            e.printStackTrace();
        }
	}
	
	public void saveTheOwnersOfTerritoriesIO(Map map) {
		for(int i = 0; i < map.getTerritories().size(); i++) {
	        try {
	            FileOutputStream fos = new FileOutputStream(fileName);
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(map.getTerritories().get(i).getOwner());
	            oos.close();
	            fos.close();
	            System.out.println("Owners of territories has been saved to " + fileName);
	        } catch (IOException e) {
	            System.out.println("Error occurred while saving the Owners of territories to " + fileName);
	            e.printStackTrace();
	        
	        }
		}
	}
	
	public void saveTheContinentsIO(Map map) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(map.getContinents());
            oos.close();
            fos.close();
            System.out.println("Continents has been saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error occurred while saving the continents to " + fileName);
            e.printStackTrace();
        }
	}
	
	public void saveTheArmyListOfTerritoriesIO(Map map) {
		for(int i = 0; i < map.getTerritories().size(); i++) {
	        try {
	            FileOutputStream fos = new FileOutputStream(fileName);
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(map.getTerritories().get(i).getArmyList());
	            oos.close();
	            fos.close();
	            System.out.println("ArmyList of a territory has been saved to " + fileName);
	        } catch (IOException e) {
	            System.out.println("Error occurred while saving the ArmyList of a territory to " + fileName);
	            e.printStackTrace();
	        }
       }
	}
	
	public void loadTheMapIO(Map map) {
		 try {
		        FileInputStream fis = new FileInputStream(fileName);
		        ObjectInputStream ois = new ObjectInputStream(fis);
		        map.setTerritories((ArrayList<Territory>) ois.readObject());
		        ois.close();
		        fis.close();
		        System.out.println("Map has been loaded from " + fileName);
		    } catch (IOException | ClassNotFoundException e) {
		        System.out.println("Error occurred while loading the map from " + fileName);
		        e.printStackTrace();
		    }
	}
	
	public void loadTheContinentsIO(Map map) {
		 try {
		        FileInputStream fis = new FileInputStream(fileName);
		        ObjectInputStream ois = new ObjectInputStream(fis);
		        map.setContinents((ArrayList<Continent>) ois.readObject());
		        ois.close();
		        fis.close();
		        System.out.println("Continents has been loaded from " + fileName);
		    } catch (IOException | ClassNotFoundException e) {
		        System.out.println("Error occurred while loading the continents from " + fileName);
		        e.printStackTrace();
		    }
	}
	
	public void loadTheOwnersOfTerritoriesIO(Map map) {
		for (int i = 0; i < map.getTerritories().size(); i++) {
	        try {
	            FileInputStream fis = new FileInputStream(fileName + "_" + i);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            map.getTerritories().get(i).setOwner((Player) ois.readObject());
	            ois.close();
	            fis.close();
	            System.out.println("Owner of territory " + i + " has been loaded from " + fileName);
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error occurred while loading the owner of territory " + i + " from " + fileName);
	            e.printStackTrace();
	        }
	    }
	}
	
	
	public void loadTheArmyListOfTerritoriesIO(Map map) {
		for (int i = 0; i < map.getTerritories().size(); i++) {
	        try {
	            FileInputStream fis = new FileInputStream(fileName + "_" + i);
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            map.getTerritories().get(i).setArmyList((ArrayList<Army>) ois.readObject());
	            ois.close();
	            fis.close();
	            System.out.println("ArmyList of territory " + i + " has been loaded from " + fileName);
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error occurred while loading the ArmyList of territory " + i + " from " + fileName);
	            e.printStackTrace();
	        }
	    }
	}
}
