package com.hfmodel.controller;

import com.hfmodel.bean.Account;
import com.hfmodel.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 跳转用户界面
     * @return
     */
    @RequestMapping("toAddAccount")
    public String toAddAccount(){
        return "assAccount";
    }

    /**
     * 添加用户并重定向
     * @param model
     * @param account
     * @return
     */
    @RequestMapping("addAcconnt")
    public String addAccount(Model model, Account account){
        if (account != null){
            accountService.saveAccount(account);
        }
        return "redirect:/user/getAllUser";
    }

    /**
     * 查询全部用户
     * @param model
     * @return
     */
    @RequestMapping("getAllAccount")
    public String getAllUser(Model model){
        List<Account> user = accountService.findAll();
        model.addAttribute("userList",user);
        return "allUser";
    }


    /**
     * 删除用户
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("delAccount")
    public String removeUser(Model model,Integer id){
        model.addAttribute("account",accountService.deleteAccount(id));
        //userService.deleteUser(id);
        return "redirect:/account/getAllAccount";
    }


    /**
     * 跳转到更新用户页面
     */
    @RequestMapping("toUpdate")
    public String toUpdate(@RequestParam(value = "id")Integer id, Model model){
        model.addAttribute("user",accountService.findAccountById(id));
        return "updateUser";
    }

    /**
     * 更新用户
     * @param
     * @return
     */
    @RequestMapping(value = "updateUser",method = RequestMethod.POST)
    public String updateUser(Account account){
        accountService.updateAccount(account);
        return "redirect:/account/getAllAccount";
    }
}
