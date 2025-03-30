package com.example.demo.Service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.History;
import com.example.demo.model.RechargePlan;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository URepo;
    
    public User createUser(User u) {
        if (u == null || URepo.existsById(u.getId()) || u.getId() < 0) {
            return null;
        }
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (!u.getEmail().matches(emailRegex)) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        return URepo.save(u);
    }

    public User getUserById(long id) {
        return URepo.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return URepo.findAll();
    }

    public User updateUser(long id, User u) {
        if (u == null || !URepo.existsById(id) || u.getId() < 0) {
            return null;
        }
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (!u.getEmail().matches(emailRegex)) {
            throw new IllegalArgumentException("Invalid email format.");
        }
        u.setId(id);
        return URepo.save(u);
    }

    public boolean deleteUser(long id) {
        if (!URepo.existsById(id)) return false;
        URepo.deleteById(id);
        return true;
    }

    public Page<User> getpages(int page, int size, String sortby, String sortOrder) {
        Sort.Direction direction = sortOrder != null && sortOrder.equalsIgnoreCase("desc") 
                                    ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortby));
        return URepo.findAll(pageable);
    }

    public User findByEmail(String email) {
        return URepo.findByEmail(email);
    }

    public List<User> findByAddress(String address) {
        return URepo.findByAddress(address);
    }

    public List<History>gethistorybtyuserid(long id)
    {
        User user=URepo.findById(id).orElse(null);
        return user.getHistories();
    }

    public Set<RechargePlan>getrechargeplanbyuserid(long id)
    {
        User user=URepo.findById(id).orElse(null);
        return user.getRechargePlan();
    }
    
}
