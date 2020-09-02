package com.cg.wallet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.wallet.entity.WalletBank;

@Repository
public interface WalletBankDao extends JpaRepository<WalletBank, String>  {

}
