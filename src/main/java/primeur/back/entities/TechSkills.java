package primeur.back.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TechSkills {

        @Id
        @GeneratedValue
        private Long idSkill ;
        private String nomSkill ;
        private String Categorie ;
        private String noteAct ;

        public void setIdSkill(Long idSkill) {
                this.idSkill = idSkill;
        }

        public void setNomSkill(String nomSkill) {
                this.nomSkill = nomSkill;
        }

        public void setCategorie(String categorie) {
                Categorie = categorie;
        }

        public void setNoteAct(String noteAct) {
                this.noteAct = noteAct;
        }

        public void setUser(User user) {
                this.user = user;
        }

        @ManyToOne
        @JoinColumn(name="id")
        private User user ;

        public Long getIdSkill() {
                return idSkill;
        }

        public String getNomSkill() {
                return nomSkill;
        }

        public String getCategorie() {
                return Categorie;
        }

        public String getNoteAct() {
                return noteAct;
        }

        public User getUser() {
                return user;
        }
}





