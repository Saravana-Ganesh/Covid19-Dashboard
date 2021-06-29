package com.covid.config;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import com.mongodb.client.MongoClients;

public class MyMongoTemplate {
	private static MongoTemplate mongoTemplate = null;
	private MyMongoTemplate() {
		
	}
	public static MongoTemplate getMongoTemplate() {
		if(mongoTemplate==null) {
			mongoTemplate = new MongoTemplate(new SimpleMongoClientDatabaseFactory(MongoClients.create(),"CovidDashBoard"));
		}
		return mongoTemplate;
	}
}	
