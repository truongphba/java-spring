package truongph.java_spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import truongph.java_spring.entity.Account;
import truongph.java_spring.entity.Student;
import truongph.java_spring.repository.AccountRepository;
import truongph.java_spring.repository.StudentJpaRepository;


@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Account saveAccount(@RequestBody Account account) {
        return accountRepository.save(account);
    }
}
