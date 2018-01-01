package com.cts.pm.user;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pm.project.Project;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;


@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;
    
    private Logger logger = LoggerFactory.getLogger(UserService.class);

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getUserList() {
    	logger.info("===== In getUserList =======");
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        logger.info("===== out getUserList =======");
        return users;

    }
    
    public User getUserById(Integer id) {
    	logger.info("===== In getUserById =======");
        return userRepository.findOne(id);
    }

//    public User getUserByUserName(String userName) {
//
//        return userRepository.findByUserName(userName);
//    }
    
//    public UserRole getUserByUserNamewithRole(String userName) {
//        return userRepository.getUserDetailsWithRole(userName);
//    }

    public User createUser(User user) {
    	logger.info("===== In createUser =======");
        return userRepository.save(user);
    }

    public User updateUser(User user, Integer user_id) {
    	logger.info("===== In udpateUser =======");
        User toBeUpdUser = userRepository.findOne(user_id);
        System.out.println("Updating user");
        if(toBeUpdUser != null)
        {
            toBeUpdUser.setId(user_id);
            toBeUpdUser.setFirstName(user.getFirstName());
            toBeUpdUser.setLastName(user.getLastName());
       
        }
        logger.info("===== exit udpateUser =======");
      return userRepository.save(toBeUpdUser);
    }

	// Added this method to handle UPDATE user ,role and other information
	// 6Dec2017
//    @Transactional	
//     public void updateUser(User user, Integer user_id) {
//      //userRepository.updateUser(user.getRole().getId(),user_id,user.getFirstName(),user.getLastName(),user.getUserName(),user.getEmailId(),user.getLanguage(),user.getAdmin());
//    }

//    public User authenticateUser(String userName, String password) {
//        User users = userRepository.findByUserName(userName);
//        if (users != null && checkPassword(password, users))
//            return users;
//        return null;
//    }

//    private String getEncodedPassword(String password) {
//        return bCryptPasswordEncoder.encode(password);
//    }
//
//    private boolean checkPassword(String password, User users) {
//        return bCryptPasswordEncoder.matches(password, users.getPassword());
//    }

	public void deleteUser(Integer id) {
		logger.info("===== In deleteUser =======");
		 userRepository.delete(id);
	}


}
