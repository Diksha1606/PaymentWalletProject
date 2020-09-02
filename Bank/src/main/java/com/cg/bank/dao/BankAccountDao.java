package com.cg.bank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.bank.entity.BankAccount;

@Repository
public interface BankAccountDao extends JpaRepository<BankAccount, String> {
	@Query("from BankAccount where accountId = :aid and pin = :apin and bankName = :bname")
	public BankAccount  getAccount(@Param("aid")String accountId,@Param("apin") String pin,@Param("bname") String bankName);
	
}
