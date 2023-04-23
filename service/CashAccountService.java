package service;

import java.math.BigDecimal;

import pojo.CashAccount;
import repository.TradeAccountRepository;

public class CashAccountService implements TradeAccountService{
    TradeAccountRepository tradeAccountRepository;

    public CashAccountService(TradeAccountRepository tradeAccountRepository){
        this.tradeAccountRepository = tradeAccountRepository;
    }

    public void createTradeAccount(CashAccount tradeAccount){
        this.tradeAccountRepository.createTradeAccount(tradeAccount);
    }

    public CashAccount retrieveTradeAccount(String id){
        return (CashAccount)this.tradeAccountRepository.retrieveTradeAccount(id);
    }

    public void updateTradeAccount(CashAccount tradeAccount){
        this.tradeAccountRepository.updateTradeAccount(tradeAccount);
    }

    public void deleteTradeAccount(String id){
        this.tradeAccountRepository.deleteTradeAccount(id);
    }

    @Override
    public void deposit(String id, BigDecimal amount) {
        CashAccount cashAccount = retrieveTradeAccount(id);
        cashAccount.setCashBalance(cashAccount.getCashBalance().add(amount));
        updateTradeAccount(cashAccount);
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        CashAccount cashAccount = retrieveTradeAccount(id);
        cashAccount.setCashBalance(cashAccount.getCashBalance().subtract(amount));
        updateTradeAccount(cashAccount);
    }


}
