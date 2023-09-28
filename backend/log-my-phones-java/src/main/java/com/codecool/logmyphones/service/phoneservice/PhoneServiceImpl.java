package com.codecool.logmyphones.service.phoneservice;

import com.codecool.logmyphones.model.DTO.PhoneDTO;
import com.codecool.logmyphones.model.Phone;
import com.codecool.logmyphones.model.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements PhoneService {
    private final PhoneRepository phoneRepository;
    @Autowired
    public PhoneServiceImpl(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    @Override
    public void addNewPhone(PhoneDTO phoneDTO) {
        Phone phone = Phone.builder().phoneNumber(phoneDTO.phoneNumber()).build();
            phoneRepository.save(phone);
    }
}
