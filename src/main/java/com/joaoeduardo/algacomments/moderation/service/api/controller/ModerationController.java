package com.joaoeduardo.algacomments.moderation.service.api.controller;

import com.joaoeduardo.algacomments.moderation.service.api.model.dto.in.*;
import com.joaoeduardo.algacomments.moderation.service.api.model.dto.out.*;
import lombok.*;
import org.springframework.data.domain.*;
import org.springframework.data.web.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.*;

import java.util.*;

@RestController
@RequestMapping("/api/moderate")
@RequiredArgsConstructor
public class ModerationController {

    private final List<String> prohibitiveWords = List.of("ódio", "xingamento");

//    private final IMapper mapper;


//
//    @GetMapping("{commentId}/detail")
//    public CommentDetailOutput getOneWithDetail(@PathVariable TSID commentId) {
//        Comment comment = commentRepository.findById(new UUID(commentId))
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//
//        CommentMonitoringOutput commentMonitoringOutput = commentMonitoringClient.getDetail(commentId);
//
//        return CommentDetailOutput.builder()
//                .commentOutput(mapper.toCommentOutput(comment))
//                .commentMonitoringOutput(commentMonitoringOutput)
//                .build();
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ModerationOutput create(@RequestBody ModerationInput moderationInput) {

        System.out.println(moderationInput.commentId());

        if (prohibitiveWords.stream()
                .anyMatch(moderationInput.text().toLowerCase()::contains)) {
            return new ModerationOutput(false, "The comment contains prohibitive words that not allowed!");
        }

        return new ModerationOutput(true, "The comment NOT contains prohibitive words!");
    }





//
//        boolean approved = true;
//        String reason = "The comment NOT contains prohibitive words";
//
//        String lowerCaseText = moderateComment.text().toLowerCase();
//
//        for (String word : prohibitiveWords) {
//            if (lowerCaseText.contains(word)) {
//                approved = false;
//                reason = "The comment contains prohibitive words that not allowed!";
//                break;
//            }
//        }
//        return new ModerationOutput(approved, reason);
//
//    }




}
