package com.cg.wallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.wallet.entity.WalletTransaction;
@Repository
public interface WalletTransactionDao extends JpaRepository<WalletTransaction,Long>{
	
}
