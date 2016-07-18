package org.jasonxiao.demo.service;

import org.jasonxiao.demo.exception.user.UserAlreadyExistException;
import org.jasonxiao.demo.exception.user.UserNotFoundException;
import org.jasonxiao.demo.model.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by Jason on 1/10/16.
 */
public interface UserService {

    List<User> getAllUsers() throws Exception;

    User getUser(Long id);

    User create(User user) throws UserAlreadyExistException;

    User update(Long id, User user) throws UserNotFoundException;

    void delete(Long id) throws UserNotFoundException;

    void evictCache();

}
