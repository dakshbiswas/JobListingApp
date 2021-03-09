package com.stackroute.favoriteservice.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.favoriteservice.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
	
	// Get Favorite Jobs By userid
	@Query(value = "select jobid from favorite_service.favorite as f where f.userid = :userid", nativeQuery = true)
	public ArrayList<String> getJobByUser(@Param("userid") String userid);

	// Check Favorite Pair Exists
	@Query(value = "select jobid from favorite_service.favorite as f where f.jobid = :jobid and f.userid = :userid", nativeQuery = true)
	public ArrayList<String> 	isFavoriterPairExists(@Param("jobid") String jobid, @Param("userid") String userid);

	// Delete Favorite Pair
	@Modifying
	@Transactional
	@Query(value = "delete from favorite_service.favorite as j where j.jobid = :jobid and j.userid = :userid", nativeQuery = true)
	public void deleteJob(@Param("jobid") String jobid, @Param("userid") String userid);
 
}

