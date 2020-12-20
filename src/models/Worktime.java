package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "worktimes")
@NamedQueries({
    @NamedQuery(
            name = "getAllWorktimes",
            query = "SELECT r FROM Worktime AS r ORDER BY r.id DESC"
            ),
    @NamedQuery(
            name = "getWorktimesCount",
            query = "SELECT COUNT(r) FROM Worktime AS r"
            ),
    @NamedQuery(
            name = "getMyAllWorktimes",
            query = "SELECT r FROM Worktime AS r WHERE r.employee = :employee ORDER BY r.id DESC"
            ),
    @NamedQuery(
            name = "getMyWorktimesCount",
            query = "SELECT COUNT(r) FROM Worktime AS r WHERE r.employee = :employee"
            ),
    @NamedQuery(
            name = "getMyWorktimesOfDate",
            query = "SELECT r FROM Worktime AS r WHERE r.employee = :employee and r.report_date = :report_date ORDER BY r.id DESC"
            )
})
@Entity
public class Worktime {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "report_date", nullable = false)
    private Date report_date;

    @Column(name = "start_hour", nullable = true)
    private Timestamp start_hour;

    @Column(name = "start_minit", nullable = true)
    private Timestamp start_minit;

    @Column(name = "end_hour", nullable = true)
    private Timestamp end_hour;

    @Column(name = "end_minit", nullable = true)
    private Timestamp end_minit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public Timestamp getStart_hour() {
        return start_hour;
    }

    public void setStart_hour(Timestamp start_hour) {
        this.start_hour = start_hour;
    }

    public Timestamp getStart_minit() {
        return start_minit;
    }

    public void setStart_minit(Timestamp start_minit) {
        this.start_minit = start_minit;
    }

    public Timestamp getEnd_hour() {
        return end_hour;
    }

    public void setEnd_hour(Timestamp end_hour) {
        this.end_hour = end_hour;
    }

    public Timestamp getEnd_minit() {
        return end_minit;
    }

    public void setEnd_minit(Timestamp end_minit) {
        this.end_minit = end_minit;
    }




}
