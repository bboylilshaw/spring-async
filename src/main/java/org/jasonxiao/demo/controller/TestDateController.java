package org.jasonxiao.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

/**
 * @author Jason Xiao
 */
@RestController
public class TestDateController {

    @RequestMapping("/date")
    public ResponseEntity<Test> getTime() throws Exception {
        Test test = new Test();
        return ResponseEntity.ok(test);
    }

    @RequestMapping(value = "/date", method = RequestMethod.POST)
    public ResponseEntity<Test> postTime(@RequestBody Test test) throws Exception {
        System.out.println(test);
        test.setState("abc");
        return ResponseEntity.ok(test);
    }

}


class Test {

    private ZonedDateTime time;
    private State state;

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    public State getState() {
        return state;
    }

    public void setState(String name) {
        this.state = State.valueOf(name);
    }

    public void setState(State state) {
        this.state = state;
    }

    public enum State {
        A, B, C
    }
}