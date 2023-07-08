package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SearchHotel extends BaseClass {

	public SearchHotel() {

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "location")

	private WebElement location;

	@FindBy(id = "hotels")

	private WebElement hotel;

	@FindBy(id = "room_type")

	private WebElement roomType;

	@FindBy(id = "room_nos")

	private WebElement roomNo;

	@FindBy(id = "datepick_in")

	private WebElement checkIndate;

	@FindBy(id = "datepick_out")

	private WebElement checkOutdate;

	@FindBy(id = "adult_room")

	private WebElement adultsperRoom;

	@FindBy(id = "child_room")

	private WebElement childrenPerRoom;

	public WebElement getLocation() {
		return location;
	}

	public void setLocation(WebElement location) {
		this.location = location;
	}

	public WebElement getHotel() {
		return hotel;
	}

	public void setHotel(WebElement hotel) {
		this.hotel = hotel;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public void setRoomType(WebElement roomType) {
		this.roomType = roomType;
	}

	public WebElement getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(WebElement roomNo) {
		this.roomNo = roomNo;
	}

	public WebElement getCheckIndate() {
		return checkIndate;
	}

	public void setCheckIndate(WebElement checkIndate) {
		this.checkIndate = checkIndate;
	}

	public WebElement getCheckOutdate() {
		return checkOutdate;
	}

	public void setCheckOutdate(WebElement checkOutdate) {
		this.checkOutdate = checkOutdate;
	}

	public WebElement getAdultsperRoom() {
		return adultsperRoom;
	}

	public void setAdultsperRoom(WebElement adultsperRoom) {
		this.adultsperRoom = adultsperRoom;
	}

	public WebElement getChildrenPerRoom() {
		return childrenPerRoom;
	}

	public void setChildrenPerRoom(WebElement childrenPerRoom) {
		this.childrenPerRoom = childrenPerRoom;
	}

	public WebElement getSearch() {
		return Search;
	}

	public void setSearch(WebElement search) {
		Search = search;
	}

	@FindBy(id = "Submit")

	private WebElement Search;

}
