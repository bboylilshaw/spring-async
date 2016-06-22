package org.jasonxiao.demo.web.controller;

import org.jasonxiao.demo.exception.UserNotFoundException;
import org.jasonxiao.demo.model.User;
import org.jasonxiao.demo.service.EmailService;
import org.jasonxiao.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;

/**
 * Created by Jason on 1/10/16.
 */
@RestController
public class UserRestController {

    private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;

    @RequestMapping(
            value = "/api/users",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<User>> getAllUsers() {
        Collection<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/user",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<User> createUser(
            @Valid @RequestBody User user,
            BindingResult bindingResult) {
        logger.info("create user...");

//        User savedUser = userService.create(user);
//         send confirmation email
//        Future<Boolean> result = emailService.sendAsyncWithResult(null);
//        try {
//            result.get();
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }

//        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        return new ResponseEntity<User>(HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/user/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        logger.info("get user...");

        User user = userService.findOne(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/user/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String updateUser(@PathVariable Long id, @RequestBody User user) throws UserNotFoundException {
        logger.info("update user...");

        User updatedUser;
        try {
            updatedUser = userService.update(id, user);
        } catch (UserNotFoundException e) {
            logger.error("User is not found", e);
            throw e;
        }

        return "OK";
    }

    @RequestMapping(
            value = "/api/user/{id}",
            method = RequestMethod.DELETE
    )
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        logger.info("delete user...");

        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
