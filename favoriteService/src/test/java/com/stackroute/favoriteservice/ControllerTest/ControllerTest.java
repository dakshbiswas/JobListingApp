//package com.stackroute.favoriteservice.ControllerTest;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.ResultActions;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
////import com.fasterxml.jackson.databind.ObjectMapper;
//import com.stackroute.favoriteservice.controller.JobController;
//import com.stackroute.favoriteservice.model.Job;
//import com.stackroute.favoriteservice.service.JobService;
//
//public class ControllerTest {
//
//
//	@Autowired
//	private MockMvc mockMvc;
//	private Job job;
//	
//	@MockBean
//	private JobService jobService;
//	
//	@InjectMocks
//	private JobController jobController;
//
//
//	//private static ObjectMapper mapper=new ObjectMapper();
//	
//	@SuppressWarnings("deprecation")
//	@BeforeEach
//	public void setUp() throws Throwable{
//			//super.setUp();
//			MockitoAnnotations.initMocks(this);
//			job = new Job("1403","mohanrohankar@gmail.com");
//	}
//	
//	@Test
//	void testSaveFavoriteJobForUser() throws Exception {
////		when(jobService.saveJobDetails(job))
////					   .thenReturn(job);
//		
////		when(jobService.isJobUserPairExists(job))
////						.thenReturn(true);
////		
//		mockMvc.perform((RequestBuilder) ((ResultActions) post("/jobs/save")
//			   .contentType(MediaType.APPLICATION_JSON)
//			   .accept(MediaType.APPLICATION_JSON)
//			   //.content("{\"jobid\":\"1403\",\"userid\":\"mohanrohankar@gmail.com\"}"))
//			   .content(jsonToString(job)))
//			   .andExpect(status().isOk()));
//
//		verify(jobService, times(1)).saveJobDetails(job);
//		Mockito.verifyNoMoreInteractions(jobService);
//
//	}
//	
//	private static String jsonToString(final Object obj) throws JsonProcessingException {
//		String result;
//		try {
//			final ObjectMapper mapper = new ObjectMapper();
//			final String jsonContent = mapper.writeValueAsString(obj);
//			result = jsonContent;
//		} catch (JsonProcessingException e) {
//			result = "json processing error";
//		}
//		return result;
//	}
//	
//}
