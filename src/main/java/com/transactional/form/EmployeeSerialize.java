package com.transactional.form;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
class EmployeeTest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String employeeUserName;
	private transient String employeePassword;
	private String employeeDept;
	private transient int employeeId;
}

class EmployeeSerialize {
	private static final Logger log = LoggerFactory.getLogger(EmployeeSerialize.class);

	public static void main(String[] args) throws Exception {
		EmployeeTest emp = new EmployeeTest("gopal@evoke.com", "gopi123$", "Java",1234);
		FileOutputStream fos = new FileOutputStream("D:\\Testing\\Employee.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(emp);
		log.info("Successfully created the file");
	}
}