package com.pedro.aopdemo;

import com.pedro.aopdemo.dao.AccountDAO;
import com.pedro.aopdemo.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		return runner -> {
			demoTheBeforeAdvice(accountDAO, membershipDAO);
		};
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
