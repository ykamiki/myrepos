package jp.co.internous.myshop.model.form;

import java.io.Serializable;

import lombok.Data;

@Data
public class HistoryForm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String userId;

}
