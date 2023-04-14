package com.example.pokemon.controller;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.pokemon.entity.Pokemon;
import com.example.pokemon.repository.PokemonRepository;

@RestController
public class PokemonController {

    @Autowired
    PokemonRepository pokemonRepository;

    @PostMapping("/pokemon")
    public Pokemon createPokemon(@RequestBody Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    @GetMapping("/pokemons")
    public List<Pokemon> getAllPokemons(){
    return pokemonRepository.findAll();
    }

    @GetMapping("/{name}")
    public Pokemon getPokemonByNaPokemon(@PathVariable String name){
    return pokemonRepository.findByName(name);
    }
    @PutMapping("/pokemons/{id}") 
    public Pokemon UpdatePokemon(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        Pokemon pokemonToUpdate = pokemonRepository.findById(id).get();
        pokemonToUpdate.setName(pokemon.getName());
        pokemonToUpdate.setType(pokemon.getType());
        return pokemonRepository.save(pokemonToUpdate);
    }
    @Transactional
    @DeleteMapping("/{name}")
    public void deletePokemon(@PathVariable String name) {
    pokemonRepository.deleteByName(name);
    }

}