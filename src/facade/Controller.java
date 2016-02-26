/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Project;
import entity.ProjectUser;
import entity.Task;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kaspe
 */
public class Controller
{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("exam-preparation_JPA1PU");

    //Create User method
    public ProjectUser createUser(String userName, String email, String created)
    {
        ProjectUser pu = new ProjectUser(userName, email, created);
        EntityManager em = emf.createEntityManager();
        try
        {

            em.getTransaction().begin();
            em.persist(pu);
            em.getTransaction().commit();
        }
        finally
        {
            em.close();
        }
        return pu;
    }

    public Project createProject(String name, String description, String created, String lastModified)
    {
        Project pro = new Project(name, description, created, lastModified);
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            em.persist(pro);
            em.getTransaction().commit();
        }
        finally
        {
            em.close();
        }
        return pro;
    }

    //Find user method (by ID)
    public ProjectUser findUser(int id)
    {
        ProjectUser found;
        EntityManager em = emf.createEntityManager();
        try
        {
            found = em.find(ProjectUser.class, id);
        }
        finally
        {
            em.close();

        }
        return found;
    }

    //Bedre med querylanguage
    public List getAllUsers()
    {
        Project p = new Project();
        return p.getUsers();

    }

    public void assignUserToProject(ProjectUser pu, int projectID)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.getTransaction().begin();
            Project p = em.find(Project.class, projectID);
            p.addUser(pu);
            System.out.println("jeg har addet " + pu.toString() + " til " + p.getUsers());
            em.persist(pu);
            em.getTransaction().commit();
        }
        finally
        {
            em.close();
        }
    }

    public Project findProject(int id)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            return em.find(Project.class, id);
        }
        finally
        {
            em.close();

        }
    }

    public void createTaskAndAssignToProject(Project p, Task t)
    {
        EntityManager em = emf.createEntityManager();
        try
        {
            em.find(Project.class, p).addTask(t);
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        }
        finally
        {
            em.close();
        }
    }

}
