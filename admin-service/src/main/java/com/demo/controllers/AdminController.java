package com.demo.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.models.User;
import com.demo.exception.DataNotFoundException;
import com.demo.models.Coupon;
import com.demo.models.Flight;
import com.demo.response.FlightResponse;
import com.demo.response.UserResponse;
import com.demo.services.AdminService;

import io.swagger.annotations.ApiOperation;

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
	@ApiOperation(notes = "User name and password are mandatory to enter", response = RestTemplate.class, value = "Used for Authentication")
	@PostMapping("/add")
	public FlightResponse addFlight(@RequestBody Flight flight) {
		System.out.println("In Flight Controller, finding all flight from Flight service");
		ResponseEntity<FlightResponse> res = restTemplate.exchange("http://localhost:8090/v3/api/flight/add",
				HttpMethod.POST, new HttpEntity(flight), new ParameterizedTypeReference<FlightResponse>() {
				});
		return res.getBody();
	}

	@GetMapping("/search")
	public FlightResponse searchFlight() {
		System.out.println("Search all Flight for Admin");
		ResponseEntity<FlightResponse> res = restTemplate.exchange("http://localhost:8090/v3/api/flight/searchAll",
				HttpMethod.GET, new HttpEntity(null), FlightResponse.class,
				new ParameterizedTypeReference<FlightResponse>() {
				});
		return res.getBody();
	}

	@DeleteMapping("/delete")
	public FlightResponse deleteFlight() {
		System.out.println("delete flight in Admin Module");
		ResponseEntity<FlightResponse> res = restTemplate.exchange("http://localhost:8090/v3/api/flight/delete",
				HttpMethod.DELETE, new HttpEntity(null), new ParameterizedTypeReference<FlightResponse>() {
				});
		return res.getBody();
	}

	@PostMapping("/blockFlight")
	public FlightResponse blockFlight() {
		System.out.println("block flight in Admin Module");
		ResponseEntity<FlightResponse> res = restTemplate.exchange("http://localhost:8090/v3/api/flight/blockFlight",
				HttpMethod.POST, new HttpEntity(null), new ParameterizedTypeReference<FlightResponse>() {
				});
		return res.getBody();
	}

	@PostMapping("/unBlockFlight")
	public FlightResponse unBlockFlight() {
		System.out.println("Unblock flight in Admin Module");
		ResponseEntity<FlightResponse> res = restTemplate.exchange("http://localhost:8090/v3/api/flight/unBlockFlight",
				HttpMethod.POST, new HttpEntity(null), new ParameterizedTypeReference<FlightResponse>() {
				});
		return res.getBody();
	}

	@PostMapping("/addCoupon")
	public FlightResponse addCoupon(@RequestBody Coupon coupon) {
		return new FlightResponse("200", null, adminService.addCoupon(coupon), null);
	}

	@GetMapping("/viewCoupon")
	public FlightResponse viewCoupon() {
		return new FlightResponse("200", null, "All coupon fetched for admin", adminService.viewCoupon());
	}

	@PostMapping("/user/bookUser/{flightNumber}")
	public UserResponse bookUser(@RequestBody User user, @PathVariable int flightNumber) {
		System.out.println("book User in user module");
		ResponseEntity<UserResponse> res = restTemplate.exchange("http://localhost:8091/bookUser" + "/" + flightNumber,
				HttpMethod.POST, new HttpEntity(user), new ParameterizedTypeReference<UserResponse>() {
				});
		return res.getBody();
	}

	@GetMapping("/user/userHistory/{mail}")
	public UserResponse getUserHistory(@PathVariable String mail) {
		System.out.println("view the history of user");
		ResponseEntity<UserResponse> res = restTemplate.exchange("http://localhost:8091/userHistory" + "/" + mail,
				HttpMethod.GET, new HttpEntity(null), new ParameterizedTypeReference<UserResponse>() {
				});
		return res.getBody();
	}

	@DeleteMapping("/user/cancel/{pnr}")
	public UserResponse cancelTicket(@PathVariable int pnr) {
		System.out.println("Cancel the ticket for user");
		ResponseEntity<UserResponse> res = restTemplate.exchange("http://localhost:8091/cancel" + "/" + pnr,
				HttpMethod.DELETE, new HttpEntity(null), new ParameterizedTypeReference<UserResponse>() {
				});
		return res.getBody();
	}

	@GetMapping("user/download/{pnrnum}")
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

	@GetMapping("/user/couponAdd/{coupon}")
	public Map<Integer, String> userAddCoupon(@PathVariable String coupon) {
		System.out.println("User trying to give a coupon");
		return adminService.userAddCoupon(coupon);
	}

	@GetMapping("/user/getUserFlight/{flightDate}/{fromPlace}/{toPlace}")
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
