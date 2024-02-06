package com.example.SunBaseAssignment.controller;

import com.example.SunBaseAssignment.dto.request.SunbaseAuthRequest;
import com.example.SunBaseAssignment.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/sunbase")
@CrossOrigin
public class SunbaseController {
    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/token")
    public ResponseEntity generateToken(@RequestBody SunbaseAuthRequest authRequest){

       try{
           HttpHeaders headers=new HttpHeaders();
           headers.setContentType(MediaType.APPLICATION_JSON);

           HttpEntity<SunbaseAuthRequest>request=new HttpEntity<>(authRequest,headers);

           String url="https://qa.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp";
           ResponseEntity<String>generatedToken=restTemplate.postForEntity(url,request,String.class);
           return generatedToken;
       }
       catch (Exception e){
           return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
       }
    }

    @GetMapping("/hello")
    public  String sayHello(){
        return "Hello Aniket";
    }


    @GetMapping("/customer-list")
    public ResponseEntity getAllData(@RequestHeader("Authorization") String authorizationHeader){
        try{
           HttpHeaders headers=new HttpHeaders();
           headers.setContentType(MediaType.APPLICATION_JSON);
           headers.set("Authorization",authorizationHeader);
            //set query paramerters..
            String url="https://qa.sunbasedata.com/sunbase/portal/api/assignment.jsp";

            UriComponentsBuilder builder=UriComponentsBuilder.fromHttpUrl(url).queryParam("cmd","get_customer_list");

            HttpEntity entity=new HttpEntity(headers);

            ResponseEntity<String>response=restTemplate.exchange(
                    builder.toUriString(),
                    HttpMethod.GET,
                    entity,
                    String.class
            );

            return ResponseEntity.ok(response.getBody());

        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    };
}
