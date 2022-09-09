package org.genspark;

import org.genspark.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

//        addEmployee(session, 2, "Bob", "BOB Dept");

//        listAllEmployees(session);

//        listEmployeesByDept(session, "BOB Dept");

//        updateEmployee(session, 1, "Tom", "TOM Dept");

//        Aggregate query to give max employee id
//        getMaxId(session);

//        Needed for each method
        tx.commit();
        System.out.println("Successfully Completed");
        factory.close();
        session.close();
    }

    private static void getMaxId(Session session) {
        Query aggregation = session.createQuery("select max(empId) from Employee");
        System.out.println(aggregation.getSingleResult());
    }

    private static void updateEmployee(Session session, int empId, String empName, String empDept) {
        Query update = session.createQuery("update Employee set empName=:n, empDept=:d where empId=:i");
        update.setParameter("n", empName);
        update.setParameter("d", empDept);
        update.setParameter("i", empId);
        int status = update.executeUpdate();
        System.out.println(status);
    }

    private static void listEmployeesByDept(Session session, String empDept) {
        Query queryDept = session.createQuery("from Employee where empDept =:dept");
        queryDept.setParameter("dept", empDept); //set the dept
        List<Employee> empList=queryDept.list();

        for(Employee emp: empList){
            System.out.println(emp);
        }
    }

    private static void listAllEmployees(Session session) {
        Query query = session.createQuery("from Employee");
        List<Employee> empList=query.list();

        for(Employee emp: empList){
            System.out.println(emp);
        }
    }

    private static void addEmployee(Session session, int empId, String empName, String empDept) {
        Employee e1 = new Employee();
        e1.setEmpId(2);
        e1.setEmpName("Bob");
        e1.setEmpDept("BOB Dept");

        session.save(e1);
    }
}
