package com.infy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserApiTest {

	@Test
	public void testHelloApi() throws Exception{
		try {
		URL url =new URL("http://localhost:8100/Hello");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type","application/json");
		System.out.println("Responsecode"+conn.getResponseCode());
		Assert.assertEquals(conn.getResponseCode(),200);
		}catch(Exception e) {
			Assert.fail();
	}
		
	}
	@Test	
	public void getHelloTest() {
		try {
			String userpass="http://localhost:8100/Hello";
			URL url = new URL(userpass);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			 Reader in1 = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			    StringBuilder sb1 = new StringBuilder();
			    for (int c; (c = in1.read()) >= 0;)
			        sb1.append((char)c);
			    String response1 = sb1.toString();
			Assert.assertEquals(response1,"Hello World!");
			
		}catch(IOException e) {
			Assert.fail();
		}
	}
		@Test
		public void getUserTest() {
			try {
				URL url= new URL("http://localhost:8100/users");
				
				HttpURLConnection conn2= (HttpURLConnection) url.openConnection();
				
				conn2.setRequestMethod("GET");
				conn2.setRequestProperty("Content-Type", "application/json");
				Assert.assertEquals(conn2.getResponseCode(), 200);
			}catch(Exception e) {
				Assert.fail();
			}
			
		}
//		@Test
//		public void addUserTest() {
//			try {
//				URL url= new URL("http://localhost:8100/addusers");
//				
//				HttpURLConnection conn2= (HttpURLConnection) url.openConnection();
//				conn2.setRequestMethod("POST");
//				conn2.setRequestProperty("Content-Type", "application/json");
////				Assert.assertEquals(conn2.getResponseCode(), 200);
//			}catch(Exception e) {
//				Assert.fail();
//			}
//			
//		}
}
