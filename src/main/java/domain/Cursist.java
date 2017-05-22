
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
    @NamedQuery(name = "Cursist.getByUsername", query = "SELECT c FROM Cursist c WHERE c.name= :username")})
public class Cursist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Groep groep;

    @OneToMany(cascade = CascadeType.ALL)
    private List<PeerAssesment> peerassesments;

    private String name;

    private Integer ingediend;

    public Cursist(String name) {
        this.name = name;
        peerassesments = new ArrayList<>();
    }

    protected Cursist() {
    }

    public int getIngediend() {
        return ingediend;
    }

    public void setIngediend(int ingediend) {
        this.ingediend = ingediend;
    }

    public Groep getGroep() {
        return groep;
    }

    public void setGroep(Groep groep) {
        this.groep = groep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PeerAssesment> getPeerassesments() {
        return peerassesments;
    }

    public void setPeerassesments(List<PeerAssesment> peerassesments) {
        this.peerassesments = peerassesments;
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
        
        if (!(object instanceof Cursist)) {
            return false;
        }
        Cursist other = (Cursist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Cursist[ id=" + id + " ]";
    }

}
