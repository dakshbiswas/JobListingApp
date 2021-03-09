package com.stackroute.favoriteservice.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.favoriteservice.exception.JobAlreadyExistsException;
import com.stackroute.favoriteservice.exception.JobNotFoundException;
import com.stackroute.favoriteservice.model.Job;
import com.stackroute.favoriteservice.repository.JobRepository;

@Service
public class JobService {

	@Autowired
	private JobRepository jobRepository;
	
	// Get Favorite Job List For User
	public ArrayList<String> getJobsByUserId(String userid) throws JobNotFoundException {
		ArrayList<String> jobIds = jobRepository.getJobByUser(userid);
		if(jobIds == null) {
			throw new JobNotFoundException("There are no favourites present for this user right now");
		}
		return jobRepository.getJobByUser(userid);
	}
	
	// Save Job Detail
	public Job saveJobDetails(Job job) throws JobAlreadyExistsException {
		if(isJobUserPairExists(job)) {
			throw new JobAlreadyExistsException("Job already exists");
		}
		return jobRepository.save(job);
	}
	
	// Delete Job Detail
	public void deleteJobDetails(Job job) throws JobNotFoundException {
		if(!isJobUserPairExists(job)) {
			throw new JobNotFoundException("The job you are trying to delete does not exist");
		}
		jobRepository.deleteJob(job.getJobid(), job.getUserid());
	}

	public Boolean isJobUserPairExists(Job job) {
		if(jobRepository.isFavoriterPairExists(job.getJobid(), job.getUserid()).isEmpty()) {
			return false;
		}
		return true;
	}

	public boolean isUserExists(String userid) {
		if(jobRepository.getJobByUser(userid).isEmpty()) {
			return false;
		}
		return true;
	}


}
