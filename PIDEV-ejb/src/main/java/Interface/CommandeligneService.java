package Interface;

import java.util.List;

import model.CommandeLigne;

public interface CommandeligneService {
	public int addcomlig(CommandeLigne dev);
	public void removecomlig(int id);
	public void updatecomlig(CommandeLigne user);
	public CommandeLigne findcomligById(int id);
	public List<CommandeLigne> findAllcomlig();
}
