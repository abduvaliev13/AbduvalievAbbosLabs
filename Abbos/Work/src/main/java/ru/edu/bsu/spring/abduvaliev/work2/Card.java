package ru.edu.bsu.spring.abduvaliev.work2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private String type;
    private String accountNumber;
    private LocalDate endDate;
}
