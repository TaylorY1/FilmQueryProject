package com.skilldistillery.filmquery.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
  
  DatabaseAccessor db = new DatabaseAccessorObject();

  public static void main(String[] args) {
    FilmQueryApp app = new FilmQueryApp();
   app.test();
//   app.testOne();
//   app.testList();
    app.launch();
  }

  private void test() {
    Film film = db.findFilmById(1);
    System.out.println(film);
    for (Actor ac : film.getCast()) {
    	System.out.println(ac);
		
	}
  }

  private void launch() {
    Scanner input = new Scanner(System.in);
    
    startUserInterface(input);
    
    input.close();
  }

  private void startUserInterface(Scanner input) {
    // smaller methods 
	  //TODO: start menu loop,input, etc. Java logic
  }
  private void testOne() {
	    Actor actor = db.findActorById(1);
	    System.out.println(actor);
	  }
  private void testList() {
	  List<Actor> actors = new ArrayList<>();
	     actors = db.findActorsByFilmId(1);
	    System.out.println(actors);
	  }
  // if logic for null - no object found from scanner input 
}
