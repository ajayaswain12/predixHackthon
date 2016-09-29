package com.techm.predix.aveoaero;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class CallAnalyticsService {
	
	/*public static void main(String args[]){
		try {
			
			HttpResponse<String> jsonResponse = Unirest.post("https://predix-analytics-catalog-release.run.aws-usw02-pr.ice.predix.io/api/v1/catalog/analytics/915b5c27-71a7-41aa-b273-24217572269f/execution")
					  .header("content-type", "application/json")
					  .header("authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImxlZ2FjeS10b2tlbi1rZXkiLCJ0eXAiOiJKV1QifQ.eyJqdGkiOiIyYjM4ZjllYmQzNTk0YTYwYjBhYWVkYTI0Zjc5YWUyMSIsInN1YiI6ImNsaWVudDAxIiwic2NvcGUiOlsiYW5hbHl0aWNzLnpvbmVzLjZkZWI4MjM5LWFjZGEtNDJlZi04NmQzLWUxZTMzMGVlYjA0Mi51c2VyIl0sImNsaWVudF9pZCI6ImNsaWVudDAxIiwiY2lkIjoiY2xpZW50MDEiLCJhenAiOiJjbGllbnQwMSIsImdyYW50X3R5cGUiOiJjbGllbnRfY3JlZGVudGlhbHMiLCJyZXZfc2lnIjoiZjdhNDA0YTAiLCJpYXQiOjE0NzQwMjY0OTQsImV4cCI6MTQ3NDg4Njg5NCwiaXNzIjoiaHR0cHM6Ly9kNTc1MmM2YS1iYTAyLTQ4OWItODVkNy04NmU4ZGJkOGE2NWIucHJlZGl4LXVhYS5ydW4uYXdzLXVzdzAyLXByLmljZS5wcmVkaXguaW8vb2F1dGgvdG9rZW4iLCJ6aWQiOiJkNTc1MmM2YS1iYTAyLTQ4OWItODVkNy04NmU4ZGJkOGE2NWIiLCJhdWQiOlsiYW5hbHl0aWNzLnpvbmVzLjZkZWI4MjM5LWFjZGEtNDJlZi04NmQzLWUxZTMzMGVlYjA0MiIsImNsaWVudDAxIl19.L5fWDw5z7T_hjNPEmiSDOHJwp7DZZtIXMv6US5YQz4U5AOGGHSkuvMTLMn-HEjSugzWRxCWKCgjU60rDKshnw4AlGgojGHXcQL2S10bdftLX9QTYTKLAKzDgQQCxDofNRdlzmpKmUgIEidsSb1Fi5hKHXXMjpgdwq4N9442rePm37uRs85BkTVwlLwghkdJwYw3eGwDZSN9-9dpbE2HVfZhQPK8ClXFONALU5WtUSnl73AvCi1JwJ9MXl0kxvoYtbXSdflAyAswmMhHF-DwPKUGT9bY6yveT9QAO-knBkZhdHHWk279K8G6pEIGbYweVw-lYWOezDc6yRWDc8G-6Jg")
					  .header("predix-zone-id", "6deb8239-acda-42ef-86d3-e1e330eeb042")
					  .header("cache-control", "no-cache")
					  .header("postman-token", "f73debdd-78be-4ea9-34b6-5656138e9711")
					  .body("{\"avio\":[{\"Flight_id\":1,\"Time\":1,\"Frame\":1,\"M50\":35,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":1.5,\"Frame\":1,\"M50\":37,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":2,\"Frame\":2,\"M50\":39,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":2.5,\"Frame\":2,\"M50\":40,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":3,\"Frame\":3,\"M50\":42,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":3.5,\"Frame\":3,\"M50\":44,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":4,\"Frame\":4,\"M50\":45,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":4.5,\"Frame\":4,\"M50\":47,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":5,\"Frame\":5,\"M50\":49,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":5.5,\"Frame\":5,\"M50\":50,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":6,\"Frame\":6,\"M50\":52,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":6.5,\"Frame\":6,\"M50\":54,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":7,\"Frame\":7,\"M50\":55,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":7.5,\"Frame\":7,\"M50\":57,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":8,\"Frame\":8,\"M50\":59,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":8.5,\"Frame\":8,\"M50\":60,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":9,\"Frame\":9,\"M50\":62,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":9.5,\"Frame\":9,\"M50\":0,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":10,\"Frame\":10,\"M50\":1,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":10.5,\"Frame\":10,\"M50\":3,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":11,\"Frame\":11,\"M50\":5,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":11.5,\"Frame\":11,\"M50\":6,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":12,\"Frame\":12,\"M50\":8,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":12.5,\"Frame\":12,\"M50\":10,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":13,\"Frame\":13,\"M50\":11,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":13.5,\"Frame\":13,\"M50\":13,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":14,\"Frame\":14,\"M50\":15,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":14.5,\"Frame\":14,\"M50\":16,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":15,\"Frame\":15,\"M50\":18,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":15.5,\"Frame\":15,\"M50\":20,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":16,\"Frame\":16,\"M50\":21,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":16.5,\"Frame\":16,\"M50\":23,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":17,\"Frame\":17,\"M50\":25,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":17.5,\"Frame\":17,\"M50\":26,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":18,\"Frame\":18,\"M50\":28,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":18.5,\"Frame\":18,\"M50\":30,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":19,\"Frame\":19,\"M50\":31,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":19.5,\"Frame\":19,\"M50\":36897,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":20,\"Frame\":20,\"M50\":35,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":20.5,\"Frame\":20,\"M50\":36,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":21,\"Frame\":21,\"M50\":38,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":21.5,\"Frame\":21,\"M50\":40,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":22,\"Frame\":22,\"M50\":41,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":22.5,\"Frame\":22,\"M50\":43,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":23,\"Frame\":23,\"M50\":45,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":23.5,\"Frame\":23,\"M50\":46,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":24,\"Frame\":24,\"M50\":48,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":24.5,\"Frame\":24,\"M50\":50,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":25,\"Frame\":25,\"M50\":51,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":25.5,\"Frame\":25,\"M50\":53,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":26,\"Frame\":26,\"M50\":55,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":26.5,\"Frame\":26,\"M50\":56,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":27,\"Frame\":27,\"M50\":58,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":27.5,\"Frame\":27,\"M50\":60,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":28,\"Frame\":28,\"M50\":61,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":28.5,\"Frame\":28,\"M50\":63,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":29,\"Frame\":29,\"M50\":1,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":29.5,\"Frame\":29,\"M50\":2,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":30,\"Frame\":30,\"M50\":4,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":30.5,\"Frame\":30,\"M50\":6,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":31,\"Frame\":31,\"M50\":7,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":31.5,\"Frame\":31,\"M50\":9,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":32,\"Frame\":32,\"M50\":11,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":32.5,\"Frame\":32,\"M50\":12,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":33,\"Frame\":33,\"M50\":14,\"M51\":0,\"M52\":0}]}")
					  .asString();

			System.out.println("jsonResponse status="+jsonResponse.getStatus());
			System.out.println("jsonResponse result="+jsonResponse.getBody());
			
			Gson gson = new Gson();
			//String responseJSONString = jsonResponse.getBody().toString();
			//MyResponseObject myObject = gson.fromJson(responseJSONString, String.class);
			
			//String jsonInString = gson.toJson(obj);


			
		} catch (UnirestException e) {			
			e.printStackTrace();
		}
		
	}*/

	//public static void main(String[] args) {
		/*WebResource webResource = client.resource(serviceURL);
		ClientResponse clientResponse = null;
			if (methodType != null && methodType.equalsIgnoreCase("GET")) {
				clientResponse = webResource
						.accept(MediaType.APPLICATION_JSON)
						.header("Authorization",
								request.getParameter("Authorization"))
						.header("GE_USER", "WSA").header("ConsumerApp", "Trajectory").get(ClientResponse.class);
			} else if (methodType != null && methodType.equalsIgnoreCase("POST")) {
				String body = request.getParameter("body");
				clientResponse = webResource
						//.accept(MediaType.APPLICATION_JSON)
						//.type(MediaType.APPLICATION_FORM_URLENCODED_TYPE)
						.header("Authorization",request.getParameter("Authorization"))
						.header("GE_USER", "WSA").header("ConsumerApp", "Trajectory")
						.header("Content-Type", "application/json")
						.post(ClientResponse.class, body);
			}
			logger.info("Client Response status : " + clientResponse.getStatus());
			output = clientResponse.getEntity(String.class);
			out.println(output);
*/
	//}
	
	/*public static void main(String args[]){
		String s1 = "\"mystring\"";
		System.out.println("s1="+s1);
		String s2=s1.replaceAll("\"", "\\\\\"");
		System.out.println("s1 replaced="+s2);
	}*/
	
	/*public static void main(String args[]){
		try {
			
			String avio =  "{\"avio\":";
			String end  = "}";
			String jsonInString = "{\"Flight_id\":1,\"Time\":1.0,\"Frame\":1,\"M50\":35.0,\"M51\":0.0,\"M52\":0.0}";
			String finalstr=avio+jsonInString+end;
			System.out.println("finalstr="+finalstr);
			
			HttpResponse<String> jsonResponse = Unirest.post("https://predix-analytics-catalog-release.run.aws-usw02-pr.ice.predix.io/api/v1/catalog/analytics/915b5c27-71a7-41aa-b273-24217572269f/execution")
					  .header("content-type", "application/json")
					  .header("authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImxlZ2FjeS10b2tlbi1rZXkiLCJ0eXAiOiJKV1QifQ.eyJqdGkiOiIyYjM4ZjllYmQzNTk0YTYwYjBhYWVkYTI0Zjc5YWUyMSIsInN1YiI6ImNsaWVudDAxIiwic2NvcGUiOlsiYW5hbHl0aWNzLnpvbmVzLjZkZWI4MjM5LWFjZGEtNDJlZi04NmQzLWUxZTMzMGVlYjA0Mi51c2VyIl0sImNsaWVudF9pZCI6ImNsaWVudDAxIiwiY2lkIjoiY2xpZW50MDEiLCJhenAiOiJjbGllbnQwMSIsImdyYW50X3R5cGUiOiJjbGllbnRfY3JlZGVudGlhbHMiLCJyZXZfc2lnIjoiZjdhNDA0YTAiLCJpYXQiOjE0NzQwMjY0OTQsImV4cCI6MTQ3NDg4Njg5NCwiaXNzIjoiaHR0cHM6Ly9kNTc1MmM2YS1iYTAyLTQ4OWItODVkNy04NmU4ZGJkOGE2NWIucHJlZGl4LXVhYS5ydW4uYXdzLXVzdzAyLXByLmljZS5wcmVkaXguaW8vb2F1dGgvdG9rZW4iLCJ6aWQiOiJkNTc1MmM2YS1iYTAyLTQ4OWItODVkNy04NmU4ZGJkOGE2NWIiLCJhdWQiOlsiYW5hbHl0aWNzLnpvbmVzLjZkZWI4MjM5LWFjZGEtNDJlZi04NmQzLWUxZTMzMGVlYjA0MiIsImNsaWVudDAxIl19.L5fWDw5z7T_hjNPEmiSDOHJwp7DZZtIXMv6US5YQz4U5AOGGHSkuvMTLMn-HEjSugzWRxCWKCgjU60rDKshnw4AlGgojGHXcQL2S10bdftLX9QTYTKLAKzDgQQCxDofNRdlzmpKmUgIEidsSb1Fi5hKHXXMjpgdwq4N9442rePm37uRs85BkTVwlLwghkdJwYw3eGwDZSN9-9dpbE2HVfZhQPK8ClXFONALU5WtUSnl73AvCi1JwJ9MXl0kxvoYtbXSdflAyAswmMhHF-DwPKUGT9bY6yveT9QAO-knBkZhdHHWk279K8G6pEIGbYweVw-lYWOezDc6yRWDc8G-6Jg")
					  .header("predix-zone-id", "6deb8239-acda-42ef-86d3-e1e330eeb042")
					  .header("cache-control", "no-cache")
					  .header("postman-token", "f73debdd-78be-4ea9-34b6-5656138e9711")
					  .body(avio +jsonInString +end)
					  .asString();

			System.out.println("jsonResponse status="+jsonResponse.getStatus());
			System.out.println("jsonResponse result="+jsonResponse.getBody());
			
			Gson gson = new Gson();
			//String responseJSONString = jsonResponse.getBody().toString();
			//MyResponseObject myObject = gson.fromJson(responseJSONString, String.class);
			
			//String jsonInString = gson.toJson(obj);


			status
		} catch (UnirestException e) {			
			e.printStackTrace();
		}
		
	}*/
	
	/*public static void main(String args[]){
	try {
		
		String avio =  "{\"avio\":[";
		String end  = "]}";
		
		//String jsonInString = "{\"Flight_id\":1,\"Time\":1,\"Frame\":1,\"M50\":35,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":1.5,\"Frame\":1,\"M50\":37,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":2,\"Frame\":2,\"M50\":39,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":2.5,\"Frame\":2,\"M50\":40,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":3,\"Frame\":3,\"M50\":42,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":3.5,\"Frame\":3,\"M50\":44,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":4,\"Frame\":4,\"M50\":45,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":4.5,\"Frame\":4,\"M50\":47,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":5,\"Frame\":5,\"M50\":49,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":5.5,\"Frame\":5,\"M50\":50,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":6,\"Frame\":6,\"M50\":52,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":6.5,\"Frame\":6,\"M50\":54,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":7,\"Frame\":7,\"M50\":55,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":7.5,\"Frame\":7,\"M50\":57,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":8,\"Frame\":8,\"M50\":59,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":8.5,\"Frame\":8,\"M50\":60,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":9,\"Frame\":9,\"M50\":62,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":9.5,\"Frame\":9,\"M50\":0,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":10,\"Frame\":10,\"M50\":1,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":10.5,\"Frame\":10,\"M50\":3,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":11,\"Frame\":11,\"M50\":5,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":11.5,\"Frame\":11,\"M50\":6,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":12,\"Frame\":12,\"M50\":8,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":12.5,\"Frame\":12,\"M50\":10,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":13,\"Frame\":13,\"M50\":11,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":13.5,\"Frame\":13,\"M50\":13,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":14,\"Frame\":14,\"M50\":15,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":14.5,\"Frame\":14,\"M50\":16,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":15,\"Frame\":15,\"M50\":18,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":15.5,\"Frame\":15,\"M50\":20,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":16,\"Frame\":16,\"M50\":21,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":16.5,\"Frame\":16,\"M50\":23,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":17,\"Frame\":17,\"M50\":25,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":17.5,\"Frame\":17,\"M50\":26,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":18,\"Frame\":18,\"M50\":28,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":18.5,\"Frame\":18,\"M50\":30,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":19,\"Frame\":19,\"M50\":31,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":19.5,\"Frame\":19,\"M50\":36897,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":20,\"Frame\":20,\"M50\":35,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":20.5,\"Frame\":20,\"M50\":36,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":21,\"Frame\":21,\"M50\":38,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":21.5,\"Frame\":21,\"M50\":40,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":22,\"Frame\":22,\"M50\":41,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":22.5,\"Frame\":22,\"M50\":43,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":23,\"Frame\":23,\"M50\":45,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":23.5,\"Frame\":23,\"M50\":46,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":24,\"Frame\":24,\"M50\":48,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":24.5,\"Frame\":24,\"M50\":50,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":25,\"Frame\":25,\"M50\":51,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":25.5,\"Frame\":25,\"M50\":53,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":26,\"Frame\":26,\"M50\":55,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":26.5,\"Frame\":26,\"M50\":56,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":27,\"Frame\":27,\"M50\":58,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":27.5,\"Frame\":27,\"M50\":60,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":28,\"Frame\":28,\"M50\":61,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":28.5,\"Frame\":28,\"M50\":63,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":29,\"Frame\":29,\"M50\":1,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":29.5,\"Frame\":29,\"M50\":2,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":30,\"Frame\":30,\"M50\":4,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":30.5,\"Frame\":30,\"M50\":6,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":31,\"Frame\":31,\"M50\":7,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":31.5,\"Frame\":31,\"M50\":9,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":32,\"Frame\":32,\"M50\":11,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":32.5,\"Frame\":32,\"M50\":12,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":33,\"Frame\":33,\"M50\":14,\"M51\":0,\"M52\":0}";
		String jsonInString =   "{\"Flight_id\":1,\"Time\":1,\"Frame\":1,\"M50\":35,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":1.5,\"Frame\":1,\"M50\":37,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":2,\"Frame\":2,\"M50\":39,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":2.5,\"Frame\":2,\"M50\":40,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":3,\"Frame\":3,\"M50\":42,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":3.5,\"Frame\":3,\"M50\":44,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":4,\"Frame\":4,\"M50\":45,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":4.5,\"Frame\":4,\"M50\":47,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":5,\"Frame\":5,\"M50\":49,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":5.5,\"Frame\":5,\"M50\":50,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":6,\"Frame\":6,\"M50\":52,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":6.5,\"Frame\":6,\"M50\":54,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":7,\"Frame\":7,\"M50\":55,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":7.5,\"Frame\":7,\"M50\":57,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":8,\"Frame\":8,\"M50\":59,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":8.5,\"Frame\":8,\"M50\":60,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":9,\"Frame\":9,\"M50\":62,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":9.5,\"Frame\":9,\"M50\":0,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":10,\"Frame\":10,\"M50\":1,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":10.5,\"Frame\":10,\"M50\":3,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":11,\"Frame\":11,\"M50\":5,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":11.5,\"Frame\":11,\"M50\":6,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":12,\"Frame\":12,\"M50\":8,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":12.5,\"Frame\":12,\"M50\":10,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":13,\"Frame\":13,\"M50\":11,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":13.5,\"Frame\":13,\"M50\":13,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":14,\"Frame\":14,\"M50\":15,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":14.5,\"Frame\":14,\"M50\":16,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":15,\"Frame\":15,\"M50\":18,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":15.5,\"Frame\":15,\"M50\":20,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":16,\"Frame\":16,\"M50\":21,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":16.5,\"Frame\":16,\"M50\":23,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":17,\"Frame\":17,\"M50\":25,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":17.5,\"Frame\":17,\"M50\":26,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":18,\"Frame\":18,\"M50\":28,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":18.5,\"Frame\":18,\"M50\":30,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":19,\"Frame\":19,\"M50\":31,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":19.5,\"Frame\":19,\"M50\":36897,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":20,\"Frame\":20,\"M50\":35,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":20.5,\"Frame\":20,\"M50\":36,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":21,\"Frame\":21,\"M50\":38,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":21.5,\"Frame\":21,\"M50\":40,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":22,\"Frame\":22,\"M50\":41,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":22.5,\"Frame\":22,\"M50\":43,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":23,\"Frame\":23,\"M50\":45,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":23.5,\"Frame\":23,\"M50\":46,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":24,\"Frame\":24,\"M50\":48,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":24.5,\"Frame\":24,\"M50\":50,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":25,\"Frame\":25,\"M50\":51,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":25.5,\"Frame\":25,\"M50\":53,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":26,\"Frame\":26,\"M50\":55,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":26.5,\"Frame\":26,\"M50\":56,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":27,\"Frame\":27,\"M50\":58,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":27.5,\"Frame\":27,\"M50\":60,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":28,\"Frame\":28,\"M50\":61,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":28.5,\"Frame\":28,\"M50\":63,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":29,\"Frame\":29,\"M50\":1,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":29.5,\"Frame\":29,\"M50\":2,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":30,\"Frame\":30,\"M50\":4,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":30.5,\"Frame\":30,\"M50\":6,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":31,\"Frame\":31,\"M50\":7,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":31.5,\"Frame\":31,\"M50\":9,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":32,\"Frame\":32,\"M50\":11,\"M51\":0,\"M52\":0}";
		
		//.header("authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImxlZ2FjeS10b2tlbi1rZXkiLCJ0eXAiOiJKV1QifQ.eyJqdGkiOiIyYjM4ZjllYmQzNTk0YTYwYjBhYWVkYTI0Zjc5YWUyMSIsInN1YiI6ImNsaWVudDAxIiwic2NvcGUiOlsiYW5hbHl0aWNzLnpvbmVzLjZkZWI4MjM5LWFjZGEtNDJlZi04NmQzLWUxZTMzMGVlYjA0Mi51c2VyIl0sImNsaWVudF9pZCI6ImNsaWVudDAxIiwiY2lkIjoiY2xpZW50MDEiLCJhenAiOiJjbGllbnQwMSIsImdyYW50X3R5cGUiOiJjbGllbnRfY3JlZGVudGlhbHMiLCJyZXZfc2lnIjoiZjdhNDA0YTAiLCJpYXQiOjE0NzQwMjY0OTQsImV4cCI6MTQ3NDg4Njg5NCwiaXNzIjoiaHR0cHM6Ly9kNTc1MmM2YS1iYTAyLTQ4OWItODVkNy04NmU4ZGJkOGE2NWIucHJlZGl4LXVhYS5ydW4uYXdzLXVzdzAyLXByLmljZS5wcmVkaXguaW8vb2F1dGgvdG9rZW4iLCJ6aWQiOiJkNTc1MmM2YS1iYTAyLTQ4OWItODVkNy04NmU4ZGJkOGE2NWIiLCJhdWQiOlsiYW5hbHl0aWNzLnpvbmVzLjZkZWI4MjM5LWFjZGEtNDJlZi04NmQzLWUxZTMzMGVlYjA0MiIsImNsaWVudDAxIl19.L5fWDw5z7T_hjNPEmiSDOHJwp7DZZtIXMv6US5YQz4U5AOGGHSkuvMTLMn-HEjSugzWRxCWKCgjU60rDKshnw4AlGgojGHXcQL2S10bdftLX9QTYTKLAKzDgQQCxDofNRdlzmpKmUgIEidsSb1Fi5hKHXXMjpgdwq4N9442rePm37uRs85BkTVwlLwghkdJwYw3eGwDZSN9-9dpbE2HVfZhQPK8ClXFONALU5WtUSnl73AvCi1JwJ9MXl0kxvoYtbXSdflAyAswmMhHF-DwPKUGT9bY6yveT9QAO-knBkZhdHHWk279K8G6pEIGbYweVw-lYWOezDc6yRWDc8G-6Jg")
		//.header("postman-token", "f73debdd-78be-4ea9-34b6-5656138e9711")
		
		String finalstr=avio+jsonInString+end;
		System.out.println("finalstr="+finalstr);
		
		HttpResponse<String> jsonResponse = Unirest.post("https://predix-analytics-catalog-release.run.aws-usw02-pr.ice.predix.io/api/v1/catalog/analytics/915b5c27-71a7-41aa-b273-24217572269f/execution")
				  .header("content-type", "application/json")
				  .header("authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImxlZ2FjeS10b2tlbi1rZXkiLCJ0eXAiOiJKV1QifQ.eyJqdGkiOiI4Y2I1YmY5ZGYwYWE0YzM4OTdlMjhlYjhmOGRiNGY5NiIsInN1YiI6ImNsaWVudDAxIiwic2NvcGUiOlsiYW5hbHl0aWNzLnpvbmVzLjZkZWI4MjM5LWFjZGEtNDJlZi04NmQzLWUxZTMzMGVlYjA0Mi51c2VyIl0sImNsaWVudF9pZCI6ImNsaWVudDAxIiwiY2lkIjoiY2xpZW50MDEiLCJhenAiOiJjbGllbnQwMSIsImdyYW50X3R5cGUiOiJjbGllbnRfY3JlZGVudGlhbHMiLCJyZXZfc2lnIjoiZjdhNDA0YTAiLCJpYXQiOjE0NzQyNjIwMDksImV4cCI6MTU2MDY2MjAwOSwiaXNzIjoiaHR0cHM6Ly9kNTc1MmM2YS1iYTAyLTQ4OWItODVkNy04NmU4ZGJkOGE2NWIucHJlZGl4LXVhYS5ydW4uYXdzLXVzdzAyLXByLmljZS5wcmVkaXguaW8vb2F1dGgvdG9rZW4iLCJ6aWQiOiJkNTc1MmM2YS1iYTAyLTQ4OWItODVkNy04NmU4ZGJkOGE2NWIiLCJhdWQiOlsiYW5hbHl0aWNzLnpvbmVzLjZkZWI4MjM5LWFjZGEtNDJlZi04NmQzLWUxZTMzMGVlYjA0MiIsImNsaWVudDAxIl19.dxcPNfUrAm8nnE6io2d-gfVQ_VP7C2x9_koXHYV_eSjHFfo4sGThvPGaf7Svt4famJNXE5JeSJMmrBc3hZbyq0srN4xSRNhcKKMDq0CZ-ifOQSI4KsT-MYV2CrC66fg559Gb1JE33N8xD1qdpLNPZSygV0bKrLM6SuKmhkjxkPoLUzGVM-G3c25lgYHRhZHb19ZZwJDAJMUFXjYIa6qH7_ZigIP7jwAazg_S7Fyh69c97Yl9KFsYoFzRGjuEyVMdKmq1QsdsELIhzwY6yBEFZrs3J9-cD4o_cFLPAGrxG0fjyq6ijLQUCvU70uyjzsnfb4IBqw3yEBS-bFapkNrrPw")
				  .header("predix-zone-id", "6deb8239-acda-42ef-86d3-e1e330eeb042")
				  .header("cache-control", "no-cache")
				  .header("postman-token", "f73debdd-78be-4ea9-34b6-5656138e9711")
				  .body(avio +jsonInString +end)
				  .asString();

		//.body("{\"avio\":[{\"Flight_id\":1,\"Time\":1,\"Frame\":1,\"M50\":35,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":1.5,\"Frame\":1,\"M50\":37,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":2,\"Frame\":2,\"M50\":39,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":2.5,\"Frame\":2,\"M50\":40,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":3,\"Frame\":3,\"M50\":42,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":3.5,\"Frame\":3,\"M50\":44,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":4,\"Frame\":4,\"M50\":45,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":4.5,\"Frame\":4,\"M50\":47,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":5,\"Frame\":5,\"M50\":49,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":5.5,\"Frame\":5,\"M50\":50,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":6,\"Frame\":6,\"M50\":52,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":6.5,\"Frame\":6,\"M50\":54,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":7,\"Frame\":7,\"M50\":55,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":7.5,\"Frame\":7,\"M50\":57,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":8,\"Frame\":8,\"M50\":59,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":8.5,\"Frame\":8,\"M50\":60,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":9,\"Frame\":9,\"M50\":62,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":9.5,\"Frame\":9,\"M50\":0,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":10,\"Frame\":10,\"M50\":1,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":10.5,\"Frame\":10,\"M50\":3,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":11,\"Frame\":11,\"M50\":5,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":11.5,\"Frame\":11,\"M50\":6,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":12,\"Frame\":12,\"M50\":8,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":12.5,\"Frame\":12,\"M50\":10,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":13,\"Frame\":13,\"M50\":11,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":13.5,\"Frame\":13,\"M50\":13,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":14,\"Frame\":14,\"M50\":15,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":14.5,\"Frame\":14,\"M50\":16,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":15,\"Frame\":15,\"M50\":18,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":15.5,\"Frame\":15,\"M50\":20,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":16,\"Frame\":16,\"M50\":21,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":16.5,\"Frame\":16,\"M50\":23,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":17,\"Frame\":17,\"M50\":25,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":17.5,\"Frame\":17,\"M50\":26,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":18,\"Frame\":18,\"M50\":28,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":18.5,\"Frame\":18,\"M50\":30,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":19,\"Frame\":19,\"M50\":31,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":19.5,\"Frame\":19,\"M50\":36897,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":20,\"Frame\":20,\"M50\":35,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":20.5,\"Frame\":20,\"M50\":36,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":21,\"Frame\":21,\"M50\":38,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":21.5,\"Frame\":21,\"M50\":40,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":22,\"Frame\":22,\"M50\":41,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":22.5,\"Frame\":22,\"M50\":43,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":23,\"Frame\":23,\"M50\":45,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":23.5,\"Frame\":23,\"M50\":46,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":24,\"Frame\":24,\"M50\":48,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":24.5,\"Frame\":24,\"M50\":50,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":25,\"Frame\":25,\"M50\":51,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":25.5,\"Frame\":25,\"M50\":53,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":26,\"Frame\":26,\"M50\":55,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":26.5,\"Frame\":26,\"M50\":56,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":27,\"Frame\":27,\"M50\":58,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":27.5,\"Frame\":27,\"M50\":60,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":28,\"Frame\":28,\"M50\":61,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":28.5,\"Frame\":28,\"M50\":63,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":29,\"Frame\":29,\"M50\":1,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":29.5,\"Frame\":29,\"M50\":2,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":30,\"Frame\":30,\"M50\":4,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":30.5,\"Frame\":30,\"M50\":6,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":31,\"Frame\":31,\"M50\":7,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":31.5,\"Frame\":31,\"M50\":9,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":32,\"Frame\":32,\"M50\":11,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":32.5,\"Frame\":32,\"M50\":12,\"M51\":0,\"M52\":0},{\"Flight_id\":1,\"Time\":33,\"Frame\":33,\"M50\":14,\"M51\":0,\"M52\":0}]}")
		//.body(avio +jsonInString +end)
		
		System.out.println("jsonResponse status="+jsonResponse.getStatus());
		System.out.println("jsonResponse result="+jsonResponse.getBody());
		
		JSONObject jsonObject=new JSONObject(jsonResponse.getBody());
		JSONObject resultObject=new JSONObject(jsonObject.get("result"));
		System.out.println("resultObject="+jsonObject.get("result"));
		JsonParser parser = new JsonParser();
		JsonObject json = (JsonObject) parser.parse(jsonObject.get("result").toString());
		System.out.println("loc="+json.get("loc"));		
		System.out.println("Flight Total distance="+json.get("Flight Total distance"));
		
		String finalPathData = json.toString();
		System.out.println("finalPathData="+finalPathData);
		
		String s1 = jsonObject.get("result").toString();
		System.out.println("s1="+s1);
		
		//Gson gson = new Gson();
		//String responseJSONString = jsonResponse.getBody().toString();
		//MyResponseObject myObject = gson.fromJson(responseJSONString, String.class);
		
		//String jsonInString = gson.toJson(obj);


		
	} catch (UnirestException e) {			
		e.printStackTrace();
	}	
	}*/
	
	
}