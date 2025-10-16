package com.ads.dental.service;

import com.ads.dental.dto.AddressDTO;
import com.ads.dental.dto.PatientDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays; import java.util.List;

@Service
public class AdsApiClient {
  private final RestTemplate rt;
  @Value("${ads.api.base}") private String base;
  public AdsApiClient(RestTemplate rt){ this.rt = rt; }

  public List<PatientDTO> listPatients(){
    return Arrays.asList(rt.getForObject(base + "/patients", PatientDTO[].class));
  }
  public PatientDTO getPatient(Long id){ return rt.getForObject(base + "/patients/" + id, PatientDTO.class); }
  public PatientDTO createPatient(PatientDTO p){ return rt.postForObject(base + "/patients", p, PatientDTO.class); }
  public PatientDTO updatePatient(Long id, PatientDTO p){
    HttpHeaders h = new HttpHeaders(); h.setContentType(MediaType.APPLICATION_JSON);
    return rt.exchange(base + "/patient/" + id, HttpMethod.PUT, new HttpEntity<>(p, h), PatientDTO.class).getBody();
  }
  public void deletePatient(Long id){ rt.delete(base + "/patient/" + id); }
  public List<PatientDTO> searchPatients(String q){
    return Arrays.asList(rt.getForObject(base + "/patient/search/" + q, PatientDTO[].class));
  }
  public List<AddressDTO> listAddresses(){
    return Arrays.asList(rt.getForObject(base + "/addresses", AddressDTO[].class));
  }
}
