package Interface;

import javax.ejb.Remote;


import model.Evaluation;



@Remote
public interface EvaluationServiceRemote {
	
	void addEvaluation(Evaluation evaluation);
	
	void updateEvaluation(Evaluation evaluation);

}
