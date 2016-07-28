package org.jasonxiao.demo.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by Jason on 7/24/16.
 */
@RestController
public class TestDateController {

    @RequestMapping("/date")
    public ResponseEntity<Test> getTime() throws Exception {
        Test test = new Test();
        test.setJava8LocalDateTime(LocalDateTime.now());
        test.setJava8ZonedDateTime(ZonedDateTime.now());
        System.out.println(test.getJava8LocalDateTime().toString());
        System.out.println(test.getJava8ZonedDateTime().toString());
        return ResponseEntity.ok(test);
    }

    @RequestMapping(value = "/date", method = RequestMethod.POST)
    public ResponseEntity<Test> postTime(@RequestBody Test test) throws Exception {
        System.out.println(test.getJava8LocalDateTime().toString());
        test.setJava8LocalDateTime(LocalDateTime.now());
        System.out.println(test.getJava8LocalDateTime().toString());
        return ResponseEntity.ok(test);
    }

}


class Test {

//    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime java8LocalDateTime;

//    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private ZonedDateTime java8ZonedDateTime;

    public LocalDateTime getJava8LocalDateTime() {
        return java8LocalDateTime;
    }

    public void setJava8LocalDateTime(LocalDateTime java8LocalDateTime) {
        this.java8LocalDateTime = java8LocalDateTime;
    }

    public ZonedDateTime getJava8ZonedDateTime() {
        return java8ZonedDateTime;
    }

    public void setJava8ZonedDateTime(ZonedDateTime java8ZonedDateTime) {
        this.java8ZonedDateTime = java8ZonedDateTime;
    }
}