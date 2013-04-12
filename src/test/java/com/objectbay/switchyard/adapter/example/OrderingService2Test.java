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

import com.objectbay.switchyard.adapter.example.domain.Order2;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(mixins = CDIMixIn.class, config = SwitchYardTestCaseConfig.SWITCHYARD_XML)
public class OrderingService2Test {

	@ServiceOperation("OrderingService2")
	private Invoker service;

	@Test
	public void testOrderIt() throws Exception {
		System.out.println("Test OrderingService Version 2 - orderIt");
		Order2 message = new Order2();
		Message response = service.operation("orderIt").sendInOut(message);

		Assert.assertTrue("is ordered", response.getContent(Boolean.class));
	}
	
	@Test
	public void testCancel() throws Exception {
		System.out.println("Test OrderingService Version 2 - cancel");
		Order2 message = new Order2();
		service.operation("cancel").sendInOnly(message);
		Message response = service.operation("cancel").sendInOut(message);

		Assert.assertFalse("cancel order", response.getContent(Boolean.class));
	}
	
	@Test
	public void testOutputTypeChange() throws Exception {
		System.out.println("Test OrderingService Version 2 - outputTypeChange");
		Order2 message = new Order2();
		Message response = service.operation("outputTypeAdded").sendInOut(message);
		
		Assert.assertEquals(Order2.class, response.getContent().getClass());
		Assert.assertTrue("is ordered", response.getContent(Order2.class).isOrdered());
	}
	
	@Test
	public void testFaultCanBeAdded() {
		System.out.println("Test OrderingService Version 2 - faultCanBeAdded");
		Order2 message = new Order2();
		message.setName("banana");
		Message response = service.operation("faultCanBeAdded").sendInOut(message);
		Assert.assertTrue("is ordered", response.getContent(Boolean.class));
		
		try {
			service.operation("faultCanBeAdded").sendInOut(message);
		} catch (InvocationFaultException e) {
			// TODO is there a simpler way to access the fault?
			Message faultMessage = e.getFaultMessage();
			Object faultContent = faultMessage.getContent();
			BeanComponentException bce = (BeanComponentException) faultContent;
			Order2Fault fault = (Order2Fault)bce.getCause();
			Assert.assertEquals("Invalid order: banana", fault.getMessage());
		}
	}
}
