package fr.eni.jee.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.jee.bo.Repas;

public interface RepasDAO {
	public void add(Repas repas) throws SQLException;
	public List<Repas> getAll() throws SQLException;
	public List<String> getIngredients(int idRepas) throws SQLException;
}
