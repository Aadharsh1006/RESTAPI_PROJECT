package com.example.demo.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.History;
import com.example.demo.model.User;
import com.example.demo.repositories.HistoryRepository;
import com.example.demo.repositories.UserRepository;

@Service
public class HistoryService {
    @Autowired
    HistoryRepository HisRepo;

    @Autowired
    UserRepository URepo;
    
    public History create(History h,long user_id)
    {
        User user=URepo.findById(user_id).orElse(null);
        h.setUser(user);
        return HisRepo.save(h);
    }
    
    public List<History> findByHistories(LocalDate date)
    {
        return HisRepo.findByDate(date);
    }

    public History findById(long id)
    {
        return HisRepo.findById(id).orElse(null);
    }

    public List<History>findByTime(String time)
    {
        return HisRepo.findByTime(time);
    }

    public List<History> findAll()
    {
        return HisRepo.findAll();
    }

    public History update(long id,History h)
    {
        h.setId(id);
        return HisRepo.save(h);
    }

    public String  delete(long id)
    {
         HisRepo.deleteById(id);
         return "Success";
    }

    public Page<History> getPage(int page,int size,String sortBy)
    {
        Pageable pageable=PageRequest.of(page, size,Sort.by(Sort.Direction.ASC, sortBy));
        return HisRepo.findAll(pageable);
    }

    public List<History> gethisbyuserid(long userid)
    {
        return HisRepo.findByUserId(userid);
    }

    // public History create(History history, long userId) {
    //     User user = URepo.findById(userId).orElse(null);
    //     if (user != null) {
    //         history.setUser(user);  
    //         return HisRepo.save(history);
    //     }
    //     return null;
    // }

    // public List<History> getUserHistory(long userId) {
    //     User user = URepo.findById(userId).orElse(null);
    //     return (user != null) ? user.getHistory() : null;
    // }

}