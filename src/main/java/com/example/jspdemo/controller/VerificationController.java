package com.example.jspdemo.controller;


import com.example.jspdemo.model.*;
import com.example.jspdemo.service.CustomUserDetailsService;
import com.example.jspdemo.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class VerificationController {

    @Autowired
    VerificationService verificationService;

    @RequestMapping("/export")
    public String home(Principal principal, Model model) {
        if(principal != null) {
            model.addAttribute("username", principal.getName());
        }
        return "export";
    }

    @RequestMapping("/admin/export")
    public String adminhome(Principal principal, Model model) {
        if(principal != null) {
            model.addAttribute("username", principal.getName());
        }
        return "/admin/export";
    }




    @GetMapping({ "/","/viewVerificationList1"})
    public String viewVerificationListByUser(@ModelAttribute("message") String message, Model model, Principal principal) {
     //   model.addAttribute("verificationList",  verificationService.findByUserName(principal.getName()));
        model.addAttribute("verificationList", verificationService.getAllVerification());
        model.addAttribute("message", message);
        if(principal.getName() =="admin"){

            return "admin/ViewVerificationList";
        }
        else {
            System.out.println(principal.getName() + " Normal User");

            return "ViewVerificationList1";
        }
    }
    @GetMapping({"/admin", "admin/viewVerificationList"})
    public String viewVerificationListAdmin(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("verificationList", verificationService.getAllVerification());
        model.addAttribute("message", message);

        return "admin/ViewVerificationList";
    }
    //original viewList
    /*
    @GetMapping({"/", "/viewVerificationList"})
    public String viewVerificationList(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("verificationList", verificationService.getAllVerification());
        model.addAttribute("message", message);

        return "ViewVerificationList";
    }

     */

    @GetMapping("/addVerification")
    public String addVerification(@ModelAttribute("message") String message, Model model, Principal principal,
                                  CustomUserDetailsService customUserDetailsService) {
        model.addAttribute("verification", new Verification(customUserDetailsService));
        model.addAttribute("message", message);
        if(principal != null) {
            model.addAttribute("username", principal.getName());
            System.out.println(" user name is not null " + principal.getName());
        }
        List<PbfVvsLab> labs = verificationService.getAllLabs();
        model.addAttribute("labsOptions",labs);
        List<PbfVvsFacility>facilities= verificationService.getAllFacilies();
        model.addAttribute("facilityOptions",facilities);
        List<PbfVvsHealthRegion> healthRegions = verificationService.getAllHealthRegion();
        model.addAttribute("healthRegions",healthRegions);
        List<PbfVvsUser> currentUsers = verificationService.getAllUser();
        model.addAttribute("user",currentUsers);

        // customUserDetailsService.CurrentUserId();

        return "AddVerification";
    }

    @PostMapping("/saveVerification")
    public String saveVerification(Verification verification, RedirectAttributes redirectAttributes, PbfVvsLab pbfVvsLab,
                                   PbfVvsFacility pbfVvsFacility, CustomUserDetailsService customUserDetailsService) {
        if (verificationService.saveOrUpdateVerification(verification,pbfVvsLab, pbfVvsFacility,customUserDetailsService)) {
            redirectAttributes.addFlashAttribute("message", "Save Success");
            return "redirect:/viewVerificationList1";
        }

        redirectAttributes.addFlashAttribute("message", "Save Failure");
        return "redirect:/addVerification";
    }

    @GetMapping("/editVerification/{id}")
    public String editVerification(@PathVariable Long id, Model model) {
        model.addAttribute("verification", verificationService.getVerificationById(id));
        List<PbfVvsLab> labs = verificationService.getAllLabs();
        model.addAttribute("labsOptions",labs);
        List<PbfVvsFacility>facilities= verificationService.getAllFacilies();
        model.addAttribute("facilityOptions",facilities);
        List<PbfVvsHealthRegion> healthRegions = verificationService.getAllHealthRegion();
        model.addAttribute("healthRegions",healthRegions);
        return "EditVerification";
    }

    @PostMapping("/editSaveVerification")
    public String editSaveVerification(Verification verification, RedirectAttributes redirectAttributes, PbfVvsLab pbfVvsLab,
                                       PbfVvsFacility pbfVvsFacility,CustomUserDetailsService customUserDetailsService) {
        if (verificationService.saveOrUpdateVerification(verification,pbfVvsLab,pbfVvsFacility,customUserDetailsService)) {
            redirectAttributes.addFlashAttribute("message", "Edit Success");
            return "redirect:/viewVerificationList1";
        }

        redirectAttributes.addFlashAttribute("message", "Edit Failure");
        return "redirect:/editVerification/" + verification.getId();
    }

    @GetMapping("/deleteVerification/{id}")
    public String deleteVerification(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (verificationService.deleteVerification(id)) {
            redirectAttributes.addFlashAttribute("message", "Delete Success");
        } else {
            redirectAttributes.addFlashAttribute("message", "Delete Failure");
        }

        return "redirect:/viewVerificationList";
    }

}
