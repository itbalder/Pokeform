package com.capgeminiproyect.Pokedex.service;

import com.capgeminiproyect.Pokedex.persistense.Pokemon;
import com.capgeminiproyect.Pokedex.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PokemonService implements PokemoInterfaceService {
    @Autowired
    private PokemonRepository pokemonRepository;

    @Override
    public List<Pokemon> getAllPokemon() {
        return pokemonRepository.findAll();

    }

    @Override
    public void savePokemon(Pokemon pokemon) {
        this.pokemonRepository.save(pokemon);
    }

    @Override
    public Pokemon getPokemonById(long id) {
        Optional<Pokemon> optional = pokemonRepository.findById(id);
        Pokemon pokemon=null;
        if (optional.isPresent()) {
            pokemon = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return pokemon;
    }

    @Override
    public void deletePokemonById(long id) {
        this.pokemonRepository.deleteById(id);
    }

    @Override
    public Page<Pokemon> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.pokemonRepository.findAll(pageable);
    }
}
