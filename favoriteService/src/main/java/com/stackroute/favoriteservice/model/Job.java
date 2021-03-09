package com.stackroute.favoriteservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Favorite")
public class Job {
 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "favoriteid")
	private Integer favoriteid;

	@Column(name = "jobid", length = 32)
	private String jobid;

	@Column(name = "userid", length = 32)
	private String userid;

	public Job() { }
	
	public Job(String jobid, String userid) {
		super();
		this.jobid = jobid;
		this.userid = userid;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "Job [jobid=" + jobid + ", userid=" + userid + "]";
	}

	
}
 