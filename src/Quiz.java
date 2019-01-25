import java.util.ArrayList;
import java.util.Collections;


public class Quiz {
	protected ArrayList<Passage> passages;
	protected int index;
	
	Quiz(int quizIndex) { //0 == quiz 1
		index = quizIndex;
		passages = new ArrayList<Passage>();
		
		Passage temp = new Passage("texts/Another School Year - What For.txt", "Ciardi", "Another School Year-What For?");
		if (temp.numberOfPassages >= quizIndex + 1) {
			passages.add(temp);
		}
		temp = new Passage("texts/How To Make People Smaller Than They Are.txt", "Cousins", "How To Make People Smaller Than They Are");
		if (temp.numberOfPassages >= quizIndex + 1) {
			passages.add(temp);
		}
		temp = new Passage("texts/Allegory of the Cave.txt", "Plato", "Allegory of the Cave");
		if (temp.numberOfPassages >= quizIndex + 1) {
			passages.add(temp);
		}
		temp = new Passage("texts/Before the Law.txt", "Kafka", "Before the Law");
		if (temp.numberOfPassages >= quizIndex + 1) {
			passages.add(temp);
		}
		temp = new Passage("texts/The Marquise of O.txt", "Kleist", "The Marquise of O-");
		if (temp.numberOfPassages >= quizIndex + 1) {
			passages.add(temp);
		}
		temp = new Passage("texts/Course in General Linguistics.txt", "Saussure", "Course in General Linguistics");
		if (temp.numberOfPassages >= quizIndex + 1) {
			passages.add(temp);
		}
		temp = new Passage("texts/The Cool Web.txt", "Graves", "The Cool Web");
		if (temp.numberOfPassages >= quizIndex + 1) {
			passages.add(temp);
		}
		temp = new Passage("texts/Funes the Memorious.txt", "Borges", "Funes the Memorious");
		if (temp.numberOfPassages >= quizIndex + 1) {
			passages.add(temp);
		}
		temp = new Passage("texts/The Structure of Scientific Revolutions.txt", "Kuhn", "The Structure of Scientific Revolutions");
		if (temp.numberOfPassages >= quizIndex + 1) {
			passages.add(temp);
		}
		temp = new Passage("texts/Five Lectures on Psychoanalysis.txt", "Freud", "Five Lectures on Psychoanalysis");
		if (temp.numberOfPassages >= quizIndex + 1) {
			passages.add(temp);
		}
		temp = new Passage("texts/A Rose for Emily.txt", "Faulkner", "A Rose for Emily");
		if (temp.numberOfPassages >= quizIndex + 1) {
			passages.add(temp);
		}
		temp = new Passage("texts/Hamlet.txt", "Shakespeare", "Hamlet");
		if (temp.numberOfPassages >= quizIndex + 1) {
			passages.add(temp);
		}
		temp = new Passage("texts/Paradise Lost.txt", "Milton", "Paradise Lost");
		if (temp.numberOfPassages >= quizIndex + 1) {
			passages.add(temp);
		}
		temp = new Passage("texts/The Love Song of J. Alfred Prufrock.txt", "Eliot", "The Love Song of J. Alfred Prufrock");
		if (temp.numberOfPassages >= quizIndex + 1) {
			passages.add(temp);
		}
		temp = new Passage("texts/The Communist Manifesto.txt", "Marx", "The Communist Manifesto");
		if (temp.numberOfPassages >= quizIndex + 1) {
			passages.add(temp);
		}
		temp = new Passage("texts/The Boarding House.txt", "Joyce", "The Boarding House");
		if (temp.numberOfPassages >= quizIndex + 1) {
			passages.add(temp);
		}
		temp = new Passage("texts/A Room of One's Own.txt", "Woolf", "A Room of One's Own");
		if (temp.numberOfPassages >= quizIndex + 1) {
			passages.add(temp);
		}
		
		Collections.shuffle(passages);
	}
}
