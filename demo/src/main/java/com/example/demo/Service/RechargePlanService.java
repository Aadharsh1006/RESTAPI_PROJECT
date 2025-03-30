package com.example.demo.Service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.RechargePlan;
import com.example.demo.model.User;
import com.example.demo.repositories.RechargePlanRepository;
import com.example.demo.repositories.UserRepository;

@Service
public class RechargePlanService {
    @Autowired
    RechargePlanRepository RpRepo;

    @Autowired
    UserRepository URepo;

    public RechargePlan create(RechargePlan rp,long id)
    {
        User user=URepo.findById(id).orElse(null);
        rp.setUser(user);
        return RpRepo.save(rp);
    }

    public RechargePlan findById(long Id)
    {
        return RpRepo.findById(Id).orElse(null);

    }

    public List<RechargePlan> findAll()
    {
        return RpRepo.findAll();
    }

    public RechargePlan update(long Id,RechargePlan rp)
    {
        rp.setId(Id);
        return RpRepo.save(rp);
    }

    public Page<RechargePlan> getpages(int page,int size)
    {
        Pageable pageable=PageRequest.of(page, size);
        return RpRepo.findAll(pageable);
    } 

    public String  delete(long Id)
    {
         RpRepo.deleteById(Id);
         return "Success";
    }

    public List<RechargePlan> sortplans(String sortby)
    {
        return RpRepo.findAll(Sort.by(Sort.Direction.ASC, (sortby)));
    }

    public RechargePlan findByPlan(String planName)
    {
        return RpRepo.findByPlanName(planName);
    }

    public List<RechargePlan> findByplanDuration(int planDuration)
    {
        return RpRepo.findByDuration(planDuration);
    }

    public Set<RechargePlan> findrechargeplanbyuserid(long userid)
    {
        return RpRepo.findRechargePlanByUserId(userid);
    }

//     // Get all users subscribed to a given RechargePlan
//     public List<User> getUsersByPlanId(long planId) {
//     RechargePlan plan = RpRepo.findById(planId).orElse(null);
//     return new ArrayList<>(plan.getUser()); // Ensuring immutability safety
// }

//     // Associate a RechargePlan with a User (alternative way)
//     public RechargePlan addUserToPlan(long planId, long userId) {
//         User user = URepo.findById(userId).orElse(null);
//         RechargePlan plan = RpRepo.findById(planId).orElse(null);
//         plan.getUser().add(user);
//         return RpRepo.save(plan);
//     }
}
