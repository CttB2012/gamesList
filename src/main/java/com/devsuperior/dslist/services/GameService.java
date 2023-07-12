package com.devsuperior.dslist.services;


import com.devsuperior.dslist.dto.GameDto;
import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDto> findAll() {

       List<Game> listaCompleta = gameRepository.findAll();

       List<GameMinDto> dto = listaCompleta.stream().map(game -> new GameMinDto(game)).collect(Collectors.toList());

       return dto;
    }
    @Transactional(readOnly = true)
    public GameDto findById(Long id){

        Game result = gameRepository.findById(id).get();
        GameDto dto = new GameDto(result);
        return  dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findByList(Long listId) {

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        List<GameMinDto> dto = list.stream().map(game -> new GameMinDto(game)).collect(Collectors.toList());

        return dto;
    }

}
