package com.infosupport.minor.case_01_frontend.controller;

import com.infosupport.minr.case_01_backend.domain.Cursus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class CursusController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping(value = {"/cursuses"}, method = RequestMethod.GET)
    public String getCursuses(Model model) {
        ResponseEntity<List<Cursus>> cursuses = restTemplate.exchange("http://localhost:8081/cursuses", HttpMethod.GET, null, new ParameterizedTypeReference<List<Cursus>>() {});
        List<Cursus> cursusesBody = cursuses.getBody();

        if (cursusesBody.size() > 0) {
            model.addAttribute("cursuses", cursusesBody);
        }

        return "cursus/index";
    }

//    @RequestMapping(value = {"/cursuses/create"}, method = RequestMethod.GET)
//    public String create() {
//        return "cursus/add";
//    }
//
//    @RequestMapping(value = {"/cursuses"}, method = RequestMethod.POST)
//    public String create(@RequestParam("file") MultipartFile file,
//                         RedirectAttributes redirectAttributes) {
//        int recordsAdded = this.cursusService.saveCursusesFromFile(file);
//        redirectAttributes.addFlashAttribute("message_file",
//                "U heeft het bestand: " + file.getOriginalFilename() + " met success ingevoerd");
//        redirectAttributes.addFlashAttribute("message_records",
//                "Er zijn " + recordsAdded + " cursusinstanties toegevoegd.\n");
//
//        return "redirect:/cursuses";
//    }
//
//    @RequestMapping(value = {"/cursuses/{id}/enroll"}, method = RequestMethod.GET)
//    public String enrollCursist(@PathVariable int id, Model model) {
//        model.addAttribute("cursus", this.cursusService.findCursus(id));
//        model.addAttribute("cursists", this.cursistService.findCursists());
//
//        return "cursus/enroll";
//    }
//
//    @RequestMapping(value = "/cursuses/{id}/enroll", method = RequestMethod.POST)
//    public String enrollCursist(@PathVariable int id, @RequestParam int cursistId, Model model,
//                                RedirectAttributes redirectAttributes) {
//        Cursist cursist = this.cursistService.findCursist(cursistId);
//        Cursus cursus = this.cursusService.findCursus(id);
//
//        if (!cursus.hasCursist(cursist)) {
//            boolean isEnrolled = cursus.addCursist(cursist);
//
//            if (isEnrolled) {
//                redirectAttributes.addFlashAttribute("message_enrolled",
//                        "U heeft de cursist: " + cursist.getFirstName() + " " + cursist.getLastName()
//                                + " met succes ingeschreven");
//            } else {
//                redirectAttributes.addFlashAttribute("message_enrolled_full",
//                        "De cursist: " + cursist.getFirstName() + " " + cursist.getLastName()
//                                + " kon niet ingeschreven worden, omdat de cursus volgepland is");
//            }
//        } else {
//            redirectAttributes.addFlashAttribute("message_enrolled_fail",
//                    "De cursist: " + cursist.getFirstName() + " " + cursist.getLastName()
//                            + " is al ingeschreven...");
//        }
//
//        this.cursusService.saveCursus(cursus);
//
//        return "redirect:/cursuses";
//    }
//
//    @RequestMapping(value = {"/cursuses/{id}/details"}, method = RequestMethod.GET)
//    public String enrollDetails(@PathVariable int id, Model model) {
//        model.addAttribute("cursus", this.cursusService.findCursus(id));
//
//        return "cursus/enroll_details";
//    }
}
