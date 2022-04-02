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
//  app.test();
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
		Scanner sc = new Scanner(System.in);

		startUserInterface(sc);

		sc.close();
	}

	private void startUserInterface(Scanner sc) {
		// smaller methods
		// TODO: start menu loop,input, etc. Java logic
		int input = 0;
		boolean enterLoop = true;
		while (enterLoop) {

			System.out.println("---------------------------------------------");
			System.out.println("--------------------MENU---------------------");
			System.out.println("---------------------------------------------");
			System.out.println("Please pick from the following menu options:");
			System.out.println("1. Look up film by ID");
			System.out.println("2. Look up film by search keyword");
			System.out.println("3. Exit the Application");
			System.out.println("---------------------------------------------");
			System.out.println("Please select an option");
			input = sc.nextInt();
			if (input < 4) {
				FilmQueryApp filmQueryA = new FilmQueryApp();

				switch (input) {
				case 1:
					System.out.println("Please enter an ID:");
					int filmId = sc.nextInt();
					Film film = new Film();
					film = db.findFilmById(filmId);
					film.setCast(db.findActorsByFilmId(filmId));
					film.setLanguage(db.findLanguage(filmId));
					
					System.out.println(film);
					break;

				case 2:
					System.out.println("Enter keyword to search films:");
					
					List<Film> films = db.findFilmByKeyword(sc.next());
					System.out.println(films);
					// call method that searches by keyword
					break;

				case 3:
					System.out.println("Bye!");
					enterLoop = false;

					break;

				default:
					System.out.println("That is an invalid option, please try again");
					break;
				}
			}
		}

	}

//	private void lookUpById(Scanner sc) {
//		System.out.println("Enter ID for Film you would like to find");
//		Film film = db.findFilmById(sc.nextInt());
//
//		System.out.println(film);
//	}

	private void lookUpByKeyword(Scanner sc) {
		System.out.println("Enter keyword to search films:");
		List<Film> film = db.findFilmByKeyword(sc.next());
		if (film = null) {
			System.out.println("Your search returned nothing, please try again.");
			
		}
		System.out.println(film);

	}


//
//	private void testOne() {
//		Actor actor = db.findActorById(1);
//		System.out.println(actor);
//	}
//
//	private void testList() {
//		List<Actor> actors = new ArrayList<>();
//		actors = db.findActorsByFilmId(1);
//		System.out.println(actors);
//	}
	// if logic for null - no object found from scanner input
}
