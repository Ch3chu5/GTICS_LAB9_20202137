package com.example.lab9.Repositories;

import com.example.lab9.Entities.CoctelFav;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoctelFavRepository extends JpaRepository<CoctelFav, Integer> {
    boolean existsById(Integer CoctelId);
}
