package primeur.back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import primeur.back.entities.SoftEnum;
import primeur.back.entities.SoftSkills;
import primeur.back.entities.TechSkills;
import primeur.back.entities.User;

import java.util.List;

public interface IUser extends JpaRepository<User,Long> {
     List<User> findByNom(String Nom) ;
<<<<<<< HEAD
     List<User> findByPrenom(String Prenom) ;
=======
     //List<User> findUserByTechSkills(TechSkills techSkills , String tech);
     //List<User> findUserBySoftSkills(SoftSkills softSkills , SoftEnum soft);
     List<User> findByPrenom(String prenom);
>>>>>>> 4d2a3392a2394c5b9de9143008d62bf01e1c3bfb

    void deleteByNom(String Nom);
    void deleteByPrenom(String Prenom);
    long countByTechSkills(String techSkills);
}
