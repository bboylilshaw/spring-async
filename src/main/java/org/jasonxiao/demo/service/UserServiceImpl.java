package org.jasonxiao.demo.service;

import org.jasonxiao.demo.exception.user.UserAlreadyExistException;
import org.jasonxiao.demo.exception.user.UserNotFoundException;
import org.jasonxiao.demo.model.User;
import org.jasonxiao.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

/**
 * Created by Jason on 1/10/16.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Cacheable(value = "all_users")
    public List<User> getAllUsers() {
        logger.info("Start to fetch users from repository");
//        throw new Exception("Some Error");
        return userRepository.findAll();
    }

    @Override
    @Cacheable(value = "user")
    public User getUser(Long id) {
        logger.info("Start to fetch user with id: {}", id);
        return userRepository.findOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public User create(User user) throws UserAlreadyExistException {
        logger.info("Start to create user {}", user.toString());
        return userRepository.save(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @CachePut(value = "user", key = "#id")
    public User update(Long id, User user) throws UserNotFoundException {
        Assert.notNull(id, "id cannot be null");
        Assert.notNull(user, "user cannot be null");

        User toBeUpdated = userRepository.findOne(id);
        if (toBeUpdated == null) throw new UserNotFoundException();

        BeanUtils.copyProperties(user, toBeUpdated, "id");

        if (id == 2) throw new RuntimeException("SOME ERROR!!!");
        return userRepository.save(toBeUpdated);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @CacheEvict("user")
    public void delete(Long id) {
        userRepository.delete(id);
    }

    @Override
    @CacheEvict(cacheNames = {"all_users", "user"}, allEntries = true)
    public void evictCache() {
        logger.info("Evicted all cache!");
    }
}
