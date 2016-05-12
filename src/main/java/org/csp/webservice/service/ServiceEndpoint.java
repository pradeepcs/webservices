package org.csp.webservice.service;

import io.spring.guides.gs_producing_web_service.GetServiceRequest;
import io.spring.guides.gs_producing_web_service.GetServiceResponse;

import org.csp.webservice.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class ServiceEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private ServiceRepository serviceRepository;

	@Autowired
	public ServiceEndpoint(ServiceRepository serviceRepository) {
		this.serviceRepository = serviceRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getServiceRequest")
	@ResponsePayload
	public GetServiceResponse getCountry(@RequestPayload GetServiceRequest request) {
		GetServiceResponse response = new GetServiceResponse();
		response.setResponse(serviceRepository.getServiceResponse(request.getRequest()));

		return response;
	}
}
