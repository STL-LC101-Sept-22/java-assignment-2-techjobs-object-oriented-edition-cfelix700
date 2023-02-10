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
import static org.junit.Assert.assertTrue;

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
//        String productTester = "Product tester";
        Employer acme = new Employer("ACME");
        Location desert = new Location("Desert");
        PositionType qualityControl = new PositionType(("Quality Control"));
        CoreCompetency persistence = new CoreCompetency("Persistence");

        Job job1 = new Job("Product Tester", acme, desert,qualityControl, persistence);
        Job job2 = new Job("Product Tester", acme, desert,qualityControl, persistence);
//        Job job3 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));

        job1.setId(1);
        job2.setId(1);
//        job3.setId(3);

        assertTrue(job1.equals(job2));
//        assertNotEquals(job1.getId(), job2.getId());
//        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        String jobString = job.toString();

        assertEquals("\n", jobString.substring(0,1));
        assertEquals("\n", jobString.substring(jobString.length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){

        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));

        String jobString = job.toString();

        assertTrue(jobString.contains("Job ID: " + job.getId()));
        assertTrue(jobString.contains("Name: Product tester"));
        assertTrue(jobString.contains("Employer: ACME"));
        assertTrue(jobString.contains("Location: Desert"));
        assertTrue(jobString.contains("Position Type: Quality Control"));
        assertTrue(jobString.contains("Core Competency: Persistence"));
    }

    @Test
    public void testToStringHandlesEmptyField(){

        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String jobString = job.toString();

        assertTrue(jobString.contains("Job ID: " + job.getId()));
        assertTrue(jobString.contains("Name: Data not available"));
        assertTrue(jobString.contains("Employer: Data not available"));
        assertTrue(jobString.contains("Location: Data not available"));
        assertTrue(jobString.contains("Position Type: Data not available"));
        assertTrue(jobString.contains("Core Competency: Data not available"));
    }

}


