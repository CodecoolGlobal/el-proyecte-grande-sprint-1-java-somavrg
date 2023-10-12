package com.codecool.logmyphones.service.phoneservice;

import com.codecool.logmyphones.model.DTO.PhoneDTO;
import org.springframework.http.ResponseEntity;

public interface PhoneService {
    ResponseEntity<PhoneDTO> addNewPhone(PhoneDTO phoneDTO);
}
