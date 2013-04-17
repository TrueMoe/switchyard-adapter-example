package org.switchyard.adapter.example;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.Message;
import org.switchyard.adapter.example.domain.InputTypeV1;
import org.switchyard.adapter.example.domain.OutputTypeV1;
import org.switchyard.adapter.example.fault.FaultV1;
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
public class ServiceContractV1Test {

	@ServiceOperation("ServiceContractV1")
	private Invoker service;

	@Test
	public void testOperationCanBeRemoved() throws Exception {
		Message response = service.operation("operationCanBeRemoved").sendInOut(null);
		// validate the results
		Assert.assertTrue("V1: operationCanBeRemoved", response.getContent(Boolean.class));
	}

	@Test
	public void testOperationNameCanChangeV1() throws Exception {
		Message response = service.operation("operationNameCanChangeV1").sendInOut(null);
		// validate the results
		Assert.assertTrue("V1: operationNameCanChangeV1", response.getContent(Boolean.class));
	}

	@Test
	public void testInputTypeCanChange() throws Exception {
		InputTypeV1 message = new InputTypeV1();
		Message response = service.operation("inputTypeCanChange").sendInOut(message);
		// validate the results
		Assert.assertTrue("V1: inputTypeCanChange", response.getContent(Boolean.class));
	}

	@Test
	public void testOutputTypeCanChange() {
		OutputTypeV1 result = service.operation("outputTypeCanChange").sendInOut(null).getContent(OutputTypeV1.class);
		// validate the results
		Assert.assertNotNull("V1: outputTypeCanChange", result);
		Assert.assertEquals("V1: outputTypeCanChange", OutputTypeV1.class, result.getClass());
	}

	@Test
	public void testOutputTypeCanBeAdded() throws Exception {
		service.operation("outputTypeCanBeAdded").sendInOnly(null);
		// validate the results
		Assert.assertTrue("V1: outputTypeCanBeAdded", true);
	}

//	@Test
//	WARNING: this feature is not supported!
//	public void testOutputTypeCanBeRemoved() throws Exception {
//		Message response = service.operation("outputTypeCanBeRemoved").sendInOut(null);
//		// validate the results
//		Assert.assertTrue("V1: outputTypeCanBeRemoved", response.getContent(Boolean.class));
//	}
//
	@Test
	public void testFaultCanBeAdded() {
		Message response = service.operation("faultCanBeAdded").sendInOut(false);
		// validate the results
		Assert.assertTrue("V1: faultCanBeAdded", response.getContent(Boolean.class));
	}

	
	/**
	 * WARNING: operation from service contract throws exception.
	 * Service contract v1 no longer interoperable. 
	 */
	@Test
	public void testFault_FaultCanBeAdded() {
		try {
			service.operation("faultCanBeAdded").sendInOut(true);
			Assert.fail("V1: faultCanBeAdded");
		} catch (InvocationFaultException e) {
			BeanComponentException bce = (BeanComponentException) e.getCause();
			Assert.assertEquals(FaultV2.class, bce.getCause().getClass()); // exception defined in service contract v2
			Assert.assertEquals("Should throw exception", bce.getCause().getMessage());
		}
	}

	@Test
	public void testFaultCanBeRemoved() throws Exception {
		Message response = service.operation("faultCanBeRemoved").sendInOut(null);
		// validate the results
		Assert.assertTrue("V1: faultCanBeRemoved", response.getContent(Boolean.class));
	}
	
	@Test
	public void testFaultCanChange() throws Exception {
		Message response = service.operation("faultCanChange").sendInOut(false);
		// validate the results
		Assert.assertTrue("V1: faultCanChange", response.getContent(Boolean.class));
	}
	
	@Test
	@Ignore
	public void testFault_FaultCanChange() throws Exception {
		try {
			service.operation("faultCanChange").sendInOut(true);
			Assert.fail("V1: faultCanChange");
		} catch (InvocationFaultException e) {
			BeanComponentException bce = (BeanComponentException) e.getCause();
			Assert.assertEquals(FaultV1.class, bce.getCause().getClass());
			Assert.assertEquals("Should throw exception", bce.getCause().getMessage());
		}
	}

}
