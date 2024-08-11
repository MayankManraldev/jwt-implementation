package com.example.demo.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.dao.UserRepository;
import com.example.demo.entities.User;
@Component
@EnableScheduling
class Schedulerconfig {
	Logger LOGGER =
			LoggerFactory.getLogger(Schedulerconfig.class);
	@Autowired
	private UserRepository userrepo;
	
	//@Scheduled(fixedRate = 1000)
	   public void fixedRateSch() {
		 List<User> user=userrepo.findAll();
	      
	      LOGGER.info("Fixed Rate scheduler:: "+user);
	   }
	

}
