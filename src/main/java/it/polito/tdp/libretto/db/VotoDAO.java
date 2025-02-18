package it.polito.tdp.libretto.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import it.polito.tdp.libretto.model.Voto;

// La classe DAO non ha variabili 

public class VotoDAO {	// Data Access Object 
	
	// CRUD - Create Read Update Delete List (CRUL) anche operazioni di search
	
	public List <Voto> listVoti(){
		try{
			Connection conn= DBConnect.getConnection();
			
			Statement st= conn.createStatement();
			String sql= "SELECT corso, punti, data "
					+ "FROM voto";
			
			ResultSet res= st.executeQuery(sql);
			List <Voto> voti= new ArrayList<>();
			while (res.next()) {
				String corso= res.getString("corso");
				int punti= res.getInt("punti");
				LocalDate data= res.getDate("data").toLocalDate();
								
				Voto v= new Voto(corso, punti, data);
				voti.add(v);	
			}
			conn.close();
			return voti;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void createVoto (Voto v) {
//		String sql= "INSERT INTO `voto` (`corso`, `punti`, `data`) VALUES ('"+v.getCorso()+"', "+v.getPunti()+", '"+v.getDataEsame()+"')";
		
		String sql= "INSERT INTO `voto` (`corso`, `punti`, `data`) VALUES (?, ?, ?)";
		try {
			Connection conn= DBConnect.getConnection();
			PreparedStatement st= conn.prepareStatement(sql);
			
			st.setString(1, v.getCorso());
			st.setInt(2, v.getPunti());
			st.setDate(3, Date.valueOf(v.getDataEsame()));

			st.executeUpdate();
			
		}catch (SQLException e ) {
			e.printStackTrace();
		}
		
	}
	
	public Voto readVoto(String corso) {
		return null;
	}
	
	public List<Voto> searchVotoPuntiMaggiore(int punti){
		return null;
	}
	
}
