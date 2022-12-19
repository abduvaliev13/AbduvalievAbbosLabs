package Abduvaliev_Abbos;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Future;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@Validated
public class Card{
    private String type;

    @Size(min=20,message = "20 или более цифр")
    @Pattern(regexp = "[0-9]+",message = "Только цисла!")
    private String accountNumber;

    @Future(message = "Будущее")
    private Date endDate;

    public void showAll(){
        System.out.println(type +" "+ accountNumber +" "+ endDate);
    }

    public void setType(String type) {
        this.type = type;
    }


    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


    public void setEndDate( Date endDate) {
        this.endDate = endDate;
    }

    public String getType() {
        return type;
    }


    public String getAccountNumber() {
        return accountNumber;
    }


    public Date getEndDate() {
        return endDate;
    }
}
