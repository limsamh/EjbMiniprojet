package fr.blois.siad.jee.tp2.entities;

import fr.blois.siad.jee.tp2.dto.Utilisateur;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
/**
 * Classe représentant l'objet métier en base de données
 * @author Salim IGUE
 */
@Entity
public class UtilisateurEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(unique = true)
    private String email;
    
    @Column
    @NotNull
    private String motDePasse;
    
    @Column(unique = true)
    private String nom;
    
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateInscription;
    
    @Column
    private Boolean blocage;
    
    public UtilisateurEntity() {
        
    }
    /**
     * Constructeur avec paramètre
     * @param email l'email de l'utilisateur
     * @param motDePasse le mot de passe de l'utilisateur
     * @param nom le nom  de l'utilisateur
     * @param dateInscription la date d'inscription de l'utilisateur
     * @param blocage le booléen permettant de savoir si un utilisateur est bloqué ou non
     */
    public UtilisateurEntity(String email, String motDePasse, String nom, Date dateInscription, Boolean blocage) {
        this.email = email;
        this.motDePasse = motDePasse;
        this.nom = nom;
        this.dateInscription = dateInscription;
        this.blocage = blocage;
    }
    /**
     *
     * @return le booléen blocage
     */
    public Boolean getBlocage() {
        return blocage;
    }
    /**
     * Méthode permettant de modifier le booléen blocage
     * @param blocage le blocage
     */
    public void setBlocage(Boolean blocage) {
        this.blocage = blocage;
    }
    /**
     *
     * @return l'identifiant utilisateur
     */
    public Integer getId() {
        return id;
    }
    /**
     * Méthode permettant de modifier l'identifiant
     * @param id l'identifiant
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     *
     * @return l'email
     */
    public String getEmail() {
        return email;
    }
    /**
     * Méthode permettant de modifier l'email
     * @param email l'email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     *
     * @return le mot de passe
     */
    public String getMotDePasse() {
        return motDePasse;
    }
    /**
     * Méthode permettant de modifier le mot de passe
     * @param motDePasse  le mot de passe
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    /**
     *
     * @return le nom de l'utilisateur
     */
    public String getNom() {
        return nom;
    }
    /**
     * Méthode permettant de modifier le nom d'utilisateur
     * @param nom le nom de l'utilisateur
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     *
     * @return la date d'inscription
     */
    public Date getDateInscription() {
        return dateInscription;
    }
    /**
     * Méthode permettant de modifier la date d'inscription
     * @param dateInscription la date d'inscription
     */
    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UtilisateurEntity)) {
            return false;
        }
        UtilisateurEntity other = (UtilisateurEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }
    
    @Override
    public String toString() {
        return "fr.blois.siad.jee.tp2.entities.UtilisateurEntity[ id=" + id + " ]";
    }
    /**
     *
     * @return l'objet métier utilisateur correspondant
     */
    public Utilisateur getDTO() {
        return new Utilisateur(id, email, motDePasse, nom, dateInscription,blocage);
    }
}
