package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Evaluation.findAll", query = "SELECT a FROM Evaluation a")
public class Evaluation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "EvaluationId")
	private int evaluationId;
	
	@Column(name = "note")
	private float note;
	
	@Column(name = "iduser")
	private int iduser;
	
	@Column(name = "conseilId")
	private int conseilId;
	
	private Conseil conseil;
	
	public Evaluation() {}

	public int getEvaluationId() {
		return evaluationId;
	}

	public void setEvaluationId(int evaluationId) {
		this.evaluationId = evaluationId;
	}

	public float getNote() {
		return note;
	}

	public void setNote(float note) {
		this.note = note;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public int getConseilId() {
		return conseilId;
	}

	public void setConseilId(int conseilId) {
		this.conseilId = conseilId;
	}

	public Conseil getConseil() {
		return conseil;
	}

	public void setConseil(Conseil conseil) {
		this.conseil = conseil;
	}
	
	
	

}
