package com.covid.service;

import java.io.ByteArrayOutputStream;
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

import com.covid.dao.HomeDAO;
import com.covid.utils.ExcelUtils;

public class FileDownloadService {
	
	public FileDownloadService() {
		
	}
	static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("resources//applicationContext.xml");
	
	public HttpEntity<ByteArrayResource> downloadExcel(){
		try {
			HomeDAO homeDAO = (HomeDAO)applicationContext.getBean("homeDAO");
			List list = homeDAO.getCaseCount(); 
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            
            //XSSFWorkbook is top level object for creating new sheets
            //High level representation of a SpreadsheetML workbook
            
            XSSFWorkbook workbook = ExcelUtils.createExcel(list); // creates the workbook
            
            //Setting header content
            HttpHeaders header = new HttpHeaders();
            header.setContentType(new MediaType("application", "force-download"));
            header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ProductTemplate.xlsx");
            
            //Write out this document to an OutputStream
            workbook.write(byteArrayOutputStream);
           // workbook.close();
            return new ResponseEntity<>(new ByteArrayResource(byteArrayOutputStream.toByteArray()),
                    header, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
}
