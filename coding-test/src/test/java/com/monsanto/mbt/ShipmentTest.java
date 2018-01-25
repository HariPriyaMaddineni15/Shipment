package com.monsanto.mbt;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class ShipmentTest {
	
	//Color specified by Specialist
    @Test
    public void testShipment_Sorted_By_Color(){
        //Implement your solution to get list of shipments
    	String sortingOption = "color";
		List<Widget> widgetList =  WidgetUtils.getSampleWidgets();
		SortUtil.sortWidgets(widgetList, sortingOption);
		Widget topWidgetObj = widgetList.get(0);
        Assert.assertEquals("Blue", topWidgetObj.getColor());
        //Assert.assertNotEquals("Yellow", topWidgetObj.getColor());
    }

    //ProductionDate specifid by Specialist
    @Test
    public void testShipment_Sorted_By_Date(){
        //Implement your solution to get list of shipments
    	String sortingOption = "productionDate";
		List<Widget> widgetList =  WidgetUtils.getSampleWidgets();
		SortUtil.sortWidgets(widgetList, sortingOption);
		Widget topWidgetObj = widgetList.get(0);
		Assert.assertEquals(WidgetUtils.stringToDateConverter("09-01-2005"), (topWidgetObj.getProductionDate()));
		Assert.assertNotEquals(WidgetUtils.stringToDateConverter("09-01-2004"), (topWidgetObj.getProductionDate()));
    }
    
    //Express option specified by Specialist
    @Test
    public void testShipment_Express() {
    	int noOfWidgetsInShipment = 4;
		String shipmentOption = "Express";
		List<Widget> existingStock =  WidgetUtils.getSampleWidgets();
		List<Widget> shipmentWidgets = existingStock.subList(0, noOfWidgetsInShipment);
		Shipment shipment = new Shipment();
		shipment.setShipmentOption(shipmentOption);
		shipment.setWidgets(shipmentWidgets);
		String status = shipment.createShippment();
	    Assert.assertNotNull(status);
	    Assert.assertEquals(noOfWidgetsInShipment, shipment.getWidgets().size());
    }
    
    //Normal option specified by Specialist
    @Test
    public void testCreateShipment_Normal() {
       	int noOfWidgetsInShipment = 9;
		String shipmentOption = "Normal";
		List<Widget> existingStock =  WidgetUtils.getSampleWidgets();
		List<Widget> shipmentWidgets = existingStock.subList(0, noOfWidgetsInShipment);
		Shipment shipment = new Shipment();
		shipment.setShipmentOption(shipmentOption);
		shipment.setWidgets(shipmentWidgets);
		String status = shipment.createShippment();
        Assert.assertNotNull(status);
        Assert.assertEquals(noOfWidgetsInShipment, shipment.getWidgets().size());
    }
    
    // When Limit exceeds
    @Test(expected = RuntimeException.class)
    public void testCreateShipment_MoreLimit() {
    	int noOfWidgetsInShipment = 19;
		String shipmentOption = "Normal";
		List<Widget> existingStock =  WidgetUtils.getSampleWidgets();
		List<Widget> shipmentWidgets = existingStock.subList(0, noOfWidgetsInShipment);
		Shipment shipment = new Shipment();
		shipment.setShipmentOption(shipmentOption);
		shipment.setWidgets(shipmentWidgets);
		String status = shipment.createShippment();
		Assert.assertNotNull(status);
        Assert.assertNotEquals(noOfWidgetsInShipment, shipment.getWidgets().size());
        
    }

}