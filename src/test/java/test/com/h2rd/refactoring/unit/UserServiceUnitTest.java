package test.com.h2rd.refactoring.unit;

import com.h2rd.refactoring.service.UserService;
import com.h2rd.refactoring.usermanagement.User;

import junit.framework.Assert;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceUnitTest {


    @Test
    public void saveUserTest() {
    	UserService userService = new UserService( new HashMap<String, User>());
        String name ="Fake Name";
        String email ="fake@email.com";
        List<String> roles = Arrays.asList("admin", "master");
        userService.saveUser(name, email, roles);

        Assert.assertEquals(1,  userService.getUsers().size());
        User user = userService.getUsers().get(0);
        Assert.assertEquals(name,  user.getName());
        Assert.assertEquals(email,  user.getEmail());
        Assert.assertEquals(roles,  user.getRoles());
    }

    @Test
    public void deleteUserTest() {
        User user = new User();
        user.setName("Fake Name");
        user.setEmail("fake@email.com");
        user.setRoles(Arrays.asList("admin", "master"));

        Map<String, User> userMap = new HashMap<String, User>();
        userMap.put("fake@email.com", user);

    	UserService userService = new UserService( userMap);
        userService.deleteUser("fake123@email.com");
        
        Assert.assertEquals(1,  userService.getUsers().size());
        
        userService.deleteUser("fake@email.com");
        Assert.assertEquals(0,  userService.getUsers().size());
    }
}