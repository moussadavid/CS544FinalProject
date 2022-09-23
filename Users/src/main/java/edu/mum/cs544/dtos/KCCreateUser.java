package edu.mum.cs544.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class KCCreateUser {
    private int status;
    private String KCId;
}
