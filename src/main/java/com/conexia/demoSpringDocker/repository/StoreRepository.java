package com.conexia.demoSpringDocker.repository;

import com.conexia.demoSpringDocker.domain.Staff;
import com.conexia.demoSpringDocker.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store,Long> {
}
