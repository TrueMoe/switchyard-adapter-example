package com.objectbay.switchyard.adapter.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.Message;
import org.switchyard.component.bean.BeanComponentException;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.test.InvocationFaultException;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;

import com.objectbay.switchyard.adapter.example.domain.Order;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(mixins = CDIMixIn.class, config = SwitchYardTestCaseConfig.SWITCHYARD_XML)
public class OrderingServiceTest {

	@ServiceOperation("OrderingService")
	private Invoker service;

	@Test
	public void testOrder() throws Exception {
		System.out.println("Test OrderingService Version 1 - order");
		Order message = new Order();
		Message response = service.operation("order").sendInOut(message);

		Assert.assertTrue("is ordered", response.getContent(Boolean.class));
	}
	
	@Test
	public void testCancel() throws Exception {
		System.out.println("Test OrderingService Version 1 - cancel");
		Order message = new Order();
		Message response = service.operation("cancel").sendInOut(message);

		Assert.assertFalse("cancel order", response.getContent(Boolean.class));
	}
	
	@Test
	public void testOutputTypeChange() throws Exception {
		System.out.println("Test OrderingService Version 1 - outputTypeChange");
		Order message = new Order();
		service.operation("outputTypeAdded").sendInOnly(message);
	}
	
	@Test
	// also existing clients are affected if a fault is added to the new service contract
	public void testFaultCanBeAdded() {
		System.out.println("Test OrderingService Version 1 - faultCanBeAdded");
		Order message = new Order();
		try {
			service.operation("faultCanBeAdded").sendInOut(message);	
		} catch (InvocationFaultException e) {
			Message faultMessage = e.getFaultMessage();
			Object faultContent = faultMessage.getContent();
			BeanComponentException bce = (BeanComponentException) faultContent;
			Order2Fault fault = (Order2Fault)bce.getCause();
			Assert.assertEquals("Invalid order: null", fault.getMessage());
		}
		
	}
}
