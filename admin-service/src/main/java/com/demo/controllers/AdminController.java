package com.demo.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.exception.DataNotFoundException;
import com.demo.models.Coupon;
import com.demo.models.Flight;
import com.demo.models.User;
import com.demo.response.CouponResponse;
import com.demo.response.FlightResponse;
import com.demo.response.UserResponse;
import com.demo.services.AdminService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api // (value = "Used for Authentication")
@RestController
public class AdminController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AdminService adminService;

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
	@ApiOperation(notes = "Admin add flight", response = RestTemplate.class, value = "Admin can add any number flights")
	@PostMapping("/add")
	@CrossOrigin(origins="http://localhost:4200/")
	//@CachePut(key="#flight",value="flightResponse")
	public FlightResponse addFlight(@RequestBody Flight flight) {
		System.out.println("In Admin Controller, add flights");
		ResponseEntity<FlightResponse> res = restTemplate.exchange("http://localhost:8090/v3/api/flight/add",
				HttpMethod.POST, new HttpEntity(flight), new ParameterizedTypeReference<FlightResponse>() {
				});
		return res.getBody();
	}

	@ApiOperation(notes = "Admin can search all flights", response = RestTemplate.class, value = "Search all flights from database for Admin")
	@GetMapping("/search")
	@CrossOrigin(origins="http://localhost:4200/")
	//@Cacheable(value="flightResponse")
	public FlightResponse searchFlight() {
		System.out.println("Search all Flight for Admin");
		ResponseEntity<FlightResponse> res = restTemplate.exchange("http://localhost:8090/v3/api/flight/searchAll",
				HttpMethod.GET, new HttpEntity(null), FlightResponse.class,
				new ParameterizedTypeReference<FlightResponse>() {
				});
		return res.getBody();
	}

	/*@ApiOperation(notes = "Admin can search flight by giving flight Number", response = RestTemplate.class, value = "Search all flights from database for Admin")
	@GetMapping("/search")
	@Cacheable(value="flightResponse")
	public FlightResponse searchFlightById() {
		System.out.println("Search Flight for Admin by Id");
		ResponseEntity<FlightResponse> res = restTemplate.exchange("http://localhost:8090/v3/api/flight/searchAll",
				HttpMethod.GET, new HttpEntity(null), FlightResponse.class,
				new ParameterizedTypeReference<FlightResponse>() {
				});
		return res.getBody();
	}*/
	
	@ApiOperation(notes = "Delete Flight", response = RestTemplate.class, value = "Admin can delete any number flights")
	@DeleteMapping("/delete/{id}")
	@CrossOrigin(origins="http://localhost:4200/")
	public FlightResponse deleteFlight(@PathVariable int id) {
		System.out.println("delete flight in Admin Module");
		ResponseEntity<FlightResponse> res = restTemplate.exchange("http://localhost:8090/v3/api/flight/delete/"+id,
				HttpMethod.DELETE, new HttpEntity(null), new ParameterizedTypeReference<FlightResponse>() {
				});
		return res.getBody();
	}

	@ApiOperation(notes = "Block flight", response = RestTemplate.class, value = "Admin can block any number flights")
	@PostMapping("/blockFlight/{id}")
	@CrossOrigin(origins="http://localhost:4200/")
	//@CachePut(key="#flight",value="flightResponse")
	public FlightResponse blockFlight(@PathVariable int id) {
		System.out.println("block flight in Admin Module");
		ResponseEntity<FlightResponse> res = restTemplate.exchange("http://localhost:8090/v3/api/flight/blockFlight/"+id,
				HttpMethod.POST, new HttpEntity(null), new ParameterizedTypeReference<FlightResponse>() {
				});
		return res.getBody();
	}

	@ApiOperation(notes = "Unblock flight", response = RestTemplate.class, value = "Admin can unBlock any number flights")
	@PostMapping("/unBlockFlight/{id}")
	@CrossOrigin(origins="http://localhost:4200/")
	//@CachePut(key="#flight",value="flightResponse")
	public FlightResponse unBlockFlight(@PathVariable int id) {
		System.out.println("Unblock flight in Admin Module");
		ResponseEntity<FlightResponse> res = restTemplate.exchange("http://localhost:8090/v3/api/flight/unBlockFlight/"+id,
				HttpMethod.POST, new HttpEntity(null), new ParameterizedTypeReference<FlightResponse>() {
				});
		return res.getBody();
	}

	@ApiOperation(notes = "Add coupon", response = RestTemplate.class, value = "Admin can add or update any Coupon")
	@PostMapping("/addCoupon")
	@CrossOrigin(origins="http://localhost:4200/")
	//@CachePut(key="#coupon",value="flightResponse")
	public FlightResponse addCoupon(@RequestBody Coupon coupon) {
		return new FlightResponse("200", null, adminService.addCoupon(coupon), null);
	}

	@ApiOperation(notes = "View Coupon", response = RestTemplate.class, value = "Admin can view all the coupons")
	@GetMapping("/viewCoupon")
	@CrossOrigin(origins="http://localhost:4200/")
	//@Cacheable(value="flightResponse")
	public FlightResponse viewCoupon() {
		return new FlightResponse("200", null, "All coupon fetched for admin", adminService.viewCoupon());
	}

	@ApiOperation(notes = "Book flight for user", response = RestTemplate.class, value = "User can book any flight")
	@PostMapping("/user/bookUser/{flightNumber}")
	@CrossOrigin(origins="http://localhost:4200/")
	//@CachePut(key="#flightNumber",value="userResponse")
	public UserResponse bookUser(@RequestBody User user, @PathVariable int flightNumber) {
		System.out.println("book User in user module");
		ResponseEntity<UserResponse> res = restTemplate.exchange("http://localhost:8091/bookUser" + "/" + flightNumber,
				HttpMethod.POST, new HttpEntity(user), new ParameterizedTypeReference<UserResponse>() {
				});
		return res.getBody();
	}

	@ApiOperation(notes = "User History", response = RestTemplate.class, value = "User can search all the flights booked by him/her by giving the mail-id")
	@GetMapping("/user/userHistory/{mail}")
	@CrossOrigin(origins="http://localhost:4200/")
	//@Cacheable(key="#mail",value="userResponse")
	public UserResponse getUserHistory(@PathVariable String mail) {
		System.out.println("view the history of user");
		ResponseEntity<UserResponse> res = restTemplate.exchange("http://localhost:8091/userHistory" + "/" + mail,
				HttpMethod.GET, new HttpEntity(null), new ParameterizedTypeReference<UserResponse>() {
				});
		return res.getBody();
	}
	
	@ApiOperation(notes = "Pasenger Details", response = RestTemplate.class, value = "Pasenger details by giving pnr number")
	@GetMapping("/user/passengerDetails/{pnr}")
	@CrossOrigin(origins="http://localhost:4200/")
	//@Cacheable(key="#mail",value="userResponse")
	public UserResponse getPasengerDetails(@PathVariable int pnr) {
		System.out.println("view the Passenger details of user");
		ResponseEntity<UserResponse> res = restTemplate.exchange("http://localhost:8091/passengerDetails" + "/" + pnr,
				HttpMethod.GET, new HttpEntity(null), new ParameterizedTypeReference<UserResponse>() {
				});
		return res.getBody();
	}

	@ApiOperation(notes = "User can cancel flight", response = RestTemplate.class, value = "User can cancel the booked flight by giving the PNR number")
	@DeleteMapping("/user/cancel/{pnr}")
	@CrossOrigin(origins="http://localhost:4200/")
	public UserResponse cancelTicket(@PathVariable int pnr) {
		System.out.println("Cancel the ticket for user");
		ResponseEntity<UserResponse> res = restTemplate.exchange("http://localhost:8091/cancel" + "/" + pnr,
				HttpMethod.DELETE, new HttpEntity(null), new ParameterizedTypeReference<UserResponse>() {
				});
		return res.getBody();
	}

	@ApiOperation(notes = "Download ticket", response = RestTemplate.class, value = "User can download the ticket by giving the PNR number")
	@GetMapping("user/download/{pnrnum}")
	@CrossOrigin(origins="http://localhost:4200/")
	public ResponseEntity<InputStreamResource> downloadPdf(@PathVariable String pnrnum) throws DataNotFoundException {
		String path = "D:\\pdf Generator\\" + pnrnum + ".pdf";
		try {
			File file = new File(path);
			HttpHeaders respHeaders = new HttpHeaders();
			MediaType mediaType = MediaType.parseMediaType("application/pdf");
			respHeaders.setContentType(mediaType);
			respHeaders.setContentLength(file.length());
			respHeaders.setContentDispositionFormData("attachment", file.getName());
			InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
			return new ResponseEntity<InputStreamResource>(isr, respHeaders, HttpStatus.OK);
		} catch (Exception e) {
			String message = "Ticket " + pnrnum + ".pdf is not there to download ";
			throw new DataNotFoundException(message);
		}
	}

	@ApiOperation(notes = "Add coupon for user", response = RestTemplate.class, value = "User can add coupon")
	@GetMapping("/user/couponAdd/{coupon}")
	@CrossOrigin(origins="http://localhost:4200/")
	//@Cacheable(key="#coupon",value="map")
	public CouponResponse userAddCoupon(@PathVariable String coupon) {
		System.out.println("User trying to give a coupon");
		return adminService.userAddCoupon(coupon);
	}

	@ApiOperation(notes = "Search flight", response = RestTemplate.class, value = "User can search flight by giving the DATE,SOURCE,DESTINATION")
	@GetMapping("/user/getUserFlight/{flightDate}/{fromPlace}/{toPlace}")
	@CrossOrigin(origins="http://localhost:4200/")
	//@Cacheable(key="#flightDate",value="flightResponse")
	public FlightResponse getUserFlight(@PathVariable String flightDate, @PathVariable String fromPlace,
			@PathVariable String toPlace) {
		System.out.println("Get flight details fetched by user");
		ResponseEntity<FlightResponse> res = restTemplate.exchange(
				"http://localhost:8090/v3/api/flight/getFlightForUser/" + flightDate + "/" + fromPlace + "/" + toPlace,
				HttpMethod.GET, new HttpEntity(null), new ParameterizedTypeReference<FlightResponse>() {
				});
		return res.getBody();
	}
}
