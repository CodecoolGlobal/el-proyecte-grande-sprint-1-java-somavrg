package com.codecool.logmyphones.model.DAO;

import com.codecool.logmyphones.model.Call;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallRepository extends JpaRepository<Call,Long> {
}
