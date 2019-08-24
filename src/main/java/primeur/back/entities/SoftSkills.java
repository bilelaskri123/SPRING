package primeur.back.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoftSkills implements Serializable {
    @Id
    private Long idSkill ;
    private SoftEnum nomSkill ;
    private Long noteAct;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user ;

    public void setIdSkill(Long idSkill) {
        this.idSkill = idSkill;
    }

    public void setNomSkill(SoftEnum nomSkill) {
        this.nomSkill = nomSkill;
    }

    public void setNoteAct(Long noteAct) {
        this.noteAct = noteAct;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getIdSkill() {
        return idSkill;
    }

    public SoftEnum getNomSkill() {
        return nomSkill;
    }

    public Long getNoteAct() {
        return noteAct;
    }

    public User getUser() {
        return user;
    }
}


