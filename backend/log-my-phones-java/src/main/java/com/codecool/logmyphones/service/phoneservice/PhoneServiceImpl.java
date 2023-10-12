package com.codecool.logmyphones.service.phoneservice;

import com.codecool.logmyphones.model.DTO.PhoneDTO;
import com.codecool.logmyphones.model.Phone;
import com.codecool.logmyphones.model.repository.PhoneRepository;
import com.codecool.logmyphones.service.mapper.PhoneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class PhoneServiceImpl implements PhoneService {
    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;
    @Autowired
    public PhoneServiceImpl(PhoneRepository phoneRepository, PhoneMapper phoneMapper) {
        this.phoneRepository = phoneRepository;
        this.phoneMapper = phoneMapper;
    }

    @Override
    public ResponseEntity<PhoneDTO> addNewPhone(PhoneDTO phoneDTO) {
        Phone phone = phoneMapper.toPhone(phoneDTO);
        phone.setCall(new HashSet<>());
        phoneRepository.save(phone);
        return new ResponseEntity<>(phoneDTO, HttpStatus.OK);
    }
}
