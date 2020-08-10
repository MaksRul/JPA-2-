import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class WorkWithTheMenu {
    static EntityManagerFactory emf ;
    static EntityManager em ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        try {
             emf = Persistence.createEntityManagerFactory("JPA");
             em = emf.createEntityManager();
            try {
                while (true) {
                    System.out.println("1:add dish");
                    System.out.println("2:select a dish for the cost ");
                    System.out.println("3:discounted dish ");
                    String namber  = sc.nextLine();
                   switch (namber){
                       case "1":
                           addDish(sc);
                           break;
                       case"2":
                           selectDishByCost(sc);
                           break;
                       case "3":
                           Discount discount = new Discount();
                           discount.toString();
                   }


                }
            } finally {
                emf.close();
                em.close();
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
    public static void addDish(Scanner sc){
        System.out.println("Input the name of the  dish");
        String nameDish = sc.nextLine();
        System.out.println("Input the cost of the dish");
        String sCost = sc.nextLine();
        int cost = Integer.parseInt(sCost);
        System.out.println("Input the wight of the dish");
        String sWight = sc.nextLine();
        int wight = Integer.parseInt(sWight);
        em.getTransaction().begin();
        try{
            Menu menu = new Menu(nameDish,cost,wight);
            em.getTransaction().commit();
        }catch (Exception ex){
            em.getTransaction().rollback();
        }

    }
    public static void selectDishByCost(Scanner sc){
        System.out.println("Input the cost of the dish");
        String cost = sc.nextLine();
        Menu menu = new Menu();
        switch (cost){
            case "cost<=100":
                System.out.println("Name dish :" + menu.getNameDish() + "Cost dish" + menu.getCost());
                break;
            case "100<cost<=200":
                System.out.println("Name dish :" + menu.getNameDish() + "Cost dish" + menu.getCost());
                break;
            case"200<cost<=500>":
                System.out.println("Name dish :" + menu.getNameDish() + "Cost dish" + menu.getCost());
                break;
            default:
               return;
        }
        }
    }
