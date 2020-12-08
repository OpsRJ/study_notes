package com.edu.studynotes.notes.dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class AuthToken {

    @NonNull
    private String token;

    @NonNull
    private String username;
}
