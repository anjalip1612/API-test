package com.apex.customer.test;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class customertest {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		//create an object of HttpClient
				HttpClient client=HttpClientBuilder.create().build();
				//create the request message
				HttpGet request=new HttpGet("https://gorest.co.in/public-api/users");
				//send the request and get the response
				HttpResponse response= client.execute(request);
				//Validate and test the response
				System.out.println(response.getStatusLine().getStatusCode());
				System.out.println(response.getStatusLine().getReasonPhrase());
	
	  HttpEntity entity = response.getEntity();
      if (entity != null) {
          // return it as a String
          String result = EntityUtils.toString(entity);
          JSONObject jsonResponse=new JSONObject(result);
          System.out.println(jsonResponse);
      }
      if(response.getStatusLine().getStatusCode()==200)
      System.out.println("Test Passed");
      else
    	  System.out.println("Test Failed");
      


}}
