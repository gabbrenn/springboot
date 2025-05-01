package rw.vladvisionlab.inzozi.dtos;

import lombok.Data;

@Data
public class DeleteUserRequest {
    private String email;
    private String password;
}
