package it.polito.tdp.anagrammi.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.anagrammi.model.Word;

public class AnagrammiDAO {
	
	public boolean isCorrect(Word word){
		
		final String sql = "SELECT nome FROM parola WHERE nome=?";

		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, word.getWord().toLowerCase());
			ResultSet rs = st.executeQuery();
			
			if(rs.next()){

				rs.close();
				st.close();
				conn.close();
				
				return true;
				
			}

			rs.close();
			st.close();
			conn.close();
			
			return false;

		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException("Errore Db");
			
		}
		
	}

}
