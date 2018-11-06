package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private final ArrayList<String> fortunes= new ArrayList<String>();
	private Random myRandom=new Random();
	
	@PostConstruct
	private void loadFortunesFromFile()  throws Exception
	{		
//		Load File
		File file = new File("src/FortuneFile.txt"); 
		
//		System.out.println("Load fortunes from file "+file.getName()); 
		
//		Buffer information
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		  String st; 
		  String[] fortunesArray= new String[0];
		  
//		  We know there is only 1 line, so we get that line and split it into an ArrayList
		  while ((st = br.readLine()) != null) 
			  fortunesArray = st.split("\\,"); 
		  
		  for(int i=0;i< fortunesArray.length;i++)
		  {
			  fortunes.add(fortunesArray[i]);
		  }
		  br.close();
	}
	
	
	@Override
	public String getFortune() {
		int index= myRandom.nextInt(fortunes.size());
		return fortunes.get(index);
	}

}
