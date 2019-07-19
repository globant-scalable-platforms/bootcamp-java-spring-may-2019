/**
 * 
 */
package com.globant.bootcamp.spring.springcore.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globant.bootcamp.spring.springcore.data.CustomAccountRepository;
import com.globant.bootcamp.spring.springcore.domain.Account;

/**
 * @author brayanguerrero
 *
 */
@Service
public class InformationImpl implements Information{
	
	@Autowired
	private CustomAccountRepository customAccountRepository;
	
	public Account getInformation(String username) {
		return customAccountRepository.getInformation(username);
	}

}
