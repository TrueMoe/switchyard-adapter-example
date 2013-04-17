package org.switchyard.adapter.example;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.Message;
import org.switchyard.adapter.example.domain.InputTypeV2;
import org.switchyard.adapter.example.domain.OutputTypeV2;
import org.switchyard.adapter.example.fault.FaultV2;
import org.switchyard.component.bean.BeanComponentException;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.test.InvocationFaultException;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(mixins = CDIMixIn.class, config = SwitchYardTestCaseConfig.SWITCHYARD_XML)
public class ServiceContractV2Test {

	@ServiceOperation("ServiceContractV2")
	private Invoker service;

	@Test
	public void testOperationCanBeAdded() throws Exception {
		Message response = service.operation("operationCanBeAdded").sendInOut(null);
		// validate the results
		Assert.assertTrue("V2: operationCanBeAdded", response.getContent(Boolean.class));
	}

	@Test
	public void testOperationNameCanChangeV2() throws Exception {
		Message response = service.operation("operationNameCanChangeV2").sendInOut(null);
		// validate the results
		Assert.assertTrue("V2: operationNameCanChangeV2", response.getContent(Boolean.class));
	}

	@Test
	public void testInputTypeCanChange() throws Exception {
		InputTypeV2 message = new InputTypeV2();
		Message response = service.operation("inputTypeCanChange").sendInOut(message);
		// validate the results
		Assert.assertTrue("V2: inputTypeCanChange", response.getContent(Boolean.class));
	}

	@Test
	public void testOutputTypeCanChange() {
		OutputTypeV2 result = service.operation("outputTypeCanChange").sendInOut(null).getContent(OutputTypeV2.class);
		// validate the results
		Assert.assertNotNull("V2: outputTypeCanChange", result);
		Assert.assertEquals("V2: outputTypeCanChange", OutputTypeV2.class, result.getClass());
	}

	@Test
	public void testOutputTypeCanBeAdded() throws Exception {
		OutputTypeV2 result = service.operation("outputTypeCanBeAdded").sendInOut(null).getContent(OutputTypeV2.class);
		// validate the results
		Assert.assertNotNull("V2: outputTypeCanBeAdded", result);
		Assert.assertEquals("V2: outputTypeCanBeAdded", OutputTypeV2.class, result.getClass());
	}

	@Test
	public void testOutputTypeCanBeRemoved() throws Exception {
		Message response = service.operation("outputTypeCanBeRemoved").sendInOut(null);
		// validate the results
		Assert.assertTrue("V2: outputTypeCanBeRemoved", response.getContent(Boolean.class));
	}

	@Test
	public void testFaultCanBeAdded() {
		Message response = service.operation("faultCanBeAdded").sendInOut(false);
		// validate the results
		Assert.assertTrue("V2: faultCanBeAdded", response.getContent(Boolean.class));
	}

	@Test
	public void testFault_FaultCanBeAdded() {
		try {
			service.operation("faultCanBeAdded").sendInOut(true);
			Assert.fail("V2: faultCanBeAdded");
		} catch (InvocationFaultException e) {
			BeanComponentException bce = (BeanComponentException) e.getCause();
			Assert.assertEquals(FaultV2.class, bce.getCause().getClass());
			Assert.assertEquals("Should throw exception", bce.getCause().getMessage());
		}
	}

	@Test
	public void testFaultCanBeRemoved() throws Exception {
		Message response = service.operation("faultCanBeRemoved").sendInOut(null);
		// validate the results
		Assert.assertTrue("V2: faultCanBeRemoved", response.getContent(Boolean.class));
	}
	
	@Test
	public void testFaultCanChange() throws Exception {
		Message response = service.operation("faultCanChange").sendInOut(false);
		// validate the results
		Assert.assertTrue("V2: faultCanChange", response.getContent(Boolean.class));
	}
	
	@Test
	public void testFault_FaultCanChange() throws Exception {
		try {
			service.operation("faultCanChange").sendInOut(true);
			Assert.fail("V2: faultCanChange");
		} catch (InvocationFaultException e) {
			BeanComponentException bce = (BeanComponentException) e.getCause();
			Assert.assertEquals(FaultV2.class, bce.getCause().getClass());
			Assert.assertEquals("Should throw exception", bce.getCause().getMessage());
		}
	}

	@Test
	@Ignore
	public void testInternalFaultChange() {
		service.operation("internalFaultChange").sendInOut(true);
	}
}
