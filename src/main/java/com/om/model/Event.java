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

    private String accountId;

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

    @Column(name = "imagekey")
    private String imageKey;

    private long likes;
    private double rating;
    private long attendees;

    @NotNull
    private String type;

    public Event() {

    }

    public Event(String accountId, long attendees, String city, String country, LocalDate creationDate, String description, LocalDateTime endDateTime, UUID id, String imageKey, long likes, String name, double rating, LocalDateTime startDateTime, String state, String street, String type, String websiteUrl, String zip) {
        this.accountId = accountId;
        this.attendees = attendees;
        this.city = city;
        this.country = country;
        this.creationDate = creationDate;
        this.description = description;
        this.endDateTime = endDateTime;
        this.id = id;
        this.imageKey = imageKey;
        this.likes = likes;
        this.name = name;
        this.rating = rating;
        this.startDateTime = startDateTime;
        this.state = state;
        this.street = street;
        this.type = type;
        this.websiteUrl = websiteUrl;
        this.zip = zip;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public long getAttendees() {
        return attendees;
    }

    public void setAttendees(long attendees) {
        this.attendees = attendees;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getImageKey() {
        return imageKey;
    }

    public void setImageKey(String imageKey) {
        this.imageKey = imageKey;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return likes == event.likes && Double.compare(rating, event.rating) == 0 && attendees == event.attendees && Objects.equals(id, event.id) && Objects.equals(accountId, event.accountId) && Objects.equals(name, event.name) && Objects.equals(creationDate, event.creationDate) && Objects.equals(street, event.street) && Objects.equals(city, event.city) && Objects.equals(state, event.state) && Objects.equals(zip, event.zip) && Objects.equals(country, event.country) && Objects.equals(description, event.description) && Objects.equals(startDateTime, event.startDateTime) && Objects.equals(endDateTime, event.endDateTime) && Objects.equals(websiteUrl, event.websiteUrl) && Objects.equals(imageKey, event.imageKey) && Objects.equals(type, event.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountId, name, creationDate, street, city, state, zip, country, description, startDateTime, endDateTime, websiteUrl, imageKey, likes, rating, attendees, type);
    }

    @Override
    public String toString() {
        return "Event{" +
                "accountId=" + accountId +
                ", id=" + id +
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
                ", imageKey='" + imageKey + '\'' +
                ", likes=" + likes +
                ", rating=" + rating +
                ", attendees=" + attendees +
                ", type='" + type + '\'' +
                '}';
    }
}