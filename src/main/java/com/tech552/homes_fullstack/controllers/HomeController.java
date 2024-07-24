package com.tech552.homes_fullstack.controllers;

import com.tech552.homes_fullstack.models.Home;
import com.tech552.homes_fullstack.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@CrossOrigin("http://localhost:4200")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @PostMapping("/homes")
    public ResponseEntity<Void> addHome(@RequestBody Home home){
        homeService.addHome(home);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(home.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/homes")
    public ResponseEntity<?> getAllHomes(){
        return  ResponseEntity.ok(homeService.getAllHomes());
    }

    @GetMapping("/homes/{id}")
    public ResponseEntity<Home> getHomeById(@PathVariable Long id){
       Home home = homeService.getHomeById(id);
       return ResponseEntity.ok(home);
    }

    @PutMapping("/homes/{id}")
    public ResponseEntity<Void> updateHome(@PathVariable Long id, @RequestBody Home home){
        homeService.updateHome(id, home);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/homes/{id}")
    public ResponseEntity<Void> deleteHome(@PathVariable Long id){
        homeService.deleteHome(id);
        return ResponseEntity.noContent().build();
    }

}
