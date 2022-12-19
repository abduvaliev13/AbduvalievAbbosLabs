package Abduvaliev_Abbos;


public class Session {

    @Tx
    public void startSession(){
        System.out.println("Сессия запущена");
    }
}
