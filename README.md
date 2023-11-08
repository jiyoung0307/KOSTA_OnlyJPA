# KOSTA_JPA
Spring없이 JPA만 사용하는 경우<br />

Entity Manager를 Persistance 객체의 도움을 받아서 생성해보자<br />
EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");<br />
EntityManager em = emf.createEntityManager();<br />
EntityTransaction tx = em.getTransaction();<br />
