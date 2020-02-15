package test.com.h2rd.refactoring.integration;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.http.ResponseEntity;

import com.h2rd.refactoring.usermanagement.User;
import com.h2rd.refactoring.web.UserController;

import junit.framework.Assert;

public class UserIntegrationTest {
	
	//@Test
	public void createUserTest() {
		UserController userController = new UserController();
		
		User integration = new User();
        integration.setName("integration");
        integration.setEmail("integration@integration.com");
        integration.setRoles(new ArrayList<String>());
        
        ResponseEntity<User> response = userController.saveUser(integration.getName(), integration.getEmail(), integration.getRoles());
        Assert.assertEquals(200, response.getStatusCodeValue());
        Assert.assertEquals(integration.getEmail(), response.getBody().getEmail());
        Assert.assertEquals(integration.getName(), response.getBody().getName());
        Assert.assertEquals(integration.getRoles(), response.getBody().getRoles());
	}

	//@Test
	public void updateUserTest() {
		UserController userResource = new UserController();
		
		createUserTest();
        
        User updated = new User();
        updated.setName("updatedName");
        updated.setEmail("integration@integration.com");
        updated.setRoles(new ArrayList<String>());
        
        ResponseEntity<User> response = userResource.saveUser(updated.getName(), updated.getEmail(), updated.getRoles());
        Assert.assertEquals(200, response.getStatusCodeValue());
        Assert.assertEquals(updated.getEmail(), response.getBody().getEmail());
        Assert.assertEquals(updated.getName(), response.getBody().getName());
	}
}