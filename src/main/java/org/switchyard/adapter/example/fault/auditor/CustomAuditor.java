//package org.switchyard.adapter.example.fault.auditor;
//
//import java.util.Set;
//
//import javax.inject.Named;
//
//import org.apache.camel.Exchange;
//import org.switchyard.Context;
//import org.switchyard.ExchangeState;
//import org.switchyard.Property;
//import org.switchyard.Service;
//import org.switchyard.bus.camel.audit.Audit;
//import org.switchyard.bus.camel.audit.Auditor;
//import org.switchyard.bus.camel.processors.Processors;
//import org.switchyard.metadata.ExchangeContract;
//
//@Named("CustomAuditor")
//@Audit(Processors.DOMAIN_HANDLERS)
//public class CustomAuditor implements Auditor {
//	private String filterName;
//
//	public CustomAuditor() {
//		filterName = "{urn:com.example.switchyard:switchyard-example:1.0}ProviderService";
//	}
//
//	@Override
//	public void beforeCall(Processors processor, Exchange exchange) {
//	}
//
//	@Override
//	public void afterCall(Processors processor, Exchange camel) {
//		org.switchyard.Exchange exchange = (org.switchyard.Exchange) camel.getProperty("SwitchYardExchange");
//		if (isProviderServiceInFaultState(exchange)) {
//			ExchangeContract contract = exchange.getContract();
//			Context context = exchange.getContext();
//			Throwable throwable = exchange.getMessage().getContent(Throwable.class).getCause();
//			
//			System.out.println(exchange.getPhase());
//			System.out.println(contract.getConsumerOperation());
//			System.out.println(contract.getProviderOperation());
//			
//			Set<Property> properties = context.getProperties();
//			for (Property property : properties) {
//				System.out.printf("%s: %s, scope: %s, labels: %s%n", property.getName(), property.getValue(), property.getScope(), property.getLabels());
//			}
//			throwable.getCause().printStackTrace(System.out);
//		}
//	}
//
//	private boolean isProviderServiceInFaultState(org.switchyard.Exchange exchange) {
//		Service providerService = exchange.getProvider();
//		return ExchangeState.FAULT.equals(exchange.getState()) && (providerService != null) && filterName.equals(providerService.getName().toString());
//	}
//
//}
