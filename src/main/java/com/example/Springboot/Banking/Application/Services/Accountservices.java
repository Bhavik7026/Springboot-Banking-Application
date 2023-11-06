package com.example.Springboot.Banking.Application.Services;

import com.example.Springboot.Banking.Application.Model.Account;
import com.example.Springboot.Banking.Application.Model.Dto.TransferDto;
import com.example.Springboot.Banking.Application.Model.Dto.WithdrawDto;
import com.example.Springboot.Banking.Application.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class Accountservices {

    @Autowired
    private AccountRepository accountRepository;

    public Account addacount(Account a) {
        return accountRepository.save(a);
    }

    public List<Account> getall() {
        return accountRepository.findAll();
    }

    public WithdrawDto withdraw(String accountNumber, Double balance) {
        Account a = accountRepository.findByAccountNumber(accountNumber);

        WithdrawDto wd = new WithdrawDto();

        double current_balance=a.getBalance();
        if(current_balance < balance){
            wd.setCurrent_balance(current_balance);
            wd.setWithdraw(balance);
            wd.setAfter_withdraw(0.0);
            wd.setStatus("Balance is less than withdraw balanace : \"NOT TRANSFER\" ");
            return wd;
        }
        double after_withdraw = current_balance-balance;
        a.setBalance(after_withdraw);
        accountRepository.save(a);

        wd.setCurrent_balance(current_balance);
        wd.setWithdraw(balance);
        wd.setAfter_withdraw(after_withdraw);
        wd.setStatus(" \"TRANSFER SUCCESS\" ");
        return wd;
    }

    public Double deposit(String accountNumber, Double balance) {
        Account a = accountRepository.findByAccountNumber(accountNumber);
        double current_balance = a.getBalance();
        double after_deposit = current_balance + balance;
        a.setBalance(after_deposit);
        accountRepository.save(a);
        return after_deposit;
    }

    public TransferDto transfer(String sender, Double balance, String receiver) {
        Account s=accountRepository.findByAccountNumber(sender);
        Account r=accountRepository.findByAccountNumber(receiver);

        TransferDto td = new TransferDto();


        Double s_balnce = s.getBalance();
        Double r_balnce = r.getBalance();

        if(s_balnce < balance){
          td.setSendernum(s.getAccountNumber());
          td.setSenderbalance(s_balnce);
          td.setAftersend(s_balnce);
          td.setRecenum(r.getAccountNumber());
          td.setRecebalance(r_balnce);
          td.setAfterrece(r_balnce);

          td.setStatus("unsuccessful Transfer !");
          return td;
        }

        s.setBalance(s_balnce-balance);
        r.setBalance(r_balnce+balance);

        accountRepository.save(s);
        accountRepository.save(r);


        td.setSendernum(s.getAccountNumber());
        td.setSenderbalance(s_balnce);
        td.setAftersend(s_balnce - balance);
        td.setRecenum(r.getAccountNumber());
        td.setRecebalance(r_balnce);
        td.setAfterrece(r_balnce + balance);

        td.setStatus("Successful Transfer !");
        return td;

    }

    public void delete(Long id) {
        accountRepository.deleteById(id);
    }
}
