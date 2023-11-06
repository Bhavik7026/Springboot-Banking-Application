package com.example.Springboot.Banking.Application.Controller;

import com.example.Springboot.Banking.Application.Model.Account;
import com.example.Springboot.Banking.Application.Model.Dto.TransferDto;
import com.example.Springboot.Banking.Application.Model.Dto.WithdrawDto;
import com.example.Springboot.Banking.Application.Services.Accountservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class Accountcontroller {

    @Autowired
    private Accountservices accountservices;

    @PostMapping("/openaccount")
    private Account addacount(@RequestBody Account a){
        return accountservices.addacount(a);
    }

    @GetMapping("/GetAll")
    private List<Account> getall(){
        return accountservices.getall();
    }

    @PutMapping("/withdraw")
    private WithdrawDto withdraw(@RequestParam String accountNumber , @RequestParam Double balance){

        return accountservices.withdraw(accountNumber , balance);
    }

    @PutMapping("/deposit")
    private Double deposit(@RequestParam String accountNumber , @RequestParam Double balance){
        return accountservices.deposit(accountNumber , balance);
    }

    @PutMapping("/transfer")
    private TransferDto transfer(@RequestParam String sender , @RequestParam Double balance, @RequestParam String receiver){
        return accountservices.transfer(sender,balance,receiver);
    }

    @DeleteMapping("/delete")
    private String delete(@RequestParam Long id){
        accountservices.delete(id);
        return "delete";
    }
}
