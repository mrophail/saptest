package com.h2rd.refactoring.usermanagement;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import lombok.Data;

import java.util.List;

@SuppressWarnings("restriction")
@XmlRootElement(name = "user")
@Data
public class User {

	private String name;
	private String email;
	
	@XmlElement(required=true)
	private List<String> roles;
}