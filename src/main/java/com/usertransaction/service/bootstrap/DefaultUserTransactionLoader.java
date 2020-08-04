package com.usertransaction.service.bootstrap;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.usertransaction.service.domain.Transaction;
import com.usertransaction.service.domain.TransactionType;
import com.usertransaction.service.domain.User;
import com.usertransaction.service.repositories.UserTransactionRepository;

@Component
public class DefaultUserTransactionLoader implements CommandLineRunner {

    private final UserTransactionRepository userTransactionRepository;
   
    public DefaultUserTransactionLoader(UserTransactionRepository userTransactionRepository
                                ) {
        this.userTransactionRepository = userTransactionRepository;
        
    }

    @Override
    public void run(String... args) throws Exception {
        
    	loadUserTransactionData();
    }

   

    private void loadUserTransactionData() {
        if (userTransactionRepository.count() == 0){
        	
        	Transaction transaction1 = Transaction.builder()
        			      .transactionType(TransactionType.BILLING)
        			      .build();
        	Transaction transaction2 = Transaction.builder()
  			      .transactionType(TransactionType.INVOICING)
  			      .build();
        	Transaction transaction3 = Transaction.builder()
    			      .transactionType(TransactionType.SUBSCRIPTION)
    			      .build();
        	
        	List<Transaction> transactionList = new ArrayList<>();
        	transactionList.add(transaction1);
        	transactionList.add(transaction2);
        	transactionList.add(transaction3);
        	
            User joeTransaction =User.builder()
            		         .email("Joe.Dowell@test.com")
            		         .firstName("Joe")
            		         .lastName("Dowell")
            		         .transaction(transactionList)
            		         .build();
            transaction1.setUser(joeTransaction);
            transaction2.setUser(joeTransaction);
            transaction3.setUser(joeTransaction);

            userTransactionRepository.save(joeTransaction);

           

        }
    }
}