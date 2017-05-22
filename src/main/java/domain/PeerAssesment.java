
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
@NamedQueries({
    @NamedQuery(name = "PeerAssesment.getById", query = "SELECT p FROM PeerAssesment p WHERE p.voor.id = :id")})
public class PeerAssesment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Antwoord> antwoorden;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cursist voor;

    public PeerAssesment(Cursist cursist) {
        voor = cursist;
        antwoorden = new ArrayList<>();

    }

    public PeerAssesment() {
    }

    public List<Antwoord> getAntwoorden() {
        return antwoorden;
    }

    public void setAntwoorden(List<Antwoord> antwoorden) {
        this.antwoorden = antwoorden;
    }

    public Cursist getVoor() {
        return voor;
    }

    public void setVoor(Cursist voor) {
        this.voor = voor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof PeerAssesment)) {
            return false;
        }
        PeerAssesment other = (PeerAssesment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.PeerAssesment[ id=" + id + " ]";
    }

}
