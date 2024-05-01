package com.bechir.departement.controllers;

import java.text.ParseException;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bechir.departement.Departementss;
import com.bechir.departement.services.DepartementServices;

@Controller
public class DepartementController {

    @Autowired
    DepartementServices departementServices;

    @RequestMapping("/ListeDepartement")
    public String listeDepartement(ModelMap modelMap,
            @RequestParam (name="page",defaultValue = "0") int page,
            @RequestParam (name="size", defaultValue = "3") int size) {
            Page<Departementss> depa = departementServices.getAllDepartementParPage(page, size);
            modelMap.addAttribute("Departementss", depa); 
            modelMap.addAttribute("pages", new int[depa.getTotalPages()]);
            modelMap.addAttribute("currentPage", page);
            return "listeDepartement";
    }

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createDepartement";
    }

//    @RequestMapping("/saveDepartement")
//    public String saveDepartement(@ModelAttribute("Departement") Departement departement, @RequestParam("date") String date, ModelMap modelMap) throws ParseException {
//        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
//        Date dateAffectation = dateformat.parse(String.valueOf(date));
//        departement.setDateAffectation(dateAffectation);
//        Departement saveDepartement = departementServices.saveDepartement(departement);
//        String msg = "departement enregistré avec Id " + saveDepartement.getId_Departement();
//        modelMap.addAttribute("msg", msg);
//        return "createDepartement";
//    }
//    
    
    
    @RequestMapping("/saveDepartement")
    public void  saveDepartement(@ModelAttribute("Departementss") Departementss departement) {
        departement.setDateAffectation(new Date()); // Enregistrement de la date actuelle
        departementServices.saveDepartement(departement);

        //        return "createDepartement";
    }
//    @RequestMapping("/saveDepartement")
//    public String saveDepartement(@ModelAttribute("Departement") Departement departement)
//    {
//    	departementServices.saveDepartement(departement);
//    return "createDepartement";
//    }


    @RequestMapping("/supprimerDepartement")
    public String supprimerDepartement(@RequestParam("id") Long id, @RequestParam(name="page", defaultValue = "0") int page,
                                       @RequestParam(name="size", defaultValue = "3") int size , ModelMap modelMap) {
        departementServices.deleteDepartementById(id);
        Page<Departementss> depa = departementServices.getAllDepartementParPage(page, size);
        modelMap.addAttribute("Departementss", depa); 
        modelMap.addAttribute("pages", new int[depa.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "ListeDepartement"; 
    }

    @RequestMapping("/modifierDepartement")
    public String editerDepartement(@RequestParam("id") Long id, ModelMap modelMap) {
        Departementss p = departementServices.getDepartement(id);
        modelMap.addAttribute("Departementss", p);
        return "formDepartement";
    }

    @RequestMapping("/updateDepartement")
    public String updateDepartement(@ModelAttribute("Departementss") Departementss departement, @RequestParam("date") String date, ModelMap modelMap) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateAffectation = dateFormat.parse(date);
        departement.setDateAffectation(dateAffectation);
        departementServices.updateDepartement(departement);

        List<Departementss> depa = departementServices.getAllDepartement();
        modelMap.addAttribute("departements", depa);
        return "listeDepartement";
    }

}
