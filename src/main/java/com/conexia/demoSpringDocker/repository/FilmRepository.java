package com.conexia.demoSpringDocker.repository;

import com.conexia.demoSpringDocker.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {

   List<Film> findByTitleContainingIgnoreCase(String title);

}
