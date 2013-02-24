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
}
