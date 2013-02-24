package com.objectbay.switchyard.adapter.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.Message;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
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
}
