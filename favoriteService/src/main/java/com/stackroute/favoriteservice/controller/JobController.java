package com.stackroute.favoriteservice.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.favoriteservice.exception.JobAlreadyExistsException;
import com.stackroute.favoriteservice.exception.JobNotFoundException;
import com.stackroute.favoriteservice.model.Job;
import com.stackroute.favoriteservice.service.JobService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping ("/favorites")
public class JobController {

		@Autowired
		private JobService jobService;
		
		@ApiOperation(value="Show Favorite Jobs of User", notes="This api is responsible for genrating favorite jobids for a specific userid ")
		// Search Favorite Jobs
		@GetMapping("/users/{userid}")
		@CrossOrigin(origins = "http://localhost:4200")
		public ResponseEntity<ArrayList<String>> getFavoriteJobsForUsers(@PathVariable String userid) throws JobNotFoundException{
			
			// TestCase 1 : check if job id already exits
			if(jobService.isUserExists(userid)) {	
				ArrayList<String> joblist = jobService.getJobsByUserId(userid);
				return ResponseEntity.ok(joblist);	// 200 All Okay
			}
			return ResponseEntity.badRequest().build(); // 400 Not Found		
		}
		
		// Save Favorite Job
		@ApiOperation(value="Save Favorite Jobs of User", notes="This api is responsible for saving favorite jobids for a specific userid ")
		@PostMapping("/jobs/save")
		@CrossOrigin(origins = "http://localhost:4200")
		public ResponseEntity<Job> saveFavoriteJobForUser(@RequestBody Job job) throws JobAlreadyExistsException {
				
			// TestCase 1 : check if job id already exits
			if(jobService.isJobUserPairExists(job)) {
				return new ResponseEntity<> ( HttpStatus.CONFLICT); // 409 Already Exits
			}
			
			// TestCase 2 : check if values are null 
			if((job.getJobid() == "") || (job.getUserid() == "")) {
				return new ResponseEntity<> (HttpStatus.BAD_REQUEST); // 400 Bad Input	
			}
						
			// TestCase 3 : user id (email) validation using REGEX 
						
			// Save Favorite job  
			jobService.saveJobDetails(job);
			
			// Response 
			return ResponseEntity.ok(job); // 200 All Okay
		}		
		@ApiOperation(value="Remove Favorite Jobs of User", notes="This api is responsible for deleting favorite jobids for a specific userid ")
		@PostMapping("/jobs/delete")
		@CrossOrigin(origins = "http://localhost:4200")
		public ResponseEntity<String> deleteFavoriteJobForUser(@RequestBody Job job) throws JobNotFoundException {

			// TestCase 1 : check if job id already exits
			if(jobService.isJobUserPairExists(job)) {
				// Delete job object 
				jobService.deleteJobDetails(job);
				return new ResponseEntity<> (HttpStatus.OK); // 200 All Okay
			}			
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST); // 400 Bad Input
		}
		@ApiOperation(value="Check if Favorite Jobs User pair exists", notes="This api is responsible for verfing if favorite job user pair exists or not")
		@CrossOrigin(origins = "http://localhost:4200")
		@GetMapping("/pair/exists")
		public ResponseEntity<Boolean> isFavoriteJobUserPairsExists(@RequestBody Job job) {
			// TestCase 1 : check if job id already exits
			if(jobService.isJobUserPairExists(job)) {
				return ResponseEntity.ok(true); // 200 All Okay
			}			
			return ResponseEntity.ok(false); // 404 Bad Input
		}
}
