package jpajava;

import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployeeTest {
    public static void main(String[] args) {
//        Entity Manager를 Persistance 객체의 도움을 받아서 생성해보자
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

//        Manager를 만들어주자
        EntityManager em = emf.createEntityManager();

//        트랜잭션 만들기
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        System.out.println("설정 끝!! 트랜잭션 시작 !!!");

        Employee emp = new Employee();
        emp.setEmpId("202301");
        emp.setEmpName("홍길동");
        emp.setDeptId(1);
        emp.setJoinDate("2023-01-01");
        emp.setSalary(100_000_000L);
        System.out.println("비영속 상태");

        em.persist(emp);
        System.out.println("영속 상태");

        em.find(Employee.class, "202301");
        System.out.println("1차 캐시에서 가져옴!! DB는 아직 안나옴!!");

        System.out.println("====== 커밋 전 ======");
        tx.commit();
        System.out.println("====== 커밋 후(DB) ======");
        em.close();
        emf.close();
        System.out.println("트랜잭션 종료 !!!");
    }
}
