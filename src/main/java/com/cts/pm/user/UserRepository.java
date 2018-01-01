package com.cts.pm.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends CrudRepository<User, Integer> {
   
	
//  String CUSTOM_QUERY = "SELECT NEW com.cts.pm.user.User(" +
//  "US.id,US.userName,US.emailId,US.language,US.firstName,US.lastName,RS.id,RS.name,US.isAdmin)" +
//  " FROM User US " +
//  "  WHERE US.userName=:userName";
//	
//	
//	@Query(CUSTOM_QUERY)
//	User findByUserName(@Param("userName") String userName);
	
	
	
    //isAdmin column added to the query
//    String CUSTOM_QUERY = "SELECT NEW com.cts.cde.io.onboarding.usermanagement.UserRole(" +
//            "US.id,US.userName,US.emailId,US.language,US.firstName,US.lastName,RS.id,RS.name,US.isAdmin)" +
//            " FROM User US INNER JOIN US.role RS " +
//            "  WHERE US.userName=:userName";
    
//    @Query(CUSTOM_QUERY)
//    UserRole getUserDetailsWithRole(@Param("userName") String userName);

	//Written custom query to update User and its associated ROLE->role id and other user information based on user id
	//6Dec2017
//       @Modifying
//    @Query("UPDATE User as US SET US.role.id = :userRoleId,US.firstName=:firstName,US.lastName=:lastName,US.userName=:userName,US.emailId=:emailId,US.language=:language,US.isAdmin=:isAdmin WHERE US.id= :userId")
//    void updateUser(@Param("userRoleId") int userRoleId, @Param("userId") int userId,@Param("firstName") String firstName,
//                    @Param("lastName") String lastName,@Param("userName") String userName,@Param("emailId") String emailId,@Param("language") String language,@Param("isAdmin") boolean isAdmin);
}
