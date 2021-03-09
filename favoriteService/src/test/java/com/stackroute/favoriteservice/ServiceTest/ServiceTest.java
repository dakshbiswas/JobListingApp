package com.stackroute.favoriteservice.ServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.favoriteservice.model.Job;
import com.stackroute.favoriteservice.repository.JobRepository;
import com.stackroute.favoriteservice.service.JobService;

public class ServiceTest {
	@Mock
	private JobRepository jobRepository;

	private Job job;

	@InjectMocks
	private JobService jobServiceImpl;

	Optional<Job> options;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		  job = new Job("1234","biswasdaksh007@gmail.com");
		options = Optional.of(job);
	}

	@Test
	public void testsaveJobDetailsSuccess() throws Exception {
		when(jobRepository.save(job)).thenReturn(job);
		Job job1 = jobServiceImpl.saveJobDetails(job);
		verify(jobRepository, times(1)).save(job);
	}

	@Test()
	public void testsaveJobDetailsfailure() throws Exception {
		when(jobRepository.getJobByUser(job.getUserid())).thenReturn(null);
		when(jobRepository.save(job)).thenReturn(job);
	}

	@Test
	public void testgetJobsByUserIdSuccess() throws Exception {
		final ArrayList<String> jobs = new ArrayList<>();
		jobs.add("1234");
		when(jobRepository.getJobByUser(job.getUserid())).thenReturn(jobs);
		ArrayList<String> jobs1 = jobServiceImpl.getJobsByUserId("biswasdaksh007@gmail.com");
		assertNotNull(jobs1);
		assertEquals(jobs, jobs1);
		verify(jobRepository, times(1)).getJobByUser(job.getUserid());
	}
	
	@Test
	public void testgetJobsByUserIdFailure() throws Exception {
		final ArrayList<String> jobs = new ArrayList<>();
		jobs.add("123");
		when(jobRepository.getJobByUser(job.getUserid())).thenReturn(null);
		ArrayList<String> jobs1 = jobServiceImpl.getJobsByUserId("biswasdaksh007@gmail.com");
		assertNotNull(jobs);
		//assertEquals(jobs, jobs1);
		verify(jobRepository, times(1)).getJobByUser(job.getUserid());
	}
	
	@Test
	public void testdeleteJobDetailsSuccess() throws Exception {
		final ArrayList<String> jobs = new ArrayList<>();
		jobs.add("123");
		when(jobRepository.getJobByUser(job.getUserid())).thenReturn(jobs);
		jobServiceImpl.deleteJobDetails(job);
		//assertEquals(jobs, jobs1);
		verify(jobRepository, times(1)).deleteJob(job.getJobid(), job.getUserid());
	}
	
	@Test
	public void testdeleteJobDetailsFailure() throws Exception {
		final ArrayList<String> jobs = new ArrayList<>();
		jobs.add("123");
		when(jobRepository.getJobByUser(job.getUserid())).thenReturn(null);
		jobServiceImpl.deleteJobDetails(job);
		//assertEquals(jobs, jobs1);
		verify(jobRepository, times(1)).deleteJob(job.getJobid(), job.getUserid());
	}
	
}
