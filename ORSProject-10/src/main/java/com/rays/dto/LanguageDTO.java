package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.rays.common.BaseDTO;

@Entity
@Table(name = "ST_LANGUAGE")
public class LanguageDTO extends BaseDTO{
	
	
	@Column(name = "sourceLanguage", length = 55)
    private String sourceLanguage;
	
	@Column(name = "targetLanguage", length = 55)
	private String targetLanguage;
	
	@Column(name = "inputText", length = 55)
	private String inputText;
	
	@Column(name = "translatedText", length = 55)
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
	public String getValue() {
		// TODO Auto-generated method stub
		return sourceLanguage;
	}

	@Override
	public String getUniqueKey() {
		// TODO Auto-generated method stub
		return "sourceLanguage";
	}

	@Override
	public String getUniqueValue() {
		// TODO Auto-generated method stub
		return sourceLanguage;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return sourceLanguage;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return "Language";
	}

}
