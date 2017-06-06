package com.ja0ck5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ja0ck5.dao.EffectiveRecordDao;
import com.ja0ck5.model.EffectiveRecord;



/**
 * User service which uses primary data source.
 * 
 * @author Michael Liao
 */
@RestController
public class EffectiveController {

	@Autowired
	EffectiveRecordDao effectiveRecordDao;

	@GetMapping("/api/effective/{id}")
	public EffectiveRecord getUser(@PathVariable("id") long id) {
		return effectiveRecordDao.getById(id);
	}


}
