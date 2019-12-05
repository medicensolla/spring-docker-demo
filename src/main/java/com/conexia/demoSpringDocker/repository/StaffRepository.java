package com.conexia.demoSpringDocker.repository;

import com.conexia.demoSpringDocker.domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

}