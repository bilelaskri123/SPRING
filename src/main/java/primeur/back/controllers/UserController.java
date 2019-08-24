package primeur.back.controllers;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import primeur.back.entities.SoftEnum;
import primeur.back.entities.SoftSkills;
import primeur.back.entities.TechSkills;
import primeur.back.entities.User;
import primeur.back.repositories.IUser;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUser userRepositroy;
    @GetMapping("/")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(userRepositroy.findAll()) ;

    }
    /*@GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable(name="id") Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().body("null");
        }
        User user = userRepositroy.getOne(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        List list=new ArrayList<>() ;
        list.add("id " + user.getId()) ;
        list.add("nom " + user.getNom()) ;
        list.add("prenom " + user.getPrenom()) ;
        list.add("equipe " + user.getEquipe()) ;
        list.add("fonction " + user.getFonction()) ;
        return ResponseEntity.ok(list) ;


    }*/
    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        return userRepositroy.findById(id)
                .map(s-> ResponseEntity.ok().body(s))
                .orElse(ResponseEntity.notFound().build()) ;

    }
    @GetMapping("/find/{nom}")
    public ResponseEntity findByNom(@PathVariable String nom) {
        if(nom==null) {
            return ResponseEntity.badRequest().build() ;
        }
        List<User> user=userRepositroy.findByNom(nom) ;
        if(user==null) {
            return ResponseEntity.notFound().build() ;
        }
        return ResponseEntity.ok(user) ;

    }

    @GetMapping("/find/{prenom}")
    public ResponseEntity findByPrenom(@PathVariable String prenom) {
        if (prenom == null) {
            return ResponseEntity.badRequest().build();
        }
        List<User> user=userRepositroy.findByPrenom(prenom);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/find/{TechSkill}")
    public ResponseEntity findByTechSkills(@PathVariable TechSkills techSkill)
    {
        User users = (User) userRepositroy.findByNom(techSkill.getNomSkill());
        return ResponseEntity.ok(users);
    }


    @GetMapping("/count/")
    public long countNombrePerson(@PathVariable TechSkills techSkills) {
        return userRepositroy.countByTechSkills(techSkills.getNomSkill());
    }

    /*@GetMapping("/SoftSkills/{softSkills}")
    public ResponseEntity findUserBySoftSkills(@PathVariable SoftSkills softSkills , @PathVariable SoftEnum soft) {
        if (softSkills.getNomSkill() != soft) {
            return ResponseEntity.badRequest().build();
        }
        List<User> users=userRepositroy.findUserBySoftSkills(softSkills,soft);
        if (users == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(users);
    }

   /* @GetMapping("/TechSkills/{techSkills}")
    public ResponseEntity findUserByTechSkills(@PathVariable TechSkills techSkills ,@PathVariable String tech) {

    }*/


   /*methode create user*/
    @PostMapping("/")
    public ResponseEntity createUser(@RequestBody User user) {
        if (user==null) {
            return ResponseEntity.badRequest().body(null ) ;
        }
        User createdUser=userRepositroy.save(user) ;
        return ResponseEntity.ok(createdUser) ;

    }


    /*update user en generale*/
    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable Long id,@RequestBody User newUser) {
        if(id==null) {
            return ResponseEntity.badRequest().build() ;
        }
        User user=userRepositroy.getOne(id) ;
        if(user==null) {
            return ResponseEntity.notFound().build() ;
        }
        if(newUser.getNom()!=null) {
            user.setNom(newUser.getNom());
        }
        if(newUser.getPrenom()!=null) {
            user.setPrenom(newUser.getPrenom());
        }

        if (newUser.getEquipe() != null) {
            user.setEquipe(newUser.getEquipe());
        }

        if (newUser.getFonction() != null) {
            user.setFonction(newUser.getFonction());
        }
        if (newUser.getMail() != null){
            user.setMail(newUser.getMail());
        }
        if (newUser.getPassword() != null) {
            user.setPassword(newUser.getPassword());
        }

        return ResponseEntity.ok(userRepositroy.save(user)) ;
    }

    /*@PutMapping("auth/{id}")
    public ResponseEntity updateUserAuth(@PathVariable Long id , @PathVariable User newUser)
    {
        if(id == null) {
            return ResponseEntity.badRequest().build();
        }
        User user = userRepositroy.getOne(id);
        if (user == null) { return ResponseEntity.notFound().build();}
        if (newUser.getMail() != null)
        {
            user.setMail(newUser.getMail());
        }
        if (newUser.getPassword() != null)
        {
            user.setPassword(newUser.getPassword());
        }
        return ResponseEntity.ok(userRepositroy.save(user));
        }
    }*/

    @DeleteMapping("/delete/{Nom}")
    public void deleteByNom(@PathVariable String Nom) {
       userRepositroy.deleteByNom(Nom);
    }

    @DeleteMapping(value = "/delete/{prenom}")
    public void deleteByPrenom(@PathVariable String Prenom) {
        userRepositroy.deleteByPrenom(Prenom);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        userRepositroy.deleteById(id);
    }

}
