package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @Column(name="emp_id", length = 6)
    private String empId;
    @Column(name="emp_name", nullable = false, length = 10)
    private String empName;
    @Column(name="dept_id")
    private int deptId;
    @Column(name="join_date", nullable = false, length = 10)
    private String joinDate;
    @Column(nullable = false)
    private Long salary;

    public Employee() {
    }

    public Employee(String empId, String empName, int deptId, String joinDate, Long salary) {
        this.empId = empId;
        this.empName = empName;
        this.deptId = deptId;
        this.joinDate = joinDate;
        this.salary = salary;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}