package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Reponses database table.
 * 
 */
@Entity
@Table(name="Reponses")
@NamedQuery(name="Repons.findAll", query="SELECT r FROM Repons r")
public class Repons implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ReponseId")
	private int reponseId;

	@Column(name="DatePost")
	private String datePost;

	@Column(name="Description")
	private String description;

	@Column(name="NbDislikes")
	private int nbDislikes;

	@Column(name="NbLikes")
	private int nbLikes;

	@Column(name="NbVues")
	private int nbVues;

	@Column(name="Titre")
	private String titre;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="QuestionId")
	private Question question;

	public Repons() {
	}

	public int getReponseId() {
		return this.reponseId;
	}

	public void setReponseId(int reponseId) {
		this.reponseId = reponseId;
	}

	public String getDatePost() {
		return this.datePost;
	}

	public void setDatePost(String datePost) {
		this.datePost = datePost;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNbDislikes() {
		return this.nbDislikes;
	}

	public void setNbDislikes(int nbDislikes) {
		this.nbDislikes = nbDislikes;
	}

	public int getNbLikes() {
		return this.nbLikes;
	}

	public void setNbLikes(int nbLikes) {
		this.nbLikes = nbLikes;
	}

	public int getNbVues() {
		return this.nbVues;
	}

	public void setNbVues(int nbVues) {
		this.nbVues = nbVues;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}