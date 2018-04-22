package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	private List<Word> parole;
	

	public AlienDictionary() {
	 parole = new ArrayList<Word>();
	}

	public List<Word> getParole() {
		return parole;
	}

	public void setParole(List<Word> parole) {
		this.parole = parole;
	}
	
	public void addWord(String alienWord,String traslation) {
		Word parolaInserita=new Word(alienWord,traslation);
		for(Word w:parole) {
			if(w.equals(parolaInserita)) {
				parole.remove(w);
				parole.add(parolaInserita);
				return;
			}
		}
		parole.add(parolaInserita);
		
	}
	public String traslateWord(String alienWord) {
		
		for(Word w:parole) {
			if(w.getAlienWord().equals(alienWord)) {
				return w.toString();
			}
		}
		return "parola non trovata";
	
	}
}
