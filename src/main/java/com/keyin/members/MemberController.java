package com.keyin.members;
import com.keyin.tournaments.Tournament;
import com.keyin.tournaments.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
@CrossOrigin
public class MemberController {

    private final MemberService memberService;
    private final TournamentService tournamentService;

    @Autowired
    public MemberController(MemberService memberService, TournamentService tournamentService) {
        this.memberService = memberService;
        this.tournamentService = tournamentService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Member>> getAllMembers() {
        Iterable<Member> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable Long id) {
        Optional<Member> member = memberService.searchByID(id);
        return member.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        List<Tournament> updatedTournamentList = new ArrayList<>();

        for (Tournament tournament : member.getTournaments()) {
            Optional< Tournament> tournamentOptional = Optional.ofNullable(tournamentService.getTournamentById(tournament.getId()));
            Tournament tournament1;

            if (tournamentOptional.isPresent()) {
                tournament = tournamentOptional.get();
                updatedTournamentList.add(tournament);
            } else {

                updatedTournamentList = member.getTournaments();
                tournamentService.createNewTournament(tournament);
            }

        }
        member.setTournaments(updatedTournamentList);
        return memberService.createNewMember(member);

    }

    @GetMapping("/{id}/tournaments")
    public ResponseEntity<List<Tournament>> getMemberTournaments(@PathVariable Long id) {
        return memberService.searchByID(id)
                .map(member -> ResponseEntity.ok(List.copyOf(member.getTournaments())))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}