package com.myftiu.digital.river.integration;


import com.myftiu.digital.river.MainHost;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by myftiu
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = MainHost.class)
@IntegrationTest
public class PerfectNumberIT {

    private static final String BASE_URL = "http://localhost:8181/rest/v1/perfect";
    private static final String VALIDATE_URL = BASE_URL + "/validate/";
    private static final String FIND_URL = BASE_URL + "/range/";
    private static final RestTemplate REST_TEMPLATE = new TestRestTemplate();



    @Test
    public void shouldReturnTrueResult() {

        // given
        int number = 6;

        // when
        ResponseEntity<String> response = REST_TEMPLATE.getForEntity(VALIDATE_URL + number, String.class);

        // then
        assertThat( response.getStatusCode() , equalTo(HttpStatus.OK));
        assertEquals(response.getBody().toLowerCase(), "true");

    }

    @Test
    public void shouldReturnFalseResult() {

        // given
        int number = 10;

        // when
        ResponseEntity<String> response = REST_TEMPLATE.getForEntity(VALIDATE_URL + number, String.class);

        // then
        assertThat( response.getStatusCode() , equalTo(HttpStatus.OK));
        assertEquals(response.getBody().toLowerCase(), "false");

    }


    @Test
    public void shouldReturnErrorCode() {
        // given
        String fakeNumber = "xxxxx";

        // when
        ResponseEntity<String> response = REST_TEMPLATE.getForEntity(VALIDATE_URL + fakeNumber, String.class);

        // then
        assertThat( response.getStatusCode() , equalTo(HttpStatus.BAD_REQUEST));

    }



    @Test
    public void shouldReturnAnArrayOfPerfectNumbers() {

        //given
        int start = 1;
        long end = 8128;

        // when
        REST_TEMPLATE.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        ResponseEntity<String> response = REST_TEMPLATE.getForEntity(FIND_URL + start + "/" + end, String.class);


        //then
        assertThat( response.getStatusCode() , equalTo(HttpStatus.OK));
        assertEquals(response.getBody(), "[6,28,496,8128]");

    }




}
