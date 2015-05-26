package com.easynutrition.business.mail;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/*-context.xml")
@WebAppConfiguration
public class TestBusinessMailSender {
	@Autowired
	private BusinessMailSender mailSender;
	@Autowired
	private ThreadPoolTaskExecutor mailExecutor;

	
	@BeforeClass
	public static void setUpClass() throws Exception {
		// Sets JNDI Mock for Spring Security and JPA
		SimpleNamingContextBuilder builder = SimpleNamingContextBuilder.emptyActivatedContextBuilder();
	    
	    DriverManagerDataSource ds = new DriverManagerDataSource();
	    ds.setUrl("jdbc:mysql://localhost:3306/easynutrition");
	    ds.setUsername("root");
	    ds.setPassword("root");
	    
	    builder.bind("java:comp/env/jdbc/EasyNutritionDS", ds);
	}
	
	@Before
	public void setUp() {
		mailExecutor.setWaitForTasksToCompleteOnShutdown(true);
	}

	@Test
	public void testSendMailNewPatient() throws Exception {
		final String[] mails = {};
		
		for (String mail : mails) {
			mailSender.sendMailNewPatient(mail, "username", "password", "nutricionist", new Locale("es"));
		}
	}
	
	@After
	public void tearDown() throws Exception {
		mailExecutor.shutdown();
		mailExecutor.getThreadPoolExecutor().awaitTermination(1, TimeUnit.DAYS);
	}
	
}