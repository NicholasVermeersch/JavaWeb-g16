package controller;

import domain.Cursist;
import domain.Groep;
import domain.PeerAssesment;
import domain.PeerAssesmentWrapper;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CursistDao;
import service.PeerAssesmentDao;


@Controller
public class CursistController {

    @Autowired
    private CursistDao cursistDao;

    @Autowired
    private PeerAssesmentDao peerAssesmentDao;

    @RequestMapping(value = "/peerassesment", method = RequestMethod.GET)
    public String showHomePage(Model model, Principal principal) {
//        Cursist cursist = new Cursist("jan");
//        List<Cursist> cursisten = new ArrayList<>();
//        Cursist bob = new Cursist("bob");
//        cursisten.add(bob);
//        cursisten.add(cursist);
//        Groep groep = new Groep("groepje", cursisten);
//        cursist.setGroep(groep);
//        bob.setGroep(groep);
        Cursist cursist = cursistDao.getByUsername(principal.getName());
        Groep groep = cursist.getGroep();
        List<Cursist> cursisten = new ArrayList<>();
        cursisten = groep.getCursists();
        List<Integer> antwoorden = new ArrayList<>();
        antwoorden.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        model.addAttribute("antwoorden", antwoorden);
        List<PeerAssesment> peerassesments = new ArrayList<>();
        for (int i = 0; i < cursisten.size(); i++) {
            PeerAssesment p = new PeerAssesment(cursisten.get(i));
            peerassesments.add(p);
            peerassesments.get(i).setVoor(cursisten.get(i));
        }
        PeerAssesmentWrapper pw = new PeerAssesmentWrapper();
        pw.setPeerassesments(peerassesments);
        model.addAttribute("pw", pw);
        return "peerassesment";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String processAssesment(@ModelAttribute(value = "pw") PeerAssesmentWrapper pw, Model model, BindingResult result, Principal principal) {
        //registrationValidation.validate(registration, result);

        if (result.hasErrors()) {
            System.out.println("test");
            return "peerassesment";
        }
       
        for (PeerAssesment p : pw.getPeerassesments()) {
            peerAssesmentDao.insert(p);
        }
        Cursist cursist = cursistDao.getByUsername(principal.getName());
        for (int i = 0; i < pw.getPeerassesments().size(); i++) {
            pw.getPeerassesments().get(i).setVoor(cursist.getGroep().getCursists().get(i));
        }
        cursist.setPeerassesments(pw.getPeerassesments());
        cursistDao.update(cursist);
        

        return "peerassesmentSucces";
    }

    @RequestMapping(value = "/overzichtassesments", method = RequestMethod.GET)
    public String overzichtAssesment(Model model, Principal principal) {
        Cursist cursist = cursistDao.getByUsername(principal.getName());
        model.addAttribute("peers", cursist.getPeerassesments());
        //model.addAttribute("peers", peerAssesmentDao.findAll());
        return "overzichtassesments";
    }

    @RequestMapping(value = "/peerassesmentSucces", method = RequestMethod.GET)
    public String succes(@ModelAttribute(value = "pw") PeerAssesmentWrapper pw,
            Model model, BindingResult result, Principal principal) {
        if (result.hasErrors()) {
            System.out.println("test");
            return "peerassesment";
        }

        Cursist cursist = cursistDao.getByUsername(principal.getName());
        cursist.setIngediend(1);
        cursist.setPeerassesments(pw.getPeerassesments());

        return "peerassesmentSucces";
    }

}
