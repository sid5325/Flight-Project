package com.demo.controllers;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
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

import com.demo.entities.User;
import com.demo.exception.DataNotFoundException;
import com.demo.exception.UserNotFoundException;
import com.demo.services.UserService;
import com.demo.utility.UserResponse;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/userHistory/{mail}")
	public UserResponse getUserBookedDetails(@PathVariable String mail) throws UserNotFoundException {
		try {
			return new UserResponse("200", service.getUserHistoryWithMailId(mail),
					"All details of user Fetched successfully");
		} catch (Exception e) {
			throw new UserNotFoundException("Error happened while fetching user details");
		}
	}

	@PostMapping("/bookUser/{flightNumber}")
	public UserResponse bookUser(@RequestBody User user, @PathVariable int flightNumber) throws UserNotFoundException {
		try {
			user.setFlightNumber(flightNumber);
			return new UserResponse("200", null, service.bookUser(user));
		} catch (Exception e) {
			throw new UserNotFoundException("Error happened while booking user details");
		}
	}

	@DeleteMapping("/cancel/{pnr}")
	public UserResponse deleteByPnr(@PathVariable int pnr) {
		return new UserResponse("200", null, service.deleteByPnr(pnr));
	}

	/*@GetMapping("/download/{pnrnum}")
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
	}*/
}
