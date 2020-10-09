package tv.weplay.testapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tv.weplay.testapi.domain.Team;
import tv.weplay.testapi.repository.TeamRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamRepository teamRepository;

    @PostMapping
    public ResponseEntity<Team> createTeam(@Valid @RequestBody Team team) {
        return ResponseEntity.status(HttpStatus.CREATED).body(teamRepository.save(team));
    }

    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        return ResponseEntity.ok().body(teamRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> findTeamById(@PathVariable Long id) {
        return ResponseEntity.ok(teamRepository.findById(id).get());
    }
}
