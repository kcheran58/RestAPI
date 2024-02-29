package com.pharmacy.system.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.pharmacy.system.model.User;
import com.pharmacy.system.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public List<User> getUserdetails(){
        return userRepo.findAll();
    }

    public User addUser(User user)
    {
        return userRepo.save(user);
    }
    
    public Optional<User> findUser(Long id){
        return userRepo.findById(id);
    }
    public User editUser(Long id,User user)
    {   User userAvail=userRepo.findById(id).orElse(null);
        if(userAvail!=null)
        {
            userAvail.setUserName(user.getUserName());
            userAvail.setAddress(user.getAddress());
            userAvail.setAge(user.getAge());
            userAvail.setPassword(user.getPassword());
            userAvail.setPhoneNumber(user.getPhoneNumber());
            userAvail.setEmail(user.getEmail());
            return userRepo.saveAndFlush(userAvail);
        }
        else
        return null;
    }
    public String deleteUser(Long id)
    {
        userRepo.deleteById(id);
        return ("User deleted");
    }
    public List<User> getpage(int offset,int pagesize)
    {
        Pageable page=PageRequest.of(offset, pagesize);
        return userRepo.findAll(page).getContent();
    }
    
    public List<User> getpagesort(int offset,int pagesize,String field)
    {
        return userRepo.findAll(PageRequest.of(offset, pagesize)
        .withSort(Sort.Direction.ASC,field)).getContent();
    }

   public List<User>sortUsers(String field)
   {
    return userRepo.findAll(Sort.by(Sort.Direction.ASC,field));
   }

}
