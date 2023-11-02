package jpajava;

import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeRemoveTest {
    public static void main(String[] args) {
//        Entity Manager를 Persistance 객체의 도움을 받아서 생성해보자
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            System.out.println("트랜잭션 시작 !!!");
            System.out.println("select는 즉시 값을 가져옴");
            Employee e1 = em.find(Employee.class, "202301");
            System.out.println("DB에서 가져옴!!");
            System.out.println("영속 상태");

            em.remove(e1);
            System.out.println("removed 상태");

            System.out.println("====== 커밋 전 ======");
            tx.commit();
            System.out.println("====== 커밋 후 ======");

            Employee e2 = em.find(Employee.class, "202301");
            System.out.println("DB에서 못가져와야 함 (DB는 현재 지워진 상태)");
            System.out.println("e2 is null ? ==> " + (e2));

        } catch (Exception e) {
            System.out.println(e.getMessage());
            tx.rollback();
        } finally {
            em.close();
            emf.close();
            System.out.println("트랜잭션 종료 !!!");
        }
    }
}
