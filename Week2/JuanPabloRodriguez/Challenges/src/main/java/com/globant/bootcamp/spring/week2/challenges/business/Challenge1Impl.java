package com.globant.bootcamp.spring.week2.challenges.business;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.globant.bootcamp.spring.week2.challenges.exception.DateNotGreaterException;

@Service
public class Challenge1Impl implements Challenge1Date {

	public boolean greaterDate(Date from_date, Date to_date) {
		if (from_date.before(to_date)) {
			return true;
		} throw new DateNotGreaterException();
	}

}
