package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    @Column(name = "emp_id")
    private String empId;
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "dept_id")
    private int deptId;
    @Column(name = "join_date")
    private String joinDate;
    private Long salary;


    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public int getDeptId() {
        return deptId;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public Long getSalary() {
        return salary;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
