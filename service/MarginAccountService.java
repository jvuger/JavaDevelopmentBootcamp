package service;

import java.math.BigDecimal;

import pojo.MarginAccount;
import repository.TradeAccountRepository;

public class MarginAccountService implements TradeAccountService{

    TradeAccountRepository tradeAccountRepository;

    public MarginAccountService(TradeAccountRepository tradeAccountRepository){
        this.tradeAccountRepository = tradeAccountRepository;
    }

    public void createTradeAccount(MarginAccount tradeAccount){
        this.tradeAccountRepository.createTradeAccount(tradeAccount);
    }

    public MarginAccount retrieveTradeAccount(String id){
        return (MarginAccount)this.tradeAccountRepository.retrieveTradeAccount(id);
    }

    public void updateTradeAccount(MarginAccount tradeAccount){
        this.tradeAccountRepository.updateTradeAccount(tradeAccount);
    }

    public void deleteTradeAccount(String id){
        this.tradeAccountRepository.deleteTradeAccount(id);
    }

    @Override
    public void deposit(String id, BigDecimal amount) {
        MarginAccount marginAccount = retrieveTradeAccount(id);
        marginAccount.setMargin(marginAccount.getMargin().add(amount));
        updateTradeAccount(marginAccount);
    }

    @Override
    public void withdraw(String id, BigDecimal amount) {
        MarginAccount marginAccount = retrieveTradeAccount(id);
        marginAccount.setMargin(marginAccount.getMargin().subtract(amount));
        updateTradeAccount(marginAccount);
    }
}