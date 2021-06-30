package com.covid.controller;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.service.FileDownloadService;

@RestController
public class FileDownloadController {
	static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources//applicationContext.xml");	
	@GetMapping(value="/downloadAsExcel")
	public HttpEntity<ByteArrayResource> downloadExcel() throws IOException {
		FileDownloadService fileDownloadService = (FileDownloadService)applicationContext.getBean("fileDownloadService");
		return fileDownloadService.downloadExcel();
	} 
}
