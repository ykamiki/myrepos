package jp.co.internous.practice.model.form;

import java.io.Serializable;

import lombok.Data;

@Data
public class HistoryForm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String userId;

}
