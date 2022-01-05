package com.transactional.form;

import java.io.FileInputStream;

import java.io.ObjectInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeDeserialize {
	private static final Logger log = LoggerFactory.getLogger(EmployeeSerialize.class);

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("D:\\Testing\\Employee.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		EmployeeTest emp = (EmployeeTest) ois.readObject();
		log.info("After Deserilizing the file --->" + "\n" + "EmployeeUserName = " + emp.getEmployeeUserName() + "\n"
				+ "EmployeePassword = " + emp.getEmployeePassword() + "\n" + "EmployeeDept = " + emp.getEmployeeDept()
				+ "\n" + "EmployeeId = " + emp.getEmployeeId());
	}

}
