package com.covid.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.covid.utils.ExcelUtils;
import com.covid.dao.HomeDAO;

public class FileDownloadService {
	
	public FileDownloadService() {
		
	}
	static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources//applicationContext.xml");	
	public HttpEntity<ByteArrayResource> downloadExcel() throws IOException {
		try {
			HomeDAO homeDAO = (HomeDAO)applicationContext.getBean("homeDAO");
			List list = homeDAO.getCaseCount(); 
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            XSSFWorkbook workbook = ExcelUtils.createExcel(list); // creates the workbook
            HttpHeaders header = new HttpHeaders();
            header.setContentType(new MediaType("application", "force-download"));
            header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ProductTemplate.xlsx");
            workbook.write(stream);
           // workbook.close();
            return new ResponseEntity<>(new ByteArrayResource(stream.toByteArray()),
                    header, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
}
