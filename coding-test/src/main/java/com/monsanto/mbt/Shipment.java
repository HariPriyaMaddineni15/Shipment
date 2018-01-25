package com.monsanto.mbt;

import java.util.List;

public class Shipment {
	private String shipmentOption;
	private List<Widget> widgets;
	
	public List<Widget> getWidgets() {
		return widgets;
	}

	public void setWidgets(List<Widget> widgets) {
		this.widgets = widgets;
	}

	public String getShipmentOption() {
		return shipmentOption;
	}
	
	public void setShipmentOption(String shipmentOption) {
		this.shipmentOption = shipmentOption;
	}
	
	/*Method to creates hipment with th conditions that 
	1. there should be widgets selected
	2. no. of widgets should be <10
	3. he should select atleast one shipment method - Express/Normal
	if not throw him exception.*/ 
	public String createShippment() {

		if (this.widgets == null) {
			throw new RuntimeException("No widgets are added to shipment");
		}
		if (this.widgets.size() > 10) {
			throw new RuntimeException(
					"We can't allow the more than 10 widgets");
		}
		if (this.shipmentOption == null) {
			throw new RuntimeException("Please select shipment option");
		}

		return "Shipment has been created with widgets " + this.widgets
				+ " with shipment option " + this.shipmentOption;
	}

}