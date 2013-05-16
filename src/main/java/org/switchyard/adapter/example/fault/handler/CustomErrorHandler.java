package org.switchyard.adapter.example.fault.handler;

import javax.inject.Named;

import org.apache.camel.Exchange;
import org.apache.camel.processor.ErrorHandler;
import org.switchyard.bus.camel.audit.Audit;

@Audit
@Named
public class CustomErrorHandler implements ErrorHandler {

	@Override
	public void process(Exchange exchange) throws Exception {
		System.out.println("Camel exchange: " + exchange);
	}
}
