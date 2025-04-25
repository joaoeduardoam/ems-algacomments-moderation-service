package com.joaoeduardo.algacomments.moderation.service.api.model.dto.out;


import lombok.*;

import java.time.*;
import java.util.*;

@Builder
public record ModerationOutput(
        Boolean approved,
        String reason
){}
