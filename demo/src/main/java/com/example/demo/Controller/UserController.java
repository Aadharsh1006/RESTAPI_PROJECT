package com.example.demo.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.UserService;
import com.example.demo.model.History;
import com.example.demo.model.RechargePlan;
import com.example.demo.model.User;

@RestController
public class UserController {
    @Autowired
    UserService UService;

    @PostMapping("/POST/users") 
    public User postHistory(@RequestBody User u)
    {
        return UService.createUser(u);
    }

    @GetMapping("/GET/users/{id}")
    public User getUserById(@PathVariable long id)
    {
        return UService.getUserById(id);
    }

    @GetMapping("/GET/users")
    public List<User> getUser()
    {
        return UService.getAllUsers();
    }

    @PutMapping("/PUT/users/{id}")
    public User updateUser(@PathVariable long id,@RequestBody User u )
    {
        return UService.updateUser(id,u);
    }

    @DeleteMapping("/DELETE/users/{id}")
    public boolean deleteUser(@PathVariable long id)
    {
        return UService.deleteUser(id);
    }

    @GetMapping("/GET/users/paginate")
    public Page<User> getpages(@RequestParam int page,int size,String sortby,String sortOrder)
    {
        return UService.getpages(page,size,sortby,sortOrder);
    }
    
    @GetMapping("/GET/users/email")
    public User findByEmail(@RequestParam String email) {
        return UService.findByEmail(email);
    }

    @GetMapping("/GET/usersByaddress")
    public List<User> findByAddress(@RequestParam String address) {
        return UService.findByAddress(address);
    }

    @GetMapping("/GET/historybyuser/{id}")
    public List<History> gethistorybyuserid(@PathVariable long id) {
        return UService.gethistorybtyuserid(id);
    }
    
    @GetMapping("/GET/rechargeplanbyuser/{id}")
    public Set<RechargePlan> getRechargePlanbyuserid (@PathVariable long id) {
        return UService.getrechargeplanbyuserid(id);
    }

    // @PostMapping("/{userId}/recharge/{planId}")
    // public User addRechargePlanToUser(@PathVariable long userId, @PathVariable long planId) {
    //     return UService.addRechargePlanToUser(userId, planId);
    // }
}
