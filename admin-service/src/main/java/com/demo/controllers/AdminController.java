package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.models.Coupon;
import com.demo.models.Flight;
import com.demo.response.FlightResponse;
import com.demo.services.AdminService;

import io.swagger.annotations.ApiOperation;

@RestController
public class AdminController {

	@Autowired
	private RestTemplate restTemplate;

	
	@Autowired private AdminService adminService;
	

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.GET, produces =
	 * "application/json", consumes = "application/json")
	 * 
	 * public HashMap<String, Object> getLogin(@RequestBody AdminDto admin) {
	 * HashMap<String, Object> map = new HashMap<>(); UserDetails sucessOrFailure =
	 * adminService.getVerification(admin); if
	 * (sucessOrFailure.equals("Admin Login Successful")) { map.put("success",
	 * sucessOrFailure);
	 * 
	 * } else { map.put("failure", sucessOrFailure); } return map; }
	 */
	@ApiOperation(notes = "User name and password are mandatory to enter", response = RestTemplate.class, value = "Used for Authentication")
	@PostMapping("/add")
	public FlightResponse addFlight(@RequestBody Flight flight) {
		System.out.println("In Flight Controller, finding all flight from Flight service");
		ResponseEntity<FlightResponse> res = restTemplate.exchange("http://localhost:9091/v2/api/flight/add",
				HttpMethod.POST, new HttpEntity(flight), new ParameterizedTypeReference<FlightResponse>() {
				});
		return res.getBody();
	}

	@GetMapping("/search")
	public FlightResponse searchFlight() {
		System.out.println("Search all Flight for Admin");
		/*
		 * HttpHeaders headers = new HttpHeaders();
		 * headers.setContentType(MediaType.APPLICATION_JSON); HttpEntity<String>
		 * dataHttpEntity = new HttpEntity<>(headers);
		 */
		ResponseEntity<FlightResponse> res = restTemplate.exchange("http://localhost:9091/v3/api/flight/searchAll",
				HttpMethod.GET, new HttpEntity(null),FlightResponse.class, new ParameterizedTypeReference<FlightResponse>() {
				});
		return res.getBody();
	}



	@DeleteMapping("/delete")
	public FlightResponse deleteFlight() {
		System.out.println("delete flight in Admin Module");
		ResponseEntity<FlightResponse> res = restTemplate.exchange("http://localhost:9091/v2/api/flight/delete",
				HttpMethod.DELETE, new HttpEntity(null), new ParameterizedTypeReference<FlightResponse>() {
				});
		return res.getBody();
	}

	@PostMapping("/blockFlight")
	public FlightResponse blockFlight() {
		System.out.println("block flight in Admin Module");
		ResponseEntity<FlightResponse> res = restTemplate.exchange("http://localhost:9091/v2/api/flight/blockFlight",
				HttpMethod.POST, new HttpEntity(null), new ParameterizedTypeReference<FlightResponse>() {
				});
		return res.getBody();
	}
	
	@PostMapping("/addCoupon")
	public FlightResponse addCoupon(@RequestBody Coupon coupon) {
		return new FlightResponse("200", null, adminService.addCoupon(coupon));
	}

}
