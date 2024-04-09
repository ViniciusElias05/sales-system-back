package com.viniciuselias.projetotcc.controller.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class StandardError implements Serializable {
    @Setter(AccessLevel.PRIVATE)
    private static final long serialVersionUID = 1L;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

}
