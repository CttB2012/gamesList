package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameListDto;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;


    public List<GameListDto> findLists(){

        List<GameList> result = gameListRepository.findAll();

        List<GameListDto> dto = result.stream().map(list -> new GameListDto(list)).collect(Collectors.toList());
        return dto;
    }
}
