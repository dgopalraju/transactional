package com.transactional.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transactional.form.TransactionalForm;
import com.transactional.model.Icici;
import com.transactional.model.Sbi;
import com.transactional.repositary.IciciRepositary;
import com.transactional.service.IciciService;

@Service
public class IciciServiceImpl implements IciciService {

	private static final Logger log = LoggerFactory.getLogger(IciciServiceImpl.class);

	@Autowired
	private IciciRepositary iciciRepositary;

	@Override
	//@Transactional(propagation = Propagation.REQUIRED)
	//@Transactional(propagation = Propagation.SUPPORTS)
	//@Transactional(propagation = Propagation.MANDATORY)
	//@Transactional(propagation = Propagation.REQUIRES_NEW)
	//@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@Transactional(isolation = Isolation.SERIALIZABLE)
	public void doTransaction(Sbi sbi, TransactionalForm transactionalForm) {	
		Icici icici = new Icici();
		log.info("ICICI--->>>>", icici.toString());
		icici.setId(sbi.getId());
		icici.setCrediterName(transactionalForm.getCrediterName());
		icici.setCreditAmount(sbi.getDebitAmount());
		iciciRepositary.save(icici);
	}
}
