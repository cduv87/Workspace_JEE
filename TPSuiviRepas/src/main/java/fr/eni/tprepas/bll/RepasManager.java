package fr.eni.tprepas.bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.tprepas.bo.Repas;
import fr.eni.tprepas.dal.RepasDao;

public class RepasManager {
	RepasDao repasDAO = new RepasDao();
	public void add(Repas repas) throws SQLException {
		repasDAO.add(repas);
	}
	
	public List<Repas> GetRepas() {
		List<Repas> ListRepas = new ArrayList<Repas>();
		try {
			ListRepas = repasDAO.getRepas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListRepas;
	}
	
	public List<String> GetIngredientsFromIdRepas(int id) {
		List<String> ListIngr = new ArrayList<String>();
		try {
			ListIngr = repasDAO.getIngredientsOfRepas(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ListIngr;
	}
	
}
