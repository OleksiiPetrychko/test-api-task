package tv.weplay.testapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tv.weplay.testapi.domain.Player;
import tv.weplay.testapi.repository.PlayerRepository;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor



public class PlayerController {
    private final PlayerRepository playerRepository;

    @PostMapping
    public ResponseEntity<Player> createPlayer(@Valid @RequestBody Player player) {
        return ResponseEntity.status(HttpStatus.CREATED).body(playerRepository.save(player));
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        return ResponseEntity.ok().body(playerRepository.findAll());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<Player> getPlayerById(@PathVariable Long id){
        return ResponseEntity.ok().body(playerRepository.findById(id).get());
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Player> deletePlayerById (@PathVariable Long id){

        Optional<Player> optionalPlayer = playerRepository.findById(id);

        if(optionalPlayer.isPresent()){
            playerRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return null;
    }

}
