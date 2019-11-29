package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Questions database table.
 * 
 */
@Entity
@Table(name="Questions")
@NamedQuery(name="Question.findAll", query="SELECT q FROM Question q")
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="QuestionId")
	private int questionId;

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

	//bi-directional many-to-one association to Repons
	@OneToMany(mappedBy="question")
	private List<Repons> reponses;

	public Question() {
	}

	public int getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
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

	public List<Repons> getReponses() {
		return this.reponses;
	}

	public void setReponses(List<Repons> reponses) {
		this.reponses = reponses;
	}

	public Repons addRepons(Repons repons) {
		getReponses().add(repons);
		repons.setQuestion(this);

		return repons;
	}

	public Repons removeRepons(Repons repons) {
		getReponses().remove(repons);
		repons.setQuestion(null);

		return repons;
	}

}