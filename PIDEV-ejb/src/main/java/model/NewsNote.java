package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class NewsNote implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_note")
	private int id_note;
	@Column(name = "noteF")
	private int noteF=0;
	@Column(name = "nbNote")
	private int nbNote=1;
	@OneToOne
	private News news;
	
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public int getId_note() {
		return id_note;
	}
	public void setId_note(int id_note) {
		this.id_note = id_note;
	}
	public int getNoteF() {
		return noteF;
	}
	public void setNoteF(int noteF) {
		this.noteF = noteF;
	}
	public int getNbNote() {
		return nbNote;
	}
	public void setNbNote(int nbNote) {
		this.nbNote = nbNote;
	}
	public NewsNote(int id_note, int noteF, int nbNote) {
		super();
		this.id_note = id_note;
		this.noteF = noteF;
		this.nbNote = nbNote;
	}
	public NewsNote(int id_note, int noteF) {
		super();
		this.id_note = id_note;
		this.noteF = noteF;
	}

	public NewsNote() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
