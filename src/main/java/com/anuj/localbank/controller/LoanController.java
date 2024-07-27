package com.anuj.localbank.controller;

import com.anuj.localbank.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;

    @GetMapping("/myLoans")
    public String myLoans() {
        return "my loans";
    }
}
