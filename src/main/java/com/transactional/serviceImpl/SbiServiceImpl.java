package com.transactional.serviceImpl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transactional.form.TransactionalForm;
import com.transactional.model.Sbi;
import com.transactional.repositary.SbiRepositary;
import com.transactional.service.IciciService;
import com.transactional.service.SbiService;

@Service
@Transactional(rollbackFor  = Exception.class)
public class SbiServiceImpl implements SbiService {

	@Autowired
	private SbiRepositary sbiRepositary;

	@Autowired
	private IciciService iciciService;

	@Override
	@Transactional
	public void doTransaction(TransactionalForm transactionalForm) {
		Sbi sbi = new Sbi();
		sbi.setDebiterName(transactionalForm.getDebiterName());
		sbi.setDebitAmount(transactionalForm.getDebitAmount());
		sbi = sbiRepositary.save(sbi);
		iciciService.doTransaction(sbi, transactionalForm);

	}
}
