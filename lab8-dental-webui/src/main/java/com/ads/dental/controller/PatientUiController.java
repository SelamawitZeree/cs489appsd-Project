package com.ads.dental.controller;

//import com.ads.dental.lab8_dental_webui.dto.PatientDTO;
//import com.ads.dental.lab8_dental_webui.service.AdsApiClient;
import com.ads.dental.dto.PatientDTO;
import com.ads.dental.service.AdsApiClient;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller @RequestMapping("/ui/patients")
public class PatientUiController {
  private final AdsApiClient api;
  public PatientUiController(AdsApiClient api){ this.api = api; }

  @GetMapping
  public String list(@RequestParam(value="q", required=false) String q, Model model){
    model.addAttribute("patients", (q!=null && !q.isBlank()) ? api.searchPatients(q) : api.listPatients());
    model.addAttribute("q", q);
    return "patients/list";
  }

  @GetMapping("/{id}") public String view(@PathVariable Long id, Model model){
    model.addAttribute("p", api.getPatient(id)); return "patients/view";
  }

  @GetMapping("/new") public String newForm(Model model){ model.addAttribute("p", new PatientDTO()); return "patients/form"; }

  @PostMapping
  public String create(@Valid @ModelAttribute("p") PatientDTO p, BindingResult br){
    if(br.hasErrors()) return "patients/form";
    api.createPatient(p); return "redirect:/ui/patients";
  }

  @GetMapping("/{id}/edit") public String editForm(@PathVariable Long id, Model model){
    model.addAttribute("p", api.getPatient(id)); return "patients/form";
  }

  @PostMapping("/{id}")
  public String update(@PathVariable Long id, @Valid @ModelAttribute("p") PatientDTO p, BindingResult br){
    if(br.hasErrors()) return "patients/form";
    api.updatePatient(id, p); return "redirect:/ui/patients/" + id;
  }

  @PostMapping("/{id}/delete")
  public String delete(@PathVariable Long id){ api.deletePatient(id); return "redirect:/ui/patients"; }
}
