package com.techm.predix.aveoaero;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.techm.predix.aveoaero.dto.FlightDataWrapperDTO;
import com.techm.predix.aveoaero.dto.FlightParametersDTO;
import com.techm.predix.aveoaero.dto.FlightPathDTO;
import com.techm.predix.aveoaero.dto.FlightPathMinDTO;
import com.techm.predix.aveoaero.entity.FlightDataEntity;
import com.techm.predix.aveoaero.repository.IFlightDataEntityRepository;

@RestController
public class FlightDataService {

	@Autowired
	private IFlightDataEntityRepository flightDataEntityRepo;
	
	private static final String DATA_SEPARATOR = "~";
	
	@RequestMapping(value = "/getFlightPathDetails/{flight_id}", method = RequestMethod.GET)
	public @ResponseBody String getFlightPathDetails(@PathVariable BigDecimal flight_id) {
		
		List<FlightPathDTO> flightPathDtoList = new ArrayList<FlightPathDTO>();
		FlightPathDTO flightPathDto = null;		
		String pathDetailsString = "";

		try {
			List<FlightDataEntity> flightDataFromDb = flightDataEntityRepo.findByflightId(flight_id);
			
			for(FlightDataEntity flightDataEntity : flightDataFromDb){				
					flightPathDto =  new FlightPathDTO();
					flightPathDto.setFlight_id(flightDataEntity.getId().getFlightId());
					flightPathDto.setTime(flightDataEntity.getId().getTime());
					flightPathDto.setFrame(flightDataEntity.getFrame());
					flightPathDto.setM50(flightDataEntity.getM50());
					flightPathDto.setM51(flightDataEntity.getM51());
					flightPathDto.setM52(flightDataEntity.getM52());					
					flightPathDtoList.add(flightPathDto);
			}
			
			Gson gson = new Gson();
			String jsonInString = gson.toJson(flightPathDtoList).replaceAll("flight_id", "Flight_id").replaceAll("time", "Time").replaceAll("frame", "Frame").replaceAll("m50", "M50").replaceAll("m51", "M51").replaceAll("m52", "M52");
			
			String avio =  "{\"avio\":";
			String end  = "}";			
			
			HttpResponse<String> jsonResponse = Unirest.post("https://predix-analytics-catalog-release.run.aws-usw02-pr.ice.predix.io/api/v1/catalog/analytics/56840a7b-7572-48c1-9917-46696f714b6b/execution")
					  .header("content-type", "application/json")
					  .header("authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImxlZ2FjeS10b2tlbi1rZXkiLCJ0eXAiOiJKV1QifQ.eyJqdGkiOiIyYjM4ZjllYmQzNTk0YTYwYjBhYWVkYTI0Zjc5YWUyMSIsInN1YiI6ImNsaWVudDAxIiwic2NvcGUiOlsiYW5hbHl0aWNzLnpvbmVzLjZkZWI4MjM5LWFjZGEtNDJlZi04NmQzLWUxZTMzMGVlYjA0Mi51c2VyIl0sImNsaWVudF9pZCI6ImNsaWVudDAxIiwiY2lkIjoiY2xpZW50MDEiLCJhenAiOiJjbGllbnQwMSIsImdyYW50X3R5cGUiOiJjbGllbnRfY3JlZGVudGlhbHMiLCJyZXZfc2lnIjoiZjdhNDA0YTAiLCJpYXQiOjE0NzQwMjY0OTQsImV4cCI6MTQ3NDg4Njg5NCwiaXNzIjoiaHR0cHM6Ly9kNTc1MmM2YS1iYTAyLTQ4OWItODVkNy04NmU4ZGJkOGE2NWIucHJlZGl4LXVhYS5ydW4uYXdzLXVzdzAyLXByLmljZS5wcmVkaXguaW8vb2F1dGgvdG9rZW4iLCJ6aWQiOiJkNTc1MmM2YS1iYTAyLTQ4OWItODVkNy04NmU4ZGJkOGE2NWIiLCJhdWQiOlsiYW5hbHl0aWNzLnpvbmVzLjZkZWI4MjM5LWFjZGEtNDJlZi04NmQzLWUxZTMzMGVlYjA0MiIsImNsaWVudDAxIl19.L5fWDw5z7T_hjNPEmiSDOHJwp7DZZtIXMv6US5YQz4U5AOGGHSkuvMTLMn-HEjSugzWRxCWKCgjU60rDKshnw4AlGgojGHXcQL2S10bdftLX9QTYTKLAKzDgQQCxDofNRdlzmpKmUgIEidsSb1Fi5hKHXXMjpgdwq4N9442rePm37uRs85BkTVwlLwghkdJwYw3eGwDZSN9-9dpbE2HVfZhQPK8ClXFONALU5WtUSnl73AvCi1JwJ9MXl0kxvoYtbXSdflAyAswmMhHF-DwPKUGT9bY6yveT9QAO-knBkZhdHHWk279K8G6pEIGbYweVw-lYWOezDc6yRWDc8G-6Jg")
					  .header("predix-zone-id", "6deb8239-acda-42ef-86d3-e1e330eeb042")
					  .header("cache-control", "no-cache")
					  .header("postman-token", "722d62f4-79cc-a8fa-ab11-84fe0ad5c823")
					  .body(avio +jsonInString +end)
					  .asString();					

			System.out.println("rk jsonResponse status="+jsonResponse.getStatus());
			System.out.println("rk jsonResponse result="+jsonResponse.getBody());
			
			JSONObject jsonObject = new JSONObject(jsonResponse.getBody());
			JsonParser parser = new JsonParser();
			JsonObject json = (JsonObject) parser.parse(jsonObject.get("result").toString());
			
			pathDetailsString = json.toString();			
			
		} catch (Exception e) {
			System.out.println("Exception in getFlightPathDetails()");
			e.printStackTrace();
		}
		return pathDetailsString;
	}
	
	@RequestMapping(value = "/getFlightPathDetailsMin/{flight_id}", method = RequestMethod.GET)
	public @ResponseBody String getFlightPathDetailsMin(@PathVariable BigDecimal flight_id) {
		System.out.println("Enter getFlightPathDetailsMin()");
		List<FlightPathMinDTO> flightPathDtoList = new ArrayList<FlightPathMinDTO>();
		FlightPathMinDTO flightPathDto = null;		
		String pathDetailsString = "";

		try {
			List<FlightDataEntity> flightDataFromDb = flightDataEntityRepo.findByflightId(flight_id);
			
			for(FlightDataEntity flightDataEntity : flightDataFromDb){				
					flightPathDto =  new FlightPathMinDTO();
					flightPathDto.setM50(flightDataEntity.getM50());
					flightPathDto.setM51(flightDataEntity.getM51());
					flightPathDto.setM52(flightDataEntity.getM52());					
					flightPathDtoList.add(flightPathDto);
			}
			
			Gson gson = new Gson();
			String jsonInString = gson.toJson(flightPathDtoList).replaceAll("m50", "M50").replaceAll("m51", "M51").replaceAll("m52", "M52");
			
			String avio =  "{\"avio\":";
			String end  = "}";			
			
			HttpResponse<String> jsonResponse = Unirest.post("")
					  .header("content-type", "application/json")
					  .header("authorization", "Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6ImxlZ2FjeS10b2tlbi1rZXkiLCJ0eXAiOiJKV1QifQ.eyJqdGkiOiIyYjM4ZjllYmQzNTk0YTYwYjBhYWVkYTI0Zjc5YWUyMSIsInN1YiI6ImNsaWVudDAxIiwic2NvcGUiOlsiYW5hbHl0aWNzLnpvbmVzLjZkZWI4MjM5LWFjZGEtNDJlZi04NmQzLWUxZTMzMGVlYjA0Mi51c2VyIl0sImNsaWVudF9pZCI6ImNsaWVudDAxIiwiY2lkIjoiY2xpZW50MDEiLCJhenAiOiJjbGllbnQwMSIsImdyYW50X3R5cGUiOiJjbGllbnRfY3JlZGVudGlhbHMiLCJyZXZfc2lnIjoiZjdhNDA0YTAiLCJpYXQiOjE0NzQwMjY0OTQsImV4cCI6MTQ3NDg4Njg5NCwiaXNzIjoiaHR0cHM6Ly9kNTc1MmM2YS1iYTAyLTQ4OWItODVkNy04NmU4ZGJkOGE2NWIucHJlZGl4LXVhYS5ydW4uYXdzLXVzdzAyLXByLmljZS5wcmVkaXguaW8vb2F1dGgvdG9rZW4iLCJ6aWQiOiJkNTc1MmM2YS1iYTAyLTQ4OWItODVkNy04NmU4ZGJkOGE2NWIiLCJhdWQiOlsiYW5hbHl0aWNzLnpvbmVzLjZkZWI4MjM5LWFjZGEtNDJlZi04NmQzLWUxZTMzMGVlYjA0MiIsImNsaWVudDAxIl19.L5fWDw5z7T_hjNPEmiSDOHJwp7DZZtIXMv6US5YQz4U5AOGGHSkuvMTLMn-HEjSugzWRxCWKCgjU60rDKshnw4AlGgojGHXcQL2S10bdftLX9QTYTKLAKzDgQQCxDofNRdlzmpKmUgIEidsSb1Fi5hKHXXMjpgdwq4N9442rePm37uRs85BkTVwlLwghkdJwYw3eGwDZSN9-9dpbE2HVfZhQPK8ClXFONALU5WtUSnl73AvCi1JwJ9MXl0kxvoYtbXSdflAyAswmMhHF-DwPKUGT9bY6yveT9QAO-knBkZhdHHWk279K8G6pEIGbYweVw-lYWOezDc6yRWDc8G-6Jg")
					  .header("predix-zone-id", "6deb8239-acda-42ef-86d3-e1e330eeb042")
					  .header("cache-control", "no-cache")
					  .body(avio +jsonInString +end)
					  .asString();					

			System.out.println("rk jsonResponse status="+jsonResponse.getStatus());
			System.out.println("rk jsonResponse result="+jsonResponse.getBody());
			
			JSONObject jsonObject = new JSONObject(jsonResponse.getBody());
			JsonParser parser = new JsonParser();
			JsonObject json = (JsonObject) parser.parse(jsonObject.get("result").toString());
			
			pathDetailsString = json.toString();			
			
		} catch (Exception e) {
			System.out.println("Exception in getFlightPathDetailsMin()");
			e.printStackTrace();
		}
		System.out.println("Exit getFlightPathDetailsMin()");
		return pathDetailsString;
	}
	
	@RequestMapping(value = "/getFlightParamDetails/{flight_id}", method = RequestMethod.GET)
	public @ResponseBody FlightDataWrapperDTO getFlightParamDetails(@PathVariable BigDecimal flight_id) {
		
		List<FlightParametersDTO> flightParametersList = new ArrayList<FlightParametersDTO>();
		FlightParametersDTO flightParametersDTO = null;
		
		FlightDataWrapperDTO flightDataWrapperDTO = new FlightDataWrapperDTO();

		try {
			List<FlightDataEntity> flightDataFromDb = flightDataEntityRepo.findByflightId(flight_id);
			
			for(FlightDataEntity flightDataEntity : flightDataFromDb){				
					flightParametersDTO =  new FlightParametersDTO();
					flightParametersDTO.setFlight_id(flightDataEntity.getId().getFlightId());
					flightParametersDTO.setTime(flightDataEntity.getId().getTime());
					flightParametersDTO.setFrame(flightDataEntity.getFrame());
					flightParametersDTO.setE07(flightDataEntity.getE07());
					flightParametersDTO.setE08(flightDataEntity.getE08());
					flightParametersDTO.setE60(flightDataEntity.getE60());
					flightParametersDTO.setE61(flightDataEntity.getE61());
					flightParametersDTO.setL01(flightDataEntity.getL01());
					flightParametersDTO.setM61(flightDataEntity.getM61());					
					flightParametersList.add(flightParametersDTO);
			}
			
			flightDataWrapperDTO.setFlightParametersDtoList(flightParametersList);			
			
		} catch (Exception e) {
			System.out.println("Exception in getFlightParamDetails()");
			e.printStackTrace();
		}		
		return flightDataWrapperDTO;
	}	
	
	@RequestMapping(value = "/getAnalyticsInput/{flight_id}", method = RequestMethod.GET)
	public @ResponseBody String getAnalyticsInput(@PathVariable BigDecimal flight_id) {
		
		List<FlightPathDTO> flightPathDtoList = new ArrayList<FlightPathDTO>();
		FlightPathDTO flightPathDto = null;		
		String analyticsInputStr = "";

		try {
			List<FlightDataEntity> flightDataFromDb = flightDataEntityRepo.findByflightId(flight_id);
			
			for(FlightDataEntity flightDataEntity : flightDataFromDb){				
					flightPathDto =  new FlightPathDTO();
					flightPathDto.setFlight_id(flightDataEntity.getId().getFlightId());
					flightPathDto.setTime(flightDataEntity.getId().getTime());
					flightPathDto.setFrame(flightDataEntity.getFrame());
					flightPathDto.setM50(flightDataEntity.getM50());
					flightPathDto.setM51(flightDataEntity.getM51());
					flightPathDto.setM52(flightDataEntity.getM52());					
					flightPathDtoList.add(flightPathDto);
			}
			
			Gson gson = new Gson();
			String jsonInString = gson.toJson(flightPathDtoList).replaceAll("flight_id", "Flight_id").replaceAll("time", "Time").replaceAll("frame", "Frame").replaceAll("m50", "M50").replaceAll("m51", "M51").replaceAll("m52", "M52");
			
			String avio =  "{\"avio\":";
			String end  = "}";			
			
			
			analyticsInputStr = avio +jsonInString +end;
			
		} catch (Exception e) {
			System.out.println("Exception in getAnalyticsInput()");
			e.printStackTrace();
		}
		return analyticsInputStr;
	}
	
	@RequestMapping(value = "/getAnalyticsInputMin/{flight_id}", method = RequestMethod.GET)
	public @ResponseBody String getAnalyticsInputMin(@PathVariable BigDecimal flight_id) {
		
		String analyticsInputStr = "";

		try {
			List<FlightDataEntity> flightDataFromDb = flightDataEntityRepo.findByflightId(flight_id);
			String data = "";
			
			for(FlightDataEntity flightDataEntity : flightDataFromDb){	
					data += "{\"s\":\"" + flightDataEntity.getM50()+DATA_SEPARATOR+flightDataEntity.getM51()+DATA_SEPARATOR+flightDataEntity.getM52()+"\"}" + ",";
			}
			
			data = replaceLast(data, ",", "");
			
			String avio =  "{\"speed\":[";
			String end  = "]}";	
			
			analyticsInputStr = avio +data +end;
			
		} catch (Exception e) {
			System.out.println("Exception in getAnalyticsInput()");
			e.printStackTrace();
		}
		return analyticsInputStr;
	}
	
	public String replaceLast(String string, String substring, String replacement)
	{
	  int index = string.lastIndexOf(substring);
	  if (index == -1)
	    return string;
	  return string.substring(0, index) + replacement
	          + string.substring(index+substring.length());
	}
	
}