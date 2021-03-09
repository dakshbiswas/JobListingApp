package com.stackroute.favoriteservice.repositoryTest;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.stackroute.favoriteservice.model.Job;
import com.stackroute.favoriteservice.repository.JobRepository;

//@RunWith(SpringRunner.class)
	@DataJpaTest
	@AutoConfigureTestDatabase(replace = Replace.NONE)
	public class RepositoryTest {
		@Autowired
		private transient JobRepository jobRepository;

		public void setRepo(JobRepository jobRepository) {
			this.jobRepository = jobRepository;
		}

		@Test
		public void testSaveJob() throws Exception {
			jobRepository.save(new Job("1234","biswasdaksh007@gmail.com"));
			
			final List<String> jobs = jobRepository.getJobByUser("biswasdaksh007@gmail.com");
			//System.out.println(player);
			Assertions.assertEquals("5313231", jobs.get(0));
		}
		@Test
		public void testGetAllJobs() throws Exception {
			jobRepository.save(new Job("5313231","biswasdaksh007@gmail.com"));
			jobRepository.save(new Job("123","biswasdaksh007@gmail.com"));
			final List<String> jobs = jobRepository.getJobByUser("biswasdaksh007@gmail.com");
			Assertions.assertEquals("5313231", jobs.get(0));
		}

	}
