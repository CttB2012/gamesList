package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameListDto;
import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.dto.ReplacementDto;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;


    @GetMapping
    public List<GameListDto> findLists() {

        List<GameListDto> list = gameListService.findLists();

        return list;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDto> findByList(@PathVariable Long listId){

        List<GameMinDto> result = gameService.findByList(listId);
        return  result;
    }
    @PostMapping(value = "/{listId}/raplacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDto body){

        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }

}
