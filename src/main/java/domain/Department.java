package domain;

import javax.persistence.*;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dept_id")
    private int deptId;
    @Column(name="dept_name", nullable = false, length = 10)
    private String deptName;
}