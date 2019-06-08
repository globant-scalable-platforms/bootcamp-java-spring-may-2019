package com.globant.bootcamp.spring.springcore.data;

import java.util.HashMap;
import java.util.Map;

public class DataSource {

	private static Map<String, String> users= new HashMap<String, String>();

	public DataSource() {	
		users.put("Amy","Paper");
		users.put("Howard","Stone");
		users.put("Leonard","Scissors");
		users.put("Penny","Lizard");
		users.put("Sheldon","Spock");
	}
	
	public String getOneDataSource(String index){
		return users.get(index);
	}
	
	public Map<String, String> getDataSource(){
		return users;
	}

	public void setAccount(String username, String userpassword) {
		users.put(username, userpassword);	
	}
	
}
