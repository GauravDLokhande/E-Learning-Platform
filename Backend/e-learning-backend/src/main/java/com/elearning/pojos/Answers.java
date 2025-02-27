package com.elearning.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@ToString(callSuper = true)
@Getter
@Setter
public class Answers extends BaseEntity{
	
	@Id
	@Column(name = "answer_id")
	private Long answerId;
	
	@OneToOne
	@JoinColumn(name="question_id")
	private Questions questions;
	
	@Column(name = "answer_text")
	private String answerText;
	
	@Column(name = "is_correct")
	private boolean isCorrect;
}
