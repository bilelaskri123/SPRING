package primeur.back.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import primeur.back.entities.TechSkills;
import primeur.back.entities.User;
import primeur.back.repositories.ITechSkills;
import primeur.back.repositories.IUser;

@RestController
public class TechSkillsController {

    @Autowired
    private ITechSkills techSkillsRepository ;
    @Autowired
    private IUser user ;

    @GetMapping("/")
    public ResponseEntity findAll() {
         return ResponseEntity.ok(techSkillsRepository.findAll()) ;
    }
    @PostMapping("/")
    public ResponseEntity createTechSkill(@RequestBody TechSkills techSkills) {
        if (techSkills == null) {
            return ResponseEntity.badRequest().body(null);
        }

        return ResponseEntity.ok(techSkillsRepository.save(techSkills));
    }


}


