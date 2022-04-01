package com.skilldistillery.filmquery.entities;

import java.util.Objects;

public class Actor {
	private int actorId;
	private String firstName;
	private String lastName;
	public Actor(int actorId, String firstName, String lastName) {
		super();
		this.actorId = actorId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Actor Id:" + actorId + ", First Name:" + firstName + ", Last Name:" + lastName;
	}
	@Override
	public int hashCode() {
		return Objects.hash(actorId, firstName, lastName);
	}
	public Actor() {
		super();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actor other = (Actor) obj;
		return actorId == other.actorId && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName);
	}
	/**
	 * @return the actorId
	 */
	public int getActorId() {
		return actorId;
	}
	/**
	 * @param actorId the actorId to set
	 */
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
