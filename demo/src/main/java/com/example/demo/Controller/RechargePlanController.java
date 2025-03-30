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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.RechargePlanService;
import com.example.demo.model.RechargePlan;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class RechargePlanController {
    @Autowired
    RechargePlanService rpService;

    @PostMapping("/POST/RechargePlan")
    public RechargePlan postRechargePlan(@RequestBody RechargePlan rp,@RequestParam long id)
    {
        return rpService.create(rp,id);
    }

    @GetMapping("/GET/RechargePlan/{id}")
    public RechargePlan getHistories(@PathVariable int Id)
    {
        return rpService.findById(Id);
    }

    @GetMapping("/GET/RechargePlan")
    public List<RechargePlan> getRechargePlan()
    {
        return rpService.findAll();
    }

    @PutMapping("/PUT/RechargePlan/{id}")
    public RechargePlan updateRechargePlan(@PathVariable int Id,@RequestBody RechargePlan rp)
    {
        return rpService.update(Id,rp);
    }

    @DeleteMapping("/DELETE/RechargePlan/{id}")
    public String deleteRechargePlan(@PathVariable int Id)
    {
        return rpService.delete(Id);
    }

    @GetMapping("/GET/paginate/RechargePlan")
    public Page<RechargePlan> getPage(@RequestParam int page,int size) {
        return rpService.getpages(page, size);
    }

    @GetMapping("/GET/sort/RechargePlan")
    public List<RechargePlan> sortPlans(@RequestParam String planName)
    {
        return rpService.sortplans(planName);
    }


    @GetMapping("/GET/RechargePlanByplanName")
    public RechargePlan findByPlanname(@RequestParam String planName) {
        return rpService.findByPlan(planName);
    }
    
    @GetMapping("/GET/RechargePlanByDuration")
    public List<RechargePlan> findByDuration(@RequestParam int planDuration) {
        return rpService.findByplanDuration(planDuration);
    }

    @GetMapping("/GET/RechargePlanByUserId")
    public Set<RechargePlan>findRechargePlanByUserId(@RequestParam long userId)
    {
        return rpService.findrechargeplanbyuserid(userId);
    }

    // @GetMapping("/{planId}/users")
    // public List<User> getUsersByPlanId(@PathVariable long planId) {
    //     return rpService.getUsersByPlanId(planId);
    // }

    // @PostMapping("/{planId}/user/{userId}")
    // public RechargePlan addUserToPlan(@PathVariable long planId, @PathVariable long userId) {
    //     return rpService.addUserToPlan(planId, userId);
    // }
}

