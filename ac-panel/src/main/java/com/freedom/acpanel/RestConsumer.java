package com.freedom.acpanel;

import com.freedom.acpanel.model.Node;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Data
@AllArgsConstructor
public class RestConsumer {

    private String currentUrl;

    public void getProductAsJson() {
        RestTemplate restTemplate = new RestTemplate();

        // Fetch JSON response as String wrapped in ResponseEntity
        ResponseEntity<String> response = restTemplate.getForEntity(this.currentUrl, String.class);
        String stringOfNodes = response.getBody();

        //ResponseEntity<List> response = restTemplate.getForEntity(this.currentUrl, List.class);
        //List<Node> listOfNodes = response.getBody();
        System.out.println(stringOfNodes.getClass());
    }
}
