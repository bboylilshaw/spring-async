package org.jasonxiao.demo.controller;

import org.jasonxiao.demo.exception.user.UserAlreadyExistException;
import org.jasonxiao.demo.exception.user.UserNotFoundException;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Jason Xiao
 */
@RestController
@RequestMapping("/api")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;
    private final EmailService emailService;

    @Autowired
    public UserController(EmailService emailService, UserService userService) {
        this.emailService = emailService;
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() throws Exception{
        logger.info("Get all users");
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@Valid @RequestBody User user, BindingResult bindingResult) throws UserAlreadyExistException {
        logger.info("Create user...");

        User savedUser = userService.create(user);
//         send confirmation email
//        Future<Boolean> result = emailService.sendAsyncWithResult(null);
//        try {
//            result.get();
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }

//        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        return ResponseEntity.ok(savedUser);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("userId") Long userId) throws UserNotFoundException {
        logger.info("Get user...");
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@PathVariable("userId") Long userId, @RequestBody User user, BindingResult bindingResult) throws UserNotFoundException {
        logger.info("Update user...");

        User updatedUser = userService.update(userId, user);

        return ResponseEntity.ok(updatedUser);
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("userId") Long userId) throws UserNotFoundException {
        logger.info("delete user...");

        userService.delete(userId);
    }

}
