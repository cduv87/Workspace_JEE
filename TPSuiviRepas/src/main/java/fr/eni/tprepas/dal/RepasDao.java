package fr.eni.tprepas.dal;

import fr.eni.tprepas.bo.Repas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

public class RepasDao {

//	ArrayList<Repas> ListeRepas = new ArrayList<Repas>();
//	
//	public void add(Repas repas) {
//		ListeRepas.add(repas);
//		for (Repas element : ListeRepas) {
//            System.out.println(element);
//        }
//	}
//	
	
	private final static String INSERT1 = "insert into Repas(date, heure) values(?,?);";
	private final static String INSERT2 = "insert into Ingredient(nom, id_repas) values(?,?);";
//	private final static String SELECT1 = "SELECT * "
//			+ "FROM Repas r "
//			+ "INNER JOIN Ingredient i ON r.id = i.id_repas";
	private final static String SELECT1 = "SELECT * "
			+ "FROM Repas ";
	private final static String SELECT2 = "SELECT * "
			+ "FROM Ingredient WHERE id_repas = ? ";
	private final static String SELECT3 = "SELECT * "
			+ "FROM Ingredient ";
	
	public void add(Repas repas) throws SQLException {
		int fid = 0;
		List<String> ingredients = repas.getIngredients();
		Connection cnx = ConnectionProvider.getConnection();
		PreparedStatement pStmt = cnx.prepareStatement(INSERT1,Statement.RETURN_GENERATED_KEYS);
		pStmt.setDate(1, Date.valueOf(repas.getDate()));
		pStmt.setTime(2, Time.valueOf(repas.getTime()));

		pStmt.executeUpdate(); // ici , il faut faire executeUpdate() et pas executeQuery() parce qu'on modifie des données
		
		ResultSet rs = pStmt.getGeneratedKeys();
		if (rs.next()) { 
			fid = rs.getInt(1);
		}
		for(String e : ingredients) {
			PreparedStatement pStmt2 = cnx.prepareStatement(INSERT2);
			pStmt2.setString(1, e.trim());
			pStmt2.setInt(2, fid);
			pStmt2.executeUpdate();
		}
}

	public List<Repas> getRepas() throws SQLException {
		List<Repas> listeRepas = new ArrayList<Repas>();
		Connection cnx = ConnectionProvider.getConnection();
		Statement statement = cnx.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = statement.executeQuery(SELECT1);
		while (rs.next()) { 
			Repas repas = new Repas();
			repas.setId(rs.getInt("id"));
			repas.setDate(((rs.getDate("date")).toLocalDate()));
			repas.setTime(((rs.getTime("heure")).toLocalTime()));
			listeRepas.add(repas);
		}
		return listeRepas;
	}
	public List<String> getIngredientsOfRepas(int id) throws SQLException {
		List<String> listeIngredients = new ArrayList<String>();
		Connection cnx = ConnectionProvider.getConnection();
		PreparedStatement pStmt = cnx.prepareStatement(SELECT2);
		pStmt.setInt(1, id);
		ResultSet rs = pStmt.executeQuery();
		while (rs.next()) { 
			listeIngredients.add(rs.getString("nom"));
		}
		return listeIngredients;
	}
	// impossible sans créer un objet ingredient
//	public List<String> getIngredients() throws SQLException {
//		List<String> listeIngredients = new ArrayList<String>();
//		Connection cnx = ConnectionProvider.getConnection();
//		Statement statement = cnx.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
//		ResultSet rs = statement.executeQuery(SELECT3);
//		while (rs.next()) { 
//			listeIngredients.add(rs.getString("nom"));
//		}
//		return listeIngredients;
//	}
	
//    public List<Repas> getAll() throws SQLException {
//        Connection cnx = ConnectionProvider.getConnection();
//        Statement state = cnx.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
//        ResultSet result;
//        try {
//            result = state.executeQuery("select * from Repas;");
//            while (result.next())
//                (new Meal(result.getDate("date").toLocalDate(),result.getTime("heure").toLocalTime(),result.getInt("id")));
//            result = state.executeQuery("select * from Ingredient;");
//            while (result.next())
//                m.appendIngredient(new Ingredient(result.getInt("id"), result.getString("nom"), result.getInt("id_repas")));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
	
	
}//end
