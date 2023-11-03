package jpajava;

import domain.Employee;

import javax.persistence.*;
import java.util.List;

public class EmployeeJPQLTest {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        System.out.println("트랜잭션 시작 !!!");

        Employee e1 = new Employee();
        e1.setEmpId("202308");
        e1.setDeptId(1);
        e1.setEmpName("test8");
        em.persist(e1);

        Employee e2 = new Employee();
        e2.setEmpId("202309");
        e2.setDeptId(1);
        e2.setEmpName("test9");
        em.persist(e2);


//        동적으로 실행될 때 오류가 발견되므로 주의할 것!
//        JPA는 ORM이므로 엔티티명으로 찾기 때문에 테이블명이 아닌 엔티티 이름으로 작성해주어야 한다
        String jpql = "select e from Employee e where e.deptId = :deptId";

        // FlushMode가 현재 Auto이므로 이 작업을 따로 해주지 않아도 됨
//        em.flush();       // flushmode = auto 임
//        타입을 주지 않으면 타입이 없는 쿼리로 반환됨!! 주의!
        TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
        query.setParameter("deptId", 1);
        List<Employee> resultList = query.getResultList();
        System.out.println("resultList.size : dept 1에는 " + resultList.size() + "명의 사원이 있음");     // 예상 5명

        jpql = "select count(e), sum(e.salary), avg(e.salary), max(e.salary), min(e.salary) from Employee e";

        Object singleResult = em.createQuery(jpql).getSingleResult();


        System.out.println("DB에서 가져옴!!");
        System.out.println("영속 상태");
        Employee e3 = em.find(Employee.class, "202301");
        System.out.println("1차 캐시에서 가져옴");

        System.out.println("====== 커밋 전 ======");
        tx.commit();
        System.out.println("====== 커밋 후(DB반영) ======");
        em.close();
        emf.close();
        System.out.println("트랜잭션 종료 !!!");
    }
}
