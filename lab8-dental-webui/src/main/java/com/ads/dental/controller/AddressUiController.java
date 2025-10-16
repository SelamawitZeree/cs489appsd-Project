package com.ads.dental.controller;

//import com.ads.dental.webui.service.AdsApiClient;
//import com.ads.dental.service.AdsApiClient;
import com.ads.dental.service.AdsApiClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui/addresses")
public class AddressUiController {
  private final AdsApiClient api;
  public AddressUiController(AdsApiClient api){ this.api = api; }
  @GetMapping
  public String list(Model model){
    model.addAttribute("addresses",
            api.listAddresses()); return "addresses/list"; }
}
