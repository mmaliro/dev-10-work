package learn.board_games.controllers;

import learn.board_games.data.DataAccessException;
import learn.board_games.domain.BoardGameService;
import learn.board_games.domain.Result;
import learn.board_games.models.BoardGame;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class BoardGameController {

    private final BoardGameService service;

    public BoardGameController(BoardGameService service) {
        this.service = service;
    }

    @GetMapping
    public List<BoardGame> findAll() throws DataAccessException {
        return service.findAll();
    }

    @PostMapping("/game")
    public ResponseEntity<Object> add(@RequestBody BoardGame game) throws DataAccessException {
        Result result = service.add(game);
        if(result.isSuccess()) {
            return new ResponseEntity<>(result.getGame(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(result.getMessages(), HttpStatus.BAD_REQUEST);

    }

    @PutMapping("/{gameId}")
    public ResponseEntity<Object> update(@PathVariable int gameId, @RequestBody BoardGame game) throws DataAccessException {
        if(gameId != game.getId()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        Result result = service.update(game);
        if(result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(result.getMessages(), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{gameId}")
    public ResponseEntity<Void> deleteById(@PathVariable int gameId) throws DataAccessException {
        boolean success = service.deleteById(gameId);
        if(success) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
