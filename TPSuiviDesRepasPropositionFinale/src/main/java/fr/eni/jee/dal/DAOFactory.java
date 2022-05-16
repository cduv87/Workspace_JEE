package fr.eni.jee.dal;

public class DAOFactory {
	/**
	 * Cette méthode sert à éviter le : RepasDAO repasDAO = new RepasDAOJdbcImpl() dans la couche BLL
	 */
	public static RepasDAO getRepasDAO() {
		return new RepasDAOJdbcImpl();
	}
}
