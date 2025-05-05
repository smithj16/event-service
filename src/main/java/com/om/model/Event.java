package com.om.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "events")
public class Event extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true)
    private String name;

    @Column(name = "creationdate")
    private LocalDate creationDate;

    private String street;

    private String city;

    private String state;

    private String zip;

    private String country;

    private String description;

    @Column(name = "startdatetime")
    private LocalDateTime startDateTime;

    @Column(name = "enddatetime")
    private LocalDateTime endDateTime;

    private String websiteUrl;

    private String image;

    private long likes;
    private double rating;
    private long attendees;

    @NotNull
    private String type;

    public Event() {

    }

    public Event(String name, UUID id, LocalDate creationDate, String street, String city, String state, String zip, String country, String description, LocalDateTime startDateTime, LocalDateTime endDateTime, String websiteUrl, String image, long likes, double rating, long attendees, String type) {
        this.name = name;
        this.id = id;
        this.creationDate = creationDate;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.description = description;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.websiteUrl = websiteUrl;
        this.image = image;
        this.likes = likes;
        this.rating = rating;
        this.attendees = attendees;
        this.type = type;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public double getRating() {
        return rating;
    }

    public long getAttendees() {
        return attendees;
    }

    public void setAttendees(long attendees) {
        this.attendees = attendees;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", image='" + image + '\'' +
                ", likes=" + likes +
                ", rating=" + rating +
                ", attendees=" + attendees +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return likes == event.likes && Double.compare(rating, event.rating) == 0 && attendees == event.attendees && Objects.equals(id, event.id) && Objects.equals(name, event.name) && Objects.equals(creationDate, event.creationDate) && Objects.equals(street, event.street) && Objects.equals(city, event.city) && Objects.equals(state, event.state) && Objects.equals(zip, event.zip) && Objects.equals(country, event.country) && Objects.equals(description, event.description) && Objects.equals(startDateTime, event.startDateTime) && Objects.equals(endDateTime, event.endDateTime) && Objects.equals(websiteUrl, event.websiteUrl) && Objects.equals(image, event.image) && Objects.equals(type, event.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, creationDate, street, city, state, zip, country, description, startDateTime, endDateTime, websiteUrl, image, likes, rating, attendees, type);
    }
}