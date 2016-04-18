package pe.com.peruInka.webapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.com.peruInka.service.services.PeruInkaService;
import pe.com.peruInka.service.util.Person;

@Controller
public class DashboardController {

	@Autowired
	private PeruInkaService peruInkaService;

	public static List<Person> list = new ArrayList<Person>();

	@RequestMapping(value = "home/dashboard", method = RequestMethod.GET)
	public String homeDashboard(Model model, HttpServletRequest request) {
		model.addAttribute("listPerson", peruInkaService.findAllPerson());
		return "home/dashboard";
	}

	@RequestMapping(value = "home/frmPerson", method = RequestMethod.GET)
	public String newPerson(Model model, HttpServletRequest request) {
		model.addAttribute("person", new Person());
		return "home/frmPerson";
	}

	@RequestMapping(value = "home/savePerson", method = RequestMethod.POST)
	public String savePeron(Model model, HttpServletRequest request, @ModelAttribute("person") Person person) {
		peruInkaService.saveService(person);
		return "redirect:dashboard";
	}

	// @RequestMapping(value = "/home/searchJsonById/{id}", method =
	// RequestMethod.GET, headers = "Accept=application/json")
	// public @ResponseBody String searchJsonById(@PathVariable("id") Long id) {
	//
	//
	// Person person = new Person();
	// person.setName("Juan");
	// list.add(person);
	//
	// return "Return value::: " + id;
	// }
	//
	// @RequestMapping(value = "/home/searchXMLById/{id}", method =
	// RequestMethod.GET, headers = "Accept=application/xml")
	// public @ResponseBody String searchXMLById(@PathVariable("id") Long id) {
	//
	// return "Return value::: " + id;
	// }

}
