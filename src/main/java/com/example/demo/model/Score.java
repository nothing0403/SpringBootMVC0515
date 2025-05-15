package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Score {

	private int highScore(List<Integer> scores) {
		Integer ans = 0;
		for(Integer score: scores) {
			ans = ans<score? score:ans; 
		}
		return ans;
	}
	private int LowScore(List<Integer> scores) {
		Integer ans = 0;
		for(Integer score: scores) {
			ans = ans>score? score:ans; 
		}
		return ans;
	}
	private Double averScore(List<Integer> scores) {
		Double ans = 0.0;
		for(Integer score: scores) {
			ans += score; 
		}
		ans = ans/(scores.size());
		return ans;
	}
	
	private int totalScore(List<Integer> scores) {
		Integer ans = 0;
		for(Integer score: scores) {
			ans += score; 
		}
		return ans;
	}
	
	private List<Integer> passScore(List<Integer> scores) {
		
	    scores.stream().filter((score) -> score>=60);
		
		return scores;
	}
	
    private List<Integer> fallScore(List<Integer> scores) {
		
	    scores.stream().filter((score) -> score<60);
		
		return scores;
	}
}
