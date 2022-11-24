package com.freedom.acpanel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AcPanelApplication {

	public static void main(String[] args) throws JsonProcessingException {

		SpringApplication.run(AcPanelApplication.class, args);

		RestConsumer rc = new RestConsumer("http://server1c.freedom1.ru/UNF_CRM_WS/hs/Crash/alarmPanel?request=getNodes");
		rc.getProductAsJson();
	}
}