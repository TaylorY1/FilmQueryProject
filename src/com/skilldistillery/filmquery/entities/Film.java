package com.skilldistillery.filmquery.entities;

import java.util.Objects;

public class Film {
	private int id;
	private String filmTitle;
	private String description;
	private int releaseYear;
	private String languageId;
	private int rentalDuration;
	private double rentalRate;
	private int filmLength;
	private double replacementCost;
	private String rating;
	private String specialFeatures;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	public Film() {
		super();
	}
	public Film(int id, String filmTitle, String description, int releaseYear, String languageId, int rentalDuration,
			double rentalRate, int filmLength, double replacementCost, String rating, String specialFeatures) {
		super();
		this.id = id;
		this.filmTitle = filmTitle;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.filmLength = filmLength;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the filmTitle
	 */
	public String getFilmTitle() {
		return filmTitle;
	}
	/**
	 * @param filmTitle the filmTitle to set
	 */
	public void setFilmTitle(String filmTitle) {
		this.filmTitle = filmTitle;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the releaseYear
	 */
	public int getReleaseYear() {
		return releaseYear;
	}
	/**
	 * @param releaseYear the releaseYear to set
	 */
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
	/**
	 * @return the languageId
	 */
	public String getLanguageId() {
		return languageId;
	}
	/**
	 * @param languageId the languageId to set
	 */
	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}
	/**
	 * @return the rentalDuration
	 */
	public int getRentalDuration() {
		return rentalDuration;
	}
	/**
	 * @param rentalDuration the rentalDuration to set
	 */
	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	/**
	 * @return the rentalRate
	 */
	public double getRentalRate() {
		return rentalRate;
	}
	/**
	 * @param rentalRate the rentalRate to set
	 */
	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}
	/**
	 * @return the filmLength
	 */
	public int getFilmLength() {
		return filmLength;
	}
	/**
	 * @param filmLength the filmLength to set
	 */
	public void setFilmLength(int filmLength) {
		this.filmLength = filmLength;
	}
	/**
	 * @return the replacementCost
	 */
	public double getReplacementCost() {
		return replacementCost;
	}
	/**
	 * @param replacementCost the replacementCost to set
	 */
	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}
	/**
	 * @return the rating
	 */
	public String getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}
	/**
	 * @return the specialFeatures
	 */
	public String getSpecialFeatures() {
		return specialFeatures;
	}
	/**
	 * @param specialFeatures the specialFeatures to set
	 */
	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "Film [id=" + id + ", filmTitle=" + filmTitle + ", description=" + description + ", releaseYear="
				+ releaseYear + ", languageId=" + languageId + ", rentalDuration=" + rentalDuration + ", rentalRate="
				+ rentalRate + ", filmLength=" + filmLength + ", replacementCost=" + replacementCost + ", rating="
				+ rating + ", specialFeatures=" + specialFeatures + "]";
	}
	
}
