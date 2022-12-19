package Abduvaliev_Abbos;

public class TaskService {
    @Tx
    public Task executeStatement(Task ts){
         try{
             System.out.println("id =" + ts.getId() +" Name =" + ts.getName() + " Status = " + ts.getStatus() + " Comment =" + ts.getComments());
             ts.setId(5);
             String name = "Oleg";
             ts.setName(name);
             System.out.println("New");
             System.out.println("id =" + ts.getId() +" Name =" + ts.getName() + " Status = " + ts.getStatus() + " Comment =" + ts.getComments());
         }catch (Exception e){
             System.out.println(e);
         }
         return ts;
    }
}
