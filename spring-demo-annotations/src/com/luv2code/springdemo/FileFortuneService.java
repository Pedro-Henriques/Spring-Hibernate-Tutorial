package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private ArrayList<String> fortunes= new ArrayList<String>();
	private Random myRandom=new Random();
	
	
	public FileFortuneService() throws Exception
	{
		File file = new File("src/FortuneFile.txt"); 
		  
		  BufferedReader br = new BufferedReader(new FileReader(file)); 
		  
		  String st; 
		  String[] fortunesArray= new String[0];
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
