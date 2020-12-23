package com.edu.studynotes.notes.dto;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class AuthTokenDTO {

    @NonNull
    private String token;

    @NonNull
    private String nickName;
}
