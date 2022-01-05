package com.transactional.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.transactional.customException.TransactionalExceptionHandler;
import com.transactional.form.TransactionalForm;
import com.transactional.service.SbiService;

@RestController
public class TransactionalController {

	private static final Logger log = LoggerFactory.getLogger(TransactionalController.class);

	@Autowired
	private SbiService sbiService;

	@PostMapping("/transaction")
	public ResponseEntity<?> doTransaction(@RequestBody TransactionalForm transactionalForm) {
		try {
			sbiService.doTransaction(transactionalForm);
		} catch (NullPointerException e) {
			return new ResponseEntity<TransactionalExceptionHandler>(new TransactionalExceptionHandler(1001,
					"Transaction Failed!!!", "Sorry for the inconvience. Please try again after some time"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(
				"Amount Credited Successfully to the " + transactionalForm.getCrediterName() + " Account.",
				HttpStatus.CREATED);
	}
}
