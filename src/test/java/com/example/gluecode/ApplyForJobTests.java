package com.example.gluecode;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import com.example.page.ApplicationPage;
import com.example.page.CandidatePage;
import com.example.page.LogIn;
import com.example.page.ViewAllJobsPage;
import com.example.page.ViewApplications;
import com.example.page.ViewSelfPostings;
import com.example.page.WelcomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApplyForJobTests {
	public WelcomePage wp;
	public LogIn lp;
	public WelcomePage wp2;
	public LogIn lp2;
	public CandidatePage cp;
	public ViewAllJobsPage vajp;
	public ApplicationPage ap;
	public ViewApplications vap;

	@Then("the user is redirected to the candidate screen")
	public void the_user_is_redirected_to_the_candidate_screen() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		this.cp = new CandidatePage(BurntOutDriverUtility.driver);
	    assertEquals(this.cp.title.getText(), "Welcome to BurntOut!");
	}
	
	@When("the candidate clicks the View Jobs link\"")
	public void the_candidate_clicks_the_view_jobs_link() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		this.cp.clickViewJobsLink();
	}
	
	@Then("the candidate is redirected to the View Jobs page")
	public void the_candidate_is_redirected_to_the_view_jobs_page() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		this.vajp = new ViewAllJobsPage (BurntOutDriverUtility.driver);
		TimeUnit.SECONDS.sleep(10);
		assertEquals(this.vajp.title.getText(), "Search for a job");
		TimeUnit.SECONDS.sleep(2);
	}
	
	@When("the candidate inputs the {string} to the Search bar")
	public void the_candidate_inputs_the_to_the_search_bar(String string) throws InterruptedException {
		 this.vajp.searchForJobByTitle(string);
		 TimeUnit.SECONDS.sleep(10);
	}
	
	@When("the candidate inputs {string} to the Search bar")
	public void the_candidate_inputs_to_the_search_bar(String string) throws InterruptedException {
		 this.vajp.searchForJobByTitle(string);
		 TimeUnit.SECONDS.sleep(2);
	}

	@Then("the job postings corresponding to the search show up")
	public void the_job_postings_corresponding_to_the_search_show_up() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
	}
	@Then("the candidate clears the Search Bar")
	public void the_candidate_clears_the_search_bar() throws InterruptedException {
	    this.vajp.clearInput();
	    TimeUnit.SECONDS.sleep(5);
	}

	@When("the candidate clicks the Apply button for the chosen posting")
	public void the_candidate_clicks_the_apply_button_for_the_chosen_posting() throws InterruptedException {
	    this.vajp.clickApplyButton();
	    TimeUnit.SECONDS.sleep(5);
	}
	@Then("the candidate is redirected to the Submit Application screen")
	public void the_candidate_is_redirected_to_the_submit_application_screen() throws InterruptedException {
		this.ap = new ApplicationPage(BurntOutDriverUtility.driver);
		TimeUnit.SECONDS.sleep(5);
	}
	@Then("the only information the candidate provides is the resume")
	public void the_only_information_the_candidate_provides_is_the_resume() throws InterruptedException {
	  this.ap.uploadResume();
	  TimeUnit.SECONDS.sleep(5);
	}
	@When("the candidate clicks Submit Application")
	public void the_candidate_clicks_submit_application() throws InterruptedException {
		this.ap.clickSubmitButton();
		TimeUnit.SECONDS.sleep(15);
		//BurntOutDriverUtility.driver.switchTo().alert().accept();
		TimeUnit.SECONDS.sleep(5);
	}
	@Then("the application is submitted")
	public void the_application_is_submitted() throws InterruptedException {
		TimeUnit.SECONDS.sleep(5);
		this.vap = new ViewApplications(BurntOutDriverUtility.driver);
		TimeUnit.SECONDS.sleep(5);
		//Make sure it was added to the table of job postings
		//assertEquals(this.ap., this.vap.checkLastTitleAdded());
		assertEquals("http://localhost:4200/view-applications", BurntOutDriverUtility.driver.getCurrentUrl());
	
	}
}
