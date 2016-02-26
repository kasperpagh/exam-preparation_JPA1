/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.Project;
import entity.ProjectUser;
import facade.Controller;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kaspe
 */
public class Tester
{

    public static void main(String[] args)
    {
        Persistence.generateSchema("exam-preparation_JPA1PU", null);

//        ProjectUser pu1 = new ProjectUser("a", "b", "c");
//        ProjectUser pu2 = new ProjectUser("d", "e", "f");
//        ProjectUser pu3 = new ProjectUser("g", "h", "i");
//        
//        Project p1 = new Project("1", "2", "3", "4");
//        Project p2 = new Project("5", "6", "7", "8");
        Controller c = new Controller();
        
        c.createProject("a", "b", "c", "d");
        c.createProject("e", "f", "g", "h");
        c.createUser("1", "2", "3");
        c.createUser("4", "5", "6");
        System.out.println("jeg prøver at adde " + c.findUser(1) + " til dette projekt: " + c.findProject(2));
        //can we fix this call??!?! NO IT'S FUCKED
//        c.assignUserToProject(c.findUser(1), 2);


        

    }

}
