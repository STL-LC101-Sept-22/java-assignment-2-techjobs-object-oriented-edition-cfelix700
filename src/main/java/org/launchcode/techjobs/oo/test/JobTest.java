package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.CoreCompetency;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.Location;
import org.launchcode.techjobs.oo.PositionType;

import static org.junit.Assert.*;


/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job.getName().equals("Product tester"));
        assertTrue(job.getEmployer().getValue().equals("ACME"));
        assertTrue(job.getLocation().getValue().equals("Desert"));
        assertTrue(job.getPositionType().getValue().equals("Quality control"));
        assertTrue(job.getCoreCompetency().getValue().equals("Persistence"));

    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert") , new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert") , new PositionType("Quality Control"), new CoreCompetency("Persistence"));

//        Set different IDs for each job
        job1.setId(1);
        job2.setId(2);

//        Verify that the two jobs are NOT equal
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = job.toString();

        assertEquals("\n", jobString.substring(0,1));
        assertEquals("\n", jobString.substring(jobString.length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){

        Employer employer = new Employer("ACME");
        Location location = new Location("Desert");
        PositionType positionType = new PositionType("Quality Control");
        CoreCompetency coreCompetency = new CoreCompetency("Persistence");
        Job job = new Job(1, "Product tester", employer, location, positionType, coreCompetency);

        String jobString = job.toString();

        assertTrue(jobString.contains("Job ID: 1"));
        assertTrue(jobString.contains("Name: Product tester"));
        assertTrue(jobString.contains("Employer: ACME"));
        assertTrue(jobString.contains("Location: Desert"));
        assertTrue(jobString.contains("Position Type: Quality Control"));
        assertTrue(jobString.contains("Core Competency: Persistence"));
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job job = new Job();
        String jobString = job.toString();

        assertTrue(jobString.contains("Job ID: Data not available"));
        assertTrue(jobString.contains("Name: Data not available"));
        assertTrue(jobString.contains("Employer: Data not available"));
        assertTrue(jobString.contains("Location: Data not available"));
        assertTrue(jobString.contains("Position: Data not available"));
        assertTrue(jobString.contains("Core Competency: Data not available"));
    }

}


