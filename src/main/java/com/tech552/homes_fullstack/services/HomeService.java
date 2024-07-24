package com.tech552.homes_fullstack.services;
import com.tech552.homes_fullstack.models.Home;
import com.tech552.homes_fullstack.repos.HomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    @Autowired
    private HomeRepo homeRepo;

    public void addHome(Home home ){
        homeRepo.save(home);
    }

    public Iterable<Home>getAllHomes(){
        return homeRepo.findAll();
    }

    public void deleteHome(Long id){
        homeRepo.deleteById(id);
    }

    public Home getHomeById(Long id){
        return homeRepo.findById(id).orElseThrow(null);
    }

    public void updateHome(Long id, Home home){
        home.setId(id);
        homeRepo.save(home);
    }
}
