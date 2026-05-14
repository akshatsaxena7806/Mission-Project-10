package com.rays.form;

import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.LanguageDTO;

public class LanguageForm extends BaseForm {

	@NotEmpty(message = "sourceLanguage is required")
	private String sourceLanguage;

	@NotEmpty(message = "targetLanguage is required")
	private String targetLanguage;

	@NotEmpty(message = "inputText is required")
	private String inputText;

	@NotEmpty(message = "translatedText is required")
	private String translatedText;

	public String getSourceLanguage() {
		return sourceLanguage;
	}

	public void setSourceLanguage(String sourceLanguage) {
		this.sourceLanguage = sourceLanguage;
	}

	public String getTargetLanguage() {
		return targetLanguage;
	}

	public void setTargetLanguage(String targetLanguage) {
		this.targetLanguage = targetLanguage;
	}

	public String getInputText() {
		return inputText;
	}

	public void setInputText(String inputText) {
		this.inputText = inputText;
	}

	public String getTranslatedText() {
		return translatedText;
	}

	public void setTranslatedText(String translatedText) {
		this.translatedText = translatedText;
	}

	@Override
	public BaseDTO getDTO() {

		LanguageDTO dto = initDTO(new LanguageDTO());

		dto.setTranslatedText(translatedText);
		dto.setSourceLanguage(sourceLanguage);
		dto.setInputText(inputText);
		dto.setTargetLanguage(targetLanguage);

		return dto;
	}

}
