package com.hotelresevation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HotelReservationSystemUC2 {

	private static final List<Integer> BridgeeWoodRegular = null;
	private HashMap<String, List<Integer>> lakeWood = new HashMap<>();
	private HashMap<String, List<Integer>> bridgeWood = new HashMap<>();
	private HashMap<String, List<Integer>> ridgeWood = new HashMap<>();
	private static int lakewoodRating;
	private static int bridgeWoodRating;
	public void HotelReservationSystem() {
		setLakeWood();
		setBridgeWood();
		setRidgeWood();
	}
	private void setRidgeWood() {
		List<Integer> RidgeWoodRewards = new ArrayList<>();
        RidgeWoodRewards.add(100);
        RidgeWoodRewards.add(40);

        List<Integer> RidgeWoodRegular = new ArrayList<>();
        RidgeWoodRegular.add(220);
        RidgeWoodRegular.add(150);
        
        RidgeWood.put("Rewards", RidgeWoodRewards);
        RidgeeWood.put("Regular", RidgeWoodRegular);
		
	}
	private void setBridgeWood() {
		List<Integer> BridgeWoodRewards = new ArrayList<>();
        BridgeWoodRewards.add(110);
        BridgeWoodRewards.add(50);

        List<Integer> BridgeWoodRegular = new ArrayList<>();
        BridgeWoodRegular.add(160);
        BridgeWoodRegular.add(60);
        
        BridgeWood.put("Rewards", BridgeWoodRewards);
        BridgeWood.put("Regular", BridgeeWoodRegular);
        bridgeWoodRating = 4;
	}
	private void setLakeWood() {
		List<Integer> lakeWoodRewards = new ArrayList<>();
        lakeWoodRewards.add(80);
        lakeWoodRewards.add(80);

        List<Integer> lakeWoodRegular = new ArrayList<>();
        lakeWoodRegular.add(110);
        lakeWoodRegular.add(90);
        
        lakeWood.put("Rewards", lakeWoodRewards);
        lakeWood.put("Regular", lakeWoodRegular);
        lakewoodRating = 3;
    }

    public String minCostHotel(String input) {
        String[] arr = input.split(",");
        String customerType = "";
        if (arr.length > 0) {
            String tempArr[] = arr[0].split(":");
            customerType = tempArr[0];
            arr[0] = tempArr[1];
        }
        String hotel = minCostHotel(customerType, arr);
        return hotel;
        	}
		private String minCostHotel(String customerType, String[] arr) {
			int numOfWeekdays = 0;
			int numOfWeekends = 0;
			int lakeWoodCost = 0;
			int BridgeWoodCost = 0;
			int RidgeWoodCost = 0;
for (int i = 0; i < arr.length; i++) {
	String day = arr[i];
	System.out.println(day); 
	if (day.contains("mon") || day.contains("tue") || day.contains("wed") || day.contains("thu") || day.contains("fri")) {
		numOfWeekdays++;
		} 
	else
	{ numOfWeekends++; 
	}
	}
List<Integer> valuesForLakewood = lakeWood.get(customerType);
List<Integer> valuesForBridgeWood = bridgeWood.get(customerType); 
List<Integer> valuesForRidgeWood = ridgeWood.get(customerType);
lakeWoodCost = numOfWeekdays * valuesForLakewood.get(0) + numOfWeekends * valuesForLakewood.get(1);
BridgeWoodCost = numOfWeekdays * valuesForBridgeWood.get(0) + numOfWeekends * valuesForBridgeWood.get(1);
RidgeWoodCost = numOfWeekdays * valuesForRidgeWood.get(0) + numOfWeekends * valuesForRidgeWood.get(1);
String hotel = minCost(lakeWoodCost, BridgeWoodCost, RidgeWoodCost);
System.out.println(lakeWoodCost + " " + BridgeWoodCost + " " + RidgeWoodCost);
return hotel;
} 
		private String minCost(int lakeWoodCost, int bridgeWoodCost, int ridgeWoodCost) {
			int minCost = Math.min(lakeWoodCost, Math.min(bridgeWoodCost, ridgeWoodCost));
			if (minCost == lakeWoodCost && minCost == bridgeWoodCost) {
				return bridgeWoodRating > lakewoodRating ? "BridgeWood" : "LakeWood"; }
			else if (minCost == bridgeWoodCost && minCost == ridgeWoodCost) { 
				return bridgeWoodRating > ridgeWoodCost ? "BridgeWood" : "RidgeWood"; 
				}
			else if (minCost == lakeWoodCost && minCost == ridgeWoodCost) {
				return lakeWoodCost > ridgeWoodCost ? "LakeWood" : "RidgeWood";
				}
			else 
			{
				if (minCost == lakeWoodCost) { return "LakeWood"; 
				}
				else if (minCost == bridgeWoodCost) { return "BridgeWood";
				}
				else
				{
					return "RidgeWood";
					}
				}
			}
		public static void main(String[] args) {
			String input1 = "Rewards: 26Mar2009(thu), 27Mar2009(fri), 28Mar2009(sat)";
			HotelReservationSystemUC2 hotelRoom = new HotelReservationSystemUC2();
			String hotel = hotelRoom.minCostHotel(input1);
			System.out.println(hotel);
			}
		}