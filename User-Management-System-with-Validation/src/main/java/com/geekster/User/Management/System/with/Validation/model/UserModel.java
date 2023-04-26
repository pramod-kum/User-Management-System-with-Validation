package com.geekster.User.Management.System.with.Validation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class UserModel {
   @NotNull
    private int userId;
    @NotBlank
    @NotEmpty
    @Pattern(regexp = "[A-Za-z]+\\s[A-Za-z]+")
    private String userName;
   @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$")
    private String dateOfBirth;
   @Email
   @NotEmpty(message = "Hi Email Id should not be Empty!!!")
    private String emailId;
   @Size(min = 10 , max = 12)
   @Pattern(regexp = "[0-9]+")
    private String phoneNumber;
   @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$")
    private String date;
   @Pattern(regexp = "^[0-2][0-3]:[0-5][0-9]$")
    private String time;
}
