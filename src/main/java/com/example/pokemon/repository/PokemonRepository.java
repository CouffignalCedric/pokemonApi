package com.example.pokemon.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pokemon.entity.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    Pokemon findByName(String name);
    Optional<Pokemon> findById(Long id);
    @Transactional
    void deleteByName(String name);

}
