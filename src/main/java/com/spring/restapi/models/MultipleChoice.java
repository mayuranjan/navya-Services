package com.spring.restapi.models;

public class MultipleChoice {
	String optionLabel;

	public MultipleChoice() {
	}

	public MultipleChoice(String optionLabel) {
		this.optionLabel = optionLabel;
	}

	public String getOptionLabel() {
		return optionLabel;
	}

	public void setOptionLabel(String optionLabel) {
		this.optionLabel = optionLabel;
	}

}