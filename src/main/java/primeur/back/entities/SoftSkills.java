package primeur.back.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SoftSkills implements Serializable {
    @Id
    @GeneratedValue
    private Long idSkill ;
    private String nomSkill ;
    private Long noteAct;
    private Long noteFuture ;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user ;

    public void setIdSkill(Long idSkill) {
        this.idSkill = idSkill;
    }

<<<<<<< HEAD
    public void setNomSkill(String nomSkill) {
=======
    public void setNomSkill(SoftEnum nomSkill) {
>>>>>>> 4d2a3392a2394c5b9de9143008d62bf01e1c3bfb
        this.nomSkill = nomSkill;
    }

    public void setNoteAct(Long noteAct) {
        this.noteAct = noteAct;
    }

<<<<<<< HEAD
    public void setNoteFuture(Long noteFuture) {
        this.noteFuture = noteFuture;
    }

=======
>>>>>>> 4d2a3392a2394c5b9de9143008d62bf01e1c3bfb
    public void setUser(User user) {
        this.user = user;
    }

    public Long getIdSkill() {
        return idSkill;
    }

<<<<<<< HEAD
    public String getNomSkill() {
=======
    public SoftEnum getNomSkill() {
>>>>>>> 4d2a3392a2394c5b9de9143008d62bf01e1c3bfb
        return nomSkill;
    }

    public Long getNoteAct() {
        return noteAct;
    }

<<<<<<< HEAD
    public Long getNoteFuture() {
        return noteFuture;
    }

=======
>>>>>>> 4d2a3392a2394c5b9de9143008d62bf01e1c3bfb
    public User getUser() {
        return user;
    }
}


