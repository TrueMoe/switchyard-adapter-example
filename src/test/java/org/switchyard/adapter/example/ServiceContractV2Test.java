package org.switchyard.adapter.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.switchyard.Message;
import org.switchyard.adapter.example.domain.InputTypeV2;
import org.switchyard.adapter.example.domain.OutputTypeV2;
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
public class ServiceContractV2Test {

	@ServiceOperation("ServiceContractV2")
	private Invoker service;

	@Test
	// Boolean operationCanBeAdded();
	public void testOperationCanBeAdded() throws Exception {
		Message response = service.operation("operationCanBeAdded")
				.expectedOutputType(JavaService.toMessageType(Boolean.class))
				.sendInOut(null);
		// validate the results
		Assert.assertTrue("V2: operationCanBeAdded", response.getContent(Boolean.class));
	}

	@Test
	// Boolean operationNameCanChangeV2();
	public void testOperationNameCanChangeV2() throws Exception {
		Message response = service.operation("operationNameCanChangeV2")
				.expectedOutputType(JavaService.toMessageType(Boolean.class))
				.sendInOut(null);
		// validate the results
		Assert.assertTrue("V2: operationNameCanChangeV2", response.getContent(Boolean.class));
	}

	@Test
	// Boolean inputTypeCanChange(InputTypeV2 inputType);
	public void testInputTypeCanChange() throws Exception {
		InputTypeV2 message = new InputTypeV2();
		Message response = service.operation("inputTypeCanChange")
				.expectedOutputType(JavaService.toMessageType(Boolean.class))
				.inputType(JavaService.toMessageType(InputTypeV2.class))
				.sendInOut(message);
		// validate the results
		Assert.assertTrue("V2: inputTypeCanChange", response.getContent(Boolean.class));
	}

	@Test
	// OutputTypeV2 outputTypeCanChange();
	public void testOutputTypeCanChange() {
		OutputTypeV2 result = service.operation("outputTypeCanChange")
				.expectedOutputType(JavaService.toMessageType(OutputTypeV2.class))
				.sendInOut(null).getContent(OutputTypeV2.class);
		// validate the results
		Assert.assertNotNull("V2: outputTypeCanChange", result);
		Assert.assertEquals("V2: outputTypeCanChange", OutputTypeV2.class, result.getClass());
	}

	@Test
	// OutputTypeV2 outputTypeCanBeAdded();
	public void testOutputTypeCanBeAdded() throws Exception {
		OutputTypeV2 result = service.operation("outputTypeCanBeAdded")
				.expectedOutputType(JavaService.toMessageType(OutputTypeV2.class))
				.sendInOut(null).getContent(OutputTypeV2.class);
		// validate the results
		Assert.assertNotNull("V2: outputTypeCanBeAdded", result);
		Assert.assertEquals("V2: outputTypeCanBeAdded", OutputTypeV2.class, result.getClass());
	}

	@Test
    // void outputTypeCanBeRemoved();
	public void testOutputTypeCanBeRemoved() throws Exception {
		Message response = service.operation("outputTypeCanBeRemoved").sendInOut(null);
		// validate the results
		Assert.assertNull(response.getContent());
	}

	@Test
	// Boolean faultCanBeAdded(Boolean throwException) throws FaultV2;
	public void testFaultCanBeAdded() {
		Message response = service.operation("faultCanBeAdded")
				.expectedOutputType(JavaService.toMessageType(Boolean.class))
				.inputType(JavaService.toMessageType(Boolean.class))
				.sendInOut(false);
		// validate the results
		Assert.assertTrue("V2: faultCanBeAdded", response.getContent(Boolean.class));
	}

	@Test
	public void testFault_FaultCanBeAdded() {
		try {
			service.operation("faultCanBeAdded")
				.expectedOutputType(JavaService.toMessageType(Boolean.class))
				.inputType(JavaService.toMessageType(Boolean.class))
				.sendInOut(true);
			Assert.fail("V2: faultCanBeAdded");
		} catch (InvocationFaultException e) {
			Assert.assertEquals(FaultV2.class, e.getCause().getClass());
			Assert.assertEquals("Should throw exception", e.getCause().getMessage());
		}
	}

	@Test
	// Boolean faultCanBeRemoved();
	public void testFaultCanBeRemoved() throws Exception {
		Message response = service.operation("faultCanBeRemoved")
				.expectedOutputType(JavaService.toMessageType(Boolean.class))
				.sendInOut(null);
		// validate the results
		Assert.assertTrue("V2: faultCanBeRemoved", response.getContent(Boolean.class));
	}
	
	@Test
	// Integer faultCanChange(Integer value)  throws FaultV2;
	public void testFaultCanChange() throws Exception {
		Message response = service.operation("faultCanChange")
				.expectedOutputType(JavaService.toMessageType(Integer.class))
				.expectedFaultType(JavaService.toMessageType(FaultV2.class))
				.inputType(JavaService.toMessageType(Integer.class))
				.sendInOut(Integer.MAX_VALUE);
		// validate the results
		Assert.assertEquals("V2: faultCanChange", Integer.MAX_VALUE, response.getContent(Integer.class).intValue());
	}
	
	@Test
	public void testFault_FaultCanChange() throws Exception {
		try {
			service.operation("faultCanChange")
				.expectedOutputType(JavaService.toMessageType(Integer.class))
				.expectedFaultType(JavaService.toMessageType(FaultV2.class))
				.inputType(JavaService.toMessageType(Integer.class))
				.sendInOut(null);
			Assert.fail("V2: faultCanChange");
		} catch (InvocationFaultException e) {
			Assert.assertEquals(FaultV2.class, e.getCause().getClass());
			Assert.assertEquals("Should throw exception", e.getCause().getMessage());
		}
	}
}
