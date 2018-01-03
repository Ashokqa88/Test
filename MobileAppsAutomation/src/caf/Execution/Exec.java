package caf.Execution;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import caf.FrameworkLibrary.DataConfig;
import caf.FrameworkLibrary.Reporting.MailReporting;

public class Exec  {
DataConfig dc = new DataConfig(); 
	MailReporting mail = new MailReporting();

	@BeforeTest
	public void executeBefore() throws IOException {

		System.out.println("Executing");
		dc.updateTestSuiteProperties();
	}

	@Test
	public void execute() throws IOException {

		dc.suitesExecution();

	}

	@AfterTest
	public void sendMail() throws Exception {
		//mail.htmlMail();
	}

}
