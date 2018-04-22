package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	private List<WordEnhanced> parole;
	

	public AlienDictionary() {
	 parole = new ArrayList<WordEnhanced>();
	}

	public List<WordEnhanced> getParole() {
		return parole;
	}

	public void setParole(List<WordEnhanced> parole) {
		this.parole = parole;
	}
	
	public void addWord(String alienWord,String traslation) {
		WordEnhanced parolaInserita=new WordEnhanced(alienWord,traslation);
		for(WordEnhanced w:parole) {
			if(w.equals(parolaInserita)) {
				w.setTranslation(w.getTranslation()+" "+traslation);
//				parole.remove(w);
//				parole.add(w);
				return;
			}
		}
		parole.add(parolaInserita);
		
	}
	public String traslateWord(String alienWord) {
		
		for(WordEnhanced w:parole) {
			if(w.getAlienWord().equals(alienWord)) {
				return w.toString();
			}
		}
		return "parola non trovata";
	
	}
}
