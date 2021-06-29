package com.covid.delete;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.covid.bo.TestMongoBO;
import com.covid.config.MyMongoTemplate;

public class TestMongoDAO {

	public static void main(String[] args) throws Exception {
		MongoTemplate mongoTemplate = MyMongoTemplate.getMongoTemplate();
		mongoTemplate.save(new TestMongoBO(3,"Test","London"));
		mongoTemplate.save(new TestMongoBO(4,"Test","London"));
	}

}
