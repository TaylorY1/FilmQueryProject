package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

	private static String url = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";

	private String user = "student";
	private String pass = "student";
	private String sqltext;

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			sqltext = "SELECT * FROM film WHERE id = ?";
			PreparedStatement s = conn.prepareStatement(sqltext);
			s.setInt(1, filmId);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				film = new Film();
				film.setId(rs.getInt("id"));
				film.setFilmTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setLanguageId(rs.getString("language_id"));

				// film.setRentalDuration(rs.getInt("rental_duration"));
				// film.setRentalRate(rs.getDouble("rental_rate"));
				// film.setFilmLength(rs.getInt("length"));
				// film.setReplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				// film.setSpecialFeatures(rs.getString("special_features"));
				// film.setCast(findActorsByFilmId(filmId));
				// creates a Film object
			}
			rs.close();
			s.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	@Override
	public List<Film> findFilmByKeyword(String filmKeyword) {
		Film film = null;
		List<Film> films = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			filmKeyword = "%" + filmKeyword + "%";
			sqltext = "SELECT * FROM film WHERE title LIKE ? OR description LIKE ?";
			PreparedStatement s = conn.prepareStatement(sqltext);
			s.setString(1, filmKeyword);
			s.setString(2, filmKeyword);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				film = new Film();
				film.setId(rs.getInt("id"));
				film.setFilmTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setLanguageId(rs.getString("language_id"));
			//	film.setLanguage(rs.getString(findLanguage("id")));
				// film.setRentalDuration(rs.getInt("rental_duration"));
				// film.setRentalRate(rs.getDouble("rental_rate"));
				// film.setFilmLength(rs.getInt("length"));
				// film.setReplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				// film.setSpecialFeatures(rs.getString("special_features"));
				// film.setCast(findActorsByFilmId(filmId));
				// creates a Film object
				films.add(film);

			}
			rs.close();
			s.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return films;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			sqltext = "SELECT * FROM actor WHERE id = ?";
			PreparedStatement s = conn.prepareStatement(sqltext);
			s.setInt(1, actorId);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				actor = new Actor();
				actor.setActorId(rs.getInt("id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));

			}
			rs.close();
			s.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();
		Actor actorOne = null;
		try {
			Connection conn = DriverManager.getConnection(url, user, pass);
			sqltext = "SELECT a.id, a.first_name, a.last_name, film.id" + " FROM film_actor f"
					+ " JOIN actor a ON f.actor_id = a.id" + " JOIN film ON f.film_id = film.id" + " WHERE film.id = ?";
			PreparedStatement s = conn.prepareStatement(sqltext);
			s.setInt(1, filmId);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				actorOne = new Actor();
				actorOne.setActorId(rs.getInt("id"));
				actorOne.setFirstName(rs.getString("first_name"));
				actorOne.setLastName(rs.getString("last_name"));
				actors.add(actorOne);

			}
			rs.close();
			s.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return actors;
	}

	public String findLanguage(int filmId) {
		String languages = "";
		try {

			Connection conn = DriverManager.getConnection(url, user, pass);
			sqltext = "SELECT l.name FROM language l JOIN film ON l.id = ?";
			PreparedStatement s = conn.prepareStatement(sqltext);
			s.setInt(1, filmId);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				languages = (rs.getString("name"));
				// actorOne.setActorId(rs.getInt("id"));
				// actorOne.setFirstName(rs.getString("first_name"));
				// actorOne.setLastName(rs.getString("last_name"));
				// actors.add(actorOne);

			}
			rs.close();
			s.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return languages;

	}
	// select name FROM language

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Driver not found!");
			throw new RuntimeException("Unable to load driver class!");
		}
	}
}
