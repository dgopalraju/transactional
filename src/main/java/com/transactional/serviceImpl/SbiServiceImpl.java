package com.transactional.serviceImpl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transactional.controller.TransactionalController;
import com.transactional.customException.TransactionalExceptionHandler;
import com.transactional.form.TransactionalForm;
import com.transactional.model.Icici;
import com.transactional.model.Sbi;
import com.transactional.repositary.IciciRepositary;
import com.transactional.repositary.SbiRepositary;
import com.transactional.service.SbiService;

@Service
public class SbiServiceImpl implements SbiService {

	private static final Logger log = LoggerFactory.getLogger(SbiServiceImpl.class);

	@Autowired
	private SbiRepositary sbiRepositary;

	@Autowired
	private IciciRepositary iciciRepositary;

	@Override
	@Transactional
	public void doTransaction(TransactionalForm transactionalForm) {

		Sbi sbi = new Sbi();
		sbi.setDebiterName(transactionalForm.getDebiterName());
		sbi.setDebitAmount(transactionalForm.getDebitAmount());
		sbi = sbiRepositary.save(sbi);

		Icici icici = null;
		log.info("ICICI--->>>>", icici.toString());
		icici.setId(sbi.getId());
		icici.setCrediterName(transactionalForm.getCrediterName());
		icici.setCreditAmount(sbi.getDebitAmount());
		iciciRepositary.save(icici);
	}

}
