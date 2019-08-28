package primeur.back.controllers;

import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import primeur.back.entities.SoftSkills;
import primeur.back.entities.User;
import primeur.back.repositories.ISoftSkills;
import primeur.back.repositories.IUser;


import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/soft")
public class SoftSkillsController {
    @Autowired
    private ISoftSkills softSkillsRepository ;
    @Autowired
    private IUser userRepository ;

    @GetMapping("/")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(softSkillsRepository.findAll()) ;
    }
<<<<<<< HEAD
    @PostMapping("/{id}")
    public ResponseEntity createSoftSkill(@PathVariable Long id, @RequestBody SoftSkills softSkills) {
        if (softSkills == null || id==null) {
=======

    @PostMapping("/")
    public ResponseEntity createSoftSkill(@RequestBody SoftSkills softSkills) {
        if (softSkills == null) {
>>>>>>> 4d2a3392a2394c5b9de9143008d62bf01e1c3bfb
            return ResponseEntity.badRequest().body(null);
        }
        User user=userRepository.getOne(id) ;
        if(user==null) {
            return ResponseEntity.notFound().build() ;
        }
        softSkills.setUser(user);
        return ResponseEntity.ok(softSkillsRepository.save(softSkills)) ;


    }
<<<<<<< HEAD
    /*@GetMapping("/all/{id}")
=======

    @GetMapping("/all/{id}")
>>>>>>> 4d2a3392a2394c5b9de9143008d62bf01e1c3bfb
    public ResponseEntity findAllUserSkills(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().body("Cannot find skill with null user");
        }
        User user=userRepository.getOne(id) ;
        //User user = userRepository.getOne(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        List<SoftSkills> userSkill= softSkillsRepository.findByUser(user);
        return ResponseEntity.ok(userSkill) ;
    }*/

}
