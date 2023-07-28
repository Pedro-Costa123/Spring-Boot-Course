package com.pedro.aopdemo;

import com.pedro.aopdemo.dao.AccountDAO;
import com.pedro.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
//			demoTheBeforeAdvice(accountDAO, membershipDAO);
//			demoTheAfterReturningAdvice(accountDAO);
			demoTheAfterThrowingAdvice(accountDAO);
		};
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;
		try {
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception exc) {
			System.out.println("Main Program: caught exception: " + exc);
		}
		System.out.println("Main Program: demoTheAfterThrowingAdvice");
		System.out.println(accounts);
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO) {
		List<Account> accounts = accountDAO.findAccounts();
		System.out.println("Main Program: demoTheAfterReturningAdvice");
		System.out.println(accounts);
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		//call the business method
		Account account = new Account();
		account.setName("Name");
		account.setLevel("Level");
		accountDAO.addAccount(account, true);
		accountDAO.doWork();

		//call the accountdao getter/setter
		accountDAO.setName("Name");
		accountDAO.setServiceCode("ServiceCode");

		String name = accountDAO.getName();
		String code = accountDAO.getServiceCode();

		//call the membership business method
		membershipDAO.addAccount();
		membershipDAO.goToSleep();
	}

}
