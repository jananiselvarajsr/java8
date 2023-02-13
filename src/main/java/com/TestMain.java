package com;

import java.util.function.Function;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.model.Account;

public class TestMain {
	public static void main(String[] args) {
		List<Account> firstList =List.of(
				new Account(1,"saving",null),
				new Account(2,"current",null),
				new Account(3,"salary",null),
				new Account(4,"joint",null));
		
		List<Account> secondList =List.of(
				new Account(1,null,"aaa"),
				new Account(2,null,"bbb"),
				new Account(3,null,"ccc"),
				new Account(5,null,"ddd"));
		
	
		LambdaAccount acc=(a,b)->{ return a!=null? a:b;};
		
		List<Account> mergedList=Stream
				.concat(firstList.stream(), secondList.stream())
				.collect(Collectors.toMap(Account::getAccountID, Function.identity(),
						(first,second)->{
							 first.setAccountType(acc.findNonNull(first.getAccountType(), second.getAccountType()));
							 first.setCustomerName(acc.findNonNull(first.getCustomerName(),second.getCustomerName()));
							return first;
						})).values().stream().collect(Collectors.toList());
		
		mergedList.forEach(System.out::println);
		
		/*
		//Sample Response
		 
		Account [accountID=1, accountType=saving, customerName=aaa]
		Account [accountID=2, accountType=current, customerName=bbb]
		Account [accountID=3, accountType=salary, customerName=ccc]
		Account [accountID=4, accountType=joint, customerName=null]
		Account [accountID=5, accountType=null, customerName=ddd]	

		 */


	}
	
	public interface LambdaAccount{
			String findNonNull(String first,String Second);
	}
	
	
}

