package com.example.demo.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.HistoryService;
import com.example.demo.model.History;

import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class HistoryController {
    @Autowired
    HistoryService hService;

    @PostMapping("/POST/History")
    public History postHistory(@RequestBody History h,@RequestParam long user_id)
    {
        return hService.create(h,user_id);
    }

    // @PostMapping("/POST/{userId}")
    // public History postHistory(@RequestBody History history, @PathVariable long userId) {
    //     return hService.create(history, userId);
    // }

    @GetMapping("/GET/History/{id}")
    public History getHistories(@PathVariable long id)
    {
        return hService.findById(id);
    }
    
    @GetMapping("/GET/History")
    public List<History> getHistories()
    {
        return hService.findAll();
    }

    @PutMapping("/PUT/History/{id}")
    public History updateHistory(@PathVariable long id,@RequestBody History h)
    {
        return hService.update(id,h);
    }

    @DeleteMapping("/DELETE/History/{id}")
    public String deleteHistory(@PathVariable long id)
    {
        return hService.delete(id);
    }

    @GetMapping("/GET/paginate/History")
    public Page<History> getPage(@RequestParam int page,int size,String sortby) {
        return hService.getPage(page, size,sortby);
    }

    @GetMapping("/GET/HistoryByDate")
    public List<History> findByDate(@RequestParam LocalDate date) {
        return hService.findByHistories(date);
    }

    @GetMapping("/GET/HistoryByTime")
    public List<History> findByTime(@RequestParam String time) {
        return hService.findByTime(time);
    }   
    
    @GetMapping("/GET/user/{userid}")
    public List<History> getHistorybyuserid(@PathVariable long userid) {
        return hService.gethisbyuserid(userid);
    }
}
