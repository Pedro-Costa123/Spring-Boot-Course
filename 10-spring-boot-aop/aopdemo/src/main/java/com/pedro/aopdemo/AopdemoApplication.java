package com.pedro.aopdemo;

import com.pedro.aopdemo.dao.AccountDAO;
import com.pedro.aopdemo.dao.MembershipDAO;
import com.pedro.aopdemo.service.TrafficFortuneService;
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
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO, TrafficFortuneService trafficFortuneService) {
		return runner -> {
//			demoTheBeforeAdvice(accountDAO, membershipDAO);
//			demoTheAfterReturningAdvice(accountDAO);
//			demoTheAfterThrowingAdvice(accountDAO);
//			demoTheAfterAdvice(accountDAO);
//			demoTheAroundAdvice(trafficFortuneService);
//			demoTheAroundAdviceHandleException(trafficFortuneService);
			demoTheAroundAdviceRethrowException(trafficFortuneService);
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService trafficFortuneService) {
		System.out.println("Main Program: demoTheAroundAdviceRethrowException");
		System.out.println("Calling getFortune() ");
		boolean tripWire = true;
		String data= trafficFortuneService.getFortune(tripWire);
		System.out.println("Data: " + data);
		System.out.println("Finished");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("Main Program: demoTheAroundAdviceHandleException");
		System.out.println("Calling getFortune() ");
		boolean tripWire = true;
		String data= trafficFortuneService.getFortune(tripWire);
		System.out.println("Data: " + data);
		System.out.println("Finished");
	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("Main Program: demoTheAroundDevice");
		System.out.println("Calling getFortune() ");
		String data= trafficFortuneService.getFortune();
		System.out.println("Data: " + data);
		System.out.println("Finished");
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO) {
		List<Account> accounts = null;
		try {
//			boolean tripWire = true;
			boolean tripWire = false;
			accounts = accountDAO.findAccounts(tripWire);
		} catch (Exception exc) {
			System.out.println("Main Program: caught exception: " + exc);
		}
		System.out.println("Main Program: demoTheAfterThrowingAdvice");
		System.out.println(accounts);
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
