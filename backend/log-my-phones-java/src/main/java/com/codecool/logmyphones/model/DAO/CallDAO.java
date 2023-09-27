package com.codecool.logmyphones.model.DAO;

import com.codecool.logmyphones.model.Call;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CallDAO extends JpaRepository<Call,Long> {
}
