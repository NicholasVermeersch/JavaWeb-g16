package controller;

import domain.Cursist;
import domain.Groep;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.CursistDao;
import service.GenericDaoJpa;
import service.JpaCursistDao;
 
@Controller
public class LoginController {
    
@Autowired
    private CursistDao cursistDao;

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String printWelcome(Model model, Principal principal) {
        model.addAttribute("username", cursistDao.getByUsername(principal.getName()).getName());       
        model.addAttribute("message", "Spring Security Custom Form example");
        List<Cursist> cursisten = new ArrayList<Cursist>();
        Cursist cursist = cursistDao.getByUsername(principal.getName());
       /* cursisten.add(new Cursist("Tjeefken"));
    cursisten.add(new Cursist("fideel"));
    cursisten.add(new Cursist("Dolfken"));
    cursisten.add(new Cursist("Theofiel"));
    cursisten.add(new Cursist("Juul Cesar"));*/
        
      //Groep groep= new Groep("de fonzen",cursisten);
      cursisten = cursist.getGroep().getCursists();
      model.addAttribute("groep",cursist.getGroep().getName());
      String cursistString = "";
      for(Cursist curs:cursisten){
          cursistString +="<li>"+curs.getName()+"</li>";
      }
      model.addAttribute("cursisten",String.format("<ul>%s</ul>",cursistString));
      //model.addAttribute("ingediend",cursist.getIngediend());
        return "hello";
    }
    
    @RequestMapping(value = "/login")
    public String login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout, Model model) {

        if (error != null) {
            model.addAttribute("error", "Invalid username and password!");
        }
        if (logout != null) {
            model.addAttribute("msg", "You've been logged out successfully.");
        }
        return "login";
    }

}
