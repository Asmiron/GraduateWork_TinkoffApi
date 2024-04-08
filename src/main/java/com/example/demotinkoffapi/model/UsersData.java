package com.example.demotinkoffapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersData {

    Long capital;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate terminal_date;

    @Override
    public String toString() {
        return "UsersData{" +
                "capital=" + capital +
                ", terminal_date=" + terminal_date +
                '}';
    }

}
