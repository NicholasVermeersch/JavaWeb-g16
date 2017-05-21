
package domain;

import java.util.ArrayList;
import java.util.List;

public class PeerAssesmentWrapper {

    private List<PeerAssesment> peerassesments;

    public PeerAssesmentWrapper() {
        peerassesments = new ArrayList<>();
    }

    public List<PeerAssesment> getPeerassesments() {
        return peerassesments;
    }

    public void setPeerassesments(List<PeerAssesment> peerassesments) {
        this.peerassesments = peerassesments;
    }

    public void add(PeerAssesment assesment) {
        peerassesments.add(assesment);
    }

}
