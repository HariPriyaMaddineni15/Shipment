package com.monsanto.mbt;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortUtil {
	public static void sortWidgets(List<Widget> widgetList, final String sortOption){
		//Sort the list with ordering comparision of Widgets using compareTo()		
		Collections.sort(widgetList,new Comparator<Widget>() {
			@Override
			public int compare(Widget widget1, Widget widget2) {
				//Sorting with color 
				if(sortOption.equalsIgnoreCase("color")){
					return widget1.getColor().compareTo(widget2.getColor());
				}
				//sorting with Production Date 
				if(sortOption.equalsIgnoreCase("productionDate")){
					return widget1.getProductionDate().compareTo(widget2.getProductionDate());
				}
				// TODO Auto-generated method stub
				return 0;
			}
		});
	}
}