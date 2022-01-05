package com.transactional.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionalForm {
	private String debiterName;
	private double debitAmount;
	private String crediterName;
}
