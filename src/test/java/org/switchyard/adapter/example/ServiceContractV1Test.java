package org.switchyard.adapter.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.Message;
import org.switchyard.adapter.example.domain.InputTypeV1;
import org.switchyard.adapter.example.domain.OutputTypeV1;
import org.switchyard.adapter.example.fault.FaultV1;
import org.switchyard.adapter.example.fault.FaultV2;
import org.switchyard.component.test.mixins.cdi.CDIMixIn;
import org.switchyard.metadata.java.JavaService;
import org.switchyard.test.InvocationFaultException;
import org.switchyard.test.Invoker;
import org.switchyard.test.ServiceOperation;
import org.switchyard.test.SwitchYardRunner;
import org.switchyard.test.SwitchYardTestCaseConfig;

@RunWith(SwitchYardRunner.class)
@SwitchYardTestCaseConfig(mixins = CDIMixIn.class, config = SwitchYardTestCaseConfig.SWITCHYARD_XML)
public class ServiceContractV1Test {

	@ServiceOperation("ServiceContractV2")
	private Invoker service;

	@Test
	// Boolean operationCanBeRemoved();
	public void testOperationCanBeRemoved() throws Exception {
		Message response = service.operation("operationCanBeRemoved")
				.expectedOutputType(JavaService.toMessageType(Boolean.class))
				.sendInOut(null);
		// validate the results
		Assert.assertTrue("V1: operationCanBeRemoved", response.getContent(Boolean.class));
	}

	@Test
	// Boolean operationNameCanChangeV1();
	public void testOperationNameCanChangeV1() throws Exception {
		Message response = service.operation("operationNameCanChangeV1")
				.expectedOutputType(JavaService.toMessageType(Boolean.class))
				.sendInOut(null);
		// validate the results
		Assert.assertTrue("V1: operationNameCanChangeV1", response.getContent(Boolean.class));
	}

	@Test
	// Boolean inputTypeCanChange(InputTypeV1 inputType);
	public void testInputTypeCanChange() throws Exception {
		InputTypeV1 message = new InputTypeV1();
		Message response = service.operation("inputTypeCanChange")
				.expectedOutputType(JavaService.toMessageType(Boolean.class))
				.inputType(JavaService.toMessageType(InputTypeV1.class))
				.sendInOut(message);
		// validate the results
		Assert.assertTrue("V1: inputTypeCanChange", response.getContent(Boolean.class));
	}

	@Test
	// OutputTypeV1 outputTypeCanChange();
	public void testOutputTypeCanChange() {
		OutputTypeV1 result = service.operation("outputTypeCanChange")
				.expectedOutputType(JavaService.toMessageType(OutputTypeV1.class))
				.sendInOut(null).getContent(OutputTypeV1.class);
		// validate the results
		Assert.assertNotNull("V1: outputTypeCanChange", result);
		Assert.assertEquals("V1: outputTypeCanChange", OutputTypeV1.class, result.getClass());
	}

	@Test
	// void outputTypeCanBeAdded();
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

	@Test
	// Boolean faultCanBeAdded(Boolean throwException);
	public void testFaultCanBeAdded() {
		Message response = service.operation("faultCanBeAdded")
				.expectedOutputType(JavaService.toMessageType(Boolean.class))
				.inputType(JavaService.toMessageType(Boolean.class))
				.sendInOut(false);
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
			service.operation("faultCanBeAdded")
				.expectedOutputType(JavaService.toMessageType(Boolean.class))
				.inputType(JavaService.toMessageType(Boolean.class))
				.sendInOut(true);
			Assert.fail("V1: faultCanBeAdded");
		} catch (InvocationFaultException e) {
			Assert.assertEquals(FaultV2.class, e.getCause().getClass()); // exception defined in service contract v2
			Assert.assertEquals("Should throw exception", e.getCause().getMessage());
		}
	}

	@Test
	// Boolean faultCanBeRemoved(Boolean throwException) throws FaultV1;
	public void testFaultCanBeRemoved() throws Exception {
		Message response = service.operation("faultCanBeRemoved")
				.expectedOutputType(JavaService.toMessageType(Boolean.class))
				.expectedFaultType(JavaService.toMessageType(FaultV1.class))
				.sendInOut(null);
		// validate the results
		Assert.assertTrue("V1: faultCanBeRemoved", response.getContent(Boolean.class));
	}
	
	@Test
	// Integer faultCanChange(Integer value) throws FaultV1;
	public void testFaultCanChange() throws Exception {
		Message response = service.operation("faultCanChange")
				.expectedOutputType(JavaService.toMessageType(Integer.class))
				.expectedFaultType(JavaService.toMessageType(FaultV1.class))
				.inputType(JavaService.toMessageType(Integer.class))
				.sendInOut(Integer.MAX_VALUE);
		// validate the results
		Assert.assertEquals("V1: faultCanChange", Integer.MAX_VALUE, response.getContent(Integer.class).intValue());
	}
	
	@Test
	public void testFault_FaultCanChange() throws Exception {
		try {
			service.operation("faultCanChange")
				.expectedOutputType(JavaService.toMessageType(Integer.class))
				.expectedFaultType(JavaService.toMessageType(FaultV1.class))
				.inputType(JavaService.toMessageType(Integer.class))
				.sendInOut(null);
			Assert.fail("V1: faultCanChange");
		} catch (Exception e) {
			Assert.assertEquals(FaultV1.class, e.getCause().getClass());
			FaultV1 fault = (FaultV1) e.getCause();
			Assert.assertEquals("Should throw exception", fault.getMessage());
		}
	}

}
