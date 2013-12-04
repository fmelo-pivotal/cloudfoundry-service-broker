package com.pivotal.cf.broker.model.fixture;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.pivotal.cf.broker.model.CreateServiceInstanceRequest;
import com.pivotal.cf.broker.model.CreateServiceInstanceResponse;
import com.pivotal.cf.broker.model.ServiceDefinition;
import com.pivotal.cf.broker.model.ServiceInstance;

public class ServiceInstanceFixture {

	public static List<ServiceInstance> getAllServiceInstances() {
		List<ServiceInstance> instances = new ArrayList<ServiceInstance>();
		instances.add(getServiceInstance());
		instances.add(getServiceInstanceTwo());
		return instances;
	}
	
	public static ServiceInstance getServiceInstance() {
		return new ServiceInstance(
				"service-instance-one-id",  
				"service-one-id", 
				"plan-one-id", 
				DataFixture.getOrgOneGuid(), 
				DataFixture.getSpaceOneGuid(), 
				"dashboard_url");
	}
	
	public static ServiceInstance getServiceInstanceTwo() {
		return new ServiceInstance(
				"service-instance-two-id", 
				"service-two-id", 
				"plan-two-id", 
				DataFixture.getOrgOneGuid(), 
				DataFixture.getSpaceOneGuid(),
				"dashboard_url");
	}
	
	public static String getServiceInstanceId() {
		return "service-instance-id";
	}
	
	public static CreateServiceInstanceRequest getCreateServiceInstanceRequest() {
		ServiceDefinition service = ServiceFixture.getService();
		return new CreateServiceInstanceRequest(
				service.getId(), 
				service.getPlans().get(0).getId(),
				DataFixture.getOrgOneGuid(),
				DataFixture.getSpaceOneGuid()
		);
	}
	
	public static String getCreateServiceInstanceRequestJson() throws JsonGenerationException, JsonMappingException, IOException {
		 return toJson(getCreateServiceInstanceRequest());
	}
	
	public static String toJson(Object object) throws JsonGenerationException, JsonMappingException, IOException {
		 ObjectMapper mapper = new ObjectMapper();
		 return mapper.writeValueAsString(object);
	}
	
	public static CreateServiceInstanceResponse getCreateServiceInstanceResponse() {
		return new CreateServiceInstanceResponse(getServiceInstance());
	}
	
}