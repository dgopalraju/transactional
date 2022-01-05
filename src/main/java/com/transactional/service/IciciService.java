package com.transactional.service;

import com.transactional.form.TransactionalForm;
import com.transactional.model.Sbi;

public interface IciciService {

	void doTransaction(Sbi sbi, TransactionalForm transactionalForm);

}
