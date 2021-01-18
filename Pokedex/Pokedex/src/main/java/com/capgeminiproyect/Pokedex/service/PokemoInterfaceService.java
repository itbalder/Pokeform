package com.capgeminiproyect.Pokedex.service;

import com.capgeminiproyect.Pokedex.persistense.Pokemon;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PokemoInterfaceService {
    List<Pokemon> getAllPokemon();
    void savePokemon(Pokemon pokemon);
    Pokemon getPokemonById(long id);
    void deletePokemonById(long id);
    Page<Pokemon> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
