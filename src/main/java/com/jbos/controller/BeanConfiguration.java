package com.jbos.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jbos.beans.SalesLead;
import com.jbos.beans.LeadInformation;
import com.jbos.beans.Touch;

@Configuration
public class BeanConfiguration {
	@Bean
	public SalesLead salesLead() {
		SalesLead bean = new SalesLead();
		return bean;
	}

	@Bean
	public LeadInformation leadInformation() {
		LeadInformation bean = new LeadInformation();
		return bean;
	}

	@Bean
	public Touch touch() {
		Touch bean = new Touch();
		return bean;
	}
}
