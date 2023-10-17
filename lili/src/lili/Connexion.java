
package lili;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;





public class Connexion {
    public static Connection connect() {
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/nom_base_de_donnees";
        String utilisateur = "votre_utilisateur";
        String motDePasse = "votre_mot_de_passe";

        try {
            // Charger le pilote JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir la connexion à la base de données
            connection = DriverManager.getConnection(url, utilisateur, motDePasse);

            System.out.println("Connexion à la base de données établie avec succès.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la connexion à la base de données.");
        }

        return connection;
    }

    public static void main(String[] args) {
        Connection connection = connect();

        // Vous pouvez utiliser "connection" pour exécuter des requêtes SQL ou d'autres opérations sur la base de données.

        // N'oubliez pas de fermer la connexion lorsque vous avez terminé.
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connexion à la base de données fermée avec succès.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur lors de la fermeture de la connexion.");
        }
    }
}
